package com.google.android.exoplayer2;

import android.util.Log;
import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;

final class MediaPeriodHolder
{
  private static final String TAG = "MediaPeriodHolder";
  public boolean hasEnabledTracks;
  public MediaPeriodInfo info;
  public final boolean[] mayRetainStreamFlags;
  public final MediaPeriod mediaPeriod;
  private final MediaSource mediaSource;
  public MediaPeriodHolder next;
  private TrackSelectorResult periodTrackSelectorResult;
  public boolean prepared;
  private final RendererCapabilities[] rendererCapabilities;
  public long rendererPositionOffsetUs;
  public final SampleStream[] sampleStreams;
  private final TrackSelector trackSelector;
  public TrackSelectorResult trackSelectorResult;
  public final Object uid;
  
  public MediaPeriodHolder(RendererCapabilities[] paramArrayOfRendererCapabilities, long paramLong, TrackSelector paramTrackSelector, Allocator paramAllocator, MediaSource paramMediaSource, Object paramObject, MediaPeriodInfo paramMediaPeriodInfo)
  {
    this.rendererCapabilities = paramArrayOfRendererCapabilities;
    this.rendererPositionOffsetUs = (paramLong - paramMediaPeriodInfo.startPositionUs);
    this.trackSelector = paramTrackSelector;
    this.mediaSource = paramMediaSource;
    this.uid = Assertions.checkNotNull(paramObject);
    this.info = paramMediaPeriodInfo;
    this.sampleStreams = new SampleStream[paramArrayOfRendererCapabilities.length];
    this.mayRetainStreamFlags = new boolean[paramArrayOfRendererCapabilities.length];
    paramTrackSelector = paramMediaSource.createPeriod(paramMediaPeriodInfo.id, paramAllocator);
    paramArrayOfRendererCapabilities = paramTrackSelector;
    if (paramMediaPeriodInfo.endPositionUs != -9223372036854775808L)
    {
      paramArrayOfRendererCapabilities = new ClippingMediaPeriod(paramTrackSelector, true);
      paramArrayOfRendererCapabilities.setClipping(0L, paramMediaPeriodInfo.endPositionUs);
    }
    this.mediaPeriod = paramArrayOfRendererCapabilities;
  }
  
