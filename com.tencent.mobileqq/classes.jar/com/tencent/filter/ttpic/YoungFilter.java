package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class YoungFilter
  extends BaseFilter
{
  public YoungFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject2).addParam(new Param.TextureResParam("inputImageTexture2", "sh/young_curve.png", 33986));
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    ((BaseFilter)localObject1).addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.07058824F, 0.0F, 0.0F }));
    ((BaseFilter)localObject1).addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.1176471F, -0.02352941F, 0.05098039F }));
    ((BaseFilter)localObject1).addParam(new Param.FloatsParam("highlightsShift", new float[] { -0.003921569F, 0.0F, 0.01960784F }));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(0.0F, 10.0F, 22.0F, 335.0F, 5.0F, 35.0F, 65.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(-6.0F, 2.0F, 10.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.FILTER_VIBRANCE);
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("contrast", 1.05F));
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("saturation", 1.0F));
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.YoungFilter
 * JD-Core Version:    0.7.0.1
 */