package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodTimeline
  extends Timeline
{
  private static final Object ID = new Object();
  private final boolean isDynamic;
  private final boolean isSeekable;
  private final long periodDurationUs;
  private final long presentationStartTimeMs;
  private final long windowDefaultStartPositionUs;
  private final long windowDurationUs;
  private final long windowPositionInPeriodUs;
  private final long windowStartTimeMs;
  
  public SinglePeriodTimeline(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.presentationStartTimeMs = paramLong1;
    this.windowStartTimeMs = paramLong2;
    this.periodDurationUs = paramLong3;
    this.windowDurationUs = paramLong4;
    this.windowPositionInPeriodUs = paramLong5;
    this.windowDefaultStartPositionUs = paramLong6;
    this.isSeekable = paramBoolean1;
    this.isDynamic = paramBoolean2;
  }
  
  public SinglePeriodTimeline(long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(-9223372036854775807L, -9223372036854775807L, paramLong1, paramLong2, paramLong3, paramLong4, paramBoolean1, paramBoolean2);
  }
  
  public SinglePeriodTimeline(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramLong, paramLong, 0L, 0L, paramBoolean1, paramBoolean2);
  }
  
  public int getIndexOfPeriod(Object paramObject)
  {
    if (ID.equals(paramObject)) {
      return 0;
    }
    return -1;
  }
  
  public Timeline.Period getPeriod(int paramInt, Timeline.Period paramPeriod, boolean paramBoolean)
  {
    Assertions.checkIndex(paramInt, 0, 1);
    Object localObject;
    if (paramBoolean) {
      localObject = ID;
    } else {
      localObject = null;
    }
    return paramPeriod.set(localObject, localObject, 0, this.periodDurationUs, -this.windowPositionInPeriodUs);
  }
  
  public int getPeriodCount()
  {
    return 1;
  }
  
  public Timeline.Window getWindow(int paramInt, Timeline.Window paramWindow, boolean paramBoolean, long paramLong)
  {
    Assertions.checkIndex(paramInt, 0, 1);
    Object localObject;
    if (paramBoolean) {
      localObject = ID;
    } else {
      localObject = null;
    }
    long l2 = this.windowDefaultStartPositionUs;
    long l1 = l2;
    if (this.isDynamic)
    {
      l1 = l2;
      if (paramLong != 0L)
      {
        long l3 = this.windowDurationUs;
        if (l3 == -9223372036854775807L) {}
        do
        {
          l1 = -9223372036854775807L;
          break;
          paramLong = l2 + paramLong;
          l1 = paramLong;
        } while (paramLong > l3);
      }
    }
    return paramWindow.set(localObject, this.presentationStartTimeMs, this.windowStartTimeMs, this.isSeekable, this.isDynamic, l1, this.windowDurationUs, 0, 0, this.windowPositionInPeriodUs);
  }
  
  public int getWindowCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SinglePeriodTimeline
 * JD-Core Version:    0.7.0.1
 */