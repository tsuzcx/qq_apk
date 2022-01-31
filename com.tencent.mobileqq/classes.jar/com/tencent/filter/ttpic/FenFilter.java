package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class FenFilter
  extends BaseFilter
{
  public FenFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter2.addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0F, -0.06411765F, 0.03137255F }));
    localBaseFilter2.addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.03137255F, -0.01588235F, 0.0F }));
    localBaseFilter2.addParam(new Param.IntParam("preserveLuminosity", 1));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_SCREEN_BLEND);
    localBaseFilter1.addParam(new Param.FloatsParam("color2", new float[] { 0.3803922F, 0.3058824F, 0.4117647F, 1.0F }));
    localBaseFilter1.addParam(new Param.FloatParam("transparency", 0.3F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/fen.png", 33986));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter1.addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter1.addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.01843137F, 0.0F, -0.0372549F }));
    localBaseFilter1.addParam(new Param.IntParam("preserveLuminosity", 1));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.FenFilter
 * JD-Core Version:    0.7.0.1
 */