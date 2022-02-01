package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;

public class BlackWhite3Filter
  extends BaseFilter
{
  public BlackWhite3Filter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(13));
    localBaseFilter2.addParam(new UniformParam.FloatParam("contrast", 1.0F));
    localBaseFilter2.addParam(new UniformParam.FloatParam("saturation", 0.0F));
    localBaseFilter2.addParam(new UniformParam.FloatParam("brightness", 1.0F));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(56));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.0627451F, 0.07058824F, 0.09019608F, 1.0F }));
    localBaseFilter1.addParam(new UniformParam.FloatParam("transparency", 1.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(59));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.9098039F, 0.8705882F, 0.8588235F, 1.0F }));
    localBaseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.55F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.ttpic.BlackWhite3Filter
 * JD-Core Version:    0.7.0.1
 */