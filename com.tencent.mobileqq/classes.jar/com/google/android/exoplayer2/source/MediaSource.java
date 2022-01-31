package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.upstream.Allocator;

public abstract interface MediaSource
{
  public static final String MEDIA_SOURCE_REUSED_ERROR_MESSAGE = "MediaSource instances are not allowed to be reused.";
  
  public abstract MediaPeriod createPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator);
  
  public abstract void maybeThrowSourceInfoRefreshError();
  
  public abstract void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener);
  
  public abstract void releasePeriod(MediaPeriod paramMediaPeriod);
  
  public abstract void releaseSource();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MediaSource
 * JD-Core Version:    0.7.0.1
 */