package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class NextDoorFilter
  extends BaseFilter
{
  public NextDoorFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new BaseFilter(GLSLRender.FILTER_SHADER_MIC_CURE_MASK);
    ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "sh/nextdoor_center_curve.png", 33986));
    ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture3", "sh/nextdoor_center_curve_mask.png", 33987));
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_MIC_CURE_MASK);
    localBaseFilter.addParam(new Param.TextureResParam("inputImageTexture2", "sh/nextdoor_edge_curve.png", 33986));
    localBaseFilter.addParam(new Param.TextureResParam("inputImageTexture3", "sh/nextdoor_edge_curve_mask.png", 33987));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    ((BaseFilter)localObject).addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0F, -0.05490196F, 0.1019608F }));
    ((BaseFilter)localObject).addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, -0.08627451F, 0.0F }));
    ((BaseFilter)localObject).addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    ((BaseFilter)localObject).addParam(new Param.IntParam("preserveLuminosity", 1));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_MULTIPLY_BLEND);
    localBaseFilter.addParam(new Param.FloatsParam("color2", new float[] { 0.9921569F, 0.8470588F, 0.6392157F, 1.0F }));
    localBaseFilter.addParam(new Param.FloatParam("transparency", 0.3F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(1.0F, 20.0F, 0.0F, 335.0F, 352.0F, 16.0F, 28.0F);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_VIBRANCE);
    localBaseFilter.addParam(new Param.FloatParam("contrast", 1.1F));
    localBaseFilter.addParam(new Param.FloatParam("saturation", 1.0F));
    localBaseFilter.addParam(new Param.FloatParam("brightness", 1.0F));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.NextDoorFilter
 * JD-Core Version:    0.7.0.1
 */