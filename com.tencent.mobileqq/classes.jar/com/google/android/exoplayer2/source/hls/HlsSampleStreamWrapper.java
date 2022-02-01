package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

final class HlsSampleStreamWrapper
  implements ExtractorOutput, SampleQueue.UpstreamFormatChangedListener, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback
{
  private static final int PRIMARY_TYPE_AUDIO = 2;
  private static final int PRIMARY_TYPE_NONE = 0;
  private static final int PRIMARY_TYPE_TEXT = 1;
  private static final int PRIMARY_TYPE_VIDEO = 3;
  private static final String TAG = "HlsSampleStreamWrapper";
  private final Allocator allocator;
  private int audioSampleQueueIndex;
  private boolean audioSampleQueueMappingDone;
  private final HlsSampleStreamWrapper.Callback callback;
  private final HlsChunkSource chunkSource;
  private Format downstreamTrackFormat;
  private int enabledTrackGroupCount;
  private final MediaSourceEventListener.EventDispatcher eventDispatcher;
  private final Handler handler;
  private boolean haveAudioVideoSampleQueues;
  private long lastSeekPositionUs;
  private final Loader loader;
  private boolean loadingFinished;
  private final Runnable maybeFinishPrepareRunnable;
  private final ArrayList<HlsMediaChunk> mediaChunks;
  private final int minLoadableRetryCount;
  private final Format muxedAudioFormat;
  private final HlsChunkSource.HlsChunkHolder nextChunkHolder;
  private final Runnable onTracksEndedRunnable;
  private long pendingResetPositionUs;
  private boolean pendingResetUpstreamFormats;
  private boolean prepared;
  private int primaryTrackGroupIndex;
  private boolean released;
  private long sampleOffsetUs;
  private boolean[] sampleQueueIsAudioVideoFlags;
  private int[] sampleQueueTrackIds;
  private SampleQueue[] sampleQueues;
  private boolean sampleQueuesBuilt;
  private boolean[] sampleQueuesEnabledStates;
  private boolean seenFirstTrackSelection;
  private int[] trackGroupToSampleQueueIndex;
  private TrackGroupArray trackGroups;
  private final int trackType;
  private boolean tracksEnded;
  private int videoSampleQueueIndex;
  private boolean videoSampleQueueMappingDone;
  
  public HlsSampleStreamWrapper(int paramInt1, HlsSampleStreamWrapper.Callback paramCallback, HlsChunkSource paramHlsChunkSource, Allocator paramAllocator, long paramLong, Format paramFormat, int paramInt2, MediaSourceEventListener.EventDispatcher paramEventDispatcher)
  {
    this.trackType = paramInt1;
    this.callback = paramCallback;
    this.chunkSource = paramHlsChunkSource;
    this.allocator = paramAllocator;
    this.muxedAudioFormat = paramFormat;
    this.minLoadableRetryCount = paramInt2;
    this.eventDispatcher = paramEventDispatcher;
    this.loader = new Loader("Loader:HlsSampleStreamWrapper");
    this.nextChunkHolder = new HlsChunkSource.HlsChunkHolder();
    this.sampleQueueTrackIds = new int[0];
    this.audioSampleQueueIndex = -1;
    this.videoSampleQueueIndex = -1;
    this.sampleQueues = new SampleQueue[0];
    this.sampleQueueIsAudioVideoFlags = new boolean[0];
    this.sampleQueuesEnabledStates = new boolean[0];
    this.mediaChunks = new ArrayList();
    this.maybeFinishPrepareRunnable = new HlsSampleStreamWrapper.1(this);
    this.onTracksEndedRunnable = new HlsSampleStreamWrapper.2(this);
    this.handler = new Handler();
    this.lastSeekPositionUs = paramLong;
    this.pendingResetPositionUs = paramLong;
  }
  
  private void buildTracks()
  {
    int i2 = this.sampleQueues.length;
    int j = 0;
    int m = 0;
    Object localObject;
    for (int n = -1;; n = k)
    {
      i = 3;
      if (j >= i2) {
        break;
      }
      localObject = this.sampleQueues[j].getUpstreamFormat().sampleMimeType;
      if (!MimeTypes.isVideo((String)localObject)) {
        if (MimeTypes.isAudio((String)localObject)) {
          i = 2;
        } else if (MimeTypes.isText((String)localObject)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      int i1;
      if (i > m)
      {
        k = j;
        i1 = i;
      }
      else
      {
        i1 = m;
        k = n;
        if (i == m)
        {
          i1 = m;
          k = n;
          if (n != -1)
          {
            k = -1;
            i1 = m;
          }
        }
      }
      j += 1;
      m = i1;
    }
    TrackGroup localTrackGroup = this.chunkSource.getTrackGroup();
    int k = localTrackGroup.length;
    this.primaryTrackGroupIndex = -1;
    this.trackGroupToSampleQueueIndex = new int[i2];
    int i = 0;
    while (i < i2)
    {
      this.trackGroupToSampleQueueIndex[i] = i;
      i += 1;
    }
    TrackGroup[] arrayOfTrackGroup = new TrackGroup[i2];
    i = 0;
    while (i < i2)
    {
      Format localFormat = this.sampleQueues[i].getUpstreamFormat();
      if (i == n)
      {
        localObject = new Format[k];
        j = 0;
        while (j < k)
        {
          localObject[j] = deriveFormat(localTrackGroup.getFormat(j), localFormat, true);
          j += 1;
        }
        arrayOfTrackGroup[i] = new TrackGroup((Format[])localObject);
        this.primaryTrackGroupIndex = i;
      }
      else
      {
        if ((m == 3) && (MimeTypes.isAudio(localFormat.sampleMimeType))) {
          localObject = this.muxedAudioFormat;
        } else {
          localObject = null;
        }
        arrayOfTrackGroup[i] = new TrackGroup(new Format[] { deriveFormat((Format)localObject, localFormat, false) });
      }
      i += 1;
    }
    this.trackGroups = new TrackGroupArray(arrayOfTrackGroup);
  }
  
  private static DummyTrackOutput createDummyTrackOutput(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unmapped track with id ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" of type ");
    localStringBuilder.append(paramInt2);
    Log.w("HlsSampleStreamWrapper", localStringBuilder.toString());
    return new DummyTrackOutput();
  }
  
  private static Format deriveFormat(Format paramFormat1, Format paramFormat2, boolean paramBoolean)
  {
    if (paramFormat1 == null) {
      return paramFormat2;
    }
    int i;
    if (paramBoolean) {
      i = paramFormat1.bitrate;
    } else {
      i = -1;
    }
    int j = MimeTypes.getTrackType(paramFormat2.sampleMimeType);
    String str3 = Util.getCodecsOfType(paramFormat1.codecs, j);
    String str2 = MimeTypes.getMediaMimeType(str3);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramFormat2.sampleMimeType;
    }
    return paramFormat2.copyWithContainerInfo(paramFormat1.id, str1, str3, i, paramFormat1.width, paramFormat1.height, paramFormat1.selectionFlags, paramFormat1.language);
  }
  
  private boolean finishedReadingChunk(HlsMediaChunk paramHlsMediaChunk)
  {
    int j = paramHlsMediaChunk.uid;
    int k = this.sampleQueues.length;
    int i = 0;
    while (i < k)
    {
      if ((this.sampleQueuesEnabledStates[i] != 0) && (this.sampleQueues[i].peekSourceId() == j)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static boolean formatsMatch(Format paramFormat1, Format paramFormat2)
  {
    String str1 = paramFormat1.sampleMimeType;
    String str2 = paramFormat2.sampleMimeType;
    int i = MimeTypes.getTrackType(str1);
    if (i != 3) {
      return i == MimeTypes.getTrackType(str2);
    }
    if (!Util.areEqual(str1, str2)) {
      return false;
    }
    if ((!"application/cea-608".equals(str1)) && (!"application/cea-708".equals(str1))) {
      return true;
    }
    return paramFormat1.accessibilityChannel == paramFormat2.accessibilityChannel;
  }
  
  private HlsMediaChunk getLastMediaChunk()
  {
    ArrayList localArrayList = this.mediaChunks;
    return (HlsMediaChunk)localArrayList.get(localArrayList.size() - 1);
  }
  
  private static boolean isMediaChunk(Chunk paramChunk)
  {
    return paramChunk instanceof HlsMediaChunk;
  }
  
  private boolean isPendingReset()
  {
    return this.pendingResetPositionUs != -9223372036854775807L;
  }
  
  private void mapSampleQueuesToMatchTrackGroups()
  {
    int k = this.trackGroups.length;
    this.trackGroupToSampleQueueIndex = new int[k];
    Arrays.fill(this.trackGroupToSampleQueueIndex, -1);
    int i = 0;
    while (i < k)
    {
      int j = 0;
      for (;;)
      {
        SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
        if (j >= arrayOfSampleQueue.length) {
          break;
        }
        if (formatsMatch(arrayOfSampleQueue[j].getUpstreamFormat(), this.trackGroups.get(i).getFormat(0)))
        {
          this.trackGroupToSampleQueueIndex[i] = j;
          break;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  private void maybeFinishPrepare()
  {
    if ((!this.released) && (this.trackGroupToSampleQueueIndex == null))
    {
      if (!this.sampleQueuesBuilt) {
        return;
      }
      SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
      int j = arrayOfSampleQueue.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfSampleQueue[i].getUpstreamFormat() == null) {
          return;
        }
        i += 1;
      }
      if (this.trackGroups != null)
      {
        mapSampleQueuesToMatchTrackGroups();
        return;
      }
      buildTracks();
      this.prepared = true;
      this.callback.onPrepared();
    }
  }
  
  private void onTracksEnded()
  {
    this.sampleQueuesBuilt = true;
    maybeFinishPrepare();
  }
  
  private void resetSampleQueues()
  {
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int j = arrayOfSampleQueue.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSampleQueue[i].reset(this.pendingResetUpstreamFormats);
      i += 1;
    }
    this.pendingResetUpstreamFormats = false;
  }
  
  private boolean seekInsideBufferUs(long paramLong)
  {
    int k = this.sampleQueues.length;
    int i = 0;
    for (;;)
    {
      int j = 1;
      if (i >= k) {
        break;
      }
      SampleQueue localSampleQueue = this.sampleQueues[i];
      localSampleQueue.rewind();
      if (localSampleQueue.advanceTo(paramLong, true, false) == -1) {
        j = 0;
      }
      if ((j == 0) && ((this.sampleQueueIsAudioVideoFlags[i] != 0) || (!this.haveAudioVideoSampleQueues))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int bindSampleQueueToSampleStream(int paramInt)
  {
    if (!isMappingFinished()) {
      return -1;
    }
    paramInt = this.trackGroupToSampleQueueIndex[paramInt];
    if (paramInt == -1) {
      return -1;
    }
    boolean[] arrayOfBoolean = this.sampleQueuesEnabledStates;
    if (arrayOfBoolean[paramInt] != 0) {
      return -1;
    }
    arrayOfBoolean[paramInt] = true;
    return paramInt;
  }
  
  public boolean continueLoading(long paramLong)
  {
    if (!this.loadingFinished)
    {
      if (this.loader.isLoading()) {
        return false;
      }
      long l;
      if (isPendingReset())
      {
        localObject1 = null;
        l = this.pendingResetPositionUs;
      }
      else
      {
        localObject1 = getLastMediaChunk();
        l = ((HlsMediaChunk)localObject1).endTimeUs;
      }
      this.chunkSource.getNextChunk((HlsMediaChunk)localObject1, paramLong, l, this.nextChunkHolder);
      boolean bool = this.nextChunkHolder.endOfStream;
      Object localObject1 = this.nextChunkHolder.chunk;
      Object localObject2 = this.nextChunkHolder.playlist;
      this.nextChunkHolder.clear();
      if (bool)
      {
        this.pendingResetPositionUs = -9223372036854775807L;
        this.loadingFinished = true;
        return true;
      }
      if (localObject1 == null)
      {
        if (localObject2 != null) {
          this.callback.onPlaylistRefreshRequired((HlsMasterPlaylist.HlsUrl)localObject2);
        }
        return false;
      }
      if (isMediaChunk((Chunk)localObject1))
      {
        this.pendingResetPositionUs = -9223372036854775807L;
        localObject2 = (HlsMediaChunk)localObject1;
        ((HlsMediaChunk)localObject2).init(this);
        this.mediaChunks.add(localObject2);
      }
      paramLong = this.loader.startLoading((Loader.Loadable)localObject1, this, this.minLoadableRetryCount);
      this.eventDispatcher.loadStarted(((Chunk)localObject1).dataSpec, ((Chunk)localObject1).type, this.trackType, ((Chunk)localObject1).trackFormat, ((Chunk)localObject1).trackSelectionReason, ((Chunk)localObject1).trackSelectionData, ((Chunk)localObject1).startTimeUs, ((Chunk)localObject1).endTimeUs, paramLong);
      return true;
    }
    return false;
  }
  
  public void continuePreparing()
  {
    if (!this.prepared) {
      continueLoading(this.lastSeekPositionUs);
    }
  }
  
  public void discardBuffer(long paramLong, boolean paramBoolean)
  {
    if (!this.sampleQueuesBuilt) {
      return;
    }
    int j = this.sampleQueues.length;
    int i = 0;
    while (i < j)
    {
      this.sampleQueues[i].discardTo(paramLong, paramBoolean, this.sampleQueuesEnabledStates[i]);
      i += 1;
    }
  }
  
  public void endTracks()
  {
    this.tracksEnded = true;
    this.handler.post(this.onTracksEndedRunnable);
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
    if (!((HlsMediaChunk)localObject).isLoadCompleted()) {
      if (this.mediaChunks.size() > 1)
      {
        localObject = this.mediaChunks;
        localObject = (HlsMediaChunk)((ArrayList)localObject).get(((ArrayList)localObject).size() - 2);
      }
      else
      {
        localObject = null;
      }
    }
    long l1 = l2;
    if (localObject != null) {
      l1 = Math.max(l2, ((HlsMediaChunk)localObject).endTimeUs);
    }
    l2 = l1;
    if (this.sampleQueuesBuilt)
    {
      localObject = this.sampleQueues;
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l1 = Math.max(l1, localObject[i].getLargestQueuedTimestampUs());
        i += 1;
      }
    }
    return l2;
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
  
  public TrackGroupArray getTrackGroups()
  {
    return this.trackGroups;
  }
  
  public void init(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (!paramBoolean2)
    {
      this.audioSampleQueueMappingDone = false;
      this.videoSampleQueueMappingDone = false;
    }
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int k = arrayOfSampleQueue.length;
    int i = 0;
    while (i < k)
    {
      arrayOfSampleQueue[i].sourceId(paramInt);
      i += 1;
    }
    if (paramBoolean1)
    {
      arrayOfSampleQueue = this.sampleQueues;
      i = arrayOfSampleQueue.length;
      paramInt = j;
      while (paramInt < i)
      {
        arrayOfSampleQueue[paramInt].splice();
        paramInt += 1;
      }
    }
  }
  
  public boolean isMappingFinished()
  {
    return this.trackGroupToSampleQueueIndex != null;
  }
  
  public boolean isReady(int paramInt)
  {
    return (this.loadingFinished) || ((!isPendingReset()) && (this.sampleQueues[paramInt].hasNextSample()));
  }
  
  public void maybeThrowError()
  {
    this.loader.maybeThrowError();
    this.chunkSource.maybeThrowError();
  }
  
  public void maybeThrowPrepareError()
  {
    maybeThrowError();
  }
  
  public void onLoadCanceled(Chunk paramChunk, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.eventDispatcher.loadCanceled(paramChunk.dataSpec, paramChunk.type, this.trackType, paramChunk.trackFormat, paramChunk.trackSelectionReason, paramChunk.trackSelectionData, paramChunk.startTimeUs, paramChunk.endTimeUs, paramLong1, paramLong2, paramChunk.bytesLoaded());
    if (!paramBoolean)
    {
      resetSampleQueues();
      if (this.enabledTrackGroupCount > 0) {
        this.callback.onContinueLoadingRequested(this);
      }
    }
  }
  
  public void onLoadCompleted(Chunk paramChunk, long paramLong1, long paramLong2)
  {
    this.chunkSource.onChunkLoadCompleted(paramChunk);
    this.eventDispatcher.loadCompleted(paramChunk.dataSpec, paramChunk.type, this.trackType, paramChunk.trackFormat, paramChunk.trackSelectionReason, paramChunk.trackSelectionData, paramChunk.startTimeUs, paramChunk.endTimeUs, paramLong1, paramLong2, paramChunk.bytesLoaded());
    if (!this.prepared)
    {
      continueLoading(this.lastSeekPositionUs);
      return;
    }
    this.callback.onContinueLoadingRequested(this);
  }
  
  public int onLoadError(Chunk paramChunk, long paramLong1, long paramLong2, IOException paramIOException)
  {
    long l = paramChunk.bytesLoaded();
    boolean bool3 = isMediaChunk(paramChunk);
    boolean bool2 = true;
    boolean bool1;
    if ((bool3) && (l != 0L)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (this.chunkSource.onChunkLoadError(paramChunk, bool1, paramIOException))
    {
      bool1 = bool2;
      if (bool3)
      {
        ArrayList localArrayList = this.mediaChunks;
        if ((HlsMediaChunk)localArrayList.remove(localArrayList.size() - 1) == paramChunk) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        Assertions.checkState(bool1);
        bool1 = bool2;
        if (this.mediaChunks.isEmpty())
        {
          this.pendingResetPositionUs = this.lastSeekPositionUs;
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    this.eventDispatcher.loadError(paramChunk.dataSpec, paramChunk.type, this.trackType, paramChunk.trackFormat, paramChunk.trackSelectionReason, paramChunk.trackSelectionData, paramChunk.startTimeUs, paramChunk.endTimeUs, paramLong1, paramLong2, paramChunk.bytesLoaded(), paramIOException, bool1);
    if (bool1)
    {
      if (!this.prepared) {
        continueLoading(this.lastSeekPositionUs);
      } else {
        this.callback.onContinueLoadingRequested(this);
      }
      return 2;
    }
    return 0;
  }
  
  public void onLoaderReleased()
  {
    resetSampleQueues();
  }
  
  public void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl paramHlsUrl, long paramLong)
  {
    this.chunkSource.onPlaylistBlacklisted(paramHlsUrl, paramLong);
  }
  
  public void onUpstreamFormatChanged(Format paramFormat)
  {
    this.handler.post(this.maybeFinishPrepareRunnable);
  }
  
  public void prepareWithMasterPlaylistInfo(TrackGroupArray paramTrackGroupArray, int paramInt)
  {
    this.prepared = true;
    this.trackGroups = paramTrackGroupArray;
    this.primaryTrackGroupIndex = paramInt;
    this.callback.onPrepared();
  }
  
  public int readData(int paramInt, FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
  {
    if (isPendingReset()) {
      return -3;
    }
    if (!this.mediaChunks.isEmpty())
    {
      int i = 0;
      while ((i < this.mediaChunks.size() - 1) && (finishedReadingChunk((HlsMediaChunk)this.mediaChunks.get(i)))) {
        i += 1;
      }
      if (i > 0) {
        Util.removeRange(this.mediaChunks, 0, i);
      }
      HlsMediaChunk localHlsMediaChunk = (HlsMediaChunk)this.mediaChunks.get(0);
      Format localFormat = localHlsMediaChunk.trackFormat;
      if (!localFormat.equals(this.downstreamTrackFormat)) {
        this.eventDispatcher.downstreamFormatChanged(this.trackType, localFormat, localHlsMediaChunk.trackSelectionReason, localHlsMediaChunk.trackSelectionData, localHlsMediaChunk.startTimeUs);
      }
      this.downstreamTrackFormat = localFormat;
    }
    return this.sampleQueues[paramInt].read(paramFormatHolder, paramDecoderInputBuffer, paramBoolean, this.loadingFinished, this.lastSeekPositionUs);
  }
  
  public void reevaluateBuffer(long paramLong) {}
  
  public void release()
  {
    if (this.prepared)
    {
      SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
      int j = arrayOfSampleQueue.length;
      int i = 0;
      while (i < j)
      {
        arrayOfSampleQueue[i].discardToEnd();
        i += 1;
      }
    }
    this.loader.release(this);
    this.handler.removeCallbacksAndMessages(null);
    this.released = true;
  }
  
  public void seekMap(SeekMap paramSeekMap) {}
  
  public boolean seekToUs(long paramLong, boolean paramBoolean)
  {
    this.lastSeekPositionUs = paramLong;
    if ((this.sampleQueuesBuilt) && (!paramBoolean) && (!isPendingReset()) && (seekInsideBufferUs(paramLong))) {
      return false;
    }
    this.pendingResetPositionUs = paramLong;
    this.loadingFinished = false;
    this.mediaChunks.clear();
    if (this.loader.isLoading()) {
      this.loader.cancelLoading();
    } else {
      resetSampleQueues();
    }
    return true;
  }
  
  public boolean selectTracks(TrackSelection[] paramArrayOfTrackSelection, boolean[] paramArrayOfBoolean1, SampleStream[] paramArrayOfSampleStream, boolean[] paramArrayOfBoolean2, long paramLong, boolean paramBoolean)
  {
    Assertions.checkState(this.prepared);
    int m = this.enabledTrackGroupCount;
    int j = 0;
    int k = 0;
    int i = 0;
    while (i < paramArrayOfTrackSelection.length)
    {
      if ((paramArrayOfSampleStream[i] != null) && ((paramArrayOfTrackSelection[i] == null) || (paramArrayOfBoolean1[i] == 0)))
      {
        this.enabledTrackGroupCount -= 1;
        ((HlsSampleStream)paramArrayOfSampleStream[i]).unbindSampleQueue();
        paramArrayOfSampleStream[i] = null;
      }
      i += 1;
    }
    boolean bool1;
    if ((!paramBoolean) && (this.seenFirstTrackSelection ? m != 0 : paramLong == this.lastSeekPositionUs)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    TrackSelection localTrackSelection = this.chunkSource.getTrackSelection();
    paramArrayOfBoolean1 = localTrackSelection;
    i = 0;
    boolean bool2;
    while (i < paramArrayOfTrackSelection.length)
    {
      Object localObject = paramArrayOfBoolean1;
      bool2 = bool1;
      if (paramArrayOfSampleStream[i] == null)
      {
        localObject = paramArrayOfBoolean1;
        bool2 = bool1;
        if (paramArrayOfTrackSelection[i] != null)
        {
          this.enabledTrackGroupCount += 1;
          localObject = paramArrayOfTrackSelection[i];
          m = this.trackGroups.indexOf(((TrackSelection)localObject).getTrackGroup());
          if (m == this.primaryTrackGroupIndex)
          {
            this.chunkSource.selectTracks((TrackSelection)localObject);
            paramArrayOfBoolean1 = (boolean[])localObject;
          }
          paramArrayOfSampleStream[i] = new HlsSampleStream(this, m);
          paramArrayOfBoolean2[i] = true;
          localObject = paramArrayOfBoolean1;
          bool2 = bool1;
          if (this.sampleQueuesBuilt)
          {
            localObject = paramArrayOfBoolean1;
            bool2 = bool1;
            if (!bool1)
            {
              localObject = this.sampleQueues[this.trackGroupToSampleQueueIndex[m]];
              ((SampleQueue)localObject).rewind();
              if ((((SampleQueue)localObject).advanceTo(paramLong, true, true) == -1) && (((SampleQueue)localObject).getReadIndex() != 0))
              {
                bool2 = true;
                localObject = paramArrayOfBoolean1;
              }
              else
              {
                bool2 = false;
                localObject = paramArrayOfBoolean1;
              }
            }
          }
        }
      }
      i += 1;
      paramArrayOfBoolean1 = (boolean[])localObject;
      bool1 = bool2;
    }
    if (this.enabledTrackGroupCount == 0)
    {
      this.chunkSource.reset();
      this.downstreamTrackFormat = null;
      this.mediaChunks.clear();
      if (this.loader.isLoading())
      {
        if (this.sampleQueuesBuilt)
        {
          paramArrayOfTrackSelection = this.sampleQueues;
          j = paramArrayOfTrackSelection.length;
          i = k;
          while (i < j)
          {
            paramArrayOfTrackSelection[i].discardToEnd();
            i += 1;
          }
        }
        this.loader.cancelLoading();
        bool2 = bool1;
      }
      else
      {
        resetSampleQueues();
        bool2 = bool1;
      }
    }
    else
    {
      if ((!this.mediaChunks.isEmpty()) && (!Util.areEqual(paramArrayOfBoolean1, localTrackSelection)))
      {
        if (!this.seenFirstTrackSelection)
        {
          long l = 0L;
          if (paramLong < 0L) {
            l = -paramLong;
          }
          paramArrayOfBoolean1.updateSelectedTrack(paramLong, l, -9223372036854775807L);
          i = this.chunkSource.getTrackGroup().indexOf(getLastMediaChunk().trackFormat);
          if (paramArrayOfBoolean1.getSelectedIndexInTrackGroup() == i)
          {
            i = 0;
            break label546;
          }
        }
        i = 1;
        label546:
        if (i != 0)
        {
          this.pendingResetUpstreamFormats = true;
          paramBoolean = true;
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        seekToUs(paramLong, paramBoolean);
        i = j;
        for (;;)
        {
          bool2 = bool1;
          if (i >= paramArrayOfSampleStream.length) {
            break;
          }
          if (paramArrayOfSampleStream[i] != null) {
            paramArrayOfBoolean2[i] = true;
          }
          i += 1;
        }
      }
    }
    this.seenFirstTrackSelection = true;
    return bool2;
  }
  
  public void setIsTimestampMaster(boolean paramBoolean)
  {
    this.chunkSource.setIsTimestampMaster(paramBoolean);
  }
  
  public void setSampleOffsetUs(long paramLong)
  {
    this.sampleOffsetUs = paramLong;
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int j = arrayOfSampleQueue.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSampleQueue[i].setSampleOffsetUs(paramLong);
      i += 1;
    }
  }
  
  public int skipData(int paramInt, long paramLong)
  {
    if (isPendingReset()) {
      return 0;
    }
    SampleQueue localSampleQueue = this.sampleQueues[paramInt];
    if ((this.loadingFinished) && (paramLong > localSampleQueue.getLargestQueuedTimestampUs())) {
      return localSampleQueue.advanceToEnd();
    }
    int i = localSampleQueue.advanceTo(paramLong, true, true);
    paramInt = i;
    if (i == -1) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public TrackOutput track(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.sampleQueues;
    int j = localObject1.length;
    int k = 0;
    if (paramInt2 == 1)
    {
      i = this.audioSampleQueueIndex;
      if (i != -1)
      {
        if (this.audioSampleQueueMappingDone)
        {
          if (this.sampleQueueTrackIds[i] == paramInt1) {
            return localObject1[i];
          }
          return createDummyTrackOutput(paramInt1, paramInt2);
        }
        this.audioSampleQueueMappingDone = true;
        this.sampleQueueTrackIds[i] = paramInt1;
        return localObject1[i];
      }
      if (this.tracksEnded) {
        return createDummyTrackOutput(paramInt1, paramInt2);
      }
    }
    else if (paramInt2 == 2)
    {
      i = this.videoSampleQueueIndex;
      if (i != -1)
      {
        if (this.videoSampleQueueMappingDone)
        {
          if (this.sampleQueueTrackIds[i] == paramInt1) {
            return localObject1[i];
          }
          return createDummyTrackOutput(paramInt1, paramInt2);
        }
        this.videoSampleQueueMappingDone = true;
        this.sampleQueueTrackIds[i] = paramInt1;
        return localObject1[i];
      }
      if (this.tracksEnded) {
        return createDummyTrackOutput(paramInt1, paramInt2);
      }
    }
    else
    {
      i = 0;
      while (i < j)
      {
        if (this.sampleQueueTrackIds[i] == paramInt1) {
          return this.sampleQueues[i];
        }
        i += 1;
      }
      if (this.tracksEnded) {
        return createDummyTrackOutput(paramInt1, paramInt2);
      }
    }
    localObject1 = new SampleQueue(this.allocator);
    ((SampleQueue)localObject1).setSampleOffsetUs(this.sampleOffsetUs);
    ((SampleQueue)localObject1).setUpstreamFormatChangeListener(this);
    Object localObject2 = this.sampleQueueTrackIds;
    int i = j + 1;
    this.sampleQueueTrackIds = Arrays.copyOf((int[])localObject2, i);
    this.sampleQueueTrackIds[j] = paramInt1;
    this.sampleQueues = ((SampleQueue[])Arrays.copyOf(this.sampleQueues, i));
    this.sampleQueues[j] = localObject1;
    this.sampleQueueIsAudioVideoFlags = Arrays.copyOf(this.sampleQueueIsAudioVideoFlags, i);
    localObject2 = this.sampleQueueIsAudioVideoFlags;
    if ((paramInt2 == 1) || (paramInt2 == 2)) {
      k = 1;
    }
    localObject2[j] = k;
    this.haveAudioVideoSampleQueues |= this.sampleQueueIsAudioVideoFlags[j];
    if (paramInt2 == 1)
    {
      this.audioSampleQueueMappingDone = true;
      this.audioSampleQueueIndex = j;
    }
    else if (paramInt2 == 2)
    {
      this.videoSampleQueueMappingDone = true;
      this.videoSampleQueueIndex = j;
    }
    this.sampleQueuesEnabledStates = Arrays.copyOf(this.sampleQueuesEnabledStates, i);
    return localObject1;
  }
  
  public void unbindSampleQueue(int paramInt)
  {
    paramInt = this.trackGroupToSampleQueueIndex[paramInt];
    Assertions.checkState(this.sampleQueuesEnabledStates[paramInt]);
    this.sampleQueuesEnabledStates[paramInt] = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper
 * JD-Core Version:    0.7.0.1
 */