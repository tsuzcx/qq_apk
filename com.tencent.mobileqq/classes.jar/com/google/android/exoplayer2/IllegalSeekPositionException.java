package com.google.android.exoplayer2;

public final class IllegalSeekPositionException
  extends IllegalStateException
{
  public final long positionMs;
  public final Timeline timeline;
  public final int windowIndex;
  
  public IllegalSeekPositionException(Timeline paramTimeline, int paramInt, long paramLong)
  {
    this.timeline = paramTimeline;
    this.windowIndex = paramInt;
    this.positionMs = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.IllegalSeekPositionException
 * JD-Core Version:    0.7.0.1
 */