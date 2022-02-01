package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.FaceFeatureParam;

public abstract class AEFaceBeautyBase
  extends AEChainI
{
  public abstract void clear();
  
  public abstract String getVersion();
  
  public abstract boolean isValid();
  
  public abstract String printParamInfo();
  
  public abstract void setFaceAttr(PTFaceAttr paramPTFaceAttr);
  
  public abstract void setFaceBeautyLevel(BeautyRealConfig.TYPE paramTYPE, int paramInt);
  
  public abstract void setFaceFeatureMultiplyAlpha(float paramFloat);
  
  public abstract void setFaceFeatureNormalAlpha(float paramFloat);
  
  public abstract void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam);
  
  public abstract void setFaceFeatureSoftlightAlpha(float paramFloat);
  
  public abstract void setLipsLut(String paramString);
  
  public abstract void setLipsLutAlpha(int paramInt);
  
  public abstract void setLipsStyleMaskPath(String paramString);
  
  public void setLoadSo(boolean paramBoolean) {}
  
  public abstract void setNormalAlphaFactor(float paramFloat);
  
  public abstract void setRenderMode(int paramInt);
  
  public abstract void setShowFaceFeatureFilter(boolean paramBoolean);
  
  public void setSkipRenderEnabled(boolean paramBoolean) {}
  
  public abstract void setVeryLowDevice(boolean paramBoolean);
  
  public abstract void setVideoSize(int paramInt1, int paramInt2, double paramDouble);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFaceBeautyBase
 * JD-Core Version:    0.7.0.1
 */