  private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] paramArrayOfSampleStream)
  {
    int i = 0;
    for (;;)
    {
      RendererCapabilities[] arrayOfRendererCapabilities = this.rendererCapabilities;
      if (i >= arrayOfRendererCapabilities.length) {
        break;
      }
      if ((arrayOfRendererCapabilities[i].getTrackType() == 5) && (this.trackSelectorResult.renderersEnabled[i] != 0)) {
        paramArrayOfSampleStream[i] = new EmptySampleStream();
      }
      i += 1;
    }
  }
  
  private void disableTrackSelectionsInResult(TrackSelectorResult paramTrackSelectorResult)
  {
    int i = 0;
    while (i < paramTrackSelectorResult.renderersEnabled.length)
    {
      int j = paramTrackSelectorResult.renderersEnabled[i];
      TrackSelection localTrackSelection = paramTrackSelectorResult.selections.get(i);
      if ((j != 0) && (localTrackSelection != null)) {
        localTrackSelection.disable();
      }
      i += 1;
    }
  }
  
  private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] paramArrayOfSampleStream)
  {
    int i = 0;
    for (;;)
    {
      RendererCapabilities[] arrayOfRendererCapabilities = this.rendererCapabilities;
      if (i >= arrayOfRendererCapabilities.length) {
        break;
      }
      if (arrayOfRendererCapabilities[i].getTrackType() == 5) {
        paramArrayOfSampleStream[i] = null;
      }
      i += 1;
    }
  }
  
  private void enableTrackSelectionsInResult(TrackSelectorResult paramTrackSelectorResult)
  {
    int i = 0;
    while (i < paramTrackSelectorResult.renderersEnabled.length)
    {
      int j = paramTrackSelectorResult.renderersEnabled[i];
      TrackSelection localTrackSelection = paramTrackSelectorResult.selections.get(i);
      if ((j != 0) && (localTrackSelection != null)) {
        localTrackSelection.enable();
      }
      i += 1;
    }
  }
  
  private void updatePeriodTrackSelectorResult(TrackSelectorResult paramTrackSelectorResult)
  {
    TrackSelectorResult localTrackSelectorResult = this.periodTrackSelectorResult;
    if (localTrackSelectorResult != null) {
      disableTrackSelectionsInResult(localTrackSelectorResult);
    }
    this.periodTrackSelectorResult = paramTrackSelectorResult;
    paramTrackSelectorResult = this.periodTrackSelectorResult;
    if (paramTrackSelectorResult != null) {
      enableTrackSelectionsInResult(paramTrackSelectorResult);
    }
  }
  
  public long applyTrackSelection(long paramLong, boolean paramBoolean)
  {
    return applyTrackSelection(paramLong, paramBoolean, new boolean[this.rendererCapabilities.length]);
  }
  
  public long applyTrackSelection(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
  {
    TrackSelectionArray localTrackSelectionArray = this.trackSelectorResult.selections;
    int i = 0;
    for (;;)
    {
      int j = localTrackSelectionArray.length;
      int k = 1;
      if (i >= j) {
        break;
      }
      boolean[] arrayOfBoolean = this.mayRetainStreamFlags;
      if ((paramBoolean) || (!this.trackSelectorResult.isEquivalent(this.periodTrackSelectorResult, i))) {
        k = 0;
      }
      arrayOfBoolean[i] = k;
      i += 1;
    }
    disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
    updatePeriodTrackSelectorResult(this.trackSelectorResult);
    paramLong = this.mediaPeriod.selectTracks(localTrackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, paramArrayOfBoolean, paramLong);
    associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
    this.hasEnabledTracks = false;
    i = 0;
    for (;;)
    {
      paramArrayOfBoolean = this.sampleStreams;
      if (i >= paramArrayOfBoolean.length) {
        break;
      }
      if (paramArrayOfBoolean[i] != null)
      {
        Assertions.checkState(this.trackSelectorResult.renderersEnabled[i]);
        if (this.rendererCapabilities[i].getTrackType() != 5) {
          this.hasEnabledTracks = true;
        }
      }
      else
      {
        if (localTrackSelectionArray.get(i) == null) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        Assertions.checkState(paramBoolean);
      }
      i += 1;
    }
    return paramLong;
  }
  
  public void continueLoading(long paramLong)
  {
    paramLong = toPeriodTime(paramLong);
    this.mediaPeriod.continueLoading(paramLong);
  }
  
  public long getBufferedPositionUs(boolean paramBoolean)
  {
    if (!this.prepared) {
      return this.info.startPositionUs;
    }
    long l2 = this.mediaPeriod.getBufferedPositionUs();
    long l1 = l2;
    if (l2 == -9223372036854775808L)
    {
      l1 = l2;
      if (paramBoolean) {
        l1 = this.info.durationUs;
      }
    }
    return l1;
  }
  
  public long getDurationUs()
  {
    return this.info.durationUs;
  }
  
  public long getNextLoadPositionUs()
  {
    if (!this.prepared) {
      return 0L;
    }
    return this.mediaPeriod.getNextLoadPositionUs();
  }
  
  public long getRendererOffset()
  {
    return this.rendererPositionOffsetUs;
  }
  
  public TrackSelectorResult handlePrepared(float paramFloat)
  {
    this.prepared = true;
    selectTracks(paramFloat);
    long l = applyTrackSelection(this.info.startPositionUs, false);
    this.rendererPositionOffsetUs += this.info.startPositionUs - l;
    this.info = this.info.copyWithStartPositionUs(l);
    return this.trackSelectorResult;
  }
  
  public boolean isFullyBuffered()
  {
    return (this.prepared) && ((!this.hasEnabledTracks) || (this.mediaPeriod.getBufferedPositionUs() == -9223372036854775808L));
  }
  
  public void reevaluateBuffer(long paramLong)
  {
    if (this.prepared) {
      this.mediaPeriod.reevaluateBuffer(toPeriodTime(paramLong));
    }
  }
  
  public void release()
  {
    updatePeriodTrackSelectorResult(null);
    try
    {
      if (this.info.endPositionUs != -9223372036854775808L)
      {
        this.mediaSource.releasePeriod(((ClippingMediaPeriod)this.mediaPeriod).mediaPeriod);
        return;
      }
      this.mediaSource.releasePeriod(this.mediaPeriod);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("MediaPeriodHolder", "Period release failed.", localRuntimeException);
    }
  }
  
  public boolean selectTracks(float paramFloat)
  {
    Object localObject1 = this.trackSelector.selectTracks(this.rendererCapabilities, this.mediaPeriod.getTrackGroups());
    boolean bool = ((TrackSelectorResult)localObject1).isEquivalent(this.periodTrackSelectorResult);
    int i = 0;
    if (bool) {
      return false;
    }
    this.trackSelectorResult = ((TrackSelectorResult)localObject1);
    localObject1 = this.trackSelectorResult.selections.getAll();
    int j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.onPlaybackSpeed(paramFloat);
      }
      i += 1;
    }
    return true;
  }
  
  public long toPeriodTime(long paramLong)
  {
    return paramLong - getRendererOffset();
  }
  
  public long toRendererTime(long paramLong)
  {
    return paramLong + getRendererOffset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.MediaPeriodHolder
 * JD-Core Version:    0.7.0.1
 */