package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;

final class PlaybackInfo
{
  public volatile long bufferedPositionUs;
  public final long contentPositionUs;
  public final boolean isLoading;
  @Nullable
  public final Object manifest;
  public final MediaSource.MediaPeriodId periodId;
  public final int playbackState;
  public volatile long positionUs;
  public final long startPositionUs;
  public final Timeline timeline;
  public final TrackSelectorResult trackSelectorResult;
  
  public PlaybackInfo(Timeline paramTimeline, long paramLong, TrackSelectorResult paramTrackSelectorResult)
  {
    this(paramTimeline, null, new MediaSource.MediaPeriodId(0), paramLong, -9223372036854775807L, 1, false, paramTrackSelectorResult);
  }
  
  public PlaybackInfo(Timeline paramTimeline, @Nullable Object paramObject, MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, TrackSelectorResult paramTrackSelectorResult)
  {
    this.timeline = paramTimeline;
    this.manifest = paramObject;
    this.periodId = paramMediaPeriodId;
    this.startPositionUs = paramLong1;
    this.contentPositionUs = paramLong2;
    this.positionUs = paramLong1;
    this.bufferedPositionUs = paramLong1;
    this.playbackState = paramInt;
    this.isLoading = paramBoolean;
    this.trackSelectorResult = paramTrackSelectorResult;
  }
  
  private static void copyMutablePositions(PlaybackInfo paramPlaybackInfo1, PlaybackInfo paramPlaybackInfo2)
  {
    paramPlaybackInfo2.positionUs = paramPlaybackInfo1.positionUs;
    paramPlaybackInfo2.bufferedPositionUs = paramPlaybackInfo1.bufferedPositionUs;
  }
  
  public PlaybackInfo copyWithIsLoading(boolean paramBoolean)
  {
    PlaybackInfo localPlaybackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, paramBoolean, this.trackSelectorResult);
    copyMutablePositions(this, localPlaybackInfo);
    return localPlaybackInfo;
  }
  
  public PlaybackInfo copyWithPeriodIndex(int paramInt)
  {
    PlaybackInfo localPlaybackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId.copyWithPeriodIndex(paramInt), this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, this.trackSelectorResult);
    copyMutablePositions(this, localPlaybackInfo);
    return localPlaybackInfo;
  }
  
  public PlaybackInfo copyWithPlaybackState(int paramInt)
  {
    PlaybackInfo localPlaybackInfo = new PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, paramInt, this.isLoading, this.trackSelectorResult);
    copyMutablePositions(this, localPlaybackInfo);
    return localPlaybackInfo;
  }
  
  public PlaybackInfo copyWithTimeline(Timeline paramTimeline, Object paramObject)
  {
    paramTimeline = new PlaybackInfo(paramTimeline, paramObject, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, this.trackSelectorResult);
    copyMutablePositions(this, paramTimeline);
    return paramTimeline;
  }
  
  public PlaybackInfo copyWithTrackSelectorResult(TrackSelectorResult paramTrackSelectorResult)
  {
    paramTrackSelectorResult = new PlaybackInfo(this.timeline, this.manifest, this.periodId, this.startPositionUs, this.contentPositionUs, this.playbackState, this.isLoading, paramTrackSelectorResult);
    copyMutablePositions(this, paramTrackSelectorResult);
    return paramTrackSelectorResult;
  }
  
  public PlaybackInfo fromNewPosition(MediaSource.MediaPeriodId paramMediaPeriodId, long paramLong1, long paramLong2)
  {
    Timeline localTimeline = this.timeline;
    Object localObject = this.manifest;
    if (paramMediaPeriodId.isAd()) {}
    for (;;)
    {
      return new PlaybackInfo(localTimeline, localObject, paramMediaPeriodId, paramLong1, paramLong2, this.playbackState, this.isLoading, this.trackSelectorResult);
      paramLong2 = -9223372036854775807L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.PlaybackInfo
 * JD-Core Version:    0.7.0.1
 */