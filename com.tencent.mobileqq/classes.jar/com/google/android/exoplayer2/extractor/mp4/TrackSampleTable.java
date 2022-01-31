package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class TrackSampleTable
{
  public final long durationUs;
  public final int[] flags;
  public final int maximumSize;
  public final long[] offsets;
  public final int sampleCount;
  public final int[] sizes;
  public final long[] timestampsUs;
  
  public TrackSampleTable(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2, long paramLong)
  {
    if (paramArrayOfInt1.length == paramArrayOfLong2.length)
    {
      bool1 = true;
      Assertions.checkArgument(bool1);
      if (paramArrayOfLong1.length != paramArrayOfLong2.length) {
        break label103;
      }
      bool1 = true;
      label34:
      Assertions.checkArgument(bool1);
      if (paramArrayOfInt2.length != paramArrayOfLong2.length) {
        break label109;
      }
    }
    label103:
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.checkArgument(bool1);
      this.offsets = paramArrayOfLong1;
      this.sizes = paramArrayOfInt1;
      this.maximumSize = paramInt;
      this.timestampsUs = paramArrayOfLong2;
      this.flags = paramArrayOfInt2;
      this.durationUs = paramLong;
      this.sampleCount = paramArrayOfLong1.length;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label34;
    }
  }
  
  public int getIndexOfEarlierOrEqualSynchronizationSample(long paramLong)
  {
    int i = Util.binarySearchFloor(this.timestampsUs, paramLong, true, false);
    while (i >= 0)
    {
      if ((this.flags[i] & 0x1) != 0) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public int getIndexOfLaterOrEqualSynchronizationSample(long paramLong)
  {
    int i = Util.binarySearchCeil(this.timestampsUs, paramLong, true, false);
    while (i < this.timestampsUs.length)
    {
      if ((this.flags[i] & 0x1) != 0) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
 * JD-Core Version:    0.7.0.1
 */