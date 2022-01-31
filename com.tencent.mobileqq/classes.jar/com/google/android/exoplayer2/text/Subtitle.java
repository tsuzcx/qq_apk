package com.google.android.exoplayer2.text;

import java.util.List;

public abstract interface Subtitle
{
  public abstract List<Cue> getCues(long paramLong);
  
  public abstract long getEventTime(int paramInt);
  
  public abstract int getEventTimeCount();
  
  public abstract int getNextEventTimeIndex(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.text.Subtitle
 * JD-Core Version:    0.7.0.1
 */