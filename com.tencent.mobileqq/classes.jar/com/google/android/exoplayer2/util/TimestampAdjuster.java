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
    return 1000000L * paramLong / 90000L;
  }
  
  public static long usToPts(long paramLong)
  {
    return 90000L * paramLong / 1000000L;
  }
  
  public long adjustSampleTimestamp(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    if (this.lastSampleTimestamp != -9223372036854775807L) {
      this.lastSampleTimestamp = paramLong;
    }
    for (;;)
    {
      return this.timestampOffsetUs + paramLong;
      if (this.firstSampleTimestampUs != 9223372036854775807L) {
        this.timestampOffsetUs = (this.firstSampleTimestampUs - paramLong);
      }
      try
      {
        this.lastSampleTimestamp = paramLong;
        notifyAll();
      }
      finally {}
    }
  }
  
  public long adjustTsTimestamp(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    if (this.lastSampleTimestamp != -9223372036854775807L)
    {
      long l2 = usToPts(this.lastSampleTimestamp);
      long l3 = (4294967296L + l2) / 8589934592L;
      long l1 = (l3 - 1L) * 8589934592L + paramLong;
      paramLong = l3 * 8589934592L + paramLong;
      if (Math.abs(l1 - l2) < Math.abs(paramLong - l2)) {
        paramLong = l1;
      }
    }
    for (;;)
    {
      return adjustSampleTimestamp(ptsToUs(paramLong));
    }
  }
  
  public long getFirstSampleTimestampUs()
  {
    return this.firstSampleTimestampUs;
  }
  
  public long getLastAdjustedTimestampUs()
  {
    long l = -9223372036854775807L;
    if (this.lastSampleTimestamp != -9223372036854775807L) {
      l = this.lastSampleTimestamp;
    }
    while (this.firstSampleTimestampUs == 9223372036854775807L) {
      return l;
    }
    return this.firstSampleTimestampUs;
  }
  
  public long getTimestampOffsetUs()
  {
    long l = -9223372036854775807L;
    if (this.firstSampleTimestampUs == 9223372036854775807L) {
      l = 0L;
    }
    while (this.lastSampleTimestamp == -9223372036854775807L) {
      return l;
    }
    return this.timestampOffsetUs;
  }
  
  public void reset()
  {
    this.lastSampleTimestamp = -9223372036854775807L;
  }
  
  /* Error */
  public void setFirstSampleTimestampUs(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/google/android/exoplayer2/util/TimestampAdjuster:lastSampleTimestamp	J
    //   6: ldc2_w 20
    //   9: lcmp
    //   10: ifne +17 -> 27
    //   13: iconst_1
    //   14: istore_3
    //   15: iload_3
    //   16: invokestatic 67	com/google/android/exoplayer2/util/Assertions:checkState	(Z)V
    //   19: aload_0
    //   20: lload_1
    //   21: putfield 39	com/google/android/exoplayer2/util/TimestampAdjuster:firstSampleTimestampUs	J
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: iconst_0
    //   28: istore_3
    //   29: goto -14 -> 15
    //   32: astore 4
    //   34: aload_0
    //   35: monitorexit
    //   36: aload 4
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	TimestampAdjuster
    //   0	39	1	paramLong	long
    //   14	15	3	bool	boolean
    //   32	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	32	finally
    //   15	24	32	finally
  }
  
  public void waitUntilInitialized()
  {
    try
    {
      if (this.lastSampleTimestamp == -9223372036854775807L) {
        wait();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.util.TimestampAdjuster
 * JD-Core Version:    0.7.0.1
 */