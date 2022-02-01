package com.tencent.aekit.api.standard.filter;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.HDRHSVFilter;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import java.util.HashMap;
import java.util.Map;

public class AEGlow
  extends AEChainI
{
  private static final String DEAULT_ASSETS_PATH = "assets://luts/";
  private static final String LUT_NAME = "eftXuanlan_lf.png";
  private float alpha = 0.0F;
  private String lutRes = getLutRes();
  private AlphaAdjustFilter mAlphaFilter = new AlphaAdjustFilter();
  private HDRHSVFilter mHDRHSVFilter = new HDRHSVFilter();
  private GPUImageLookupFilter mLookUpFilter = new GPUImageLookupFilter(this.lutRes);
  
  public void applyFilterChain(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(this.lutRes)) || (this.mIsApplied)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("stretechMag", Float.valueOf(25.0F));
    localHashMap.put("sharpnessMag", Float.valueOf(0.3F));
    localHashMap.put("saturationMag", Float.valueOf(1.3F));
    localHashMap.put("percent", Float.valueOf(0.001F));
    this.mHDRHSVFilter.setParameterDic(localHashMap);
    this.mHDRHSVFilter.applyFilterChain(paramBoolean, paramInt1, paramInt2);
    this.mLookUpFilter.apply();
    this.mAlphaFilter.apply();
    this.mAlphaFilter.setAdjustParam(this.alpha);
    this.mIsApplied = true;
  }
  
  public void clear()
  {
    if ((TextUtils.isEmpty(this.lutRes)) || (!this.mIsApplied)) {
      return;
    }
    this.mHDRHSVFilter.clearGLSLSelf();
    this.mLookUpFilter.clearGLSLSelf();
    this.mAlphaFilter.clearGLSLSelf();
    this.mIsApplied = false;
  }
  
  public String getLutRes()
  {
    String str1 = "assets://luts/eftXuanlan_lf.png";
    if (!TextUtils.isEmpty(FeatureManager.getResourceDir())) {
      str1 = FileUtils.getRealPath(FeatureManager.getResourceDir()) + "eftXuanlan_lf.png";
    }
    String str2 = str1;
    if (!FileUtils.assetAndPathExist(AEModule.getContext(), str1)) {
      str2 = null;
    }
    return str2;
  }
  
  public String printParamInfo()
  {
    return "AEGlow {TAG =AEGlow , alpha='" + this.alpha + '}';
  }
  
  public Frame render(Frame paramFrame)
  {
    if ((TextUtils.isEmpty(this.lutRes)) || (this.alpha == 0.0F)) {
      return paramFrame;
    }
    Frame localFrame1 = this.mHDRHSVFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
    Frame localFrame2 = this.mLookUpFilter.RenderProcess(localFrame1.getTextureId(), paramFrame.width, paramFrame.height);
    if (this.alpha == 1.0F)
    {
      localFrame1.unlock();
      paramFrame.unlock();
      return localFrame2;
    }
    this.mAlphaFilter.setFilterTexture(localFrame2.getTextureId());
    this.mAlphaFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, localFrame1);
    localFrame2.unlock();
    paramFrame.unlock();
    return localFrame1;
  }
  
  public void setAlpha(float paramFloat)
  {
    this.alpha = paramFloat;
    this.mAlphaFilter.setAdjustParam(this.alpha);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEGlow
 * JD-Core Version:    0.7.0.1
 */