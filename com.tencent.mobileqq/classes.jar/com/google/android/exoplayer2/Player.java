package com.google.android.exoplayer2;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;

public abstract interface Player
{
  public static final int DISCONTINUITY_REASON_AD_INSERTION = 3;
  public static final int DISCONTINUITY_REASON_INTERNAL = 4;
  public static final int DISCONTINUITY_REASON_PERIOD_TRANSITION = 0;
  public static final int DISCONTINUITY_REASON_SEEK = 1;
  public static final int DISCONTINUITY_REASON_SEEK_ADJUSTMENT = 2;
  public static final int REPEAT_MODE_ALL = 2;
  public static final int REPEAT_MODE_OFF = 0;
  public static final int REPEAT_MODE_ONE = 1;
  public static final int STATE_BUFFERING = 2;
  public static final int STATE_ENDED = 4;
  public static final int STATE_IDLE = 1;
  public static final int STATE_READY = 3;
  public static final int TIMELINE_CHANGE_REASON_DYNAMIC = 2;
  public static final int TIMELINE_CHANGE_REASON_PREPARED = 0;
  public static final int TIMELINE_CHANGE_REASON_RESET = 1;
  
  public abstract void addListener(Player.EventListener paramEventListener);
  
  public abstract int getBufferedPercentage();
  
  public abstract long getBufferedPosition();
  
  public abstract long getContentPosition();
  
  public abstract int getCurrentAdGroupIndex();
  
  public abstract int getCurrentAdIndexInAdGroup();
  
  @Nullable
  public abstract Object getCurrentManifest();
  
  public abstract int getCurrentPeriodIndex();
  
  public abstract long getCurrentPosition();
  
  public abstract Timeline getCurrentTimeline();
  
  public abstract TrackGroupArray getCurrentTrackGroups();
  
  public abstract TrackSelectionArray getCurrentTrackSelections();
  
  public abstract int getCurrentWindowIndex();
  
  public abstract long getDuration();
  
  public abstract int getNextWindowIndex();
  
  public abstract boolean getPlayWhenReady();
  
  public abstract PlaybackParameters getPlaybackParameters();
  
  public abstract int getPlaybackState();
  
  public abstract int getPreviousWindowIndex();
  
  public abstract int getRendererCount();
  
  public abstract int getRendererType(int paramInt);
  
  public abstract int getRepeatMode();
  
  public abstract boolean getShuffleModeEnabled();
  
  @Nullable
  public abstract Player.TextComponent getTextComponent();
  
  @Nullable
  public abstract Player.VideoComponent getVideoComponent();
  
  public abstract boolean isCurrentWindowDynamic();
  
  public abstract boolean isCurrentWindowSeekable();
  
  public abstract boolean isLoading();
  
  public abstract boolean isPlayingAd();
  
  public abstract void release();
  
  public abstract void removeListener(Player.EventListener paramEventListener);
  
  public abstract void seekTo(int paramInt, long paramLong);
  
  public abstract void seekTo(long paramLong);
  
  public abstract void seekToDefaultPosition();
  
  public abstract void seekToDefaultPosition(int paramInt);
  
  public abstract void setPlayWhenReady(boolean paramBoolean);
  
  public abstract void setPlaybackParameters(@Nullable PlaybackParameters paramPlaybackParameters);
  
  public abstract void setRepeatMode(int paramInt);
  
  public abstract void setShuffleModeEnabled(boolean paramBoolean);
  
  public abstract void stop();
  
  public abstract void stop(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.Player
 * JD-Core Version:    0.7.0.1
 */