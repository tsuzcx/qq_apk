package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class TeaMilkFilter
  extends BaseFilter
{
  public TeaMilkFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, -20.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_SCREEN_BLEND);
    localBaseFilter.addParam(new Param.FloatsParam("color2", new float[] { 0.09019608F, 0.0666667F, 0.0666667F, 1.0F }));
    localBaseFilter.addParam(new Param.FloatParam("transparency", 0.5F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "sh/teamilk_curve2.png", 33986));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_MULTIPLY_BLEND);
    localBaseFilter.addParam(new Param.FloatsParam("color2", new float[] { 0.9411765F, 0.9176471F, 0.854902F, 1.0F }));
    localBaseFilter.addParam(new Param.FloatParam("transparency", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.TeaMilkFilter
 * JD-Core Version:    0.7.0.1
 */