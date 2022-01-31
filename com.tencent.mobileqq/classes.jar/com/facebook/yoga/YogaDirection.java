package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaDirection
{
  INHERIT(0),  LTR(1),  RTL(2);
  
  private int mIntValue;
  
  private YogaDirection(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaDirection fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0: 
      return INHERIT;
    case 1: 
      return LTR;
    }
    return RTL;
  }
  
  public int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaDirection
 * JD-Core Version:    0.7.0.1
 */