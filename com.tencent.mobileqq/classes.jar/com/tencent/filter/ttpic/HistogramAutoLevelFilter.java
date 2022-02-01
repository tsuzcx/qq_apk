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
    this.minRatio = (0.0F + paramFloat * 0.05F);
    this.maxRatio = (1.0F - 0.05F * paramFloat);
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
    int j = 0;
    int i;
    label111:
    int k;
    if (j < 3)
    {
      int n = j * 256;
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt2 < 256)
      {
        paramInt1 += arrayOfInt1[(n + paramInt2)];
        paramInt2 += 1;
      }
      float f1 = this.minRatio;
      float f2 = this.maxRatio;
      int i2 = (int)(f1 * paramInt1);
      int i1 = (int)(paramInt1 * f2);
      i = 0;
      int m = 0;
      paramInt1 = 0;
      paramInt2 = paramInt1;
      k = m;
      paramInt3 = i;
      if (paramInt1 < 256)
      {
        paramInt3 = i + arrayOfInt1[(n + paramInt1)];
        if (paramInt3 >= i2)
        {
          paramInt2 = paramInt1 + 1;
          k = paramInt1;
        }
      }
      else
      {
        label151:
        if (paramInt2 >= 256) {
          break label346;
        }
        paramInt3 += arrayOfInt1[(n + paramInt2)];
        if (paramInt3 < i1) {
          break label206;
        }
      }
    }
    for (;;)
    {
      localObject[j] = k;
      arrayOfInt2[j] = paramInt2;
      j += 1;
      break;
      paramInt1 += 1;
      i = paramInt3;
      break label111;
      label206:
      paramInt2 += 1;
      break label151;
      addParam(new UniformParam.FloatParam("l_threshold_r", localObject[0] / 255.0F));
      addParam(new UniformParam.FloatParam("h_threshold_r", arrayOfInt2[0] / 255.0F));
      addParam(new UniformParam.FloatParam("l_threshold_g", localObject[1] / 255.0F));
      addParam(new UniformParam.FloatParam("h_threshold_g", arrayOfInt2[1] / 255.0F));
      addParam(new UniformParam.FloatParam("l_threshold_b", localObject[2] / 255.0F));
      addParam(new UniformParam.FloatParam("h_threshold_b", arrayOfInt2[2] / 255.0F));
      return;
      label346:
      paramInt2 = 0;
    }
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.ttpic.HistogramAutoLevelFilter
 * JD-Core Version:    0.7.0.1
 */