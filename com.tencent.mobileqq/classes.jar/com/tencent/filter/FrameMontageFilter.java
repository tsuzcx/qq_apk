package com.tencent.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import java.util.Map;

public class FrameMontageFilter
  extends BaseFilter
{
  private Bitmap imagebitmap = null;
  private int type = 0;
  
  public FrameMontageFilter(int paramInt)
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.type = paramInt;
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
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    float f2 = 0.0F;
    if (this.imagebitmap == null)
    {
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", this.imagebitmap, 33986, false));
    if (this.type == 0)
    {
      this.glslProgramShader = BaseFilter.getFragmentShader(51);
      f1 = (float)Math.floor(paramFloat2 / this.imagebitmap.getHeight() + 0.999999D);
      f2 = (float)Math.floor(paramFloat1 / this.imagebitmap.getWidth() + 0.999999D);
      addParam(new UniformParam.FloatParam("height_scale", f1));
      addParam(new UniformParam.FloatParam("width_scale", f2));
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    this.glslVertextShader = BaseFilter.getVertexShader(6);
    this.glslProgramShader = BaseFilter.getFragmentShader(50);
    float f1 = this.imagebitmap.getHeight() / this.imagebitmap.getWidth();
    if (this.type == 1)
    {
      this.glslVertextShader = BaseFilter.getVertexShader(7);
      if (paramFloat2 > paramFloat1 * f1) {
        f1 = (paramFloat2 - f1 * paramFloat1) / 2.0F / paramFloat2;
      }
    }
    for (;;)
    {
      addParam(new UniformParam.FloatParam("height_offset", f1));
      addParam(new UniformParam.FloatParam("width_offset", f2));
      break;
      f2 = (paramFloat1 - paramFloat2 / f1) / 2.0F / paramFloat1;
      f1 = 0.0F;
      continue;
      if (this.type == 2)
      {
        this.glslVertextShader = BaseFilter.getVertexShader(8);
        if (paramFloat2 < paramFloat1 * f1)
        {
          f1 = (paramFloat1 * f1 - paramFloat2) / 2.0F / (f1 * paramFloat1);
        }
        else
        {
          f2 = (paramFloat2 / f1 - paramFloat1) / 2.0F / (paramFloat2 / f1);
          f1 = 0.0F;
        }
      }
      else
      {
        f1 = 0.0F;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.filter.FrameMontageFilter
 * JD-Core Version:    0.7.0.1
 */