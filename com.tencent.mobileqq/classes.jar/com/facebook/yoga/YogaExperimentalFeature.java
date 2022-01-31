package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaExperimentalFeature
{
  WEB_FLEX_BASIS(0);
  
  private int mIntValue;
  
  private YogaExperimentalFeature(int paramInt)
  {
    this.mIntValue = paramInt;
  }
  
  public static YogaExperimentalFeature fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown enum value: " + paramInt);
    }
    return WEB_FLEX_BASIS;
  }
  
  public int intValue()
  {
    return this.mIntValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.facebook.yoga.YogaExperimentalFeature
 * JD-Core Version:    0.7.0.1
 */