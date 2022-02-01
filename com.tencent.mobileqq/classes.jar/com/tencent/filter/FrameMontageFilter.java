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
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Bitmap localBitmap = this.imagebitmap;
    if (localBitmap == null)
    {
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, false));
    float f1;
    float f2;
    if (this.type == 0)
    {
      this.glslProgramShader = BaseFilter.getFragmentShader(51);
      double d = paramFloat2 / this.imagebitmap.getHeight();
      Double.isNaN(d);
      f1 = (float)Math.floor(d + 0.999999D);
      d = paramFloat1 / this.imagebitmap.getWidth();
      Double.isNaN(d);
      f2 = (float)Math.floor(d + 0.999999D);
      addParam(new UniformParam.FloatParam("height_scale", f1));
      addParam(new UniformParam.FloatParam("width_scale", f2));
    }
    else
    {
      this.glslVertextShader = BaseFilter.getVertexShader(6);
      this.glslProgramShader = BaseFilter.getFragmentShader(50);
      float f3 = this.imagebitmap.getHeight() / this.imagebitmap.getWidth();
      int i = this.type;
      f2 = 0.0F;
      f1 = 0.0F;
      if (i == 1)
      {
        this.glslVertextShader = BaseFilter.getVertexShader(7);
        f1 = paramFloat1 * f3;
        if (paramFloat2 > f1) {
          f1 = (paramFloat2 - f1) / 2.0F / paramFloat2;
        }
      }
      for (;;)
      {
        break;
        f1 = (paramFloat1 - paramFloat2 / f3) / 2.0F / paramFloat1;
        break label329;
        if (i == 2)
        {
          this.glslVertextShader = BaseFilter.getVertexShader(8);
          f1 = paramFloat1 * f3;
          if (paramFloat2 < f1)
          {
            f1 = (f1 - paramFloat2) / 2.0F / f1;
          }
          else
          {
            f1 = paramFloat2 / f3;
            f1 = (f1 - paramFloat1) / 2.0F / f1;
            break label329;
          }
        }
      }
      f3 = 0.0F;
      f2 = f1;
      f1 = f3;
      label329:
      addParam(new UniformParam.FloatParam("height_offset", f2));
      addParam(new UniformParam.FloatParam("width_offset", f1));
    }
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void clearGLSL()
  {
    Bitmap localBitmap = this.imagebitmap;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.imagebitmap = null;
    }
    super.clearGLSL();
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