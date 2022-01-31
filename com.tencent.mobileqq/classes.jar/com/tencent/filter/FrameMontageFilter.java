package com.tencent.filter;

import android.graphics.Bitmap;
import java.util.Map;

public class FrameMontageFilter
  extends BaseFilter
{
  Bitmap imagebitmap = null;
  private int type = 0;
  
  public FrameMontageFilter(int paramInt)
  {
    super(GLSLRender.FILTER_SHADER_NONE);
    this.type = paramInt;
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (this.imagebitmap == null)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    addParam(new Param.TextureBitmapParam("inputImageTexture2", this.imagebitmap, 33986, false));
    float f1;
    float f2;
    if (this.type == 0)
    {
      this.glsl_programID = GLSLRender.FILTER_TEXTREPET_SHADER;
      f1 = (float)Math.floor(paramFloat2 / this.imagebitmap.getHeight() + 0.999999D);
      f2 = (float)Math.floor(paramFloat1 / this.imagebitmap.getWidth() + 0.999999D);
      addParam(new Param.FloatParam("height_scale", f1));
      addParam(new Param.FloatParam("width_scale", f2));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    this.glsl_vertextshaderID = GLSLRender.VERTEXT_FRAME_SHADER;
    this.glsl_programID = GLSLRender.FILTER_FRAME_SHADER;
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f5 = this.imagebitmap.getHeight() / this.imagebitmap.getWidth();
    if (this.type == 1)
    {
      this.glsl_vertextshaderID = GLSLRender.VERTEXT_FRAMEORIGIN_SHADER;
      if (paramFloat2 > paramFloat1 * f5)
      {
        f1 = (paramFloat2 - paramFloat1 * f5) / 2.0F / paramFloat2;
        f2 = f3;
      }
    }
    for (;;)
    {
      addParam(new Param.FloatParam("height_offset", f1));
      addParam(new Param.FloatParam("width_offset", f2));
      break;
      f2 = (paramFloat1 - paramFloat2 / f5) / 2.0F / paramFloat1;
      f1 = f4;
      continue;
      f1 = f4;
      f2 = f3;
      if (this.type == 2)
      {
        this.glsl_vertextshaderID = GLSLRender.VERTEXT_FRAMESTRETCH_SHADER;
        if (paramFloat2 < paramFloat1 * f5)
        {
          f1 = (paramFloat1 * f5 - paramFloat2) / 2.0F / (paramFloat1 * f5);
          f2 = f3;
        }
        else
        {
          f2 = (paramFloat2 / f5 - paramFloat1) / 2.0F / (paramFloat2 / f5);
          f1 = f4;
        }
      }
    }
  }
  
  public void ClearGLSL()
  {
    if (this.imagebitmap != null)
    {
      this.imagebitmap.recycle();
      this.imagebitmap = null;
    }
    super.ClearGLSL();
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("image")) {
      this.imagebitmap = ((Bitmap)paramMap.get("image"));
    }
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.FrameMontageFilter
 * JD-Core Version:    0.7.0.1
 */