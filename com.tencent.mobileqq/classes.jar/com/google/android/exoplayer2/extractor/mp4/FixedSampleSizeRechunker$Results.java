package com.google.android.exoplayer2.extractor.mp4;

public final class FixedSampleSizeRechunker$Results
{
  public final long duration;
  public final int[] flags;
  public final int maximumSize;
  public final long[] offsets;
  public final int[] sizes;
  public final long[] timestamps;
  
  private FixedSampleSizeRechunker$Results(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2, long paramLong)
  {
    this.offsets = paramArrayOfLong1;
    this.sizes = paramArrayOfInt1;
    this.maximumSize = paramInt;
    this.timestamps = paramArrayOfLong2;
    this.flags = paramArrayOfInt2;
    this.duration = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.Results
 * JD-Core Version:    0.7.0.1
 */