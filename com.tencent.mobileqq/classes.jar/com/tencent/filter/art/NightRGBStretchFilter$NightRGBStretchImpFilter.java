package com.tencent.filter.art;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.view.RendererUtils;

public class NightRGBStretchFilter$NightRGBStretchImpFilter
  extends BaseFilter
{
  private int paramTEXTRUEID = 0;
  
  public NightRGBStretchFilter$NightRGBStretchImpFilter()
  {
    super(BaseFilter.getFragmentShader(88));
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.paramTEXTRUEID = RendererUtils.createTexture();
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
    int[] arrayOfInt = ((QImage)localObject).nativeGetArrayHistogram();
    ((QImage)localObject).Dispose();
    int j = 0;
    paramInt1 = 0;
    paramInt3 = 0;
    paramInt2 = 0;
    while (paramInt1 < 256)
    {
      paramInt2 += arrayOfInt[paramInt1];
      paramInt3 += arrayOfInt[paramInt1] * paramInt1;
      paramInt1 += 1;
    }
    int m = paramInt3 / paramInt2;
    float f1 = paramInt2;
    paramInt2 = (int)(0.001F * f1);
    int n = (int)(f1 * 0.99F);
    paramInt1 = 0;
    paramInt3 = 0;
    while (paramInt1 < 256)
    {
      paramInt3 += arrayOfInt[paramInt1];
      if (paramInt3 > paramInt2)
      {
        paramInt2 = paramInt1;
        break label120;
      }
      paramInt1 += 1;
    }
    paramInt2 = 0;
    label120:
    int i;
    int k;
    do
    {
      i = paramInt1 + 1;
      if (i >= 256) {
        break;
      }
      k = paramInt3 + arrayOfInt[i];
      paramInt1 = i;
      paramInt3 = k;
    } while (k <= n);
    paramInt1 = i;
    break label165;
    paramInt1 = 255;
    label165:
    f1 = m - paramInt2;
    float f2 = paramInt1 - paramInt2;
    f1 /= f2;
    f1 = (float)(Math.log(0.5D) / Math.log(f1));
    double d = f1;
    if (d < 0.1D) {
      f1 = 0.1F;
    }
    if (d > 10.0D) {
      f1 = 10.0F;
    }
    localObject = new float[256];
    paramInt3 = 0;
    while (paramInt3 < paramInt2)
    {
      localObject[paramInt3] = 0.0F;
      paramInt3 += 1;
    }
    paramInt3 = paramInt2;
    for (;;)
    {
      i = paramInt1;
      if (paramInt3 >= paramInt1) {
        break;
      }
      localObject[paramInt3] = ((float)Math.pow((paramInt3 - paramInt2) / f2, f1));
      paramInt3 += 1;
    }
    while (i < 256)
    {
      localObject[i] = 1.0F;
      i += 1;
    }
    arrayOfInt = new int[256];
    paramInt1 = j;
    while (paramInt1 < 256)
    {
      arrayOfInt[paramInt1] = ((int)(localObject[paramInt1] * 255.0F));
      paramInt1 += 1;
    }
    GLES20.glActiveTexture(33984);
    GLSLRender.nativeTextCure(arrayOfInt, this.paramTEXTRUEID);
  }
  
  public void clearGLSL()
  {
    RendererUtils.clearTexture(this.paramTEXTRUEID);
    super.clearGLSL();
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    setTextureParam(this.paramTEXTRUEID, 1);
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.art.NightRGBStretchFilter.NightRGBStretchImpFilter
 * JD-Core Version:    0.7.0.1
 */