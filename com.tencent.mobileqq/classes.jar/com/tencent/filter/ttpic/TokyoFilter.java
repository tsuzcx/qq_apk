package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.TextureResParam;

public class TokyoFilter
  extends BaseFilter
{
  public TokyoFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "sh/tokyo_curve.png", 33986));
    setNextFilter((BaseFilter)localObject, null);
    HSVColorChannelFilter localHSVColorChannelFilter = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localHSVColorChannelFilter).setInput(0.0F, 11.0F, 0.0F, 307.0F, 337.0F, 7.0F, 37.0F);
    ((BaseFilter)localObject).setNextFilter(localHSVColorChannelFilter, null);
    localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, 26.0F, 32.0F, 6.0F, 37.0F, 67.0F, 96.0F);
    localHSVColorChannelFilter.setNextFilter((BaseFilter)localObject, null);
    localHSVColorChannelFilter = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localHSVColorChannelFilter).setInput(0.0F, 0.0F, 23.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    ((BaseFilter)localObject).setNextFilter(localHSVColorChannelFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.TokyoFilter
 * JD-Core Version:    0.7.0.1
 */