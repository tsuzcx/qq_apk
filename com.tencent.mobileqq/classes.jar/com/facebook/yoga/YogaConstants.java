package com.facebook.yoga;

public class YogaConstants
{
  public static final float UNDEFINED = (0.0F / 0.0F);
  
  public static boolean isUndefined(float paramFloat)
  {
    return Float.compare(paramFloat, (0.0F / 0.0F)) == 0;
  }
  
  public static boolean isUndefined(YogaValue paramYogaValue)
  {
    return paramYogaValue.unit == YogaUnit.UNDEFINED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaConstants
 * JD-Core Version:    0.7.0.1
 */