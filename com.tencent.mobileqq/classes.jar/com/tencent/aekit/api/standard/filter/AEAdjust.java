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
      Object localObject = this.mVibranceBaseFilter;
      if (localObject != null) {
        ((VibranceBaseFilter)localObject).applyFilterChain(true, 0.0F, 0.0F);
      }
      localObject = this.mHighlightShadowFilter;
      if (localObject != null) {
        ((HighlightShadowFilter)localObject).applyFilterChain(true, 0.0F, 0.0F);
      }
      localObject = this.mHighPassSharpenFilter;
      if (localObject != null) {
        ((HighPassSharpenFilter)localObject).applyFilterChain(true, 0.0F, 0.0F);
      }
      localObject = this.mColorTemperatureLutFilter;
      if (localObject != null) {
        ((ColorTemperatureLutFilter)localObject).applyFilterChain(true, 0.0F, 0.0F);
      }
      localObject = this.mVignettingFilter;
      if (localObject != null) {
        ((VignettingFilter)localObject).applyFilterChain(true, 0.0F, 0.0F);
      }
      localObject = this.mFadeFilter;
      if (localObject != null) {
        ((FadeFilter)localObject).applyFilterChain(true, 0.0F, 0.0F);
      }
      localObject = this.mGrainFilter;
      if (localObject != null) {
        ((GrainFilter)localObject).applyFilterChain(true, 0.0F, 0.0F);
      }
      localObject = this.mHSLAdjustFilter;
      if (localObject != null) {
        ((HSLAdjustFilter)localObject).applyFilterChain(true, 0.0F, 0.0F);
      }
    }
    this.mIsApplied = true;
  }
  
  public void clear()
  {
    Object localObject = this.mVibranceBaseFilter;
    if (localObject != null)
    {
      ((VibranceBaseFilter)localObject).clearGLSL();
      this.mVibranceBaseFilter = null;
    }
    localObject = this.mHighPassSharpenFilter;
    if (localObject != null)
    {
      ((HighPassSharpenFilter)localObject).clearGLSLSelf();
      this.mHighPassSharpenFilter = null;
    }
    localObject = this.mHighlightShadowFilter;
    if (localObject != null)
    {
      ((HighlightShadowFilter)localObject).clearGLSLSelf();
      this.mHighlightShadowFilter = null;
    }
    localObject = this.mColorTemperatureLutFilter;
    if (localObject != null)
    {
      ((ColorTemperatureLutFilter)localObject).clearGLSLSelf();
      this.mColorTemperatureLutFilter = null;
    }
    localObject = this.mVignettingFilter;
    if (localObject != null)
    {
      ((VignettingFilter)localObject).clearGLSLSelf();
      this.mVignettingFilter = null;
    }
    localObject = this.mFadeFilter;
    if (localObject != null)
    {
      ((FadeFilter)localObject).clearGLSLSelf();
      this.mFadeFilter = null;
    }
    localObject = this.mGrainFilter;
    if (localObject != null)
    {
      ((GrainFilter)localObject).clearGLSLSelf();
      this.mGrainFilter = null;
    }
    localObject = this.mHSLAdjustFilter;
    if (localObject != null)
    {
      ((HSLAdjustFilter)localObject).clearGLSLSelf();
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
        return paramFrame;
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
      if (this.hasHSL)
      {
        localFrame2 = this.mHSLAdjustFilter.RenderProcess(localFrame1.getTextureId(), localFrame1.width, localFrame1.height);
        paramFrame = localFrame2;
        if (localFrame1 != localFrame2)
        {
          localFrame1.unlock();
          paramFrame = localFrame2;
        }
      }
      else
      {
        paramFrame = localFrame1;
      }
      localFrame1 = this.mFadeFilter.render(paramFrame);
      if (paramFrame != localFrame1) {
        paramFrame.unlock();
      }
      this.mHighPassSharpenFilter.setCanvasSize(localFrame1.width, localFrame1.height);
      paramFrame = this.mHighPassSharpenFilter.render(localFrame1);
      if (localFrame1 != paramFrame) {
        localFrame1.unlock();
      }
      Frame localFrame2 = this.mVignettingFilter.render(paramFrame);
      if (paramFrame != localFrame2) {
        paramFrame.unlock();
      }
      paramFrame = this.mGrainFilter.render(localFrame2);
      localFrame1 = paramFrame;
      if (localFrame2 != paramFrame)
      {
        localFrame2.unlock();
        localFrame1 = paramFrame;
      }
    }
    return localFrame1;
  }
  
  public void setAdjustLevel(AdjustRealConfig.TYPE paramTYPE, int paramInt)
  {
    float f = paramInt * this.alpha;
    switch (AEAdjust.1.$SwitchMap$com$tencent$ttpic$openapi$config$AdjustRealConfig$TYPE[paramTYPE.ordinal()])
    {
    default: 
      return;
    case 10: 
      setGrainLevel(f);
      return;
    case 9: 
      setFadeLevel(f);
      return;
    case 8: 
      setVignettingLevel(f);
      return;
    case 7: 
      setColorTemperature(f);
      return;
    case 6: 
      setSaturation(f);
      return;
    case 5: 
      setSharp(f);
      return;
    case 4: 
      setContrast(f);
      return;
    case 3: 
      setShadows(f);
      return;
    case 2: 
      setHighlights(f);
      return;
    }
    setBrightness(f);
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
      switch (str.hashCode())
      {
      default: 
        break;
      case 2140672316: 
        if (str.equals("satAdjustRed")) {
          i = 11;
        }
        break;
      case 2089176170: 
        if (str.equals("hueAdjustRed")) {
          i = 10;
        }
        break;
      case 1970170486: 
        if (str.equals("lumAdjustCyan")) {
          i = 24;
        }
        break;
      case 1970128813: 
        if (str.equals("lumAdjustBlue")) {
          i = 27;
        }
        break;
      case 1938804892: 
        if (str.equals("hueAdjustGreen")) {
          i = 19;
        }
        break;
      case 1935904728: 
        if (str.equals("satAdjustCyan")) {
          i = 23;
        }
        break;
      case 1935863055: 
        if (str.equals("satAdjustBlue")) {
          i = 26;
        }
        break;
      case 1334636230: 
        if (str.equals("darkCornerValue")) {
          i = 7;
        }
        break;
      case 1295304681: 
        if (str.equals("satAdjustYellow")) {
          i = 17;
        }
        break;
      case 1052601137: 
        if (str.equals("satAdjustPurple")) {
          i = 29;
        }
        break;
      case 1033399006: 
        if (str.equals("lumAdjustRed")) {
          i = 12;
        }
        break;
      case 1020692899: 
        if (str.equals("satAdjustOrange")) {
          i = 14;
        }
        break;
      case 949232144: 
        if (str.equals("lumAdjustGreen")) {
          i = 21;
        }
        break;
      case 793911183: 
        if (str.equals("contrastValue")) {
          i = 1;
        }
        break;
      case 526710198: 
        if (str.equals("grainValue")) {
          i = 9;
        }
        break;
      case 507766045: 
        if (str.equals("highlightValue")) {
          i = 5;
        }
        break;
      case 476943867: 
        if (str.equals("hueAdjustYellow")) {
          i = 16;
        }
        break;
      case 339524202: 
        if (str.equals("hueAdjustCyan")) {
          i = 22;
        }
        break;
      case 339482529: 
        if (str.equals("hueAdjustBlue")) {
          i = 25;
        }
        break;
      case 234240323: 
        if (str.equals("hueAdjustPurple")) {
          i = 28;
        }
        break;
      case 202332085: 
        if (str.equals("hueAdjustOrange")) {
          i = 13;
        }
        break;
      case -113006354: 
        if (str.equals("satAdjustGreen")) {
          i = 20;
        }
        break;
      case -135040249: 
        if (str.equals("lumAdjustYellow")) {
          i = 18;
        }
        break;
      case -279095294: 
        if (str.equals("hueAdjustMagenta")) {
          i = 31;
        }
        break;
      case -377743793: 
        if (str.equals("lumAdjustPurple")) {
          i = 30;
        }
        break;
      case -409652031: 
        if (str.equals("lumAdjustOrange")) {
          i = 15;
        }
        break;
      case -492488513: 
        if (str.equals("saturationValue")) {
          i = 2;
        }
        break;
      case -679713836: 
        if (str.equals("satAdjustMagenta")) {
          i = 32;
        }
        break;
      case -892831659: 
        if (str.equals("fadeValue")) {
          i = 8;
        }
        break;
      case -1306280776: 
        if (str.equals("scaleCValue")) {
          i = 3;
        }
        break;
      case -1404092777: 
        if (str.equals("brightValue")) {
          i = 0;
        }
        break;
      case -1572611023: 
        if (str.equals("shadowValue")) {
          i = 6;
        }
        break;
      case -1711609058: 
        if (str.equals("sharpenValue")) {
          i = 4;
        }
        break;
      case -2070733706: 
        if (str.equals("lumAdjustMagenta")) {
          i = 33;
        }
        break;
      }
      int i = -1;
      switch (i)
      {
      default: 
        break;
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
      case 30: 
      case 31: 
      case 32: 
      case 33: 
        this.hasHSL = true;
        localHashMap.put(localEntry.getKey(), Float.valueOf(Float.parseFloat((String)localEntry.getValue()) / 100.0F));
        break;
      case 9: 
        setGrainLevel(Float.parseFloat((String)localEntry.getValue()));
        break;
      case 8: 
        setFadeLevel(Float.parseFloat((String)localEntry.getValue()));
        break;
      case 7: 
        setVignettingLevel(Float.parseFloat((String)localEntry.getValue()));
        break;
      case 6: 
        setShadows(Float.parseFloat((String)localEntry.getValue()));
        break;
      case 5: 
        setHighlights(Float.parseFloat((String)localEntry.getValue()));
        break;
      case 4: 
        setSharp(Float.parseFloat((String)localEntry.getValue()));
        break;
      case 3: 
        setColorTemperature(Float.parseFloat((String)localEntry.getValue()));
        break;
      case 2: 
        setSaturation(Float.parseFloat((String)localEntry.getValue()));
        break;
      case 1: 
        setContrast(Float.parseFloat((String)localEntry.getValue()));
        break;
      case 0: 
        setBrightness(Float.parseFloat((String)localEntry.getValue()));
      }
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
    VibranceBaseFilter localVibranceBaseFilter = this.mVibranceBaseFilter;
    if (localVibranceBaseFilter != null) {
      localVibranceBaseFilter.setBrightness(paramFloat / 100.0F);
    }
  }
  
  public void setColorTemperature(float paramFloat)
  {
    ColorTemperatureLutFilter localColorTemperatureLutFilter = this.mColorTemperatureLutFilter;
    if (localColorTemperatureLutFilter != null) {
      localColorTemperatureLutFilter.updateAlpha(paramFloat / 100.0F);
    }
  }
  
  public void setContrast(float paramFloat)
  {
    VibranceBaseFilter localVibranceBaseFilter = this.mVibranceBaseFilter;
    if (localVibranceBaseFilter != null) {
      localVibranceBaseFilter.setContrast(paramFloat / 100.0F);
    }
  }
  
  public void setFadeLevel(float paramFloat)
  {
    FadeFilter localFadeFilter = this.mFadeFilter;
    if (localFadeFilter != null) {
      localFadeFilter.setAlpha(paramFloat / 100.0F);
    }
  }
  
  public void setGrainLevel(float paramFloat)
  {
    GrainFilter localGrainFilter = this.mGrainFilter;
    if (localGrainFilter != null) {
      localGrainFilter.setAlpha(paramFloat / 100.0F);
    }
  }
  
  public void setHSLParams(HashMap<String, Float> paramHashMap)
  {
    HSLAdjustFilter localHSLAdjustFilter = this.mHSLAdjustFilter;
    if (localHSLAdjustFilter != null) {
      localHSLAdjustFilter.setParams(paramHashMap);
    }
  }
  
  public void setHighlights(float paramFloat)
  {
    HighlightShadowFilter localHighlightShadowFilter = this.mHighlightShadowFilter;
    if (localHighlightShadowFilter != null) {
      localHighlightShadowFilter.setHighlights(paramFloat / 100.0F);
    }
  }
  
  public void setSaturation(float paramFloat)
  {
    VibranceBaseFilter localVibranceBaseFilter = this.mVibranceBaseFilter;
    if (localVibranceBaseFilter != null) {
      localVibranceBaseFilter.setSaturation(paramFloat / 100.0F);
    }
  }
  
  public void setShadows(float paramFloat)
  {
    HighlightShadowFilter localHighlightShadowFilter = this.mHighlightShadowFilter;
    if (localHighlightShadowFilter != null) {
      localHighlightShadowFilter.setShadows(paramFloat / 100.0F);
    }
  }
  
  public void setSharp(float paramFloat)
  {
    HighPassSharpenFilter localHighPassSharpenFilter = this.mHighPassSharpenFilter;
    if (localHighPassSharpenFilter != null) {
      localHighPassSharpenFilter.setAlpha(paramFloat / 100.0F);
    }
  }
  
  public void setVignettingLevel(float paramFloat)
  {
    VignettingFilter localVignettingFilter = this.mVignettingFilter;
    if (localVignettingFilter != null) {
      localVignettingFilter.setAlpha(paramFloat / 100.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEAdjust
 * JD-Core Version:    0.7.0.1
 */