package com.tencent.component.media.image.region;

import android.graphics.Rect;

public class RegionDrawableData
{
  private static final String TAG = "RegionDrawableData";
  public float mDefaultScale;
  public Rect mImageArea;
  public int mSample;
  public float mScale;
  public int mScrollDirection;
  public Rect mShowArea;
  public boolean mShowRegion;
  public int mSourceDensity;
  public int mState;
  public int mTargetDensity;
  public long mTaskTime;
  
  private int scaleToSampleRoundup(float paramFloat)
  {
    int m = (int)Math.ceil(1.0F / paramFloat);
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
      if (k != 0)
      {
        j = k;
        if ((i & i - 1) != 0) {
          j = k << 1;
        }
        return j;
      }
      j >>= 1;
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
      i = scaleToSampleRoundup(f);
    }
    this.mSample = i;
    return i;
  }
  
  public String toString()
  {
    if ((this.mShowArea != null) && (this.mImageArea != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowAreaChanged mShowArea = ");
      localStringBuilder.append(this.mShowArea);
      localStringBuilder.append(" mImageArea = ");
      localStringBuilder.append(this.mImageArea);
      localStringBuilder.append(" scale = ");
      localStringBuilder.append(this.mScale);
      localStringBuilder.append(" mDefaultScale = ");
      localStringBuilder.append(this.mDefaultScale);
      localStringBuilder.append(" sample = ");
      localStringBuilder.append(this.mSample);
      localStringBuilder.append(" mTargetDensity = ");
      localStringBuilder.append(this.mTargetDensity);
      localStringBuilder.append(" mSourceDensity = ");
      localStringBuilder.append(this.mSourceDensity);
      localStringBuilder.append(" mIsShowRegion = ");
      localStringBuilder.append(this.mShowRegion);
      return localStringBuilder.toString();
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionDrawableData
 * JD-Core Version:    0.7.0.1
 */