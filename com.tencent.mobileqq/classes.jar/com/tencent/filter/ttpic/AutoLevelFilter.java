package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class AutoLevelFilter
  extends BaseFilter
{
  public AutoLevelFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramBoolean)
    {
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    BaseFilter localBaseFilter = new BaseFilter(BaseFilter.getVertexShader(13), BaseFilter.getFragmentShader(112));
    localBaseFilter.addParam(new UniformParam.FloatParam("sharpness", 0.2F));
    localBaseFilter.addParam(new UniformParam.FloatParam("inputH", 1.0F));
    localBaseFilter.addParam(new UniformParam.FloatParam("inputS", 1.2F));
    localBaseFilter.addParam(new UniformParam.FloatParam("inputV", 1.0F));
    localBaseFilter.addParam(new UniformParam.FloatParam("imageWidthFactor", 1.0F / paramFloat1));
    localBaseFilter.addParam(new UniformParam.FloatParam("imageHeightFactor", 1.0F / paramFloat2));
    setNextFilter(localBaseFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.ttpic.AutoLevelFilter
 * JD-Core Version:    0.7.0.1
 */