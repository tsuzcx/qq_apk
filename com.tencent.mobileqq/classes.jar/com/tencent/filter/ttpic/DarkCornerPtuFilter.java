package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureResParam;

public class DarkCornerPtuFilter
  extends BaseFilter
{
  private int maskType = 0;
  private BaseFilter nextFilter = null;
  
  public DarkCornerPtuFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.nextFilter = new BaseFilter(GLSLRender.FILTER_GPULEVELS_SHADER);
    this.nextFilter.addParam(new Param.TextureResParam("inputImageTexture2", "sh/darkcornermask_s.png", 33986));
    this.nextFilter.addParam(new Param.TextureResParam("inputImageTexture3", "sh/darkcornermask_l.png", 33987));
    this.nextFilter.addParam(new Param.FloatsParam("levelMinimum", new float[] { 0.0F, 0.0F, 0.0F }));
    this.nextFilter.addParam(new Param.FloatsParam("levelMiddle", new float[] { 0.3F, 0.3F, 0.3F }));
    this.nextFilter.addParam(new Param.FloatsParam("levelMaximum", new float[] { 1.0F, 1.0F, 1.0F }));
    this.nextFilter.addParam(new Param.FloatsParam("minOutput", new float[] { 0.0F, 0.0F, 0.0F }));
    this.nextFilter.addParam(new Param.FloatsParam("maxOutput", new float[] { 1.0F, 1.0F, 1.0F }));
    this.nextFilter.addParam(new Param.IntParam("maskType", this.maskType));
    setNextFilter(this.nextFilter, (int[])null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setMaskType(int paramInt)
  {
    this.maskType = paramInt;
    if (this.nextFilter != null) {
      this.nextFilter.addParam(new Param.IntParam("maskType", this.maskType));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.DarkCornerPtuFilter
 * JD-Core Version:    0.7.0.1
 */