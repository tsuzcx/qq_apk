package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

final class ExtractorMediaPeriod
  implements ExtractorOutput, MediaPeriod, SampleQueue.UpstreamFormatChangedListener, Loader.Callback<ExtractorMediaPeriod.ExtractingLoadable>, Loader.ReleaseCallback
{
  private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000L;
  private int actualMinLoadableRetryCount;
  private final Allocator allocator;
  private MediaPeriod.Callback callback;
  private final long continueLoadingCheckIntervalBytes;
  @Nullable
  private final String customCacheKey;
  private final DataSource dataSource;
  private long durationUs;
  private int enabledTrackCount;
  private final MediaSourceEventListener.EventDispatcher eventDispatcher;
  private int extractedSamplesCountAtStartOfLoad;
  private final ExtractorMediaPeriod.ExtractorHolder extractorHolder;
  private final Handler handler;
  private boolean haveAudioVideoTracks;
  private long lastSeekPositionUs;
  private long length;
  private final ExtractorMediaPeriod.Listener listener;
  private final ConditionVariable loadCondition;
  private final Loader loader;
  private boolean loadingFinished;
  private final Runnable maybeFinishPrepareRunnable;
  private final int minLoadableRetryCount;
  private boolean notifyDiscontinuity;
  private final Runnable onContinueLoadingRequestedRunnable;
  private boolean pendingDeferredRetry;
  private long pendingResetPositionUs;
  private boolean prepared;
  private boolean released;
  private int[] sampleQueueTrackIds;
  private int[] sampleQueueTrackTypes;
  private SampleQueue[] sampleQueues;
  private boolean sampleQueuesBuilt;
  private SeekMap seekMap;
  private boolean seenFirstTrackSelection;
  private boolean[] trackEnabledStates;
  private boolean[] trackFormatNotificationSent;
  private boolean[] trackIsAudioVideoFlags;
  private TrackGroupArray tracks;
  private final Uri uri;
  
  public ExtractorMediaPeriod(Uri paramUri, DataSource paramDataSource, Extractor[] paramArrayOfExtractor, int paramInt1, MediaSourceEventListener.EventDispatcher paramEventDispatcher, ExtractorMediaPeriod.Listener paramListener, Allocator paramAllocator, @Nullable String paramString, int paramInt2)
  {
    this.uri = paramUri;
    this.dataSource = paramDataSource;
    this.minLoadableRetryCount = paramInt1;
    this.eventDispatcher = paramEventDispatcher;
    this.listener = paramListener;
    this.allocator = paramAllocator;
    this.customCacheKey = paramString;
    this.continueLoadingCheckIntervalBytes = paramInt2;
    this.loader = new Loader("Loader:ExtractorMediaPeriod");
    this.extractorHolder = new ExtractorMediaPeriod.ExtractorHolder(paramArrayOfExtractor, this);
    this.loadCondition = new ConditionVariable();
    this.maybeFinishPrepareRunnable = new ExtractorMediaPeriod.1(this);
    this.onContinueLoadingRequestedRunnable = new ExtractorMediaPeriod.2(this);
    this.handler = new Handler();
    this.sampleQueueTrackIds = new int[0];
    this.sampleQueueTrackTypes = new int[0];
    this.sampleQueues = new SampleQueue[0];
    this.pendingResetPositionUs = -9223372036854775807L;
    this.length = -1L;
    this.durationUs = -9223372036854775807L;
    paramInt2 = paramInt1;
    if (paramInt1 == -1) {
      paramInt2 = 3;
    }
    this.actualMinLoadableRetryCount = paramInt2;
  }
  
  private boolean configureRetry(ExtractorMediaPeriod.ExtractingLoadable paramExtractingLoadable, int paramInt)
  {
    int i = 0;
    if ((this.length != -1L) || ((this.seekMap != null) && (this.seekMap.getDurationUs() != -9223372036854775807L)))
    {
      this.extractedSamplesCountAtStartOfLoad = paramInt;
      return true;
    }
    if ((this.prepared) && (!suppressRead()))
    {
      this.pendingDeferredRetry = true;
      return false;
    }
    this.notifyDiscontinuity = this.prepared;
    this.lastSeekPositionUs = 0L;
    this.extractedSamplesCountAtStartOfLoad = 0;
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int j = arrayOfSampleQueue.length;
    paramInt = i;
    while (paramInt < j)
    {
      arrayOfSampleQueue[paramInt].reset();
      paramInt += 1;
    }
    paramExtractingLoadable.setLoadPosition(0L, 0L);
    return true;
  }
  
  private void copyLengthFromLoader(ExtractorMediaPeriod.ExtractingLoadable paramExtractingLoadable)
  {
    if (this.length == -1L) {
      this.length = ExtractorMediaPeriod.ExtractingLoadable.access$700(paramExtractingLoadable);
    }
  }
  
  private int getExtractedSamplesCount()
  {
    int i = 0;
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int k = arrayOfSampleQueue.length;
    int j = 0;
    while (i < k)
    {
      j += arrayOfSampleQueue[i].getWriteIndex();
      i += 1;
    }
    return j;
  }
  
  private long getLargestQueuedTimestampUs()
  {
    long l = -9223372036854775808L;
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int j = arrayOfSampleQueue.length;
    int i = 0;
    while (i < j)
    {
      l = Math.max(l, arrayOfSampleQueue[i].getLargestQueuedTimestampUs());
      i += 1;
    }
    return l;
  }
  
  private static boolean isLoadableExceptionFatal(IOException paramIOException)
  {
    return paramIOException instanceof UnrecognizedInputFormatException;
  }
  
  private boolean isPendingReset()
  {
    return this.pendingResetPositionUs != -9223372036854775807L;
  }
  
  private void maybeFinishPrepare()
  {
    if ((this.released) || (this.prepared) || (this.seekMap == null) || (!this.sampleQueuesBuilt)) {
      return;
    }
    Object localObject1 = this.sampleQueues;
    int j = localObject1.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label63;
      }
      if (localObject1[i].getUpstreamFormat() == null) {
        break;
      }
      i += 1;
    }
    label63:
    this.loadCondition.close();
    j = this.sampleQueues.length;
    localObject1 = new TrackGroup[j];
    this.trackIsAudioVideoFlags = new boolean[j];
    this.trackEnabledStates = new boolean[j];
    this.trackFormatNotificationSent = new boolean[j];
    this.durationUs = this.seekMap.getDurationUs();
    i = 0;
    if (i < j)
    {
      Object localObject2 = this.sampleQueues[i].getUpstreamFormat();
      localObject1[i] = new TrackGroup(new Format[] { localObject2 });
      localObject2 = ((Format)localObject2).sampleMimeType;
      if ((MimeTypes.isVideo((String)localObject2)) || (MimeTypes.isAudio((String)localObject2))) {}
      for (int k = 1;; k = 0)
      {
        this.trackIsAudioVideoFlags[i] = k;
        this.haveAudioVideoTracks = (k | this.haveAudioVideoTracks);
        i += 1;
        break;
      }
    }
    this.tracks = new TrackGroupArray((TrackGroup[])localObject1);
    if ((this.minLoadableRetryCount == -1) && (this.length == -1L) && (this.seekMap.getDurationUs() == -9223372036854775807L)) {
      this.actualMinLoadableRetryCount = 6;
    }
    this.prepared = true;
    this.listener.onSourceInfoRefreshed(this.durationUs, this.seekMap.isSeekable());
    this.callback.onPrepared(this);
  }
  
  private void maybeNotifyTrackFormat(int paramInt)
  {
    if (this.trackFormatNotificationSent[paramInt] == 0)
    {
      Format localFormat = this.tracks.get(paramInt).getFormat(0);
      this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(localFormat.sampleMimeType), localFormat, 0, null, this.lastSeekPositionUs);
      this.trackFormatNotificationSent[paramInt] = true;
    }
  }
  
  private void maybeStartDeferredRetry(int paramInt)
  {
    int i = 0;
    if ((!this.pendingDeferredRetry) || (this.trackIsAudioVideoFlags[paramInt] == 0) || (this.sampleQueues[paramInt].hasNextSample())) {
      return;
    }
    this.pendingResetPositionUs = 0L;
    this.pendingDeferredRetry = false;
    this.notifyDiscontinuity = true;
    this.lastSeekPositionUs = 0L;
    this.extractedSamplesCountAtStartOfLoad = 0;
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int j = arrayOfSampleQueue.length;
    paramInt = i;
    while (paramInt < j)
    {
      arrayOfSampleQueue[paramInt].reset();
      paramInt += 1;
    }
    this.callback.onContinueLoadingRequested(this);
  }
  
  private boolean seekInsideBufferUs(long paramLong)
  {
    int k = this.sampleQueues.length;
    int i = 0;
    while (i < k)
    {
      SampleQueue localSampleQueue = this.sampleQueues[i];
      localSampleQueue.rewind();
      if (localSampleQueue.advanceTo(paramLong, true, false) != -1) {}
      for (int j = 1; (j == 0) && ((this.trackIsAudioVideoFlags[i] != 0) || (!this.haveAudioVideoTracks)); j = 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void startLoading()
  {
    ExtractorMediaPeriod.ExtractingLoadable localExtractingLoadable = new ExtractorMediaPeriod.ExtractingLoadable(this, this.uri, this.dataSource, this.extractorHolder, this.loadCondition);
    if (this.prepared)
    {
      Assertions.checkState(isPendingReset());
      if ((this.durationUs != -9223372036854775807L) && (this.pendingResetPositionUs >= this.durationUs))
      {
        this.loadingFinished = true;
        this.pendingResetPositionUs = -9223372036854775807L;
        return;
      }
      localExtractingLoadable.setLoadPosition(this.seekMap.getSeekPoints(this.pendingResetPositionUs).first.position, this.pendingResetPositionUs);
      this.pendingResetPositionUs = -9223372036854775807L;
    }
    this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
    long l = this.loader.startLoading(localExtractingLoadable, this, this.actualMinLoadableRetryCount);
    this.eventDispatcher.loadStarted(ExtractorMediaPeriod.ExtractingLoadable.access$400(localExtractingLoadable), 1, -1, null, 0, null, ExtractorMediaPeriod.ExtractingLoadable.access$500(localExtractingLoadable), this.durationUs, l);
  }
  
  private boolean suppressRead()
  {
    return (this.notifyDiscontinuity) || (isPendingReset());
  }
  
  public boolean continueLoading(long paramLong)
  {
    boolean bool;
    if ((this.loadingFinished) || (this.pendingDeferredRetry) || ((this.prepared) && (this.enabledTrackCount == 0))) {
      bool = false;
    }
    do
    {
      return bool;
      bool = this.loadCondition.open();
    } while (this.loader.isLoading());
    startLoading();
    return true;
  }
  
  public void discardBuffer(long paramLong, boolean paramBoolean)
  {
    int j = this.sampleQueues.length;
    int i = 0;
    while (i < j)
    {
      this.sampleQueues[i].discardTo(paramLong, paramBoolean, this.trackEnabledStates[i]);
      i += 1;
    }
  }
  
  public void endTracks()
  {
    this.sampleQueuesBuilt = true;
    this.handler.post(this.maybeFinishPrepareRunnable);
  }
  
  public long getAdjustedSeekPositionUs(long paramLong, SeekParameters paramSeekParameters)
  {
    if (!this.seekMap.isSeekable()) {
      return 0L;
    }
    SeekMap.SeekPoints localSeekPoints = this.seekMap.getSeekPoints(paramLong);
    return Util.resolveSeekPositionUs(paramLong, paramSeekParameters, localSeekPoints.first.timeUs, localSeekPoints.second.timeUs);
  }
  
  public long getBufferedPositionUs()
  {
    long l1;
    if (this.loadingFinished) {
      l1 = -9223372036854775808L;
    }
    long l2;
    do
    {
      return l1;
      if (isPendingReset()) {
        return this.pendingResetPositionUs;
      }
      if (this.haveAudioVideoTracks)
      {
        int j = this.sampleQueues.length;
        l1 = 9223372036854775807L;
        int i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= j) {
            break;
          }
          l2 = l1;
          if (this.trackIsAudioVideoFlags[i] != 0) {
            l2 = Math.min(l1, this.sampleQueues[i].getLargestQueuedTimestampUs());
          }
          i += 1;
          l1 = l2;
        }
      }
      l2 = getLargestQueuedTimestampUs();
      l1 = l2;
    } while (l2 != -9223372036854775808L);
    return this.lastSeekPositionUs;
  }
  
  public long getNextLoadPositionUs()
  {
    if (this.enabledTrackCount == 0) {
      return -9223372036854775808L;
    }
    return getBufferedPositionUs();
  }
  
  public TrackGroupArray getTrackGroups()
  {
    return this.tracks;
  }
  
  boolean isReady(int paramInt)
  {
    return (!suppressRead()) && ((this.loadingFinished) || (this.sampleQueues[paramInt].hasNextSample()));
  }
  
  void maybeThrowError()
  {
    this.loader.maybeThrowError(this.actualMinLoadableRetryCount);
  }
  
  public void maybeThrowPrepareError()
  {
    maybeThrowError();
  }
  
  public void onLoadCanceled(ExtractorMediaPeriod.ExtractingLoadable paramExtractingLoadable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.eventDispatcher.loadCanceled(ExtractorMediaPeriod.ExtractingLoadable.access$400(paramExtractingLoadable), 1, -1, null, 0, null, ExtractorMediaPeriod.ExtractingLoadable.access$500(paramExtractingLoadable), this.durationUs, paramLong1, paramLong2, ExtractorMediaPeriod.ExtractingLoadable.access$600(paramExtractingLoadable));
    if (!paramBoolean)
    {
      copyLengthFromLoader(paramExtractingLoadable);
      paramExtractingLoadable = this.sampleQueues;
      int j = paramExtractingLoadable.length;
      int i = 0;
      while (i < j)
      {
        paramExtractingLoadable[i].reset();
        i += 1;
      }
      if (this.enabledTrackCount > 0) {
        this.callback.onContinueLoadingRequested(this);
      }
    }
  }
  
  public void onLoadCompleted(ExtractorMediaPeriod.ExtractingLoadable paramExtractingLoadable, long paramLong1, long paramLong2)
  {
    if (this.durationUs == -9223372036854775807L)
    {
      l = getLargestQueuedTimestampUs();
      if (l != -9223372036854775808L) {
        break label109;
      }
    }
    label109:
    for (long l = 0L;; l += 10000L)
    {
      this.durationUs = l;
      this.listener.onSourceInfoRefreshed(this.durationUs, this.seekMap.isSeekable());
      this.eventDispatcher.loadCompleted(ExtractorMediaPeriod.ExtractingLoadable.access$400(paramExtractingLoadable), 1, -1, null, 0, null, ExtractorMediaPeriod.ExtractingLoadable.access$500(paramExtractingLoadable), this.durationUs, paramLong1, paramLong2, ExtractorMediaPeriod.ExtractingLoadable.access$600(paramExtractingLoadable));
      copyLengthFromLoader(paramExtractingLoadable);
      this.loadingFinished = true;
      this.callback.onContinueLoadingRequested(this);
      return;
    }
  }
  
  public int onLoadError(ExtractorMediaPeriod.ExtractingLoadable paramExtractingLoadable, long paramLong1, long paramLong2, IOException paramIOException)
  {
    boolean bool = isLoadableExceptionFatal(paramIOException);
    this.eventDispatcher.loadError(ExtractorMediaPeriod.ExtractingLoadable.access$400(paramExtractingLoadable), 1, -1, null, 0, null, ExtractorMediaPeriod.ExtractingLoadable.access$500(paramExtractingLoadable), this.durationUs, paramLong1, paramLong2, ExtractorMediaPeriod.ExtractingLoadable.access$600(paramExtractingLoadable), paramIOException, bool);
    copyLengthFromLoader(paramExtractingLoadable);
    if (bool) {
      return 3;
    }
    int j = getExtractedSamplesCount();
    int i;
    if (j > this.extractedSamplesCountAtStartOfLoad) {
      i = 1;
    }
    while (configureRetry(paramExtractingLoadable, j)) {
      if (i != 0)
      {
        return 1;
        i = 0;
      }
      else
      {
        return 0;
      }
    }
    return 2;
  }
  
  public void onLoaderReleased()
  {
    SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
    int j = arrayOfSampleQueue.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSampleQueue[i].reset();
      i += 1;
    }
    this.extractorHolder.release();
  }
  
  public void onUpstreamFormatChanged(Format paramFormat)
  {
    this.handler.post(this.maybeFinishPrepareRunnable);
  }
  
  public void prepare(MediaPeriod.Callback paramCallback, long paramLong)
  {
    this.callback = paramCallback;
    this.loadCondition.open();
    startLoading();
  }
  
  int readData(int paramInt, FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean)
  {
    if (suppressRead()) {
      return -3;
    }
    int i = this.sampleQueues[paramInt].read(paramFormatHolder, paramDecoderInputBuffer, paramBoolean, this.loadingFinished, this.lastSeekPositionUs);
    if (i == -4) {
      maybeNotifyTrackFormat(paramInt);
    }
    for (;;)
    {
      return i;
      if (i == -3) {
        maybeStartDeferredRetry(paramInt);
      }
    }
  }
  
  public long readDiscontinuity()
  {
    if ((this.notifyDiscontinuity) && ((this.loadingFinished) || (getExtractedSamplesCount() > this.extractedSamplesCountAtStartOfLoad)))
    {
      this.notifyDiscontinuity = false;
      return this.lastSeekPositionUs;
    }
    return -9223372036854775807L;
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
  
  public void seekMap(SeekMap paramSeekMap)
  {
    this.seekMap = paramSeekMap;
    this.handler.post(this.maybeFinishPrepareRunnable);
  }
  
  public long seekToUs(long paramLong)
  {
    int i = 0;
    if (this.seekMap.isSeekable())
    {
      this.lastSeekPositionUs = paramLong;
      this.notifyDiscontinuity = false;
      if ((isPendingReset()) || (!seekInsideBufferUs(paramLong))) {
        break label46;
      }
    }
    for (;;)
    {
      return paramLong;
      paramLong = 0L;
      break;
      label46:
      this.pendingDeferredRetry = false;
      this.pendingResetPositionUs = paramLong;
      this.loadingFinished = false;
      if (this.loader.isLoading())
      {
        this.loader.cancelLoading();
        return paramLong;
      }
      SampleQueue[] arrayOfSampleQueue = this.sampleQueues;
      int j = arrayOfSampleQueue.length;
      while (i < j)
      {
        arrayOfSampleQueue[i].reset();
        i += 1;
      }
    }
  }
  
  public long selectTracks(TrackSelection[] paramArrayOfTrackSelection, boolean[] paramArrayOfBoolean1, SampleStream[] paramArrayOfSampleStream, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int n = 0;
    int i1 = 0;
    int m = 0;
    Assertions.checkState(this.prepared);
    int j = this.enabledTrackCount;
    int i = 0;
    int k;
    while (i < paramArrayOfTrackSelection.length)
    {
      if ((paramArrayOfSampleStream[i] != null) && ((paramArrayOfTrackSelection[i] == null) || (paramArrayOfBoolean1[i] == 0)))
      {
        k = ExtractorMediaPeriod.SampleStreamImpl.access$300((ExtractorMediaPeriod.SampleStreamImpl)paramArrayOfSampleStream[i]);
        Assertions.checkState(this.trackEnabledStates[k]);
        this.enabledTrackCount -= 1;
        this.trackEnabledStates[k] = false;
        paramArrayOfSampleStream[i] = null;
      }
      i += 1;
    }
    label129:
    boolean bool;
    if (this.seenFirstTrackSelection) {
      if (j == 0)
      {
        i = 1;
        j = 0;
        k = i;
        if (j >= paramArrayOfTrackSelection.length) {
          break label375;
        }
        i = k;
        if (paramArrayOfSampleStream[j] == null)
        {
          i = k;
          if (paramArrayOfTrackSelection[j] != null)
          {
            paramArrayOfBoolean1 = paramArrayOfTrackSelection[j];
            if (paramArrayOfBoolean1.length() != 1) {
              break label351;
            }
            bool = true;
            label176:
            Assertions.checkState(bool);
            if (paramArrayOfBoolean1.getIndexInTrackGroup(0) != 0) {
              break label357;
            }
            bool = true;
            label194:
            Assertions.checkState(bool);
            int i2 = this.tracks.indexOf(paramArrayOfBoolean1.getTrackGroup());
            if (this.trackEnabledStates[i2] != 0) {
              break label363;
            }
            bool = true;
            label227:
            Assertions.checkState(bool);
            this.enabledTrackCount += 1;
            this.trackEnabledStates[i2] = true;
            paramArrayOfSampleStream[j] = new ExtractorMediaPeriod.SampleStreamImpl(this, i2);
            paramArrayOfBoolean2[j] = true;
            i = k;
            if (k == 0)
            {
              paramArrayOfBoolean1 = this.sampleQueues[i2];
              paramArrayOfBoolean1.rewind();
              if ((paramArrayOfBoolean1.advanceTo(paramLong, true, true) != -1) || (paramArrayOfBoolean1.getReadIndex() == 0)) {
                break label369;
              }
            }
          }
        }
      }
    }
    label351:
    label357:
    label363:
    label369:
    for (i = 1;; i = 0)
    {
      j += 1;
      k = i;
      break label129;
      i = 0;
      break;
      if (paramLong != 0L)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      bool = false;
      break label176;
      bool = false;
      break label194;
      bool = false;
      break label227;
    }
    label375:
    long l;
    if (this.enabledTrackCount == 0)
    {
      this.pendingDeferredRetry = false;
      this.notifyDiscontinuity = false;
      if (this.loader.isLoading())
      {
        paramArrayOfTrackSelection = this.sampleQueues;
        j = paramArrayOfTrackSelection.length;
        i = m;
        while (i < j)
        {
          paramArrayOfTrackSelection[i].discardToEnd();
          i += 1;
        }
        this.loader.cancelLoading();
        l = paramLong;
      }
    }
    do
    {
      this.seenFirstTrackSelection = true;
      return l;
      paramArrayOfTrackSelection = this.sampleQueues;
      j = paramArrayOfTrackSelection.length;
      i = n;
      for (;;)
      {
        l = paramLong;
        if (i >= j) {
          break;
        }
        paramArrayOfTrackSelection[i].reset();
        i += 1;
      }
      l = paramLong;
    } while (k == 0);
    paramLong = seekToUs(paramLong);
    i = i1;
    for (;;)
    {
      l = paramLong;
      if (i >= paramArrayOfSampleStream.length) {
        break;
      }
      if (paramArrayOfSampleStream[i] != null) {
        paramArrayOfBoolean2[i] = true;
      }
      i += 1;
    }
  }
  
  int skipData(int paramInt, long paramLong)
  {
    int i = 0;
    if (suppressRead()) {
      return 0;
    }
    SampleQueue localSampleQueue = this.sampleQueues[paramInt];
    if ((this.loadingFinished) && (paramLong > localSampleQueue.getLargestQueuedTimestampUs())) {
      i = localSampleQueue.advanceToEnd();
    }
    while (i > 0)
    {
      maybeNotifyTrackFormat(paramInt);
      return i;
      int j = localSampleQueue.advanceTo(paramLong, true, true);
      if (j != -1) {
        i = j;
      }
    }
    maybeStartDeferredRetry(paramInt);
    return i;
  }
  
  public TrackOutput track(int paramInt1, int paramInt2)
  {
    int j = this.sampleQueues.length;
    int i = 0;
    while (i < j)
    {
      if (this.sampleQueueTrackIds[i] == paramInt1) {
        return this.sampleQueues[i];
      }
      i += 1;
    }
    SampleQueue localSampleQueue = new SampleQueue(this.allocator);
    localSampleQueue.setUpstreamFormatChangeListener(this);
    this.sampleQueueTrackIds = Arrays.copyOf(this.sampleQueueTrackIds, j + 1);
    this.sampleQueueTrackIds[j] = paramInt1;
    this.sampleQueueTrackTypes = Arrays.copyOf(this.sampleQueueTrackTypes, j + 1);
    this.sampleQueueTrackTypes[j] = paramInt2;
    this.sampleQueues = ((SampleQueue[])Arrays.copyOf(this.sampleQueues, j + 1));
    this.sampleQueues[j] = localSampleQueue;
    return localSampleQueue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ExtractorMediaPeriod
 * JD-Core Version:    0.7.0.1
 */