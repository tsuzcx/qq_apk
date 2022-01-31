package com.google.android.exoplayer2.source.chunk;

import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.SequenceableLoader.Callback;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChunkSampleStream<T extends ChunkSource>
  implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback
{
  private static final String TAG = "ChunkSampleStream";
  private final SequenceableLoader.Callback<ChunkSampleStream<T>> callback;
  private final T chunkSource;
  long decodeOnlyUntilPositionUs;
  private final SampleQueue[] embeddedSampleQueues;
  private final Format[] embeddedTrackFormats;
  private final int[] embeddedTrackTypes;
  private final boolean[] embeddedTracksSelected;
  private final MediaSourceEventListener.EventDispatcher eventDispatcher;
  private long lastSeekPositionUs;
  private final Loader loader;
  boolean loadingFinished;
  private final BaseMediaChunkOutput mediaChunkOutput;
  private final ArrayList<BaseMediaChunk> mediaChunks;
  private final int minLoadableRetryCount;
  private final ChunkHolder nextChunkHolder;
  private long pendingResetPositionUs;
  private Format primaryDownstreamTrackFormat;
  private final SampleQueue primarySampleQueue;
  public final int primaryTrackType;
  private final List<BaseMediaChunk> readOnlyMediaChunks;
  @Nullable
  private ChunkSampleStream.ReleaseCallback<T> releaseCallback;
  
