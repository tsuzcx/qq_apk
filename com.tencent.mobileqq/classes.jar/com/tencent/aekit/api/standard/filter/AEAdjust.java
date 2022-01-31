package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.filter.ColorTemperatureLutFilter;
import com.tencent.ttpic.filter.VibranceBaseFilter;
import com.tencent.ttpic.openapi.config.AdjustRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.FadeFilter;
import com.tencent.ttpic.openapi.filter.HighPassSharpenFilter;
import com.tencent.ttpic.openapi.filter.HighlightShadowFilter;

public class AEAdjust
  extends AEChainI
{
  private Frame mColorTemperatureFrame = new Frame();
  private ColorTemperatureLutFilter mColorTemperatureLutFilter = new ColorTemperatureLutFilter();
  private boolean mEnable = true;
  private FadeFilter mFadeFilter = new FadeFilter();
  private Frame mFadeFrame = new Frame();
  private HighPassSharpenFilter mHighPassSharpenFilter = new HighPassSharpenFilter();
  private Frame mHighPassSharpenFrame = new Frame();
  private HighlightShadowFilter mHighlightShadowFilter = new HighlightShadowFilter();
  private Frame mHighlightShadowFrame = new Frame();
  private VibranceBaseFilter mVibranceBaseFilter = new VibranceBaseFilter();
  private Frame mVibranceFrame = new Frame();
  
  public void apply()
  {
    if (!this.mIsApplied)
    {
      if (this.mVibranceBaseFilter != null) {
        this.mVibranceBaseFilter.apply();
      }
      if (this.mHighlightShadowFilter != null) {
        this.mHighlightShadowFilter.applyFilterChain(true, 0.0F, 0.0F);
      }
      if (this.mHighPassSharpenFilter != null) {
        this.mHighPassSharpenFilter.apply();
      }
      if (this.mColorTemperatureLutFilter != null) {
        this.mColorTemperatureLutFilter.apply();
      }
      if (this.mFadeFilter != null) {
        this.mFadeFilter.apply();
      }
    }
    this.mIsApplied = true;
  }
  
  public void clear()
  {
    if (this.mVibranceBaseFilter != null)
    {
      this.mVibranceBaseFilter.ClearGLSL();
      this.mVibranceBaseFilter = null;
    }
    if (this.mHighPassSharpenFilter != null)
    {
      this.mHighPassSharpenFilter.clearGLSLSelf();
      this.mHighPassSharpenFilter = null;
    }
    if (this.mHighlightShadowFilter != null)
    {
      this.mHighlightShadowFilter.clearGLSLSelf();
      this.mHighlightShadowFilter = null;
    }
    if (this.mColorTemperatureLutFilter != null)
    {
      this.mColorTemperatureLutFilter.clearGLSLSelf();
      this.mColorTemperatureLutFilter = null;
    }
    if (this.mFadeFilter != null)
    {
      this.mFadeFilter.clearGLSLSelf();
      this.mFadeFilter = null;
    }
    if (this.mVibranceFrame != null)
    {
      this.mVibranceFrame.clear();
      this.mVibranceFrame = null;
    }
    if (this.mHighPassSharpenFrame != null)
    {
      this.mHighPassSharpenFrame.clear();
      this.mHighPassSharpenFrame = null;
    }
    if (this.mHighlightShadowFrame != null)
    {
      this.mHighlightShadowFrame.clear();
      this.mHighlightShadowFrame = null;
    }
    if (this.mColorTemperatureFrame != null)
    {
      this.mColorTemperatureFrame.clear();
      this.mColorTemperatureFrame = null;
    }
    if (this.mFadeFrame != null)
    {
      this.mFadeFrame.clear();
      this.mFadeFrame = null;
    }
    this.mIsApplied = false;
  }
  
  public Frame render(Frame paramFrame)
  {
    if (!this.mEnable) {
      return paramFrame;
    }
    if (this.mVibranceBaseFilter != null) {
      this.mVibranceBaseFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mVibranceFrame);
    }
    if (this.mVibranceFrame == null) {
      this.mVibranceFrame = paramFrame;
    }
    if (this.mHighPassSharpenFilter != null)
    {
      this.mHighPassSharpenFilter.setCanvasSize(this.mVibranceFrame.width, this.mVibranceFrame.height);
      this.mHighPassSharpenFilter.RenderProcess(this.mVibranceFrame.getTextureId(), this.mVibranceFrame.width, this.mVibranceFrame.height, -1, 0.0D, this.mHighPassSharpenFrame);
    }
    if (this.mHighPassSharpenFrame == null) {
      this.mHighPassSharpenFrame = this.mVibranceFrame;
    }
    if (this.mHighlightShadowFilter != null) {
      this.mHighlightShadowFilter.RenderProcess(this.mHighPassSharpenFrame.getTextureId(), this.mHighPassSharpenFrame.width, this.mHighPassSharpenFrame.height, -1, 0.0D, this.mHighlightShadowFrame);
    }
    if (this.mHighlightShadowFrame == null) {
      this.mHighlightShadowFrame = this.mHighPassSharpenFrame;
    }
    if (this.mColorTemperatureLutFilter != null) {
      this.mColorTemperatureLutFilter.RenderProcess(this.mHighlightShadowFrame.getTextureId(), this.mHighlightShadowFrame.width, this.mHighlightShadowFrame.height, -1, 0.0D, this.mColorTemperatureFrame);
    }
    if (this.mColorTemperatureFrame == null) {
      this.mColorTemperatureFrame = this.mHighlightShadowFrame;
    }
    if (this.mFadeFilter != null) {
      this.mFadeFilter.RenderProcess(this.mColorTemperatureFrame.getTextureId(), this.mColorTemperatureFrame.width, this.mColorTemperatureFrame.height, -1, 0.0D, this.mFadeFrame);
    }
    if (this.mFadeFrame == null) {
      this.mFadeFrame = this.mColorTemperatureFrame;
    }
    return this.mFadeFrame;
  }
  
  public void setAdjustLevel(AdjustRealConfig.TYPE paramTYPE, int paramInt)
  {
    switch (AEAdjust.1.$SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[paramTYPE.ordinal()])
    {
    default: 
      return;
    case 1: 
      setBrightness(paramInt);
      return;
    case 2: 
      setHighlights(paramInt);
      return;
    case 3: 
      setShadows(paramInt);
      return;
    case 4: 
      setContrast(paramInt);
      return;
    case 5: 
      setSharp(paramInt);
      return;
    case 6: 
      setSaturation(paramInt);
      return;
    case 7: 
      setColorTemperature(paramInt);
      return;
    }
    setFadeLevel(paramInt);
  }
  
  public void setBrightness(float paramFloat)
  {
    if (this.mVibranceBaseFilter != null) {
      this.mVibranceBaseFilter.setBrightness(paramFloat / 100.0F);
    }
  }
  
  public void setColorTemperature(float paramFloat)
  {
    if (this.mColorTemperatureLutFilter != null) {
      this.mColorTemperatureLutFilter.updateAlpha(paramFloat / 100.0F);
    }
  }
  
  public void setContrast(float paramFloat)
  {
    if (this.mVibranceBaseFilter != null) {
      this.mVibranceBaseFilter.setContrast(paramFloat / 100.0F);
    }
  }
  
  public void setFadeLevel(float paramFloat)
  {
    if (this.mFadeFilter != null) {
      this.mFadeFilter.setAlpha(paramFloat / 100.0F);
    }
  }
  
  public void setHighlights(float paramFloat)
  {
    if (this.mHighlightShadowFilter != null) {
      this.mHighlightShadowFilter.setHighlights(paramFloat / 100.0F);
    }
  }
  
  public void setSaturation(float paramFloat)
  {
    if (this.mVibranceBaseFilter != null) {
      this.mVibranceBaseFilter.setSaturation(paramFloat / 100.0F);
    }
  }
  
  public void setShadows(float paramFloat)
  {
    if (this.mHighlightShadowFilter != null) {
      this.mHighlightShadowFilter.setShadows(paramFloat / 100.0F);
    }
  }
  
  public void setSharp(float paramFloat)
  {
    if (this.mHighPassSharpenFilter != null) {
      this.mHighPassSharpenFilter.setAlpha(paramFloat / 100.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEAdjust
 * JD-Core Version:    0.7.0.1
 */