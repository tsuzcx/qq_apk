package com.google.android.exoplayer2.util;

public final class TimestampAdjuster
{
  public static final long DO_NOT_OFFSET = 9223372036854775807L;
  private static final long MAX_PTS_PLUS_ONE = 8589934592L;
  private long firstSampleTimestampUs;
  private volatile long lastSampleTimestamp = -9223372036854775807L;
  private long timestampOffsetUs;
  
  public TimestampAdjuster(long paramLong)
  {
    setFirstSampleTimestampUs(paramLong);
  }
  
  public static long ptsToUs(long paramLong)
  {
    return paramLong * 1000000L / 90000L;
  }
  
  public static long usToPts(long paramLong)
  {
    return paramLong * 90000L / 1000000L;
  }
  
  public long adjustSampleTimestamp(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    if (this.lastSampleTimestamp != -9223372036854775807L)
    {
      this.lastSampleTimestamp = paramLong;
    }
    else
    {
      long l = this.firstSampleTimestampUs;
      if (l != 9223372036854775807L) {
        this.timestampOffsetUs = (l - paramLong);
      }
    }
    try
    {
      this.lastSampleTimestamp = paramLong;
      notifyAll();
      return paramLong + this.timestampOffsetUs;
    }
    finally {}
  }
  
  public long adjustTsTimestamp(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    long l1 = paramLong;
    if (this.lastSampleTimestamp != -9223372036854775807L)
    {
      long l3 = usToPts(this.lastSampleTimestamp);
      l1 = (4294967296L + l3) / 8589934592L;
      long l2 = (l1 - 1L) * 8589934592L + paramLong;
      paramLong += l1 * 8589934592L;
      l1 = paramLong;
      if (Math.abs(l2 - l3) < Math.abs(paramLong - l3)) {
        l1 = l2;
      }
    }
    return adjustSampleTimestamp(ptsToUs(l1));
  }
  
  public long getFirstSampleTimestampUs()
  {
    return this.firstSampleTimestampUs;
  }
  
  public long getLastAdjustedTimestampUs()
  {
    long l2 = this.lastSampleTimestamp;
    long l1 = -9223372036854775807L;
    if (l2 != -9223372036854775807L) {
      return this.lastSampleTimestamp;
    }
    l2 = this.firstSampleTimestampUs;
    if (l2 != 9223372036854775807L) {
      l1 = l2;
    }
    return l1;
  }
  
  public long getTimestampOffsetUs()
  {
    if (this.firstSampleTimestampUs == 9223372036854775807L) {
      return 0L;
    }
    if (this.lastSampleTimestamp == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    return this.timestampOffsetUs;
  }
  
  public void reset()
  {
    this.lastSampleTimestamp = -9223372036854775807L;
  }
  
  public void setFirstSampleTimestampUs(long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.lastSampleTimestamp == -9223372036854775807L)
        {
          bool = true;
          Assertions.checkState(bool);
          this.firstSampleTimestampUs = paramLong;
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void waitUntilInitialized()
  {
    try
    {
      while (this.lastSampleTimestamp == -9223372036854775807L) {
        wait();
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.util.TimestampAdjuster
 * JD-Core Version:    0.7.0.1
 */