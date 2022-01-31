package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.openapi.filter.NightRGBStretchImpFilter;

public class AELight
  extends AEChainI
{
  private static final String TAG = "NightRGBStretchFilter";
  private int[] histogram;
  private boolean isInited = false;
  private boolean mIsVeryLowEndDevice;
  public float mLightSensorBrightness = 3.4028235E+38F;
  private NightRGBStretchImpFilter mNightRGBStretchFilter = new NightRGBStretchImpFilter();
  private int previewHeight;
  private int previewWidth;
  
  public void apply()
  {
    if (!this.isInited) {
      this.mNightRGBStretchFilter.applyFilterChain(true, this.previewWidth, this.previewHeight);
    }
  }
  
  public void clear()
  {
    if (this.mNightRGBStretchFilter != null) {
      this.mNightRGBStretchFilter.ClearGLSL();
    }
    this.isInited = false;
  }
  
  public boolean isLowLightEnv()
  {
    return (!this.mIsVeryLowEndDevice) && (this.mLightSensorBrightness < 20.0F) && (this.mNightRGBStretchFilter.needRender());
  }
  
  public String printParamInfo()
  {
    return "AELight {mLightSensorBrightness=" + this.mLightSensorBrightness + ", mIsVeryLowEndDevice=" + this.mIsVeryLowEndDevice + ", previewWidth=" + this.previewWidth + ", previewHeight=" + this.previewHeight + '}';
  }
  
  public Frame render(Frame paramFrame)
  {
    this.mNightRGBStretchFilter.setHistogram(this.histogram);
    if ((!this.mIsVeryLowEndDevice) && (this.mLightSensorBrightness < 20.0F) && (this.mNightRGBStretchFilter.needRender()))
    {
      BenchUtil.benchStart("mNightRGBStretchFilter.RenderProcess");
      Frame localFrame = this.mNightRGBStretchFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
      paramFrame.unlock();
      BenchUtil.benchEnd("mNightRGBStretchFilter.RenderProcess");
      return localFrame;
    }
    this.mNightRGBStretchFilter.reset();
    return paramFrame;
  }
  
  public void setHistogram(int[] paramArrayOfInt)
  {
    this.histogram = paramArrayOfInt;
  }
  
  public void setIsVeryLowEndDevice(boolean paramBoolean)
  {
    this.mIsVeryLowEndDevice = paramBoolean;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.previewWidth = paramInt1;
    this.previewHeight = paramInt2;
  }
  
  public void setmLightSensorBrightness(float paramFloat)
  {
    this.mLightSensorBrightness = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AELight
 * JD-Core Version:    0.7.0.1
 */