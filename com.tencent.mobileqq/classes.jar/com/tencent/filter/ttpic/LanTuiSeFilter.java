package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class LanTuiSeFilter
  extends BaseFilter
{
  public LanTuiSeFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/lantuise.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_HSVADJUSTER2_SHADER);
    localBaseFilter1.addParam(new Param.FloatParam("inputH", 1.0F));
    localBaseFilter1.addParam(new Param.FloatParam("inputS", 1.0F));
    localBaseFilter1.addParam(new Param.FloatParam("inputV", 1.0914F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter2.addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, 0.06494118F }));
    localBaseFilter2.addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("highlightsShift", new float[] { -0.1515294F, 0.0F, 0.08293334F }));
    localBaseFilter2.addParam(new Param.IntParam("preserveLuminosity", 1));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_TEMP);
    localBaseFilter1.addParam(new Param.FloatParam("scaleC", -0.144F));
    localBaseFilter1.addParam(new Param.FloatParam("scaleT", 0.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_SCREEN_BLEND);
    localBaseFilter2.addParam(new Param.FloatsParam("color2", new float[] { 0.5490196F, 0.654902F, 0.6980392F, 1.0F }));
    localBaseFilter2.addParam(new Param.FloatParam("transparency", 0.15F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.LanTuiSeFilter
 * JD-Core Version:    0.7.0.1
 */