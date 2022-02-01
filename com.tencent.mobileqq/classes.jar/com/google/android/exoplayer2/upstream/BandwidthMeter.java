package com.google.android.exoplayer2.upstream;

public abstract interface BandwidthMeter
{
  public static final long NO_ESTIMATE = -1L;
  
  public abstract long getBitrateEstimate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.BandwidthMeter
 * JD-Core Version:    0.7.0.1
 */