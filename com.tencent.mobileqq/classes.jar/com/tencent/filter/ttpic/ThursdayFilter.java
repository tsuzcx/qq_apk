package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class ThursdayFilter
  extends BaseFilter
{
  public ThursdayFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(0.0F, 27.0F, 0.0F, 316.0F, 340.0F, 0.0F, 24.0F);
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(-5.0F, 20.0F, 5.0F, 358.0F, 28.0F, 46.0F, 74.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(20.0F, 0.0F, 0.0F, 68.0F, 90.0F, 124.0F, 140.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    ((BaseFilter)localObject1).addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0588235F, 0.03921569F, 0.0F }));
    ((BaseFilter)localObject1).addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.03921569F, 0.0F }));
    ((BaseFilter)localObject1).addParam(new Param.FloatsParam("highlightsShift", new float[] { -0.01960784F, 0.03921569F, 0.01960784F }));
    ((BaseFilter)localObject1).addParam(new Param.IntParam("preserveLuminosity", 1));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject2).addParam(new Param.TextureResParam("inputImageTexture2", "sh/thursday_curve.png", 33986));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.ThursdayFilter
 * JD-Core Version:    0.7.0.1
 */