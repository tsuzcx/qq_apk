package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.view.RendererUtils;

public class HistogramsStrectchFilter
  extends BaseFilter
{
  private float maxRatio = 0.999F;
  private float minRatio = 0.001F;
  
  public HistogramsStrectchFilter()
  {
    super(BaseFilter.getFragmentShader(32));
  }
  
  public HistogramsStrectchFilter(float paramFloat1, float paramFloat2)
  {
    super(BaseFilter.getFragmentShader(32));
    this.minRatio = paramFloat1;
    this.maxRatio = paramFloat2;
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("l_threshold", 0.1F));
    addParam(new UniformParam.FloatParam("h_threshold", 0.1F));
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    QImage localQImage = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
    int[] arrayOfInt = localQImage.nativeGetArrayHistogram();
    localQImage.Dispose();
    int j = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < 256)
    {
      paramInt2 += arrayOfInt[paramInt1];
      paramInt1 += 1;
    }
    float f1 = this.minRatio;
    float f2 = this.maxRatio;
    float f3 = paramInt2;
    paramInt3 = (int)(f1 * f3);
    int k = (int)(f3 * f2);
    paramInt1 = 0;
    paramInt2 = 0;
    int i;
    while (paramInt1 < 256)
    {
      paramInt2 += arrayOfInt[paramInt1];
      if (paramInt2 >= paramInt3)
      {
        i = paramInt1 + 1;
        paramInt3 = paramInt1;
        paramInt1 = i;
        break label124;
      }
      paramInt1 += 1;
    }
    paramInt3 = 0;
    for (;;)
    {
      label124:
      i = j;
      if (paramInt1 >= 256) {
        break;
      }
      paramInt2 += arrayOfInt[paramInt1];
      if (paramInt2 >= k)
      {
        i = paramInt1;
        break;
      }
      paramInt1 += 1;
    }
    double d = paramInt3;
    Double.isNaN(d);
    addParam(new UniformParam.FloatParam("l_threshold", (float)(d / 255.0D)));
    d = i;
    Double.isNaN(d);
    addParam(new UniformParam.FloatParam("h_threshold", (float)(d / 255.0D)));
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