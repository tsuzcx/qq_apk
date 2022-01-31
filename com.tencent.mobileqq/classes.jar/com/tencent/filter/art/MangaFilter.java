package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.Param.TextureResParam;
import java.util.Map;

public class MangaFilter
  extends BaseFilter
{
  Bitmap graybitmap = null;
  int type = 0;
  
  public MangaFilter(int paramInt)
  {
    super(GLSLRender.FILTER_SHADER_NONE);
    this.type = paramInt;
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
    BaseFilter localBaseFilter3 = new BaseFilter(GLSLRender.VERTEXT_GRAYFORMANGA_SHADER, GLSLRender.FILTER_GRAYFORMANGA_SHADER);
    setNextFilter(localBaseFilter3, null);
    BaseFilter localBaseFilter2;
    BaseFilter localBaseFilter1;
    label216:
    float f1;
    float f2;
    if (this.graybitmap == null)
    {
      localBaseFilter2 = new BaseFilter(GLSLRender.VERTEXT_SOBELFORMANGA_SHADER, GLSLRender.FILTER_SOBELFORMANGA_SHADER);
      localBaseFilter3.setNextFilter(localBaseFilter2, null);
      if (GLES20.glGetString(7937).indexOf("PowerVR SGX 540") != -1)
      {
        localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_NONMAXSUPRESS_SHADER_LOWDEVICE);
        localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex + 2 });
        localBaseFilter2 = new BaseFilter(GLSLRender.VERTEXT_SOBELBLUR_SHADER, GLSLRender.FILTER_SOBELBLUR_SHADER);
        localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { this.srcTextureIndex + 3 });
        localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_MANGA_SHADER);
        localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture2", "manga/manga.png", 33986));
        localBaseFilter1.addParam(new Param.FloatParam("height_scale", paramFloat2 / 64.0F));
        localBaseFilter1.addParam(new Param.FloatParam("width_scale", paramFloat1 / 64.0F));
        localBaseFilter2.setNextFilter(localBaseFilter1, null);
        localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_BACKGROUNDTEXUL_SHADER);
        localBaseFilter2.addParam(new Param.FloatParam("rx", 1.0F));
        localBaseFilter2.addParam(new Param.FloatParam("ry", 1.0F));
        localBaseFilter2.addParam(new Param.FloatParam("tx", 0.0F));
        localBaseFilter2.addParam(new Param.FloatParam("ty", 0.0F));
        localBaseFilter2.addParam(new Param.IntParam("flag", this.type));
        if ((paramFloat1 <= 640.0F) || (paramFloat2 <= 852.0F)) {
          break label552;
        }
        f1 = paramFloat1 / 640.0F;
        f2 = paramFloat2 / 852.0F;
        if (f1 >= f2) {
          break label539;
        }
        f2 = 640.0F;
        f1 = paramFloat2 / f1;
      }
    }
    for (;;)
    {
      localBaseFilter2.addParam(new Param.FloatParam("w", f2));
      localBaseFilter2.addParam(new Param.FloatParam("h", f1));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_NONMAXSUPRESS_SHADER);
      break;
      localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_MANGAFORSAVE_SHADER);
      localBaseFilter1.addParam(new Param.TextureResParam("inputImageTexture3", "manga/manga.png", 33987));
      localBaseFilter1.addParam(new Param.TextureBitmapParam("inputImageTexture2", this.graybitmap, 33986, false));
      localBaseFilter1.addParam(new Param.FloatParam("par", 0.45F));
      localBaseFilter1.addParam(new Param.FloatParam("height_scale", paramFloat2 / 64.0F));
      localBaseFilter1.addParam(new Param.FloatParam("width_scale", paramFloat1 / 64.0F));
      localBaseFilter3.setNextFilter(localBaseFilter1, null);
      break label216;
      label539:
      f2 = paramFloat1 / f2;
      f1 = 852.0F;
      continue;
      label552:
      f1 = 640.0F / paramFloat1;
      f2 = 852.0F / paramFloat2;
      if (f1 < f2)
      {
        f2 = paramFloat1 * f2;
        f1 = 852.0F;
      }
      else
      {
        f2 = 640.0F;
        f1 = paramFloat2 * f1;
      }
    }
  }
  
  public void ClearGLSL()
  {
    if (this.graybitmap != null)
    {
      this.graybitmap.recycle();
      this.graybitmap = null;
    }
    super.ClearGLSL();
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("graybitmap")) {
      this.graybitmap = ((Bitmap)paramMap.get("graybitmap"));
    }
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.art.MangaFilter
 * JD-Core Version:    0.7.0.1
 */