package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class MilkCoffeeFilter
  extends BaseFilter
{
  public MilkCoffeeFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(3.0F, 40.0F, 3.0F, 329.0F, 352.0F, 10.0F, 35.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(-5.0F, 5.0F, 10.0F, 6.0F, 32.0F, 52.0F, 82.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject2).addParam(new Param.TextureResParam("inputImageTexture2", "sh/milkcoffee_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.FILTER_HARDLIGHTBLEND2_SHADER);
    ((BaseFilter)localObject1).addParam(new Param.FloatsParam("color2", new float[] { 0.7294118F, 0.5372549F, 0.5058824F, 1.0F }));
    ((BaseFilter)localObject1).addParam(new Param.FloatParam("transparency", 0.1F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, -0.02352941F }));
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, -0.02352941F }));
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("highlightsShift", new float[] { -0.007843138F, 0.0F, 0.0F }));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.MilkCoffeeFilter
 * JD-Core Version:    0.7.0.1
 */