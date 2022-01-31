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
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt2 < 256)
    {
      paramInt1 += arrayOfInt[paramInt2];
      paramInt2 += 1;
    }
    float f1 = this.minRatio;
    float f2 = this.maxRatio;
    paramInt3 = (int)(f1 * paramInt1);
    int j = (int)(paramInt1 * f2);
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramInt1 < 256)
    {
      paramInt2 += arrayOfInt[paramInt1];
      if (paramInt2 >= paramInt3)
      {
        int i = paramInt1 + 1;
        paramInt3 = paramInt1;
        paramInt1 = i;
      }
    }
    for (;;)
    {
      label105:
      if (paramInt1 < 256)
      {
        paramInt2 += arrayOfInt[paramInt1];
        if (paramInt2 < j) {}
      }
      for (;;)
      {
        addParam(new UniformParam.FloatParam("l_threshold", (float)(paramInt3 / 255.0D)));
        addParam(new UniformParam.FloatParam("h_threshold", (float)(paramInt1 / 255.0D)));
        return;
        paramInt1 += 1;
        break;
        paramInt1 += 1;
        break label105;
        paramInt1 = 0;
      }
      paramInt3 = 0;
    }
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.filter.HistogramsStrectchFilter
 * JD-Core Version:    0.7.0.1
 */