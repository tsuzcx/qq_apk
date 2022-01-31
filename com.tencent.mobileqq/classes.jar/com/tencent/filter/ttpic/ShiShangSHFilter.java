package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.TextureResParam;

public class ShiShangSHFilter
  extends BaseFilter
{
  int effectindex = 0;
  
  public ShiShangSHFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public ShiShangSHFilter(int paramInt)
  {
    super(GLSLRender.FILTER_SHADER_NONE);
    this.effectindex = paramInt;
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
    BaseFilter localBaseFilter1;
    BaseFilter localBaseFilter2;
    if (this.effectindex == 0)
    {
      localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
      localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/shishang_sh_curve.png", 33986));
      setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_SOFTLIGHTBLEND_SHADER);
      localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/shishang_sh_blend.jpg", 33986));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_HARDLIGHTBLEND_SHADER);
      localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/fugu_sh_blend.jpg", 33986));
      setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_ALPHA_ADJUST);
      localBaseFilter2.addParam(new Param.FloatParam("filterAdjustParam", 0.3F));
      localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { this.srcTextureIndex });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.ShiShangSHFilter
 * JD-Core Version:    0.7.0.1
 */