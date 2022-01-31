package com.tencent.algo.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HistogramsStrectchFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.ttpic.ChannelStretchFilter3;

public class Drama3Filter
  extends BaseFilter
{
  float param = 1.0F;
  
  public Drama3Filter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramBoolean)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    float f = Math.min(paramFloat2, paramFloat1);
    localBaseFilter.scaleFact = Math.min(200.0F / f, 1.0F);
    setNextFilter(localBaseFilter, null);
    int i = getTheFilterIndex(localBaseFilter);
    Object localObject = new HistogramsStrectchFilter();
    localBaseFilter.setNextFilter((BaseFilter)localObject, new int[] { this.srcTextureIndex + 1 + (i - 1) });
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_VIBRANCE);
    localBaseFilter.addParam(new Param.FloatParam("contrast", 0.8F));
    localBaseFilter.addParam(new Param.FloatParam("saturation", 0.8F));
    localBaseFilter.addParam(new Param.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.FILTER_RGBTOHSV);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    localBaseFilter.scaleFact = Math.min(400.0F / f, 1.0F);
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    i = getTheFilterIndex(localBaseFilter);
    localObject = new ChannelStretchFilter3(localBaseFilter.scaleFact);
    ((BaseFilter)localObject).addParam(new Param.FloatParam("strength", 30.0F));
    ((BaseFilter)localObject).addParam(new Param.FloatParam("highlight", 24.4F));
    ((BaseFilter)localObject).addParam(new Param.FloatParam("shadow", 26.700001F));
    localBaseFilter.setNextFilter((BaseFilter)localObject, new int[] { this.srcTextureIndex + 1 + (i - 1) });
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_HSVTORGB);
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.FILTER_ALPHA_ADJUST_REAL);
    ((BaseFilter)localObject).addParam(new Param.FloatParam("filterAdjustParam", 0.7F));
    localBaseFilter.setNextFilter((BaseFilter)localObject, new int[] { this.srcTextureIndex });
    ((BaseFilter)localObject).setNextFilter(new DehazeProcessFilter(0.5F), null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setAdjustParam(float paramFloat)
  {
    this.param = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.algo.filter.Drama3Filter
 * JD-Core Version:    0.7.0.1
 */