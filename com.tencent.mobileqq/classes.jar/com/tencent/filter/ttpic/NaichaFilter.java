package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class NaichaFilter
  extends BaseFilter
{
  public NaichaFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_VIBRANCE);
    localBaseFilter2.addParam(new Param.FloatParam("contrast", 1.0F));
    localBaseFilter2.addParam(new Param.FloatParam("saturation", 0.5F));
    localBaseFilter2.addParam(new Param.FloatParam("brightness", 1.0F));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/heibai4_Curve.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_MULTIPLY_BLEND);
    localBaseFilter2.addParam(new Param.FloatsParam("color2", new float[] { 0.8470588F, 0.8F, 0.7450981F, 1.0F }));
    localBaseFilter2.addParam(new Param.FloatParam("transparency", 1.0F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_SCREEN_BLEND);
    localBaseFilter1.addParam(new Param.FloatsParam("color2", new float[] { 0.09019608F, 0.0666667F, 0.0666667F, 1.0F }));
    localBaseFilter1.addParam(new Param.FloatParam("transparency", 1.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_MULTIPLY_BLEND_RSS);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/heibai4_blend.png", 33986));
    localBaseFilter2.addParam(new Param.FloatParam("transparency", 0.8F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.NaichaFilter
 * JD-Core Version:    0.7.0.1
 */