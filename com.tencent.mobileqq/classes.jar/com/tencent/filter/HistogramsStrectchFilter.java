package com.tencent.filter;

import com.tencent.view.RendererUtils;

public class HistogramsStrectchFilter
  extends BaseFilter
{
  float max_ratio = 0.999F;
  float min_ratio = 0.001F;
  
  public HistogramsStrectchFilter()
  {
    super(GLSLRender.FILTER_HISTOGRAMS_STRCTCH);
  }
  
  public HistogramsStrectchFilter(float paramFloat1, float paramFloat2)
  {
    super(GLSLRender.FILTER_HISTOGRAMS_STRCTCH);
    this.min_ratio = paramFloat1;
    this.max_ratio = paramFloat2;
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new Param.FloatParam("l_threshold", 0.1F));
    addParam(new Param.FloatParam("h_threshold", 0.1F));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    QImage localQImage = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
    int[] arrayOfInt = localQImage.nativeGetArrayHistogram();
    localQImage.Dispose();
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt2 < 256)
    {
      paramInt1 += arrayOfInt[paramInt2];
      paramInt2 += 1;
    }
    float f1 = this.min_ratio;
    float f2 = this.max_ratio;
    int i1 = (int)(paramInt1 * f1);
    int n = (int)(paramInt1 * f2);
    int i = 0;
    int m = 0;
    int k = 0;
    paramInt1 = 0;
    paramInt2 = paramInt1;
    int j = m;
    paramInt3 = i;
    if (paramInt1 < 256)
    {
      paramInt3 = i + arrayOfInt[paramInt1];
      if (paramInt3 < i1) {
        break label190;
      }
      j = paramInt1;
      paramInt2 = paramInt1 + 1;
    }
    for (;;)
    {
      paramInt1 = k;
      if (paramInt2 < 256)
      {
        paramInt3 += arrayOfInt[paramInt2];
        if (paramInt3 >= n) {
          paramInt1 = paramInt2;
        }
      }
      else
      {
        addParam(new Param.FloatParam("l_threshold", (float)(j / 255.0D)));
        addParam(new Param.FloatParam("h_threshold", (float)(paramInt1 / 255.0D)));
        return;
        label190:
        paramInt1 += 1;
        i = paramInt3;
        break;
      }
      paramInt2 += 1;
    }
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.HistogramsStrectchFilter
 * JD-Core Version:    0.7.0.1
 */