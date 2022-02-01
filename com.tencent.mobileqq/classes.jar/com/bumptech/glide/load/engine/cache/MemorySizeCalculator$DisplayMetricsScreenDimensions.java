package com.bumptech.glide.load.engine.cache;

import android.util.DisplayMetrics;

final class MemorySizeCalculator$DisplayMetricsScreenDimensions
  implements MemorySizeCalculator.ScreenDimensions
{
  private final DisplayMetrics a;
  
  MemorySizeCalculator$DisplayMetricsScreenDimensions(DisplayMetrics paramDisplayMetrics)
  {
    this.a = paramDisplayMetrics;
  }
  
  public int a()
  {
    return this.a.widthPixels;
  }
  
  public int b()
  {
    return this.a.heightPixels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.cache.MemorySizeCalculator.DisplayMetricsScreenDimensions
 * JD-Core Version:    0.7.0.1
 */