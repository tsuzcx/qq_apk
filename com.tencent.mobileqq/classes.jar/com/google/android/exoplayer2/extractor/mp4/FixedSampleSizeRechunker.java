package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Util;

final class FixedSampleSizeRechunker
{
  private static final int MAX_SAMPLE_SIZE = 8192;
  
  public static FixedSampleSizeRechunker.Results rechunk(int paramInt, long[] paramArrayOfLong, int[] paramArrayOfInt, long paramLong)
  {
    int i1 = 8192 / paramInt;
    int m = paramArrayOfInt.length;
    int k = 0;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += Util.ceilDivide(paramArrayOfInt[i], i1);
      i += 1;
    }
    long[] arrayOfLong1 = new long[j];
    int[] arrayOfInt1 = new int[j];
    long[] arrayOfLong2 = new long[j];
    int[] arrayOfInt2 = new int[j];
    m = 0;
    j = 0;
    int n = 0;
    i = k;
    k = m;
    while (i < paramArrayOfInt.length)
    {
      m = paramArrayOfInt[i];
      long l = paramArrayOfLong[i];
      while (m > 0)
      {
        int i2 = Math.min(i1, m);
        arrayOfLong1[j] = l;
        arrayOfInt1[j] = (paramInt * i2);
        n = Math.max(n, arrayOfInt1[j]);
        arrayOfLong2[j] = (k * paramLong);
        arrayOfInt2[j] = 1;
        l += arrayOfInt1[j];
        k += i2;
        m -= i2;
        j += 1;
      }
      i += 1;
    }
    return new FixedSampleSizeRechunker.Results(arrayOfLong1, arrayOfInt1, n, arrayOfLong2, arrayOfInt2, paramLong * k, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker
 * JD-Core Version:    0.7.0.1
 */