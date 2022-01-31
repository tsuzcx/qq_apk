package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.TextureResParam;

public class LightRedFilter
  extends BaseFilter
{
  public LightRedFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(4.0F, 9.0F, -2.0F, 309.0F, 334.0F, 6.0F, 32.0F);
    setNextFilter((BaseFilter)localObject, null);
    HSVColorChannelFilter localHSVColorChannelFilter = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localHSVColorChannelFilter).setInput(0.0F, -17.0F, 4.0F, 338.0F, 16.0F, 61.0F, 93.0F);
    ((BaseFilter)localObject).setNextFilter(localHSVColorChannelFilter, null);
    localObject = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "sh/lightred_curve.png", 33986));
    localHSVColorChannelFilter.setNextFilter((BaseFilter)localObject, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.LightRedFilter
 * JD-Core Version:    0.7.0.1
 */