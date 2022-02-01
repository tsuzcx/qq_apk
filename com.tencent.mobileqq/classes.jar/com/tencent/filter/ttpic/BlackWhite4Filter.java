package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class BlackWhite4Filter
  extends BaseFilter
{
  public BlackWhite4Filter()
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
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "sh/heibai4_Curve.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(117));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/heibai4_blend.png", 33986));
    localBaseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.8F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.ttpic.BlackWhite4Filter
 * JD-Core Version:    0.7.0.1
 */