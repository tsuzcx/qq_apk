package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class GradientGlareFashionFilter
  extends BaseFilter
{
  public GradientGlareFashionFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, -50.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
    localBaseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/glarefashion_curve.png", 33986));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(BaseFilter.getFragmentShader(135));
    ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", "sh/glarefashion_screen.png", 33986));
    ((BaseFilter)localObject).addParam(new UniformParam.FloatParam("transparency", 0.3F));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.ttpic.GradientGlareFashionFilter
 * JD-Core Version:    0.7.0.1
 */