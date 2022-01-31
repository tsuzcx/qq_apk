package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaFlexDirection
{
  COLUMN(0),  COLUMN_REVERSE(1),  ROW(2),  ROW_REVERSE(3);
  
  private int mIntValue;
  
  private YogaFlexDirection(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaFlexDirection fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    case 0: 
      return COLUMN;
    case 1: 
      return COLUMN_REVERSE;
    case 2: 
      return ROW;
    }
    return ROW_REVERSE;
  }
  
  public int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaFlexDirection
 * JD-Core Version:    0.7.0.1
 */