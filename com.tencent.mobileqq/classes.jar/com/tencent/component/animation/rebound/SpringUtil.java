package com.tencent.component.animation.rebound;

public class SpringUtil
{
  public static double clamp(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return Math.min(Math.max(paramDouble1, paramDouble2), paramDouble3);
  }
  
  public static double mapValueFromRangeToRange(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    return (paramDouble1 - paramDouble2) / (paramDouble3 - paramDouble2) * (paramDouble5 - paramDouble4) + paramDouble4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.animation.rebound.SpringUtil
 * JD-Core Version:    0.7.0.1
 */