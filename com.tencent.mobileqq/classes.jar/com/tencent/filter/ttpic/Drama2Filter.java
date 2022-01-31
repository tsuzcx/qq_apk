package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HistogramsStrectchFilter;
import com.tencent.filter.Param.FloatParam;

public class Drama2Filter
  extends BaseFilter
{
  float param = 1.0F;
  
  public Drama2Filter()
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
    Object localObject2 = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    float f = Math.min(paramFloat2, paramFloat1);
    ((BaseFilter)localObject2).scaleFact = Math.min(200.0F / f, 1.0F);
    setNextFilter((BaseFilter)localObject2, null);
    int i = getTheFilterIndex((BaseFilter)localObject2);
    Object localObject1 = new HistogramsStrectchFilter();
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, new int[] { this.srcTextureIndex + 1 + (i - 1) });
    localObject2 = new BaseFilter(GLSLRender.FILTER_VIBRANCE);
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("contrast", 0.96F));
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("saturation", 0.766F));
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.FILTER_RGBTOHSV);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.VERTEXT_SHADER_SHARPEN, GLSLRender.FILTER_CHANNEL_SHARPEN_FR);
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("sharpness", 0.377F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    ((BaseFilter)localObject1).scaleFact = Math.min(400.0F / f, 1.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    i = getTheFilterIndex((BaseFilter)localObject1);
    localObject2 = new ChannelStretchFilter3(((BaseFilter)localObject1).scaleFact);
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("strength", 50.0F));
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("highlight", 24.4F));
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("shadow", 26.700001F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, new int[] { this.srcTextureIndex + 1 + (i - 1) });
    ((BaseFilter)localObject2).setNextFilter(new BaseFilter(GLSLRender.FILTER_HSVTORGB), null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setAdjustParam(float paramFloat)
  {
    this.param = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.Drama2Filter
 * JD-Core Version:    0.7.0.1
 */