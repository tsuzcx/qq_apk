package com.tencent.filter.art;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.QImage;
import com.tencent.view.RendererUtils;

public class NightRGBStretchFilter
  extends BaseFilter
{
  private BaseFilter adjustFilter = null;
  float strenth = 0.5F;
  
  public NightRGBStretchFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    localBaseFilter.scaleFact = Math.min(100.0F / Math.min(paramFloat2, paramFloat1), 1.0F);
    setNextFilter(localBaseFilter, null);
    this.adjustFilter = new NightRGBStretchImpFilter();
    this.adjustFilter.addParam(new Param.FloatParam("param", this.strenth));
    if (this.strenth >= 0.5F) {
      this.adjustFilter.addParam(new Param.FloatParam("scale", 2.0F));
    }
    for (;;)
    {
      localBaseFilter.setNextFilter(this.adjustFilter, new int[] { this.srcTextureIndex + 1 });
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.adjustFilter.addParam(new Param.FloatParam("scale", 1.0F));
    }
  }
  
  public void ClearGLSL()
  {
    this.adjustFilter = null;
    super.ClearGLSL();
  }
  
  public boolean isAdjustFilter()
  {
    return true;
  }
  
  public void setAdjustParam(float paramFloat)
  {
    this.strenth = paramFloat;
    if (this.adjustFilter != null) {
      this.adjustFilter.addParam(new Param.FloatParam("param", this.strenth));
    }
  }
  
  public static class NightRGBStretchImpFilter
    extends BaseFilter
  {
    int paramTEXTRUEID = 0;
    
    public NightRGBStretchImpFilter()
    {
      super();
    }
    
    public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      this.paramTEXTRUEID = RendererUtils.createTexture();
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
    
    public void ClearGLSL()
    {
      RendererUtils.clearTexture(this.paramTEXTRUEID);
      super.ClearGLSL();
    }
    
    public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
      int[] arrayOfInt = ((QImage)localObject).nativeGetArrayHistogram();
      ((QImage)localObject).Dispose();
      paramInt2 = 0;
      paramInt1 = 0;
      int k = 0;
      int j = 255;
      paramInt3 = 0;
      while (paramInt3 < 256)
      {
        paramInt1 += arrayOfInt[paramInt3];
        paramInt2 += arrayOfInt[paramInt3] * paramInt3;
        paramInt3 += 1;
      }
      int m = paramInt2 / paramInt1;
      int i1 = (int)(paramInt1 * 0.001F);
      int n = (int)(paramInt1 * 0.99F);
      int i = 0;
      paramInt2 = 0;
      paramInt1 = k;
      paramInt3 = i;
      if (paramInt2 < 256)
      {
        paramInt3 = i + arrayOfInt[paramInt2];
        if (paramInt3 > i1) {
          paramInt1 = paramInt2;
        }
      }
      else
      {
        paramInt2 += 1;
        i = paramInt3;
        paramInt3 = paramInt2;
      }
      float f1;
      for (;;)
      {
        paramInt2 = j;
        if (paramInt3 < 256)
        {
          i += arrayOfInt[paramInt3];
          if (i > n) {
            paramInt2 = paramInt3;
          }
        }
        else
        {
          f1 = (m - paramInt1) / (paramInt2 - paramInt1);
          float f2 = (float)(Math.log(0.5D) / Math.log(f1));
          f1 = f2;
          if (f2 < 0.1D) {
            f1 = 0.1F;
          }
          if (f2 > 10.0D) {
            f1 = 10.0F;
          }
          localObject = new float[256];
          paramInt3 = 0;
          while (paramInt3 < paramInt1)
          {
            localObject[paramInt3] = 0.0F;
            paramInt3 += 1;
          }
          paramInt2 += 1;
          i = paramInt3;
          break;
        }
        paramInt3 += 1;
      }
      paramInt3 = paramInt1;
      while (paramInt3 < paramInt2)
      {
        localObject[paramInt3] = ((float)Math.pow((paramInt3 - paramInt1) / (paramInt2 - paramInt1), f1));
        paramInt3 += 1;
      }
      while (paramInt2 < 256)
      {
        localObject[paramInt2] = 1.0F;
        paramInt2 += 1;
      }
      arrayOfInt = new int[256];
      paramInt1 = 0;
      while (paramInt1 < 256)
      {
        arrayOfInt[paramInt1] = ((int)(localObject[paramInt1] * 255.0F));
        paramInt1 += 1;
      }
      GLES20.glActiveTexture(33984);
      GLSLRender.nativeTextCure(arrayOfInt, this.paramTEXTRUEID);
    }
    
    public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
    {
      setTextureParam(this.paramTEXTRUEID, 1);
      return super.renderTexture(paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.art.NightRGBStretchFilter
 * JD-Core Version:    0.7.0.1
 */