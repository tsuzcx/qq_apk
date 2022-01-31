package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class LightFilter
  extends BaseFilter
{
  public LightFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter.addParam(new Param.TextureResParam("inputImageTexture2", "sh/light_curve.png", 33986));
    setNextFilter(localBaseFilter, null);
    HSVColorChannelFilter localHSVColorChannelFilter = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localHSVColorChannelFilter).setInput(0.0F, -30.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    localBaseFilter.setNextFilter(localHSVColorChannelFilter, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter.addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, 0.03921569F }));
    localBaseFilter.addParam(new Param.FloatsParam("midtonesShift", new float[] { -0.0588235F, 0.0F, 0.0F }));
    localBaseFilter.addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localHSVColorChannelFilter.setNextFilter(localBaseFilter, null);
    localHSVColorChannelFilter = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localHSVColorChannelFilter).setInput(-8.0F, 28.0F, 0.0F, 319.0F, 346.0F, 18.0F, 31.0F);
    localBaseFilter.setNextFilter(localHSVColorChannelFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.LightFilter
 * JD-Core Version:    0.7.0.1
 */