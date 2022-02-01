package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.FaceFeatureParam;
import com.tencent.ttpic.openapi.filter.TTBeautyV5BeautyFaceList;

public class AEFaceBeauty
  extends AEFaceBeautyBase
{
  private static final String TAG = "AEFaceBeautyV5";
  private int beautyLevel;
  private int colorToneLevel;
  private int contrastRatioLevel;
  private int eyeLightenLevel;
  private float faceFeatureMultiplyAlpha;
  private float faceFeatureNormalAlpha;
  private FaceFeatureParam faceFeatureParam;
  private float faceFeatureSoftlightAlpha;
  private boolean isLoadSo = false;
  private boolean isSkipBeautyRender = false;
  private boolean isSkipRenderEnabled = false;
  private boolean isVeryLowDevice = false;
  private int lipsLutAlpha;
  private String lipsLutPath;
  private TTBeautyV5BeautyFaceList mBeautyFaceList = new TTBeautyV5BeautyFaceList();
  private PTFaceAttr mFaceAttr;
  private double mFaceScale = 1.0D;
  private int mVideoHeight = 1280;
  private int mVideoWidth = 720;
  private float normalAlphaFactor;
  private int removePounchLevel;
  private int removeWrinkles2Level;
  private int removeWrinklesLevel;
  private int renderMode;
  private boolean showFaceFeatureFilter;
  private int toothWhitenLevel;
  
  private void configFilter() {}
  
  private boolean isAllZeroLevel()
  {
    return (this.colorToneLevel == 50) && (this.beautyLevel + this.eyeLightenLevel + this.toothWhitenLevel + this.removePounchLevel + this.removeWrinklesLevel + this.removeWrinkles2Level + this.contrastRatioLevel == 0);
  }
  
  public void apply()
  {
    if (!this.mIsApplied)
    {
      this.mBeautyFaceList.initial();
      this.mIsApplied = true;
    }
  }
  
  public void clear()
  {
    TTBeautyV5BeautyFaceList localTTBeautyV5BeautyFaceList = this.mBeautyFaceList;
    if (localTTBeautyV5BeautyFaceList != null) {
      localTTBeautyV5BeautyFaceList.clear();
    }
    this.mIsApplied = false;
  }
  
  public String getVersion()
  {
    return "V5";
  }
  
  public boolean isValid()
  {
    return this.mIsApplied;
  }
  
  public String printParamInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AESmoothPrev2 {beautyLevel=");
    localStringBuilder.append(this.beautyLevel);
    localStringBuilder.append(", eyeLightenLevel=");
    localStringBuilder.append(this.eyeLightenLevel);
    localStringBuilder.append(", toothWhitenLevel=");
    localStringBuilder.append(this.toothWhitenLevel);
    localStringBuilder.append(", removePounchLevel=");
    localStringBuilder.append(this.removePounchLevel);
    localStringBuilder.append(", removeWrinklesLevel=");
    localStringBuilder.append(this.removeWrinklesLevel);
    localStringBuilder.append(", colorToneLevel=");
    localStringBuilder.append(this.colorToneLevel);
    localStringBuilder.append(", contrastRatioLevel=");
    localStringBuilder.append(this.contrastRatioLevel);
    localStringBuilder.append(", isVeryLowDevice=");
    localStringBuilder.append(this.isVeryLowDevice);
    localStringBuilder.append(", normalAlphaFactor=");
    localStringBuilder.append(this.normalAlphaFactor);
    localStringBuilder.append(", faceFeatureNormalAlpha=");
    localStringBuilder.append(this.faceFeatureNormalAlpha);
    localStringBuilder.append(", faceFeatureMultiplyAlpha=");
    localStringBuilder.append(this.faceFeatureMultiplyAlpha);
    localStringBuilder.append(", faceFeatureSoftlightAlpha=");
    localStringBuilder.append(this.faceFeatureSoftlightAlpha);
    localStringBuilder.append(", showFaceFeatureFilter=");
    localStringBuilder.append(this.showFaceFeatureFilter);
    localStringBuilder.append(", lipsLutAlpha=");
    localStringBuilder.append(this.lipsLutAlpha);
    localStringBuilder.append(", lipsLutPath=");
    localStringBuilder.append(this.lipsLutPath);
    localStringBuilder.append(", renderMode=");
    localStringBuilder.append(this.renderMode);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public Frame render(Frame paramFrame)
  {
    if (this.isSkipBeautyRender) {
      return paramFrame;
    }
    configFilter();
    Frame localFrame = paramFrame;
    if (this.mBeautyFaceList != null)
    {
      PTFaceAttr localPTFaceAttr = this.mFaceAttr;
      localFrame = paramFrame;
      if (localPTFaceAttr != null)
      {
        localFrame = paramFrame;
        if (localPTFaceAttr.getFaceCount() > 0)
        {
          this.mBeautyFaceList.updateVideoSize(this.mVideoWidth, this.mVideoHeight, this.mFaceScale);
          localFrame = this.mBeautyFaceList.render2(paramFrame, this.mFaceAttr.getAllFacePoints(), this.mFaceAttr.getPointsVis(), this.mFaceAttr.getFaceStatusList(), this.isVeryLowDevice, this.isLoadSo);
        }
      }
    }
    return localFrame;
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.mFaceAttr = paramPTFaceAttr;
  }
  
  public void setFaceBeautyLevel(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    switch (AEFaceBeauty.1.$SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
    {
    default: 
      break;
    case 8: 
      this.contrastRatioLevel = paramInt;
      this.mBeautyFaceList.setContrastLevel(this.contrastRatioLevel);
      break;
    case 7: 
      this.colorToneLevel = paramInt;
      this.mBeautyFaceList.setSkinColorAlpha((this.colorToneLevel - 50) / 50.0F);
      break;
    case 6: 
      this.removeWrinkles2Level = paramInt;
      this.mBeautyFaceList.setSmoothOpacity2(this.removeWrinkles2Level / 100.0F);
      break;
    case 5: 
      this.removeWrinklesLevel = paramInt;
      this.mBeautyFaceList.setSmoothOpacity(this.removeWrinklesLevel / 100.0F);
      break;
    case 4: 
      this.removePounchLevel = paramInt;
      this.mBeautyFaceList.setEyePouchOpacity(this.removePounchLevel / 100.0F);
      break;
    case 3: 
      this.toothWhitenLevel = paramInt;
      this.mBeautyFaceList.setToothWhitenAlpha(this.toothWhitenLevel / 80.0F);
      break;
    case 2: 
      this.eyeLightenLevel = paramInt;
      this.mBeautyFaceList.setEyeOpacity(this.eyeLightenLevel / 100.0F);
      break;
    case 1: 
      this.beautyLevel = paramInt;
      this.mBeautyFaceList.setBeautyLevel(this.beautyLevel / 100.0F);
    }
    if ((this.isSkipRenderEnabled) && (isAllZeroLevel()))
    {
      paramTYPE = this.lipsLutPath;
      if ((paramTYPE == null) || (paramTYPE.isEmpty())) {}
    }
    else
    {
      if (!"None/null".equals(this.lipsLutPath)) {
        break label287;
      }
    }
    this.isSkipBeautyRender = true;
    return;
    label287:
    this.isSkipBeautyRender = false;
  }
  
  public void setFaceFeatureMultiplyAlpha(float paramFloat)
  {
    this.faceFeatureMultiplyAlpha = paramFloat;
    TTBeautyV5BeautyFaceList localTTBeautyV5BeautyFaceList = this.mBeautyFaceList;
    if (localTTBeautyV5BeautyFaceList != null) {
      localTTBeautyV5BeautyFaceList.setFaceFeatureMultiplyAlpha(paramFloat);
    }
  }
  
  public void setFaceFeatureNormalAlpha(float paramFloat)
  {
    this.faceFeatureNormalAlpha = paramFloat;
    TTBeautyV5BeautyFaceList localTTBeautyV5BeautyFaceList = this.mBeautyFaceList;
    if (localTTBeautyV5BeautyFaceList != null) {
      localTTBeautyV5BeautyFaceList.setFaceFeatureNormalAlpha(paramFloat);
    }
  }
  
  public void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam)
  {
    this.faceFeatureParam = paramFaceFeatureParam;
    TTBeautyV5BeautyFaceList localTTBeautyV5BeautyFaceList = this.mBeautyFaceList;
    if (localTTBeautyV5BeautyFaceList != null) {
      localTTBeautyV5BeautyFaceList.setFaceFeatureParam(paramFaceFeatureParam);
    }
  }
  
  public void setFaceFeatureSoftlightAlpha(float paramFloat)
  {
    this.faceFeatureSoftlightAlpha = paramFloat;
    TTBeautyV5BeautyFaceList localTTBeautyV5BeautyFaceList = this.mBeautyFaceList;
    if (localTTBeautyV5BeautyFaceList != null) {
      localTTBeautyV5BeautyFaceList.setFaceFeatureSoftlightAlpha(paramFloat);
    }
  }
  
  public void setLipsLut(String paramString)
  {
    this.lipsLutPath = paramString;
    TTBeautyV5BeautyFaceList localTTBeautyV5BeautyFaceList = this.mBeautyFaceList;
    if (localTTBeautyV5BeautyFaceList != null) {
      localTTBeautyV5BeautyFaceList.setLipsLut(paramString);
    }
    if (((paramString == null) || (paramString.isEmpty()) || (paramString.equals("None/null"))) && (isAllZeroLevel()) && (this.isSkipRenderEnabled))
    {
      this.isSkipBeautyRender = true;
      return;
    }
    this.isSkipBeautyRender = false;
  }
  
  public void setLipsLutAlpha(int paramInt)
  {
    this.lipsLutAlpha = paramInt;
    TTBeautyV5BeautyFaceList localTTBeautyV5BeautyFaceList = this.mBeautyFaceList;
    if (localTTBeautyV5BeautyFaceList != null) {
      localTTBeautyV5BeautyFaceList.setLipsLutAlpha(paramInt);
    }
  }
  
  public void setLipsStyleMaskPath(String paramString)
  {
    TTBeautyV5BeautyFaceList localTTBeautyV5BeautyFaceList = this.mBeautyFaceList;
    if (localTTBeautyV5BeautyFaceList != null) {
      localTTBeautyV5BeautyFaceList.setLipsStyleMaskPath(paramString);
    }
  }
  
  public void setLoadSo(boolean paramBoolean)
  {
    this.isLoadSo = paramBoolean;
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    this.normalAlphaFactor = paramFloat;
    TTBeautyV5BeautyFaceList localTTBeautyV5BeautyFaceList = this.mBeautyFaceList;
    if (localTTBeautyV5BeautyFaceList != null) {
      localTTBeautyV5BeautyFaceList.setNormalAlphaFactor(paramFloat);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    this.renderMode = paramInt;
    TTBeautyV5BeautyFaceList localTTBeautyV5BeautyFaceList = this.mBeautyFaceList;
    if (localTTBeautyV5BeautyFaceList != null) {
      localTTBeautyV5BeautyFaceList.setRenderMode(paramInt);
    }
  }
  
  public void setShowFaceFeatureFilter(boolean paramBoolean)
  {
    this.showFaceFeatureFilter = paramBoolean;
    TTBeautyV5BeautyFaceList localTTBeautyV5BeautyFaceList = this.mBeautyFaceList;
    if (localTTBeautyV5BeautyFaceList != null) {
      localTTBeautyV5BeautyFaceList.setShowFaceFeatureFilter(paramBoolean);
    }
  }
  
  public void setSkipRenderEnabled(boolean paramBoolean)
  {
    this.isSkipRenderEnabled = paramBoolean;
  }
  
  public void setVeryLowDevice(boolean paramBoolean)
  {
    this.isVeryLowDevice = paramBoolean;
  }
  
  public void setVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.mFaceScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFaceBeauty
 * JD-Core Version:    0.7.0.1
 */