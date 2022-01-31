package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;

public abstract interface Player$EventListener
{
  public abstract void onLoadingChanged(boolean paramBoolean);
  
  public abstract void onPlaybackParametersChanged(PlaybackParameters paramPlaybackParameters);
  
  public abstract void onPlayerError(ExoPlaybackException paramExoPlaybackException);
  
  public abstract void onPlayerStateChanged(boolean paramBoolean, int paramInt);
  
  public abstract void onPositionDiscontinuity(int paramInt);
  
  public abstract void onRepeatModeChanged(int paramInt);
  
  public abstract void onSeekProcessed();
  
  public abstract void onShuffleModeEnabledChanged(boolean paramBoolean);
  
  public abstract void onTimelineChanged(Timeline paramTimeline, Object paramObject, int paramInt);
  
  public abstract void onTracksChanged(TrackGroupArray paramTrackGroupArray, TrackSelectionArray paramTrackSelectionArray);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.Player.EventListener
 * JD-Core Version:    0.7.0.1
 */