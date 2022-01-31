package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.TextureResParam;

public class GradientGlareFashionFilter
  extends BaseFilter
{
  public GradientGlareFashionFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, -50.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter.addParam(new Param.TextureResParam("inputImageTexture2", "sh/glarefashion_curve.png", 33986));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.FILTER_SHADER_MULTIPLY_BLEND_4);
    ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "sh/glarefashion_screen.png", 33986));
    ((BaseFilter)localObject).addParam(new Param.FloatParam("transparency", 0.3F));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.GradientGlareFashionFilter
 * JD-Core Version:    0.7.0.1
 */