package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class CoffeeFilter
  extends BaseFilter
{
  public CoffeeFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(58));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("channelparam", new float[] { 0.4F, 0.4F, 0.2F }));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("mixparam", new float[] { 1.0F, 1.0F, 1.0F }));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "sh/coffee_curve.png", 33986));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(116));
    localBaseFilter2.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.2235294F, 0.1921569F, 0.1607843F, 1.0F }));
    localBaseFilter2.addParam(new UniformParam.FloatParam("transparency", 1.0F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(116));
    localBaseFilter1.addParam(new UniformParam.FloatsParam("color2", new float[] { 0.4431373F, 0.3921569F, 0.3607843F, 1.0F }));
    localBaseFilter1.addParam(new UniformParam.FloatParam("transparency", 1.0F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.ttpic.CoffeeFilter
 * JD-Core Version:    0.7.0.1
 */