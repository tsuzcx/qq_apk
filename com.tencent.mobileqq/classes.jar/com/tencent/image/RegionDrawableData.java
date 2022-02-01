package com.tencent.image;

import android.graphics.Rect;

public class RegionDrawableData
{
  public static final int REGION_STATE_NONE = 0;
  public static final int REGION_STATE_SAMPLE = 1;
  public static final int SCROLL_DIRECTION_NO = 0;
  public static final int SCROLL_DIRECTION_TOLEFT = 1;
  public static final int SCROLL_DIRECTION_TORIGHT = 2;
  public float mDefaultScale;
  public Rect mImageArea;
  int mSample;
  public float mScale;
  public int mScrollDirection;
  public Rect mShowArea;
  public boolean mShowRegion;
  int mSourceDensity;
  public int mState;
  int mTargetDensity;
  public long mTaskTime;
  
  private int scaleToSampleRoundDown(float paramFloat)
  {
    int m = (int)Math.floor(1.0F / paramFloat);
    int k = 64;
    int j = k;
    int i = m;
    if (m > 64)
    {
      i = 64;
      j = k;
    }
    while (j != 0)
    {
      k = i & j;
      if (k != 0) {
        return k;
      }
      j >>= 1;
    }
    return 1;
  }
  
  private int scaleToSampleRoundup(float paramFloat)
  {
    double d = paramFloat;
    Double.isNaN(d);
    int j = (int)Math.round(1.0D / d);
    int i = j;
    if (j < 1) {
      i = 1;
    }
    int m = 64;
    int k = m;
    j = i;
    if (i > 64)
    {
      j = 64;
      k = m;
    }
    while (k != 0)
    {
      i = j & k;
      if (i != 0)
      {
        if ((k >> 1 & j) != 0)
        {
          if ((j & k - 1) == 0) {
            return i;
          }
          return i << 1;
        }
        return i;
      }
      k >>= 1;
    }
    return 1;
  }
  
  public int calcSample()
  {
    float f = this.mScale;
    int i;
    if (f == 0.0F) {
      i = 1;
    } else {
      i = scaleToSampleRoundup(f * (this.mTargetDensity / this.mSourceDensity));
    }
    this.mSample = i;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.RegionDrawableData
 * JD-Core Version:    0.7.0.1
 */