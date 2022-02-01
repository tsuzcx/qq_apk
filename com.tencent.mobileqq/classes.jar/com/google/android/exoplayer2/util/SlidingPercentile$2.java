package com.google.android.exoplayer2.util;

import java.util.Comparator;

final class SlidingPercentile$2
  implements Comparator<SlidingPercentile.Sample>
{
  public int compare(SlidingPercentile.Sample paramSample1, SlidingPercentile.Sample paramSample2)
  {
    if (paramSample1.value < paramSample2.value) {
      return -1;
    }
    if (paramSample2.value < paramSample1.value) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.util.SlidingPercentile.2
 * JD-Core Version:    0.7.0.1
 */