package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class RichBlueFilter
  extends BaseFilter
{
  public RichBlueFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, -19.0F, 8.0F, 354.0F, 20.0F, 52.0F, 77.0F);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter.addParam(new Param.TextureResParam("inputImageTexture2", "sh/richblue_curve.png", 33986));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    ((BaseFilter)localObject).addParam(new Param.FloatsParam("shadowsShift", new float[] { -0.172549F, -0.03921569F, 0.1647059F }));
    ((BaseFilter)localObject).addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.02352941F, -0.007843138F, 0.07843138F }));
    ((BaseFilter)localObject).addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.03137255F, 0.0F, 0.0F }));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_VIBRANCE);
    localBaseFilter.addParam(new Param.FloatParam("contrast", 0.97F));
    localBaseFilter.addParam(new Param.FloatParam("saturation", 1.0F));
    localBaseFilter.addParam(new Param.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.RichBlueFilter
 * JD-Core Version:    0.7.0.1
 */