package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class FairyTaleFilter
  extends BaseFilter
{
  public FairyTaleFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("shadowsShift", new float[] { -0.02745098F, 0.0F, 0.01176471F }));
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("midtonesShift", new float[] { -0.03921569F, 0.0588235F, 0.09803922F }));
    ((BaseFilter)localObject2).addParam(new Param.FloatsParam("highlightsShift", new float[] { -0.1176471F, 0.03921569F, 0.0F }));
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new BaseFilter(GLSLRender.FILTER_VIBRANCE);
    ((BaseFilter)localObject1).addParam(new Param.FloatParam("contrast", 1.05F));
    ((BaseFilter)localObject1).addParam(new Param.FloatParam("saturation", 1.0F));
    ((BaseFilter)localObject1).addParam(new Param.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.FILTER_HSVADJUSTER_SHADER);
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("inputH", 1.0F));
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("inputS", 1.01F));
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("inputV", 1.02F));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject1).addParam(new Param.TextureResParam("inputImageTexture2", "sh/fairytale_curve.png", 33986));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(-10.0F, 45.0F, 5.0F, 310.0F, 330.0F, 356.0F, 30.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(-15.0F, -10.0F, 10.0F, 354.0F, 26.0F, 74.0F, 101.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.FairyTaleFilter
 * JD-Core Version:    0.7.0.1
 */