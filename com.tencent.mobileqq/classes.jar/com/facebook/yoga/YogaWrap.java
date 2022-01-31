package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaWrap
{
  NO_WRAP(0),  WRAP(1),  WRAP_REVERSE(2);
  
  private int mIntValue;
  
  private YogaWrap(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaWrap fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0: 
      return NO_WRAP;
    case 1: 
      return WRAP;
    }
    return WRAP_REVERSE;
  }
  
  public int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaWrap
 * JD-Core Version:    0.7.0.1
 */