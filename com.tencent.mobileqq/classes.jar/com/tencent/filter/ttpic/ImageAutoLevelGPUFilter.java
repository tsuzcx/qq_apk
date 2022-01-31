package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;

public class ImageAutoLevelGPUFilter
  extends BaseFilter
{
  public float p = 1.0F;
  
  public ImageAutoLevelGPUFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    int i = getTheFilterIndex(this);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    localBaseFilter.scaleFact = Math.min(100.0F / Math.min(paramFloat2, paramFloat1), 1.0F);
    setNextFilter(localBaseFilter, null);
    localBaseFilter.setNextFilter(new HistogramAutoLevelFilter(this.p), new int[] { this.srcTextureIndex + 1 + i });
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.ImageAutoLevelGPUFilter
 * JD-Core Version:    0.7.0.1
 */