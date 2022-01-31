package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.TextureResParam;

public class BaiChaFilter
  extends BaseFilter
{
  private BaseFilter nextFilter;
  
  public BaiChaFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.nextFilter = new GPUImageLookupFilter();
    this.nextFilter.addParam(new Param.TextureResParam("inputImageTexture2", "sh/baicha_lf.png", 33986));
    setNextFilter(this.nextFilter, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.BaiChaFilter
 * JD-Core Version:    0.7.0.1
 */