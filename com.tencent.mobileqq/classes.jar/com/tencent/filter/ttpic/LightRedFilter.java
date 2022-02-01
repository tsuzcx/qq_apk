package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class LightRedFilter
  extends BaseFilter
{
  public LightRedFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(4.0F, 9.0F, -2.0F, 309.0F, 334.0F, 6.0F, 32.0F);
    setNextFilter((BaseFilter)localObject, null);
    HSVColorChannelFilter localHSVColorChannelFilter = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localHSVColorChannelFilter).setInput(0.0F, -17.0F, 4.0F, 338.0F, 16.0F, 61.0F, 93.0F);
    ((BaseFilter)localObject).setNextFilter(localHSVColorChannelFilter, null);
    localObject = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", "sh/lightred_curve.png", 33986));
    localHSVColorChannelFilter.setNextFilter((BaseFilter)localObject, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.ttpic.LightRedFilter
 * JD-Core Version:    0.7.0.1
 */