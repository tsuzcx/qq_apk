package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;

public class BeautysRealAutoFilter$SmootfilterImpFilter
  extends BaseFilter
{
  private boolean needUpdate = true;
  private int previewHeight;
  private int previewWidth;
  private float radius = 0.5F;
  private boolean useforHorizontal;
  
  public BeautysRealAutoFilter$SmootfilterImpFilter(boolean paramBoolean)
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.useforHorizontal = paramBoolean;
  }
  
  private void generrateShader()
  {
    float f = Math.round(this.radius * 10.0F / 720.0F * this.previewWidth);
    int i;
    if (f >= 1.0F)
    {
      i = (int)Math.floor(Math.sqrt(-2.0D * Math.pow(f, 2.0D) * Math.log(0.0039063F * Math.sqrt(6.283185307179586D * Math.pow(f, 2.0D)))));
      i += i % 2;
    }
    for (;;)
    {
      updateFragmentShader(HFGPUShaderFactory.gaussianFragmentShaderForOptimizedBlurOfRadiusOpt1(i, f, this.useforHorizontal, this.useforHorizontal));
      clearGLSLSelf();
      apply();
      this.needUpdate = false;
      return;
      i = 0;
    }
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.previewWidth = ((int)paramFloat1);
    this.previewHeight = ((int)paramFloat2);
    generrateShader();
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.needUpdate) || (this.previewWidth != paramInt2) || (this.previewHeight != paramInt3)) {}
    for (boolean bool = true;; bool = false)
    {
      this.needUpdate = bool;
      if (this.needUpdate)
      {
        this.previewWidth = paramInt2;
        this.previewHeight = paramInt3;
        generrateShader();
      }
      return;
    }
  }
  
  public void updateRadius(float paramFloat)
  {
    this.radius = paramFloat;
    this.needUpdate = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.filter.ttpic.BeautysRealAutoFilter.SmootfilterImpFilter
 * JD-Core Version:    0.7.0.1
 */