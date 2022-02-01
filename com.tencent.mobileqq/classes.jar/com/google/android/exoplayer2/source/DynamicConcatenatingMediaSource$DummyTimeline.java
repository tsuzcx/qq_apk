package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;

final class DynamicConcatenatingMediaSource$DummyTimeline
  extends Timeline
{
  public int getIndexOfPeriod(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return -1;
  }
  
  public Timeline.Period getPeriod(int paramInt, Timeline.Period paramPeriod, boolean paramBoolean)
  {
    return paramPeriod.set(null, null, 0, -9223372036854775807L, -9223372036854775807L);
  }
  
  public int getPeriodCount()
  {
    return 1;
  }
  
  public Timeline.Window getWindow(int paramInt, Timeline.Window paramWindow, boolean paramBoolean, long paramLong)
  {
    return paramWindow.set(null, -9223372036854775807L, -9223372036854775807L, false, true, 0L, -9223372036854775807L, 0, 0, 0L);
  }
  
  public int getWindowCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource.DummyTimeline
 * JD-Core Version:    0.7.0.1
 */