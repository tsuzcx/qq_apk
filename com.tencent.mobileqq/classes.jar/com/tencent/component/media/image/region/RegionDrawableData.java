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
    int j = (int)Math.ceil(1.0F / paramFloat);
    int i = j;
    if (j > 64) {
      i = 64;
    }
    j = 64;
    int k;
    while (j != 0)
    {
      k = i & j;
      if (k != 0)
      {
        if ((i & i - 1) == 0) {
          break label59;
        }
        return k << 1;
      }
      j >>= 1;
    }
    return 1;
    label59:
    return k;
  }
  
  public int calcSample()
  {
    if (this.mScale == 0.0F) {}
    for (int i = 1;; i = scaleToSampleRoundup(this.mScale))
    {
      this.mSample = i;
      return i;
    }
  }
  
  public String toString()
  {
    if ((this.mShowArea != null) && (this.mImageArea != null)) {
      return "onShowAreaChanged mShowArea = " + this.mShowArea + " mImageArea = " + this.mImageArea + " scale = " + this.mScale + " mDefaultScale = " + this.mDefaultScale + " sample = " + this.mSample + " mTargetDensity = " + this.mTargetDensity + " mSourceDensity = " + this.mSourceDensity + " mIsShowRegion = " + this.mShowRegion;
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionDrawableData
 * JD-Core Version:    0.7.0.1
 */