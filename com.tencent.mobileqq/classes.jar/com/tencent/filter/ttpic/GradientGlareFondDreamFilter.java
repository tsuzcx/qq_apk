package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class GradientGlareFondDreamFilter
  extends BaseFilter
{
  public GradientGlareFondDreamFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/glarefonddream_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(135));
    localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "sh/glarefonddream_screen0.png", 33986));
    localBaseFilter1.addParam(new UniformParam.FloatParam("transparency", 0.6F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(135));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/glarefonddream_screen1.png", 33986));
    localBaseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.7F));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(135));
    localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "sh/glarefonddream_screen2.png", 33986));
    localBaseFilter1.addParam(new UniformParam.FloatParam("transparency", 0.4F));
    localBaseFilter2.setNextFilter(localBaseFilter1, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.filter.ttpic.GradientGlareFondDreamFilter
 * JD-Core Version:    0.7.0.1
 */