package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.TextureResParam;

public class MenghuanFilter
  extends BaseFilter
{
  public MenghuanFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_MIC_CURE_NEW_SHADER);
    localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", "sh/menghuan_curve.png", 33986));
    setNextFilter(localBaseFilter2, null);
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_SHADER_SCREEN_BLEND_OLD);
    if (this.needFlipBlend) {}
    for (int i = 1;; i = 0)
    {
      localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "sh/menghuan_blend.png", 33986, i));
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_GPULEVELSEX_SHADER);
      localBaseFilter2.addParam(new Param.FloatsParam("levelMinimum", new float[] { 0.1607843F, 0.1607843F, 0.1607843F }));
      localBaseFilter2.addParam(new Param.FloatsParam("levelMiddle", new float[] { 1.0F, 1.0F, 1.0F }));
      localBaseFilter2.addParam(new Param.FloatsParam("levelMaximum", new float[] { 1.0F, 1.0F, 1.0F }));
      localBaseFilter2.addParam(new Param.FloatsParam("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
      localBaseFilter2.addParam(new Param.FloatsParam("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.MenghuanFilter
 * JD-Core Version:    0.7.0.1
 */