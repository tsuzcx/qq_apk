package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class LightWhiteFilter
  extends BaseFilter
{
  public LightWhiteFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(0.0F, 10.0F, 0.0F, 329.0F, 349.0F, 13.0F, 32.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(0.0F, -10.0F, -4.0F, 2.0F, 18.0F, 49.0F, 72.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/lightwhite_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(BaseFilter.getFragmentShader(13));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("contrast", 1.05F));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("saturation", 1.0F));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.LightWhiteFilter
 * JD-Core Version:    0.7.0.1
 */