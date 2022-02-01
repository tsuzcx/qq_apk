package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.QImage;
import com.tencent.view.RendererUtils;

public class HistogramAutoLevelFilter
  extends BaseFilter
{
  private float maxRatio = 0.999F;
  private float minRatio = 0.001F;
  
  public HistogramAutoLevelFilter()
  {
    super(BaseFilter.getFragmentShader(65));
  }
  
  public HistogramAutoLevelFilter(float paramFloat)
  {
    super(BaseFilter.getFragmentShader(65));
    paramFloat *= 0.05F;
    this.minRatio = (0.0F + paramFloat);
    this.maxRatio = (1.0F - paramFloat);
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("l_threshold_r", 0.1F));
    addParam(new UniformParam.FloatParam("h_threshold_r", 0.1F));
    addParam(new UniformParam.FloatParam("l_threshold_g", 0.1F));
    addParam(new UniformParam.FloatParam("h_threshold_g", 0.1F));
    addParam(new UniformParam.FloatParam("l_threshold_b", 0.1F));
    addParam(new UniformParam.FloatParam("h_threshold_b", 0.1F));
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
    int[] arrayOfInt1 = ((QImage)localObject).nativeGetArrayHistogramChannels();
    ((QImage)localObject).Dispose();
    localObject = new int[3];
    int[] arrayOfInt2 = new int[3];
    paramInt3 = 0;
    while (paramInt3 < 3)
    {
      int k = paramInt3 * 256;
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt1 < 256)
      {
        paramInt2 += arrayOfInt1[(k + paramInt1)];
        paramInt1 += 1;
      }
      float f1 = this.minRatio;
      float f2 = this.maxRatio;
      float f3 = paramInt2;
      int i = (int)(f1 * f3);
      int m = (int)(f3 * f2);
      paramInt1 = 0;
      for (paramInt2 = 0; paramInt1 < 256; paramInt2 = j)
      {
        j = paramInt2 + arrayOfInt1[(k + paramInt1)];
        if (j >= i)
        {
          paramInt2 = paramInt1 + 1;
          i = paramInt1;
          paramInt1 = j;
          break label167;
        }
        paramInt1 += 1;
      }
      int j = paramInt1;
      i = 0;
      paramInt1 = paramInt2;
      paramInt2 = j;
      label167:
      while (paramInt2 < 256)
      {
        paramInt1 += arrayOfInt1[(k + paramInt2)];
        if (paramInt1 >= m) {
          break label202;
        }
        paramInt2 += 1;
      }
      paramInt2 = 0;
      label202:
      localObject[paramInt3] = i;
      arrayOfInt2[paramInt3] = paramInt2;
      paramInt3 += 1;
    }
    addParam(new UniformParam.FloatParam("l_threshold_r", localObject[0] / 255.0F));
    addParam(new UniformParam.FloatParam("h_threshold_r", arrayOfInt2[0] / 255.0F));
    addParam(new UniformParam.FloatParam("l_threshold_g", localObject[1] / 255.0F));
    addParam(new UniformParam.FloatParam("h_threshold_g", arrayOfInt2[1] / 255.0F));
    addParam(new UniformParam.FloatParam("l_threshold_b", localObject[2] / 255.0F));
    addParam(new UniformParam.FloatParam("h_threshold_b", arrayOfInt2[2] / 255.0F));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.HistogramAutoLevelFilter
 * JD-Core Version:    0.7.0.1
 */