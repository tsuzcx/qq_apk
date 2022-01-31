package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class NuanHuangFilter
  extends BaseFilter
{
  public NuanHuangFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter2.addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, -0.1552941F }));
    localBaseFilter2.addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.03921569F, 0.0F, -0.1764706F }));
    localBaseFilter2.addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, -0.08934902F }));
    localBaseFilter2.addParam(new Param.IntParam("preserveLuminosity", 1));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/nuanhuang.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_HSVADJUSTER_SHADER);
    localBaseFilter2.addParam(new Param.FloatParam("inputH", 1.0F));
    localBaseFilter2.addParam(new Param.FloatParam("inputS", 1.06F));
    localBaseFilter2.addParam(new Param.FloatParam("inputV", 1.04F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.NuanHuangFilter
 * JD-Core Version:    0.7.0.1
 */