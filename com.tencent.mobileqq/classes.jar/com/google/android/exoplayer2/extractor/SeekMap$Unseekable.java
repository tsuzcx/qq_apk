package com.google.android.exoplayer2.extractor;

public final class SeekMap$Unseekable
  implements SeekMap
{
  private final long durationUs;
  private final SeekMap.SeekPoints startSeekPoints;
  
  public SeekMap$Unseekable(long paramLong)
  {
    this(paramLong, 0L);
  }
  
  public SeekMap$Unseekable(long paramLong1, long paramLong2)
  {
    this.durationUs = paramLong1;
    if (paramLong2 == 0L) {}
    for (SeekPoint localSeekPoint = SeekPoint.START;; localSeekPoint = new SeekPoint(0L, paramLong2))
    {
      this.startSeekPoints = new SeekMap.SeekPoints(localSeekPoint);
      return;
    }
  }
  
  public long getDurationUs()
  {
    return this.durationUs;
  }
  
  public SeekMap.SeekPoints getSeekPoints(long paramLong)
  {
    return this.startSeekPoints;
  }
  
  public boolean isSeekable()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.SeekMap.Unseekable
 * JD-Core Version:    0.7.0.1
 */