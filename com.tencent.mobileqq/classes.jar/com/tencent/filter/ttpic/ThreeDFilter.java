package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class ThreeDFilter
  extends BaseFilter
{
  public ThreeDFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_GPULEVELS1_SHADER);
    localBaseFilter2.addParam(new Param.FloatsParam("levelMinimum", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("levelMiddle", new float[] { 0.04F, 1.0F, 1.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("levelMaximum", new float[] { 1.0F, 1.0F, 1.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_INPUT2_SHADER);
    localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex + 1 });
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_GPULEVELS1_SHADER);
    localBaseFilter2.addParam(new Param.FloatsParam("levelMinimum", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("levelMiddle", new float[] { 1.0F, 0.02F, 1.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("levelMaximum", new float[] { 1.0F, 1.0F, 1.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
    localBaseFilter2.addParam(new Param.FloatsParam("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_MULTIPLY_BLEND_3);
    localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex + 2 });
    localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/3d_curve.png", 33986));
    localBaseFilter1.setNextFilter(localBaseFilter2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.ThreeDFilter
 * JD-Core Version:    0.7.0.1
 */