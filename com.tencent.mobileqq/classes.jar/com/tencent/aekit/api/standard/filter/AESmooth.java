package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.TTBeautyV5PrefixFilterGroup;

public class AESmooth
  extends AEChainI
{
  private static final String TAG = "AESmoothV5";
  private int exposureLevel;
  private float lookUpIntensity;
  private String lookUpPath;
  private PTFaceAttr mFaceAttr;
  private boolean mIsApplied = false;
  private boolean mIsTakePhoto = false;
  private boolean mIsVeryLowEndDevice;
  private TTBeautyV5PrefixFilterGroup mSmoothFilter = new TTBeautyV5PrefixFilterGroup();
  private int smoothLevel;
  
  private void configFilter()
  {
    int i;
    if ((!this.mIsVeryLowEndDevice) && (this.mFaceAttr.getCurve() != null))
    {
      i = 1;
      if (i == 0) {
        break label58;
      }
      this.mSmoothFilter.updateToneCurveTexture(this.mFaceAttr.getCurve(), this.mIsTakePhoto);
    }
    for (;;)
    {
      this.mSmoothFilter.updateBlurAndSharpenStrength(this.mIsTakePhoto);
      return;
      i = 0;
      break;
      label58:
      this.mSmoothFilter.resetToneCurveTexture();
    }
  }
  
  public void apply()
  {
    if (this.mIsApplied) {
      return;
    }
    this.mSmoothFilter.apply();
    this.mSmoothFilter.setLookUpLeftIntensity(0.0F);
    this.mSmoothFilter.setLookUpRightIntensity(0.0F);
    this.mIsApplied = true;
  }
  
  public void clear()
  {
    if (this.mSmoothFilter != null) {
      this.mSmoothFilter.clear();
    }
    this.mIsApplied = false;
  }
  
  public String printParamInfo()
  {
    return "AESmooth {TAG =AESmoothV5 , mIsVeryLowEndDevice='" + this.mIsVeryLowEndDevice + ", smoothLevel=" + this.smoothLevel + ", exposureLevel=" + this.exposureLevel + ", mIsTakePhoto=" + this.mIsTakePhoto + ", lookUpIntensity=" + this.lookUpIntensity + ", lookUpPath=" + this.lookUpPath + ", mSmoothFilter= TTBeautyV5PrefixFilterGroup" + '}';
  }
  
  public Frame render(Frame paramFrame)
  {
    if (this.mFaceAttr == null) {
      return paramFrame;
    }
    configFilter();
    return this.mSmoothFilter.render(paramFrame, this.mFaceAttr);
  }
  
  public void setExposureLevel(int paramInt)
  {
    this.exposureLevel = paramInt;
    this.mSmoothFilter.setExposureValue(this.exposureLevel);
  }
  
  public void setExposureValue(int paramInt)
  {
    this.mSmoothFilter.setExposureValue(paramInt);
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.mFaceAttr = paramPTFaceAttr;
  }
  
  public void setIsVeryLowEndDevice(boolean paramBoolean)
  {
    this.mIsVeryLowEndDevice = paramBoolean;
  }
  
  public void setLookUpIntensity(float paramFloat)
  {
    this.lookUpIntensity = paramFloat;
    if (paramFloat > 0.0F)
    {
      this.mSmoothFilter.setLookUpLeftIntensity(paramFloat);
      this.mSmoothFilter.setLookUpRightIntensity(paramFloat);
      return;
    }
    this.mSmoothFilter.setLookUpLeftIntensity(0.0F);
    this.mSmoothFilter.setLookUpRightIntensity(0.0F);
  }
  
  public void setLookUpPath(String paramString)
  {
    this.lookUpPath = paramString;
    this.mSmoothFilter.setLookUpLeftPath(paramString);
  }
  
  public void setSharpenSize(int paramInt1, int paramInt2)
  {
    if (this.mSmoothFilter != null) {
      this.mSmoothFilter.setSmoothSharpenSize(paramInt1, paramInt2);
    }
  }
  
  public void setSharpenStrength(float paramFloat)
  {
    if (this.mSmoothFilter != null) {
      this.mSmoothFilter.setSmoothSharpenStrength(paramFloat);
    }
  }
  
  public void setSmoothLevel(int paramInt)
  {
    this.smoothLevel = paramInt;
    this.mSmoothFilter.setSmoothBlurAlpha(this.smoothLevel / 100.0F);
  }
  
  public void setmIsTakePhoto(boolean paramBoolean)
  {
    this.mIsTakePhoto = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AESmooth
 * JD-Core Version:    0.7.0.1
 */