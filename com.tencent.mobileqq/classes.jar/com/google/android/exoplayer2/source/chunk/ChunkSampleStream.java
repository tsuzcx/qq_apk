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
    int i = 0;
    if (paramArrayOfInt == null) {
      paramInt2 = 0;
    } else {
      paramInt2 = paramArrayOfInt.length;
    }
    this.embeddedSampleQueues = new SampleQueue[paramInt2];
    this.embeddedTracksSelected = new boolean[paramInt2];
    int j = paramInt2 + 1;
    paramArrayOfFormat = new int[j];
    paramT = new SampleQueue[j];
    this.primarySampleQueue = new SampleQueue(paramAllocator);
    paramArrayOfFormat[0] = paramInt1;
    paramT[0] = this.primarySampleQueue;
    for (paramInt1 = i; paramInt1 < paramInt2; paramInt1 = i)
    {
      paramCallback = new SampleQueue(paramAllocator);
      this.embeddedSampleQueues[paramInt1] = paramCallback;
      i = paramInt1 + 1;
      paramT[i] = paramCallback;
      paramArrayOfFormat[i] = paramArrayOfInt[paramInt1];
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
    BaseMediaChunk localBaseMediaChunk = (BaseMediaChunk)this.mediaChunks.get(paramInt);
    Object localObject = this.mediaChunks;
    Util.removeRange((List)localObject, paramInt, ((ArrayList)localObject).size());
    localObject = this.primarySampleQueue;
    paramInt = 0;
    ((SampleQueue)localObject).discardUpstreamSamples(localBaseMediaChunk.getFirstSampleIndex(0));
    for (;;)
    {
      localObject = this.embeddedSampleQueues;
      if (paramInt >= localObject.length) {
        break;
      }
      localObject = localObject[paramInt];
      paramInt += 1;
      ((SampleQueue)localObject).discardUpstreamSamples(localBaseMediaChunk.getFirstSampleIndex(paramInt));
    }
    return localBaseMediaChunk;
  }
  
  private BaseMediaChunk getLastMediaChunk()
  {
    ArrayList localArrayList = this.mediaChunks;
    return (BaseMediaChunk)localArrayList.get(localArrayList.size() - 1);
  }
  
  private boolean haveReadFromMediaChunk(int paramInt)
  {
    BaseMediaChunk localBaseMediaChunk = (BaseMediaChunk)this.mediaChunks.get(paramInt);
    if (this.primarySampleQueue.getReadIndex() > localBaseMediaChunk.getFirstSampleIndex(0)) {
      return true;
    }
    paramInt = 0;
    int j;
    int i;
    do
    {
      SampleQueue[] arrayOfSampleQueue = this.embeddedSampleQueues;
      if (paramInt >= arrayOfSampleQueue.length) {
        break;
      }
      j = arrayOfSampleQueue[paramInt].getReadIndex();
      i = paramInt + 1;
      paramInt = i;
    } while (j <= localBaseMediaChunk.getFirstSampleIndex(i));
    return true;
    return false;
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
    } else {
      paramInt1 = primaryStreamIndexToMediaChunkIndex(paramInt1 - 1, i);
    }
    while (i <= paramInt1)
    {
      maybeNotifyPrimaryTrackFormatChanged(i);
      i += 1;
    }
  }
  
  private int primaryStreamIndexToMediaChunkIndex(int paramInt1, int paramInt2)
  {
    int i;
    do
    {
      i = paramInt2 + 1;
      if (i >= this.mediaChunks.size()) {
        break;
      }
      paramInt2 = i;
    } while (((BaseMediaChunk)this.mediaChunks.get(i)).getFirstSampleIndex(0) <= paramInt1);
    return i - 1;
    return this.mediaChunks.size() - 1;
  }
  
  public boolean continueLoading(long paramLong)
  {
    boolean bool1 = this.loadingFinished;
    int i = 0;
    if (!bool1)
    {
      if (this.loader.isLoading()) {
        return false;
      }
      bool1 = isPendingReset();
      long l;
      if (bool1)
      {
        localObject = null;
        l = this.pendingResetPositionUs;
      }
      else
      {
        localObject = getLastMediaChunk();
        l = ((MediaChunk)localObject).endTimeUs;
      }
      this.chunkSource.getNextChunk((MediaChunk)localObject, paramLong, l, this.nextChunkHolder);
      boolean bool2 = this.nextChunkHolder.endOfStream;
      Object localObject = this.nextChunkHolder.chunk;
      this.nextChunkHolder.clear();
      if (bool2)
      {
        this.pendingResetPositionUs = -9223372036854775807L;
        this.loadingFinished = true;
        return true;
      }
      if (localObject == null) {
        return false;
      }
      if (isMediaChunk((Chunk)localObject))
      {
        BaseMediaChunk localBaseMediaChunk = (BaseMediaChunk)localObject;
        if (bool1)
        {
          if (localBaseMediaChunk.startTimeUs == this.pendingResetPositionUs) {
            i = 1;
          }
          if (i != 0) {
            paramLong = -9223372036854775808L;
          } else {
            paramLong = this.pendingResetPositionUs;
          }
          this.decodeOnlyUntilPositionUs = paramLong;
          this.pendingResetPositionUs = -9223372036854775807L;
        }
        localBaseMediaChunk.init(this.mediaChunkOutput);
        this.mediaChunks.add(localBaseMediaChunk);
      }
      paramLong = this.loader.startLoading((Loader.Loadable)localObject, this, this.minLoadableRetryCount);
      this.eventDispatcher.loadStarted(((Chunk)localObject).dataSpec, ((Chunk)localObject).type, this.primaryTrackType, ((Chunk)localObject).trackFormat, ((Chunk)localObject).trackSelectionReason, ((Chunk)localObject).trackSelectionData, ((Chunk)localObject).startTimeUs, ((Chunk)localObject).endTimeUs, paramLong);
      return true;
    }
    return false;
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
      for (;;)
      {
        SampleQueue[] arrayOfSampleQueue = this.embeddedSampleQueues;
        if (i >= arrayOfSampleQueue.length) {
          break;
        }
        arrayOfSampleQueue[i].discardTo(paramLong, paramBoolean, this.embeddedTracksSelected[i]);
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
    long l2 = this.lastSeekPositionUs;
    Object localObject = getLastMediaChunk();
    if (!((BaseMediaChunk)localObject).isLoadCompleted()) {
      if (this.mediaChunks.size() > 1)
      {
        localObject = this.mediaChunks;
        localObject = (BaseMediaChunk)((ArrayList)localObject).get(((ArrayList)localObject).size() - 2);
      }
      else
      {
        localObject = null;
      }
    }
    long l1 = l2;
    if (localObject != null) {
      l1 = Math.max(l2, ((BaseMediaChunk)localObject).endTimeUs);
    }
    return Math.max(l1, this.primarySampleQueue.getLargestQueuedTimestampUs());
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
    boolean bool2 = isMediaChunk(paramChunk);
    int i = this.mediaChunks.size() - 1;
    if ((l != 0L) && (bool2) && (haveReadFromMediaChunk(i))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (this.chunkSource.onChunkLoadError(paramChunk, bool1, paramIOException)) {
      if (!bool1)
      {
        Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
      }
      else
      {
        if (bool2)
        {
          if (discardUpstreamMediaChunksFromIndex(i) == paramChunk) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          Assertions.checkState(bool1);
          if (this.mediaChunks.isEmpty()) {
            this.pendingResetPositionUs = this.lastSeekPositionUs;
          }
        }
        bool1 = true;
        break label147;
      }
    }
    boolean bool1 = false;
    label147:
    this.eventDispatcher.loadError(paramChunk.dataSpec, paramChunk.type, this.primaryTrackType, paramChunk.trackFormat, paramChunk.trackSelectionReason, paramChunk.trackSelectionData, paramChunk.startTimeUs, paramChunk.endTimeUs, paramLong1, paramLong2, l, paramIOException, bool1);
    if (bool1)
    {
      this.callback.onContinueLoadingRequested(this);
      return 2;
    }
    return 0;
  }
  
  public void onLoaderReleased()
  {
    this.primarySampleQueue.reset();
    Object localObject = this.embeddedSampleQueues;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].reset();
      i += 1;
    }
    localObject = this.releaseCallback;
    if (localObject != null) {
      ((ChunkSampleStream.ReleaseCallback)localObject).onSampleStreamReleased(this);
    }
  }
  
  public int readData(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
  {
    if (isPendingReset()) {
      return -3;
    }
    int i = this.primarySampleQueue.read(paramFormatHolder, paramDecoderInputBuffer, paramBoolean, this.loadingFinished, this.decodeOnlyUntilPositionUs);
    if (i == -4) {
      maybeNotifyPrimaryTrackFormatChanged(this.primarySampleQueue.getReadIndex(), 1);
    }
    return i;
  }
  
  public void reevaluateBuffer(long paramLong)
  {
    if (!this.loader.isLoading())
    {
      if (isPendingReset()) {
        return;
      }
      int j = this.mediaChunks.size();
      int k = this.chunkSource.getPreferredQueueSize(paramLong, this.readOnlyMediaChunks);
      int i = k;
      if (j <= k) {
        return;
      }
      while (i < j)
      {
        if (!haveReadFromMediaChunk(i)) {
          break label81;
        }
        i += 1;
      }
      i = j;
      label81:
      if (i == j) {
        return;
      }
      paramLong = getLastMediaChunk().endTimeUs;
      BaseMediaChunk localBaseMediaChunk = discardUpstreamMediaChunksFromIndex(i);
      if (this.mediaChunks.isEmpty()) {
        this.pendingResetPositionUs = this.lastSeekPositionUs;
      }
      this.loadingFinished = false;
      this.eventDispatcher.upstreamDiscarded(this.primaryTrackType, localBaseMediaChunk.startTimeUs, paramLong);
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
    this.lastSeekPositionUs = paramLong;
    this.primarySampleQueue.rewind();
    boolean bool = isPendingReset();
    int j = 0;
    Object localObject2;
    if (bool)
    {
      bool = false;
    }
    else
    {
      localObject2 = null;
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= this.mediaChunks.size()) {
          break;
        }
        localObject1 = (BaseMediaChunk)this.mediaChunks.get(i);
        long l = ((BaseMediaChunk)localObject1).startTimeUs;
        if (l == paramLong) {
          break;
        }
        if (l > paramLong)
        {
          localObject1 = localObject2;
          break;
        }
        i += 1;
      }
      if (localObject1 != null)
      {
        bool = this.primarySampleQueue.setReadPosition(((BaseMediaChunk)localObject1).getFirstSampleIndex(0));
        this.decodeOnlyUntilPositionUs = -9223372036854775808L;
      }
      else
      {
        localObject1 = this.primarySampleQueue;
        if (paramLong < getNextLoadPositionUs()) {
          bool = true;
        } else {
          bool = false;
        }
        if (((SampleQueue)localObject1).advanceTo(paramLong, true, bool) != -1) {
          bool = true;
        } else {
          bool = false;
        }
        this.decodeOnlyUntilPositionUs = this.lastSeekPositionUs;
      }
    }
    if (bool)
    {
      localObject1 = this.embeddedSampleQueues;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        localObject2.rewind();
        localObject2.advanceTo(paramLong, true, false);
        i += 1;
      }
    }
    this.pendingResetPositionUs = paramLong;
    this.loadingFinished = false;
    this.mediaChunks.clear();
    if (this.loader.isLoading())
    {
      this.loader.cancelLoading();
      return;
    }
    this.primarySampleQueue.reset();
    Object localObject1 = this.embeddedSampleQueues;
    int k = localObject1.length;
    int i = j;
    while (i < k)
    {
      localObject1[i].reset();
      i += 1;
    }
  }
  
  public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long paramLong, int paramInt)
  {
    int i = 0;
    while (i < this.embeddedSampleQueues.length)
    {
      if (this.embeddedTrackTypes[i] == paramInt)
      {
        Assertions.checkState(this.embeddedTracksSelected[i] ^ 0x1);
        this.embeddedTracksSelected[i] = true;
        this.embeddedSampleQueues[i].rewind();
        this.embeddedSampleQueues[i].advanceTo(paramLong, true, true);
        return new ChunkSampleStream.EmbeddedSampleStream(this, this, this.embeddedSampleQueues[i], i);
      }
      i += 1;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    for (;;)
    {
      throw localIllegalStateException;
    }
  }
  
  public int skipData(long paramLong)
  {
    boolean bool = isPendingReset();
    int i = 0;
    if (bool) {
      return 0;
    }
    if ((this.loadingFinished) && (paramLong > this.primarySampleQueue.getLargestQueuedTimestampUs()))
    {
      i = this.primarySampleQueue.advanceToEnd();
    }
    else
    {
      int j = this.primarySampleQueue.advanceTo(paramLong, true, true);
      if (j != -1) {
        i = j;
      }
    }
    if (i > 0) {
      maybeNotifyPrimaryTrackFormatChanged(this.primarySampleQueue.getReadIndex(), i);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.chunk.ChunkSampleStream
 * JD-Core Version:    0.7.0.1
 */