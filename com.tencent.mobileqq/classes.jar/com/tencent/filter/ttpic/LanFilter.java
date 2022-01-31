package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class LanFilter
  extends BaseFilter
{
  public LanFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_TEMP);
    localBaseFilter2.addParam(new Param.FloatParam("scaleC", -0.549F));
    localBaseFilter2.addParam(new Param.FloatParam("scaleT", 0.0F));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_DARKEN_BLEND);
    localBaseFilter1.addParam(new Param.FloatsParam("color2", new float[] { 0.5921569F, 0.764706F, 0.839216F, 1.0F }));
    localBaseFilter1.addParam(new Param.FloatParam("transparency", 0.58F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_MIC_CURE_MASK);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/lan_curve1.png", 33986));
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture3", "sh/lan_curve1mask.png", 33987));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/lan_curve2.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter2.addParam(new Param.FloatsParam("shadowsShift", new float[] { -0.01960784F, 0.0F, 0.01960784F }));
    localBaseFilter2.addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new Param.IntParam("preserveLuminosity", 1));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.LanFilter
 * JD-Core Version:    0.7.0.1
 */