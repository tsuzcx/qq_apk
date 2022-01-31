package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.QImage;
import com.tencent.view.RendererUtils;

public class HistogramAutoLevelFilter
  extends BaseFilter
{
  float max_ratio = 0.999F;
  float min_ratio = 0.001F;
  
  public HistogramAutoLevelFilter()
  {
    super(GLSLRender.FILTER_SHADER_AUTOLEVEL_HIS);
  }
  
  public HistogramAutoLevelFilter(float paramFloat)
  {
    super(GLSLRender.FILTER_SHADER_AUTOLEVEL_HIS);
    this.min_ratio = (0.0F + paramFloat * 0.05F);
    this.max_ratio = (1.0F - paramFloat * 0.05F);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new Param.FloatParam("l_threshold_r", 0.1F));
    addParam(new Param.FloatParam("h_threshold_r", 0.1F));
    addParam(new Param.FloatParam("l_threshold_g", 0.1F));
    addParam(new Param.FloatParam("h_threshold_g", 0.1F));
    addParam(new Param.FloatParam("l_threshold_b", 0.1F));
    addParam(new Param.FloatParam("h_threshold_b", 0.1F));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
    int[] arrayOfInt1 = ((QImage)localObject).nativeGetArrayHistogramChannels();
    ((QImage)localObject).Dispose();
    localObject = new int[3];
    int[] arrayOfInt2 = new int[3];
    int j = 0;
    if (j < 3)
    {
      int i1 = j * 256;
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt2 < 256)
      {
        paramInt1 += arrayOfInt1[(i1 + paramInt2)];
        paramInt2 += 1;
      }
      float f1 = this.min_ratio;
      float f2 = this.max_ratio;
      int i3 = (int)(paramInt1 * f1);
      int i2 = (int)(paramInt1 * f2);
      int i = 0;
      int n = 0;
      int m = 0;
      paramInt1 = 0;
      label114:
      paramInt2 = paramInt1;
      int k = n;
      paramInt3 = i;
      if (paramInt1 < 256)
      {
        paramInt3 = i + arrayOfInt1[(i1 + paramInt1)];
        if (paramInt3 < i3) {
          break label204;
        }
        k = paramInt1;
        paramInt2 = paramInt1 + 1;
      }
      for (;;)
      {
        paramInt1 = m;
        if (paramInt2 < 256)
        {
          paramInt3 += arrayOfInt1[(i1 + paramInt2)];
          if (paramInt3 >= i2) {
            paramInt1 = paramInt2;
          }
        }
        else
        {
          localObject[j] = k;
          arrayOfInt2[j] = paramInt1;
          j += 1;
          break;
          label204:
          paramInt1 += 1;
          i = paramInt3;
          break label114;
        }
        paramInt2 += 1;
      }
    }
    addParam(new Param.FloatParam("l_threshold_r", localObject[0] / 255.0F));
    addParam(new Param.FloatParam("h_threshold_r", arrayOfInt2[0] / 255.0F));
    addParam(new Param.FloatParam("l_threshold_g", localObject[1] / 255.0F));
    addParam(new Param.FloatParam("h_threshold_g", arrayOfInt2[1] / 255.0F));
    addParam(new Param.FloatParam("l_threshold_b", localObject[2] / 255.0F));
    addParam(new Param.FloatParam("h_threshold_b", arrayOfInt2[2] / 255.0F));
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