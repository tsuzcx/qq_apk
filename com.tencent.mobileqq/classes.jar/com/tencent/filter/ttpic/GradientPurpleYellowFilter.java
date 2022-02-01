package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class GradientPurpleYellowFilter
  extends BaseFilter
{
  public GradientPurpleYellowFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/purpleyellow_nuan_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(136));
    if (this.needFlipBlend) {}
    for (int i = 1;; i = 0)
    {
      localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "sh/gradient_purpleyellow_rgb.png", 33986, i));
      localBaseFilter1.addParam(new UniformParam.FloatParam("ralpha", 0.6F));
      localBaseFilter1.addParam(new UniformParam.FloatParam("galpha", 0.6F));
      localBaseFilter1.addParam(new UniformParam.FloatParam("balpha", 0.6F));
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(54));
      localBaseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/purpleyellow_anticmos_curve.png", 33986));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.ttpic.GradientPurpleYellowFilter
 * JD-Core Version:    0.7.0.1
 */