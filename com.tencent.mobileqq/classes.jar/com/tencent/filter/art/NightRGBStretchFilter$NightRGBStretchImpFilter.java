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
    int j = 0;
    Object localObject = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
    int[] arrayOfInt = ((QImage)localObject).nativeGetArrayHistogram();
    ((QImage)localObject).Dispose();
    paramInt3 = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt3 < 256)
    {
      paramInt1 += arrayOfInt[paramInt3];
      paramInt2 += arrayOfInt[paramInt3] * paramInt3;
      paramInt3 += 1;
    }
    int k = paramInt2 / paramInt1;
    int i = (int)(paramInt1 * 0.001F);
    int m = (int)(paramInt1 * 0.99F);
    paramInt1 = 0;
    paramInt2 = 0;
    if (paramInt2 < 256)
    {
      paramInt3 = paramInt1 + arrayOfInt[paramInt2];
      if (paramInt3 <= i) {}
    }
    for (paramInt1 = paramInt2;; paramInt1 = i)
    {
      paramInt2 += 1;
      label110:
      if (paramInt2 < 256)
      {
        paramInt3 += arrayOfInt[paramInt2];
        if (paramInt3 <= m) {}
      }
      for (;;)
      {
        float f1 = (k - paramInt1) / (paramInt2 - paramInt1);
        float f2 = (float)(Math.log(0.5D) / Math.log(f1));
        if (f2 < 0.1D) {}
        for (f1 = 0.1F;; f1 = f2)
        {
          if (f2 > 10.0D) {
            f1 = 10.0F;
          }
          localObject = new float[256];
          paramInt3 = 0;
          for (;;)
          {
            if (paramInt3 < paramInt1)
            {
              localObject[paramInt3] = 0.0F;
              paramInt3 += 1;
              continue;
              paramInt2 += 1;
              paramInt1 = paramInt3;
              break;
              paramInt2 += 1;
              break label110;
            }
          }
          paramInt3 = paramInt1;
          for (;;)
          {
            i = paramInt2;
            if (paramInt3 >= paramInt2) {
              break;
            }
            localObject[paramInt3] = ((float)Math.pow((paramInt3 - paramInt1) / (paramInt2 - paramInt1), f1));
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
          return;
        }
        paramInt2 = 255;
      }
      i = 0;
      paramInt3 = paramInt1;
    }
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    setTextureParam(this.paramTEXTRUEID, 1);
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.art.NightRGBStretchFilter.NightRGBStretchImpFilter
 * JD-Core Version:    0.7.0.1
 */