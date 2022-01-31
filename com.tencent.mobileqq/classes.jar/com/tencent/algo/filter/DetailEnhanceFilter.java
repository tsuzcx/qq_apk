package com.tencent.algo.filter;

import com.microrapid.opencv.OpencvAlgorithm;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.view.RendererUtils;

public class DetailEnhanceFilter
  extends BaseFilter
{
  int paramTEXTRUEID = 0;
  float strength = 5.0F;
  
  public DetailEnhanceFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.paramTEXTRUEID = RendererUtils.createTexture();
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void ClearGLSL()
  {
    RendererUtils.clearTexture(this.paramTEXTRUEID);
    super.ClearGLSL();
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    QImage localQImage = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
    OpencvAlgorithm.nativeDetailEnhanceFilter(localQImage, this.strength);
    GLSLRender.nativeTextImage(localQImage, this.paramTEXTRUEID);
    localQImage.Dispose();
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.algo.filter.DetailEnhanceFilter
 * JD-Core Version:    0.7.0.1
 */