  public ChunkSampleStream(int paramInt1, int[] paramArrayOfInt, Format[] paramArrayOfFormat, T paramT, SequenceableLoader.Callback<ChunkSampleStream<T>> paramCallback, Allocator paramAllocator, long paramLong, int paramInt2, MediaSourceEventListener.EventDispatcher paramEventDispatcher)
  {
    this.primaryTrackType = paramInt1;
    this.embeddedTrackTypes = paramArrayOfInt;
    this.embeddedTrackFormats = paramArrayOfFormat;
    this.chunkSource = paramT;
    this.callback = paramCallback;
    this.eventDispatcher = paramEventDispatcher;
    this.minLoadableRetryCount = paramInt2;
    this.loader = new Loader("Loader:ChunkSampleStream");
    this.nextChunkHolder = new ChunkHolder();
    this.mediaChunks = new ArrayList();
    this.readOnlyMediaChunks = Collections.unmodifiableList(this.mediaChunks);
    if (paramArrayOfInt == null) {}
    for (paramInt2 = 0;; paramInt2 = paramArrayOfInt.length)
    {
      this.embeddedSampleQueues = new SampleQueue[paramInt2];
      this.embeddedTracksSelected = new boolean[paramInt2];
      paramArrayOfFormat = new int[paramInt2 + 1];
      paramT = new SampleQueue[paramInt2 + 1];
      this.primarySampleQueue = new SampleQueue(paramAllocator);
      paramArrayOfFormat[0] = paramInt1;
      paramT[0] = this.primarySampleQueue;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramCallback = new SampleQueue(paramAllocator);
        this.embeddedSampleQueues[paramInt1] = paramCallback;
        paramT[(paramInt1 + 1)] = paramCallback;
        paramArrayOfFormat[(paramInt1 + 1)] = paramArrayOfInt[paramInt1];
        paramInt1 += 1;
      }
    }
    this.mediaChunkOutput = new BaseMediaChunkOutput(paramArrayOfFormat, paramT);
    this.pendingResetPositionUs = paramLong;
    this.lastSeekPositionUs = paramLong;
  }
  
  private void discardDownstreamMediaChunks(int paramInt)
  {
    paramInt = primaryStreamIndexToMediaChunkIndex(paramInt, 0);
    if (paramInt > 0) {
      Util.removeRange(this.mediaChunks, 0, paramInt);
    }
  }
  
  private BaseMediaChunk discardUpstreamMediaChunksFromIndex(int paramInt)
  {
    int i = 0;
    BaseMediaChunk localBaseMediaChunk = (BaseMediaChunk)this.mediaChunks.get(paramInt);
    Util.removeRange(this.mediaChunks, paramInt, this.mediaChunks.size());
    this.primarySampleQueue.discardUpstreamSamples(localBaseMediaChunk.getFirstSampleIndex(0));
    paramInt = i;
    while (paramInt < this.embeddedSampleQueues.length)
    {
      this.embeddedSampleQueues[paramInt].discardUpstreamSamples(localBaseMediaChunk.getFirstSampleIndex(paramInt + 1));
      paramInt += 1;
    }
    return localBaseMediaChunk;
  }
  
  private BaseMediaChunk getLastMediaChunk()
  {
    return (BaseMediaChunk)this.mediaChunks.get(this.mediaChunks.size() - 1);
  }
  
  private boolean haveReadFromMediaChunk(int paramInt)
  {
    boolean bool2 = false;
    BaseMediaChunk localBaseMediaChunk = (BaseMediaChunk)this.mediaChunks.get(paramInt);
    boolean bool1;
    if (this.primarySampleQueue.getReadIndex() > localBaseMediaChunk.getFirstSampleIndex(0))
    {
      bool1 = true;
      return bool1;
    }
    paramInt = 0;
    for (;;)
    {
      bool1 = bool2;
      if (paramInt >= this.embeddedSampleQueues.length) {
        break;
      }
      if (this.embeddedSampleQueues[paramInt].getReadIndex() > localBaseMediaChunk.getFirstSampleIndex(paramInt + 1)) {
        return true;
      }
      paramInt += 1;
    }
  }
  
  private boolean isMediaChunk(Chunk paramChunk)
  {
    return paramChunk instanceof BaseMediaChunk;
  }
  
  private void maybeNotifyPrimaryTrackFormatChanged(int paramInt)
  {
    BaseMediaChunk localBaseMediaChunk = (BaseMediaChunk)this.mediaChunks.get(paramInt);
    Format localFormat = localBaseMediaChunk.trackFormat;
    if (!localFormat.equals(this.primaryDownstreamTrackFormat)) {
      this.eventDispatcher.downstreamFormatChanged(this.primaryTrackType, localFormat, localBaseMediaChunk.trackSelectionReason, localBaseMediaChunk.trackSelectionData, localBaseMediaChunk.startTimeUs);
    }
    this.primaryDownstreamTrackFormat = localFormat;
  }
  
  private void maybeNotifyPrimaryTrackFormatChanged(int paramInt1, int paramInt2)
  {
    int i = primaryStreamIndexToMediaChunkIndex(paramInt1 - paramInt2, 0);
    if (paramInt2 == 1) {
      paramInt1 = i;
    }
    while (i <= paramInt1)
    {
      maybeNotifyPrimaryTrackFormatChanged(i);
      i += 1;
      continue;
      paramInt1 = primaryStreamIndexToMediaChunkIndex(paramInt1 - 1, i);
    }
  }
  
  private int primaryStreamIndexToMediaChunkIndex(int paramInt1, int paramInt2)
  {
    paramInt2 += 1;
    while (paramInt2 < this.mediaChunks.size())
    {
      if (((BaseMediaChunk)this.mediaChunks.get(paramInt2)).getFirstSampleIndex(0) > paramInt1) {
        return paramInt2 - 1;
      }
      paramInt2 += 1;
    }
    return this.mediaChunks.size() - 1;
  }
  
  public boolean continueLoading(long paramLong)
  {
    if ((this.loadingFinished) || (this.loader.isLoading())) {
      return false;
    }
    boolean bool1 = isPendingReset();
    Object localObject;
    if (bool1) {
      localObject = null;
    }
    for (long l = this.pendingResetPositionUs;; l = ((MediaChunk)localObject).endTimeUs)
    {
      this.chunkSource.getNextChunk((MediaChunk)localObject, paramLong, l, this.nextChunkHolder);
      boolean bool2 = this.nextChunkHolder.endOfStream;
      localObject = this.nextChunkHolder.chunk;
      this.nextChunkHolder.clear();
      if (!bool2) {
        break;
      }
      this.pendingResetPositionUs = -9223372036854775807L;
      this.loadingFinished = true;
      return true;
      localObject = getLastMediaChunk();
    }
    if (localObject == null) {
      return false;
    }
    BaseMediaChunk localBaseMediaChunk;
    int i;
    if (isMediaChunk((Chunk)localObject))
    {
      localBaseMediaChunk = (BaseMediaChunk)localObject;
      if (bool1)
      {
        if (localBaseMediaChunk.startTimeUs != this.pendingResetPositionUs) {
          break label263;
        }
        i = 1;
        if (i == 0) {
          break label268;
        }
      }
    }
    label263:
    label268:
    for (paramLong = -9223372036854775808L;; paramLong = this.pendingResetPositionUs)
    {
      this.decodeOnlyUntilPositionUs = paramLong;
      this.pendingResetPositionUs = -9223372036854775807L;
      localBaseMediaChunk.init(this.mediaChunkOutput);
      this.mediaChunks.add(localBaseMediaChunk);
      paramLong = this.loader.startLoading((Loader.Loadable)localObject, this, this.minLoadableRetryCount);
      this.eventDispatcher.loadStarted(((Chunk)localObject).dataSpec, ((Chunk)localObject).type, this.primaryTrackType, ((Chunk)localObject).trackFormat, ((Chunk)localObject).trackSelectionReason, ((Chunk)localObject).trackSelectionData, ((Chunk)localObject).startTimeUs, ((Chunk)localObject).endTimeUs, paramLong);
      return true;
      i = 0;
      break;
    }
  }
  
  public void discardBuffer(long paramLong, boolean paramBoolean)
  {
    int i = this.primarySampleQueue.getFirstIndex();
    this.primarySampleQueue.discardTo(paramLong, paramBoolean, true);
    int j = this.primarySampleQueue.getFirstIndex();
    if (j > i)
    {
      paramLong = this.primarySampleQueue.getFirstTimestampUs();
      i = 0;
      while (i < this.embeddedSampleQueues.length)
      {
        this.embeddedSampleQueues[i].discardTo(paramLong, paramBoolean, this.embeddedTracksSelected[i]);
        i += 1;
      }
      discardDownstreamMediaChunks(j);
    }
  }
  
  public long getAdjustedSeekPositionUs(long paramLong, SeekParameters paramSeekParameters)
  {
    return this.chunkSource.getAdjustedSeekPositionUs(paramLong, paramSeekParameters);
  }
  
  public long getBufferedPositionUs()
  {
    if (this.loadingFinished) {
      return -9223372036854775808L;
    }
    if (isPendingReset()) {
      return this.pendingResetPositionUs;
    }
    long l = this.lastSeekPositionUs;
    BaseMediaChunk localBaseMediaChunk = getLastMediaChunk();
    if (localBaseMediaChunk.isLoadCompleted())
    {
      if (localBaseMediaChunk == null) {
        break label104;
      }
      l = Math.max(l, localBaseMediaChunk.endTimeUs);
    }
    label104:
    for (;;)
    {
      return Math.max(l, this.primarySampleQueue.getLargestQueuedTimestampUs());
      if (this.mediaChunks.size() > 1)
      {
        localBaseMediaChunk = (BaseMediaChunk)this.mediaChunks.get(this.mediaChunks.size() - 2);
        break;
      }
      localBaseMediaChunk = null;
      break;
    }
  }
  
  public T getChunkSource()
  {
    return this.chunkSource;
  }
  
  public long getNextLoadPositionUs()
  {
    if (isPendingReset()) {
      return this.pendingResetPositionUs;
    }
    if (this.loadingFinished) {
      return -9223372036854775808L;
    }
    return getLastMediaChunk().endTimeUs;
  }
  
  boolean isPendingReset()
  {
    return this.pendingResetPositionUs != -9223372036854775807L;
  }
  
  public boolean isReady()
  {
    return (this.loadingFinished) || ((!isPendingReset()) && (this.primarySampleQueue.hasNextSample()));
  }
  
  public void maybeThrowError()
  {
    this.loader.maybeThrowError();
    if (!this.loader.isLoading()) {
      this.chunkSource.maybeThrowError();
    }
  }
  
  public void onLoadCanceled(Chunk paramChunk, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.eventDispatcher.loadCanceled(paramChunk.dataSpec, paramChunk.type, this.primaryTrackType, paramChunk.trackFormat, paramChunk.trackSelectionReason, paramChunk.trackSelectionData, paramChunk.startTimeUs, paramChunk.endTimeUs, paramLong1, paramLong2, paramChunk.bytesLoaded());
    if (!paramBoolean)
    {
      this.primarySampleQueue.reset();
      paramChunk = this.embeddedSampleQueues;
      int j = paramChunk.length;
      int i = 0;
      while (i < j)
      {
        paramChunk[i].reset();
        i += 1;
      }
      this.callback.onContinueLoadingRequested(this);
    }
  }
  
  public void onLoadCompleted(Chunk paramChunk, long paramLong1, long paramLong2)
  {
    this.chunkSource.onChunkLoadCompleted(paramChunk);
    this.eventDispatcher.loadCompleted(paramChunk.dataSpec, paramChunk.type, this.primaryTrackType, paramChunk.trackFormat, paramChunk.trackSelectionReason, paramChunk.trackSelectionData, paramChunk.startTimeUs, paramChunk.endTimeUs, paramLong1, paramLong2, paramChunk.bytesLoaded());
    this.callback.onContinueLoadingRequested(this);
  }
  
  public int onLoadError(Chunk paramChunk, long paramLong1, long paramLong2, IOException paramIOException)
  {
    long l = paramChunk.bytesLoaded();
    boolean bool4 = isMediaChunk(paramChunk);
    int i = this.mediaChunks.size() - 1;
    boolean bool2;
    if ((l == 0L) || (!bool4) || (!haveReadFromMediaChunk(i)))
    {
      bool2 = true;
      boolean bool3 = false;
      bool1 = bool3;
      if (this.chunkSource.onChunkLoadError(paramChunk, bool2, paramIOException))
      {
        if (bool2) {
          break label161;
        }
        Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
        bool1 = bool3;
      }
    }
    label161:
    do
    {
      this.eventDispatcher.loadError(paramChunk.dataSpec, paramChunk.type, this.primaryTrackType, paramChunk.trackFormat, paramChunk.trackSelectionReason, paramChunk.trackSelectionData, paramChunk.startTimeUs, paramChunk.endTimeUs, paramLong1, paramLong2, l, paramIOException, bool1);
      if (!bool1) {
        break label226;
      }
      this.callback.onContinueLoadingRequested(this);
      return 2;
      bool2 = false;
      break;
      bool2 = true;
      bool1 = bool2;
    } while (!bool4);
    if (discardUpstreamMediaChunksFromIndex(i) == paramChunk) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Assertions.checkState(bool1);
      bool1 = bool2;
      if (!this.mediaChunks.isEmpty()) {
        break;
      }
      this.pendingResetPositionUs = this.lastSeekPositionUs;
      bool1 = bool2;
      break;
    }
    label226:
    return 0;
  }
  
  public void onLoaderReleased()
  {
    this.primarySampleQueue.reset();
    SampleQueue[] arrayOfSampleQueue = this.embeddedSampleQueues;
    int j = arrayOfSampleQueue.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSampleQueue[i].reset();
      i += 1;
    }
    if (this.releaseCallback != null) {
      this.releaseCallback.onSampleStreamReleased(this);
    }
  }
  
  public int readData(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
  {
    int i;
    if (isPendingReset()) {
      i = -3;
    }
    int j;
    do
    {
      return i;
      j = this.primarySampleQueue.read(paramFormatHolder, paramDecoderInputBuffer, paramBoolean, this.loadingFinished, this.decodeOnlyUntilPositionUs);
      i = j;
    } while (j != -4);
    maybeNotifyPrimaryTrackFormatChanged(this.primarySampleQueue.getReadIndex(), 1);
    return j;
  }
  
  public void reevaluateBuffer(long paramLong)
  {
    if ((this.loader.isLoading()) || (isPendingReset())) {}
    label135:
    for (;;)
    {
      return;
      int j = this.mediaChunks.size();
      int i = this.chunkSource.getPreferredQueueSize(paramLong, this.readOnlyMediaChunks);
      if (j > i)
      {
        if (i < j) {
          if (haveReadFromMediaChunk(i)) {}
        }
        for (;;)
        {
          if (i == j) {
            break label135;
          }
          paramLong = getLastMediaChunk().endTimeUs;
          BaseMediaChunk localBaseMediaChunk = discardUpstreamMediaChunksFromIndex(i);
          if (this.mediaChunks.isEmpty()) {
            this.pendingResetPositionUs = this.lastSeekPositionUs;
          }
          this.loadingFinished = false;
          this.eventDispatcher.upstreamDiscarded(this.primaryTrackType, localBaseMediaChunk.startTimeUs, paramLong);
          return;
          i += 1;
          break;
          i = j;
        }
      }
    }
  }
  
  public void release()
  {
    release(null);
  }
  
  public void release(@Nullable ChunkSampleStream.ReleaseCallback<T> paramReleaseCallback)
  {
    this.releaseCallback = paramReleaseCallback;
    this.primarySampleQueue.discardToEnd();
    paramReleaseCallback = this.embeddedSampleQueues;
    int j = paramReleaseCallback.length;
    int i = 0;
    while (i < j)
    {
      paramReleaseCallback[i].discardToEnd();
      i += 1;
    }
    this.loader.release(this);
  }
  
  public void seekToUs(long paramLong)
  {
    int j = 0;
    this.lastSeekPositionUs = paramLong;
    this.primarySampleQueue.rewind();
    boolean bool;
    Object localObject1;
    int i;
    label78:
    long l;
    if (isPendingReset())
    {
      bool = false;
      if (bool)
      {
        localObject1 = this.embeddedSampleQueues;
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          localObject2.rewind();
          localObject2.advanceTo(paramLong, true, false);
          i += 1;
        }
      }
    }
    else
    {
      i = 0;
      if (i >= this.mediaChunks.size()) {
        break label299;
      }
      localObject1 = (BaseMediaChunk)this.mediaChunks.get(i);
      l = ((BaseMediaChunk)localObject1).startTimeUs;
      if (l != paramLong) {}
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        bool = this.primarySampleQueue.setReadPosition(((BaseMediaChunk)localObject1).getFirstSampleIndex(0));
        this.decodeOnlyUntilPositionUs = -9223372036854775808L;
        break;
        if (l > paramLong)
        {
          localObject1 = null;
          continue;
        }
        i += 1;
        break label78;
      }
      localObject1 = this.primarySampleQueue;
      if (paramLong < getNextLoadPositionUs())
      {
        bool = true;
        label184:
        if (((SampleQueue)localObject1).advanceTo(paramLong, true, bool) == -1) {
          break label217;
        }
      }
      label217:
      for (bool = true;; bool = false)
      {
        this.decodeOnlyUntilPositionUs = this.lastSeekPositionUs;
        break;
        bool = false;
        break label184;
      }
      this.pendingResetPositionUs = paramLong;
      this.loadingFinished = false;
      this.mediaChunks.clear();
      if (this.loader.isLoading()) {
        this.loader.cancelLoading();
      }
      for (;;)
      {
        return;
        this.primarySampleQueue.reset();
        localObject1 = this.embeddedSampleQueues;
        int k = localObject1.length;
        i = j;
        while (i < k)
        {
          localObject1[i].reset();
          i += 1;
        }
      }
      label299:
      localObject1 = null;
    }
  }
  
  public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long paramLong, int paramInt)
  {
    boolean bool = false;
    int i = 0;
    while (i < this.embeddedSampleQueues.length)
    {
      if (this.embeddedTrackTypes[i] == paramInt)
      {
        if (this.embeddedTracksSelected[i] == 0) {
          bool = true;
        }
        Assertions.checkState(bool);
        this.embeddedTracksSelected[i] = true;
        this.embeddedSampleQueues[i].rewind();
        this.embeddedSampleQueues[i].advanceTo(paramLong, true, true);
        return new ChunkSampleStream.EmbeddedSampleStream(this, this, this.embeddedSampleQueues[i], i);
      }
      i += 1;
    }
    throw new IllegalStateException();
  }
  
  public int skipData(long paramLong)
  {
    int i = 0;
    int j = 0;
    if (isPendingReset()) {
      return j;
    }
    if ((this.loadingFinished) && (paramLong > this.primarySampleQueue.getLargestQueuedTimestampUs())) {
      i = this.primarySampleQueue.advanceToEnd();
    }
    for (;;)
    {
      j = i;
      if (i <= 0) {
        break;
      }
      maybeNotifyPrimaryTrackFormatChanged(this.primarySampleQueue.getReadIndex(), i);
      return i;
      j = this.primarySampleQueue.advanceTo(paramLong, true, true);
      if (j != -1) {
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.ChunkSampleStream
 * JD-Core Version:    0.7.0.1
 */