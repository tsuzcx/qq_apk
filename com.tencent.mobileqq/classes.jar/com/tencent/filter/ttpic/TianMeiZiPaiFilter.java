package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.BeautysFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class TianMeiZiPaiFilter
  extends BaseFilter
{
  public TianMeiZiPaiFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject = new BeautysFilter(GLSLRender.FILTER_SHADER_NONE, 0);
    ((BaseFilter)localObject).setEffectIndex(2);
    ((BaseFilter)localObject).setSrcFilterIndex(this.srcTextureIndex + 1);
    ((BaseFilter)localObject).ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    setNextFilter((BaseFilter)localObject, null);
    BaseFilter localBaseFilter = ((BaseFilter)localObject).getLastFilter();
    localObject = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    ((BaseFilter)localObject).addParam(new Param.TextureResParam("inputImageTexture2", "sh/tianmeizipai_curve.png", 33986));
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
    localBaseFilter.addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter.addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter.addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.03137255F, 0.0F, 0.0F }));
    ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
    localObject = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject).setInput(0.0F, 3.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.TianMeiZiPaiFilter
 * JD-Core Version:    0.7.0.1
 */