package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;

public abstract class Player$DefaultEventListener
  implements Player.EventListener
{
  public void onLoadingChanged(boolean paramBoolean) {}
  
  public void onPlaybackParametersChanged(PlaybackParameters paramPlaybackParameters) {}
  
  public void onPlayerError(ExoPlaybackException paramExoPlaybackException) {}
  
  public void onPlayerStateChanged(boolean paramBoolean, int paramInt) {}
  
  public void onPositionDiscontinuity(int paramInt) {}
  
  public void onRepeatModeChanged(int paramInt) {}
  
  public void onSeekProcessed() {}
  
  public void onShuffleModeEnabledChanged(boolean paramBoolean) {}
  
  @Deprecated
  public void onTimelineChanged(Timeline paramTimeline, Object paramObject) {}
  
  public void onTimelineChanged(Timeline paramTimeline, Object paramObject, int paramInt)
  {
    onTimelineChanged(paramTimeline, paramObject);
  }
  
  public void onTracksChanged(TrackGroupArray paramTrackGroupArray, TrackSelectionArray paramTrackSelectionArray) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.Player.DefaultEventListener
 * JD-Core Version:    0.7.0.1
 */