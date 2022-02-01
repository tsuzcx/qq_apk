package com.google.android.exoplayer2;

public final class Timeline$Window
{
  public long defaultPositionUs;
  public long durationUs;
  public int firstPeriodIndex;
  public Object id;
  public boolean isDynamic;
  public boolean isSeekable;
  public int lastPeriodIndex;
  public long positionInFirstPeriodUs;
  public long presentationStartTimeMs;
  public long windowStartTimeMs;
  
  public long getDefaultPositionMs()
  {
    return C.usToMs(this.defaultPositionUs);
  }
  
  public long getDefaultPositionUs()
  {
    return this.defaultPositionUs;
  }
  
  public long getDurationMs()
  {
    return C.usToMs(this.durationUs);
  }
  
  public long getDurationUs()
  {
    return this.durationUs;
  }
  
  public long getPositionInFirstPeriodMs()
  {
    return C.usToMs(this.positionInFirstPeriodUs);
  }
  
  public long getPositionInFirstPeriodUs()
  {
    return this.positionInFirstPeriodUs;
  }
  
  public Window set(Object paramObject, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, long paramLong3, long paramLong4, int paramInt1, int paramInt2, long paramLong5)
  {
    this.id = paramObject;
    this.presentationStartTimeMs = paramLong1;
    this.windowStartTimeMs = paramLong2;
    this.isSeekable = paramBoolean1;
    this.isDynamic = paramBoolean2;
    this.defaultPositionUs = paramLong3;
    this.durationUs = paramLong4;
    this.firstPeriodIndex = paramInt1;
    this.lastPeriodIndex = paramInt2;
    this.positionInFirstPeriodUs = paramLong5;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.Timeline.Window
 * JD-Core Version:    0.7.0.1
 */