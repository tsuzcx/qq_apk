package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class MoLvFilter
  extends BaseFilter
{
  public MoLvFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
    double d = 0.292F;
    Double.isNaN(d);
    float f1 = (float)(d * -0.1843137254901961D);
    Double.isNaN(d);
    float f2 = (float)(d * 0.07058823529411765D);
    d = 0.383F;
    Double.isNaN(d);
    float f3 = (float)(-0.1843137254901961D * d);
    Double.isNaN(d);
    float f4 = (float)(d * 0.07058823529411765D);
    localBaseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { f1, f2, 0.0F }));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { f3, f4, 0.01960784F }));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.0627451F, -0.09411765F, 0.0F }));
    localBaseFilter2.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(60));
    localBaseFilter1.addParam(new UniformParam.FloatParam("inputH", 1.0F));
    localBaseFilter1.addParam(new UniformParam.FloatParam("inputS", 1.0F));
    localBaseFilter1.addParam(new UniformParam.FloatParam("inputV", 1.146F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/molv_curve1.png", 33986));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(107));
    localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "sh/molv_curve2.png", 33986));
    localBaseFilter1.addParam(new TextureResParam("inputImageTexture3", "sh/molv_curve2mask.png", 33987));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.ttpic.MoLvFilter
 * JD-Core Version:    0.7.0.1
 */