package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class GradientAndyWarholCowFilter
  extends BaseFilter
{
  public GradientAndyWarholCowFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, -10.0F, 25.0F, 339.0F, 9.0F, 39.0F, 69.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/andy_gradient_curve.png", 33986));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", "sh/andy_curve.png", 33986));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(64));
    localBaseFilter.addParam(new UniformParam.FloatParam("exposure", 0.305F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.ttpic.GradientAndyWarholCowFilter
 * JD-Core Version:    0.7.0.1
 */