package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.filter.ColorTemperatureLutFilter;
import com.tencent.ttpic.filter.VibranceBaseFilter;
import com.tencent.ttpic.openapi.config.AdjustRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.FadeFilter;
import com.tencent.ttpic.openapi.filter.GrainFilter;
import com.tencent.ttpic.openapi.filter.HSLAdjustFilter;
import com.tencent.ttpic.openapi.filter.HighPassSharpenFilter;
import com.tencent.ttpic.openapi.filter.HighlightShadowFilter;
import com.tencent.ttpic.openapi.filter.VignettingFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class AEAdjust
  extends AEChainI
{
  private float alpha = 1.0F;
  private boolean hasHSL = false;
  private ColorTemperatureLutFilter mColorTemperatureLutFilter = new ColorTemperatureLutFilter();
  private boolean mEnable = true;
  private FadeFilter mFadeFilter = new FadeFilter();
  private GrainFilter mGrainFilter = new GrainFilter();
  private HSLAdjustFilter mHSLAdjustFilter = new HSLAdjustFilter();
  private HighPassSharpenFilter mHighPassSharpenFilter = new HighPassSharpenFilter();
  private HighlightShadowFilter mHighlightShadowFilter = new HighlightShadowFilter();
  private VibranceBaseFilter mVibranceBaseFilter = new VibranceBaseFilter();
  private VignettingFilter mVignettingFilter = new VignettingFilter();
  
  public void apply()
  {
    if (!this.mIsApplied)
    {
      if (this.mVibranceBaseFilter != null) {
        this.mVibranceBaseFilter.applyFilterChain(true, 0.0F, 0.0F);
      }
      if (this.mHighlightShadowFilter != null) {
        this.mHighlightShadowFilter.applyFilterChain(true, 0.0F, 0.0F);
      }
      if (this.mHighPassSharpenFilter != null) {
        this.mHighPassSharpenFilter.applyFilterChain(true, 0.0F, 0.0F);
      }
      if (this.mColorTemperatureLutFilter != null) {
        this.mColorTemperatureLutFilter.applyFilterChain(true, 0.0F, 0.0F);
      }
      if (this.mVignettingFilter != null) {
        this.mVignettingFilter.applyFilterChain(true, 0.0F, 0.0F);
      }
      if (this.mFadeFilter != null) {
        this.mFadeFilter.applyFilterChain(true, 0.0F, 0.0F);
      }
      if (this.mGrainFilter != null) {
        this.mGrainFilter.applyFilterChain(true, 0.0F, 0.0F);
      }
      if (this.mHSLAdjustFilter != null) {
        this.mHSLAdjustFilter.applyFilterChain(true, 0.0F, 0.0F);
      }
    }
    this.mIsApplied = true;
  }
  
  public void clear()
  {
    if (this.mVibranceBaseFilter != null)
    {
      this.mVibranceBaseFilter.clearGLSL();
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
    if (this.mVignettingFilter != null)
    {
      this.mVignettingFilter.clearGLSLSelf();
      this.mVignettingFilter = null;
    }
    if (this.mFadeFilter != null)
    {
      this.mFadeFilter.clearGLSLSelf();
      this.mFadeFilter = null;
    }
    if (this.mGrainFilter != null)
    {
      this.mGrainFilter.clearGLSLSelf();
      this.mGrainFilter = null;
    }
    if (this.mHSLAdjustFilter != null)
    {
      this.mHSLAdjustFilter.clearGLSLSelf();
      this.mHSLAdjustFilter = null;
    }
    this.mIsApplied = false;
  }
  
  public float getAlpha()
  {
    return this.alpha;
  }
  
  public Frame render(Frame paramFrame)
  {
    Frame localFrame1 = paramFrame;
    if (this.mEnable)
    {
      if (this.alpha == 0.0F) {
        localFrame1 = paramFrame;
      }
    }
    else {
      return localFrame1;
    }
    localFrame1 = this.mHighlightShadowFilter.render(paramFrame);
    if (paramFrame != localFrame1) {
      paramFrame.unlock();
    }
    paramFrame = this.mVibranceBaseFilter.render(localFrame1);
    if (localFrame1 != paramFrame) {
      localFrame1.unlock();
    }
    localFrame1 = this.mColorTemperatureLutFilter.render(paramFrame);
    if (paramFrame != localFrame1) {
      paramFrame.unlock();
    }
    Frame localFrame2;
    if (this.hasHSL)
    {
      localFrame2 = this.mHSLAdjustFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
      paramFrame = localFrame2;
      if (localFrame1 != localFrame2) {
        localFrame1.unlock();
      }
    }
    for (paramFrame = localFrame2;; paramFrame = localFrame1)
    {
      localFrame1 = this.mFadeFilter.render(paramFrame);
      if (paramFrame != localFrame1) {
        paramFrame.unlock();
      }
      this.mHighPassSharpenFilter.setCanvasSize(localFrame1.width, localFrame1.height);
      paramFrame = this.mHighPassSharpenFilter.render(localFrame1);
      if (localFrame1 != paramFrame) {
        localFrame1.unlock();
      }
      localFrame2 = this.mVignettingFilter.render(paramFrame);
      if (paramFrame != localFrame2) {
        paramFrame.unlock();
      }
      paramFrame = this.mGrainFilter.render(localFrame2);
      localFrame1 = paramFrame;
      if (localFrame2 == paramFrame) {
        break;
      }
      localFrame2.unlock();
      return paramFrame;
    }
  }
  
  public void setAdjustLevel(AdjustRealConfig.TYPE paramTYPE, int paramInt)
  {
    float f = paramInt * this.alpha;
    switch (AEAdjust.1.$SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[paramTYPE.ordinal()])
    {
    default: 
      return;
    case 1: 
      setBrightness(f);
      return;
    case 2: 
      setHighlights(f);
      return;
    case 3: 
      setShadows(f);
      return;
    case 4: 
      setContrast(f);
      return;
    case 5: 
      setSharp(f);
      return;
    case 6: 
      setSaturation(f);
      return;
    case 7: 
      setColorTemperature(f);
      return;
    case 8: 
      setVignettingLevel(f);
      return;
    case 9: 
      setFadeLevel(f);
      return;
    }
    setGrainLevel(f);
  }
  
  public void setAdjustParams(HashMap<String, String> paramHashMap)
  {
    this.hasHSL = false;
    HashMap localHashMap = new HashMap();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      String str = (String)localEntry.getKey();
      label344:
      int i;
      switch (str.hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          setBrightness(Float.parseFloat((String)localEntry.getValue()));
          break;
          if (!str.equals("brightValue")) {
            break label344;
          }
          i = 0;
          continue;
          if (!str.equals("contrastValue")) {
            break label344;
          }
          i = 1;
          continue;
          if (!str.equals("saturationValue")) {
            break label344;
          }
          i = 2;
          continue;
          if (!str.equals("scaleCValue")) {
            break label344;
          }
          i = 3;
          continue;
          if (!str.equals("sharpenValue")) {
            break label344;
          }
          i = 4;
          continue;
          if (!str.equals("highlightValue")) {
            break label344;
          }
          i = 5;
          continue;
          if (!str.equals("shadowValue")) {
            break label344;
          }
          i = 6;
          continue;
          if (!str.equals("darkCornerValue")) {
            break label344;
          }
          i = 7;
          continue;
          if (!str.equals("fadeValue")) {
            break label344;
          }
          i = 8;
          continue;
          if (!str.equals("grainValue")) {
            break label344;
          }
          i = 9;
          continue;
          if (!str.equals("hueAdjustRed")) {
            break label344;
          }
          i = 10;
          continue;
          if (!str.equals("satAdjustRed")) {
            break label344;
          }
          i = 11;
          continue;
          if (!str.equals("lumAdjustRed")) {
            break label344;
          }
          i = 12;
          continue;
          if (!str.equals("hueAdjustOrange")) {
            break label344;
          }
          i = 13;
          continue;
          if (!str.equals("satAdjustOrange")) {
            break label344;
          }
          i = 14;
          continue;
          if (!str.equals("lumAdjustOrange")) {
            break label344;
          }
          i = 15;
          continue;
          if (!str.equals("hueAdjustYellow")) {
            break label344;
          }
          i = 16;
          continue;
          if (!str.equals("satAdjustYellow")) {
            break label344;
          }
          i = 17;
          continue;
          if (!str.equals("lumAdjustYellow")) {
            break label344;
          }
          i = 18;
          continue;
          if (!str.equals("hueAdjustGreen")) {
            break label344;
          }
          i = 19;
          continue;
          if (!str.equals("satAdjustGreen")) {
            break label344;
          }
          i = 20;
          continue;
          if (!str.equals("lumAdjustGreen")) {
            break label344;
          }
          i = 21;
          continue;
          if (!str.equals("hueAdjustCyan")) {
            break label344;
          }
          i = 22;
          continue;
          if (!str.equals("satAdjustCyan")) {
            break label344;
          }
          i = 23;
          continue;
          if (!str.equals("lumAdjustCyan")) {
            break label344;
          }
          i = 24;
          continue;
          if (!str.equals("hueAdjustBlue")) {
            break label344;
          }
          i = 25;
          continue;
          if (!str.equals("satAdjustBlue")) {
            break label344;
          }
          i = 26;
          continue;
          if (!str.equals("lumAdjustBlue")) {
            break label344;
          }
          i = 27;
          continue;
          if (!str.equals("hueAdjustPurple")) {
            break label344;
          }
          i = 28;
          continue;
          if (!str.equals("satAdjustPurple")) {
            break label344;
          }
          i = 29;
          continue;
          if (!str.equals("lumAdjustPurple")) {
            break label344;
          }
          i = 30;
          continue;
          if (!str.equals("hueAdjustMagenta")) {
            break label344;
          }
          i = 31;
          continue;
          if (!str.equals("satAdjustMagenta")) {
            break label344;
          }
          i = 32;
          continue;
          if (!str.equals("lumAdjustMagenta")) {
            break label344;
          }
          i = 33;
        }
      }
      setContrast(Float.parseFloat((String)localEntry.getValue()));
      continue;
      setSaturation(Float.parseFloat((String)localEntry.getValue()));
      continue;
      setColorTemperature(Float.parseFloat((String)localEntry.getValue()));
      continue;
      setSharp(Float.parseFloat((String)localEntry.getValue()));
      continue;
      setHighlights(Float.parseFloat((String)localEntry.getValue()));
      continue;
      setShadows(Float.parseFloat((String)localEntry.getValue()));
      continue;
      setVignettingLevel(Float.parseFloat((String)localEntry.getValue()));
      continue;
      setFadeLevel(Float.parseFloat((String)localEntry.getValue()));
      continue;
      setGrainLevel(Float.parseFloat((String)localEntry.getValue()));
      continue;
      this.hasHSL = true;
      localHashMap.put(localEntry.getKey(), Float.valueOf(Float.parseFloat((String)localEntry.getValue()) / 100.0F));
    }
    if (this.hasHSL) {
      this.mHSLAdjustFilter.setParams(localHashMap);
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    this.alpha = paramFloat;
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
  
  public void setGrainLevel(float paramFloat)
  {
    if (this.mGrainFilter != null) {
      this.mGrainFilter.setAlpha(paramFloat / 100.0F);
    }
  }
  
  public void setHSLParams(HashMap<String, Float> paramHashMap)
  {
    if (this.mHSLAdjustFilter != null) {
      this.mHSLAdjustFilter.setParams(paramHashMap);
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
  
  public void setVignettingLevel(float paramFloat)
  {
    if (this.mVignettingFilter != null) {
      this.mVignettingFilter.setAlpha(paramFloat / 100.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEAdjust
 * JD-Core Version:    0.7.0.1
 */