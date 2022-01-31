package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class MilkGreenFilter
  extends BaseFilter
{
  public MilkGreenFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(0.0F, -4.0F, 4.0F, 0.0F, 28.0F, 48.0F, 72.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(-5.039946F, 24.0F, 0.0F, 329.0F, 330.0F, 8.0F, 26.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject2).addParam(new Param.TextureResParam("inputImageTexture2", "sh/milkgreen_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.FILTER_HARDLIGHTBLEND2_SHADER);
    ((BaseFilter)localObject1).addParam(new Param.FloatsParam("color2", new float[] { 0.7215686F, 0.8784314F, 0.772549F, 1.0F }));
    ((BaseFilter)localObject1).addParam(new Param.FloatParam("transparency", 0.1F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.MilkGreenFilter
 * JD-Core Version:    0.7.0.1
 */