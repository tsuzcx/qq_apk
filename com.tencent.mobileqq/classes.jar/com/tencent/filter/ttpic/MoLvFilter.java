package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class MoLvFilter
  extends BaseFilter
{
  public MoLvFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    float f1 = (float)(-0.1843137254901961D * 0.292F);
    float f2 = (float)(0.07058823529411765D * 0.292F);
    float f3 = (float)(-0.1843137254901961D * 0.383F);
    float f4 = (float)(0.07058823529411765D * 0.383F);
    localBaseFilter2.addParam(new Param.FloatsParam("shadowsShift", new float[] { f1, f2, 0.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("midtonesShift", new float[] { f3, f4, 0.01960784F }));
    localBaseFilter2.addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.0627451F, -0.09411765F, 0.0F }));
    localBaseFilter2.addParam(new Param.IntParam("preserveLuminosity", 1));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_HSVADJUSTER_SHADER);
    localBaseFilter1.addParam(new Param.FloatParam("inputH", 1.0F));
    localBaseFilter1.addParam(new Param.FloatParam("inputS", 1.0F));
    localBaseFilter1.addParam(new Param.FloatParam("inputV", 1.0F + 0.292F / 2.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/molv_curve1.png", 33986));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_MIC_CURE_MASK);
    localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/molv_curve2.png", 33986));
    localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture3", "sh/molv_curve2mask.png", 33987));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.MoLvFilter
 * JD-Core Version:    0.7.0.1
 */