package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;
import java.util.Map;

public class MangaFilter
  extends BaseFilter
{
  private Bitmap graybitmap = null;
  private int type = 0;
  
  public MangaFilter(int paramInt)
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.type = paramInt;
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
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    float f1 = 852.0F;
    float f2 = 640.0F;
    this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
    BaseFilter localBaseFilter3 = new BaseFilter(BaseFilter.getVertexShader(9), BaseFilter.getFragmentShader(89));
    setNextFilter(localBaseFilter3, null);
    BaseFilter localBaseFilter2;
    BaseFilter localBaseFilter1;
    label239:
    float f3;
    float f4;
    if (this.graybitmap == null)
    {
      localBaseFilter2 = new BaseFilter(BaseFilter.getVertexShader(10), BaseFilter.getFragmentShader(94));
      localBaseFilter3.setNextFilter(localBaseFilter2, null);
      if (GLES20.glGetString(7937).indexOf("PowerVR SGX 540") != -1)
      {
        localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(96));
        localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex + 2 });
        localBaseFilter2 = new BaseFilter(BaseFilter.getVertexShader(11), BaseFilter.getFragmentShader(91));
        localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { this.srcTextureIndex + 3 });
        localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(92));
        localBaseFilter1.addParam(new TextureResParam("inputImageTexture2", "manga/manga.png", 33986));
        localBaseFilter1.addParam(new UniformParam.FloatParam("height_scale", paramFloat2 / 64.0F));
        localBaseFilter1.addParam(new UniformParam.FloatParam("width_scale", paramFloat1 / 64.0F));
        localBaseFilter2.setNextFilter(localBaseFilter1, null);
        localBaseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(93));
        localBaseFilter2.addParam(new UniformParam.FloatParam("rx", 1.0F));
        localBaseFilter2.addParam(new UniformParam.FloatParam("ry", 1.0F));
        localBaseFilter2.addParam(new UniformParam.FloatParam("tx", 0.0F));
        localBaseFilter2.addParam(new UniformParam.FloatParam("ty", 0.0F));
        localBaseFilter2.addParam(new UniformParam.IntParam("flag", this.type));
        if ((paramFloat1 <= 640.0F) || (paramFloat2 <= 852.0F)) {
          break label573;
        }
        f3 = paramFloat1 / 640.0F;
        f4 = paramFloat2 / 852.0F;
        if (f3 >= f4) {
          break label564;
        }
        f1 = paramFloat2 / f3;
      }
    }
    for (;;)
    {
      localBaseFilter2.addParam(new UniformParam.FloatParam("w", f2));
      localBaseFilter2.addParam(new UniformParam.FloatParam("h", f1));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
      localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(96));
      break;
      localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(95));
      localBaseFilter1.addParam(new TextureResParam("inputImageTexture3", "manga/manga.png", 33987));
      localBaseFilter1.addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", this.graybitmap, 33986, false));
      localBaseFilter1.addParam(new UniformParam.FloatParam("par", 0.45F));
      localBaseFilter1.addParam(new UniformParam.FloatParam("height_scale", paramFloat2 / 64.0F));
      localBaseFilter1.addParam(new UniformParam.FloatParam("width_scale", paramFloat1 / 64.0F));
      localBaseFilter3.setNextFilter(localBaseFilter1, null);
      break label239;
      label564:
      f2 = paramFloat1 / f4;
      continue;
      label573:
      f3 = 640.0F / paramFloat1;
      f4 = 852.0F / paramFloat2;
      if (f3 < f4) {
        f2 = paramFloat1 * f4;
      } else {
        f1 = paramFloat2 * f3;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.filter.art.MangaFilter
 * JD-Core Version:    0.7.0.1
 */