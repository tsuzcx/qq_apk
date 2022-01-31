package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.PlaybackParameters;

public abstract interface MediaClock
{
  public abstract PlaybackParameters getPlaybackParameters();
  
  public abstract long getPositionUs();
  
  public abstract PlaybackParameters setPlaybackParameters(PlaybackParameters paramPlaybackParameters);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.util.MediaClock
 * JD-Core Version:    0.7.0.1
 */