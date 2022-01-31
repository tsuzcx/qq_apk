package com.google.android.exoplayer2.extractor;

public abstract interface SeekMap
{
  public abstract long getDurationUs();
  
  public abstract SeekMap.SeekPoints getSeekPoints(long paramLong);
  
  public abstract boolean isSeekable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.SeekMap
 * JD-Core Version:    0.7.0.1
 */