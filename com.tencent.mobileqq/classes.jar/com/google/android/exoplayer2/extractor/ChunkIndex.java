package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Util;

public final class ChunkIndex
  implements SeekMap
{
  private final long durationUs;
  public final long[] durationsUs;
  public final int length;
  public final long[] offsets;
  public final int[] sizes;
  public final long[] timesUs;
  
  public ChunkIndex(int[] paramArrayOfInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    this.sizes = paramArrayOfInt;
    this.offsets = paramArrayOfLong1;
    this.durationsUs = paramArrayOfLong2;
    this.timesUs = paramArrayOfLong3;
    this.length = paramArrayOfInt.length;
    if (this.length > 0)
    {
      this.durationUs = (paramArrayOfLong2[(this.length - 1)] + paramArrayOfLong3[(this.length - 1)]);
      return;
    }
    this.durationUs = 0L;
  }
  
  public int getChunkIndex(long paramLong)
  {
    return Util.binarySearchFloor(this.timesUs, paramLong, true, true);
  }
  
  public long getDurationUs()
  {
    return this.durationUs;
  }
  
  public SeekMap.SeekPoints getSeekPoints(long paramLong)
  {
    int i = getChunkIndex(paramLong);
    SeekPoint localSeekPoint = new SeekPoint(this.timesUs[i], this.offsets[i]);
    if ((localSeekPoint.timeUs >= paramLong) || (i == this.length - 1)) {
      return new SeekMap.SeekPoints(localSeekPoint);
    }
    return new SeekMap.SeekPoints(localSeekPoint, new SeekPoint(this.timesUs[(i + 1)], this.offsets[(i + 1)]));
  }
  
  public boolean isSeekable()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ChunkIndex
 * JD-Core Version:    0.7.0.1
 */