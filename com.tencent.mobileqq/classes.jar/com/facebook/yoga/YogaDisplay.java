package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaDisplay
{
  FLEX(0),  NONE(1);
  
  private int mIntValue;
  
  private YogaDisplay(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaDisplay fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0: 
      return FLEX;
    }
    return NONE;
  }
  
  public int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.facebook.yoga.YogaDisplay
 * JD-Core Version:    0.7.0.1
 */