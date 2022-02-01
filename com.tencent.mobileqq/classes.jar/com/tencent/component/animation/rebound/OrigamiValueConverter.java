package com.tencent.component.animation.rebound;

public class OrigamiValueConverter
{
  public static double frictionFromOrigamiValue(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 0.0D;
    }
    return 25.0D + (paramDouble - 8.0D) * 3.0D;
  }
  
  public static double origamiValueFromFriction(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 0.0D;
    }
    return 8.0D + (paramDouble - 25.0D) / 3.0D;
  }
  
  public static double origamiValueFromTension(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 0.0D;
    }
    return 30.0D + (paramDouble - 194.0D) / 3.62D;
  }
  
  public static double tensionFromOrigamiValue(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 0.0D;
    }
    return 194.0D + (paramDouble - 30.0D) * 3.62D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.animation.rebound.OrigamiValueConverter
 * JD-Core Version:    0.7.0.1
 */