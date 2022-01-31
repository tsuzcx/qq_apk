package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.TextureResParam;

public class GradientGlareFondDreamFilter
  extends BaseFilter
{
  public GradientGlareFondDreamFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/glarefonddream_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_MULTIPLY_BLEND_4);
    localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/glarefonddream_screen0.png", 33986));
    localBaseFilter1.addParam(new Param.FloatParam("transparency", 0.6F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_MULTIPLY_BLEND_4);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/glarefonddream_screen1.png", 33986));
    localBaseFilter2.addParam(new Param.FloatParam("transparency", 0.7F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_MULTIPLY_BLEND_4);
    localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/glarefonddream_screen2.png", 33986));
    localBaseFilter1.addParam(new Param.FloatParam("transparency", 0.4F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.GradientGlareFondDreamFilter
 * JD-Core Version:    0.7.0.1
 */