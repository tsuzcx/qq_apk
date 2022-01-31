package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.view.RendererUtils;

public class FaceBeautyAutoFilter$FocusBlurFilter
  extends BaseFilter
{
  private float blurSize = 0.0F;
  private float lastScaleFilt = 1.0F;
  private int paramTEXTRUEID = 0;
  
  public FaceBeautyAutoFilter$FocusBlurFilter(FaceBeautyAutoFilter paramFaceBeautyAutoFilter, int paramInt, float paramFloat)
  {
    super(BaseFilter.getFragmentShader(3));
    this.lastScaleFilt = paramFloat;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.blurSize *= 2.0F;
      return;
      this.blurSize = 0.62F;
      continue;
      this.blurSize = 0.67F;
      continue;
      this.blurSize = 1.0F;
    }
  }
  
  public void ClearGLSL()
  {
    RendererUtils.clearTexture(this.paramTEXTRUEID);
    super.ClearGLSL();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.paramTEXTRUEID = RendererUtils.createTexture();
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    QImage localQImage = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
    FaceBeautyAutoFilter.nativeFastBlur(localQImage, this.blurSize * this.lastScaleFilt);
    GLSLRender.nativeTextImage(localQImage, this.paramTEXTRUEID);
    localQImage.Dispose();
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.ttpic.FaceBeautyAutoFilter.FocusBlurFilter
 * JD-Core Version:    0.7.0.1
 */