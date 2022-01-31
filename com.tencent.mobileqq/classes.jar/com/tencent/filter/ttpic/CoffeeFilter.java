package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class CoffeeFilter
  extends BaseFilter
{
  public CoffeeFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_CHANNEL_MIXER);
    localBaseFilter2.addParam(new Param.FloatsParam("channelparam", new float[] { 0.4F, 0.4F, 0.2F }));
    localBaseFilter2.addParam(new Param.FloatsParam("mixparam", new float[] { 1.0F, 1.0F, 1.0F }));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/coffee_curve.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SOFTLIGHTBLEND2_SHADER);
    localBaseFilter2.addParam(new Param.FloatsParam("color2", new float[] { 0.2235294F, 0.1921569F, 0.1607843F, 1.0F }));
    localBaseFilter2.addParam(new Param.FloatParam("transparency", 1.0F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SOFTLIGHTBLEND2_SHADER);
    localBaseFilter1.addParam(new Param.FloatsParam("color2", new float[] { 0.4431373F, 0.3921569F, 0.3607843F, 1.0F }));
    localBaseFilter1.addParam(new Param.FloatParam("transparency", 1.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.CoffeeFilter
 * JD-Core Version:    0.7.0.1
 */