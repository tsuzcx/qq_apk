package com.tencent.filter;

import java.util.Map;

public class FlaresFilter
  extends BaseFilter
{
  String surfaceBlurName;
  private int type = 0;
  
  public FlaresFilter(int paramInt)
  {
    super(GLSLRender.FILTER_SHADER_NONE);
    this.type = paramInt;
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    double d = paramFloat1 / paramFloat2;
    this.glsl_programID = GLSLRender.FILTER_FLARES;
    addParam(new Param.TextureResParam("inputImageTexture3", "flares/flares_curve.png", 33987));
    switch (this.type)
    {
    default: 
      addParam(new Param.TextureResParam("inputImageTexture2", "flares/flares_light_leak_3.jpg", 33986, d));
      addParam(new Param.IntParam("flag", 1));
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      addParam(new Param.TextureResParam("inputImageTexture2", "flares/flares_bokeh_basic_1.jpg", 33986, d));
      addParam(new Param.IntParam("flag", 0));
      continue;
      addParam(new Param.TextureResParam("inputImageTexture2", "flares/flares_bokeh_basic_2.jpg", 33986, d));
      addParam(new Param.IntParam("flag", 0));
      continue;
      addParam(new Param.TextureResParam("inputImageTexture2", "flares/flares_bokeh_basic_3.jpg", 33986, d));
      addParam(new Param.IntParam("flag", 0));
      continue;
      addParam(new Param.TextureResParam("inputImageTexture2", "flares/flares_bokeh_heart_1.jpg", 33986, d));
      addParam(new Param.IntParam("flag", 0));
      continue;
      addParam(new Param.TextureResParam("inputImageTexture2", "flares/flares_bokeh_heart_2.jpg", 33986, d));
      addParam(new Param.IntParam("flag", 0));
      continue;
      addParam(new Param.TextureResParam("inputImageTexture2", "flares/flares_lens_flares_1.jpg", 33986, d));
      addParam(new Param.IntParam("flag", 0));
      continue;
      addParam(new Param.TextureResParam("inputImageTexture2", "flares/flares_lens_flares_2.jpg", 33986, d));
      addParam(new Param.IntParam("flag", 0));
      continue;
      addParam(new Param.TextureResParam("inputImageTexture2", "flares/flares_lens_flares_3.jpg", 33986, d));
      addParam(new Param.IntParam("flag", 0));
      continue;
      addParam(new Param.TextureResParam("inputImageTexture2", "flares/flares_light_leak_1.jpg", 33986, d));
      addParam(new Param.IntParam("flag", 1));
      continue;
      addParam(new Param.TextureResParam("inputImageTexture2", "flares/flares_light_leak_2.jpg", 33986, d));
      addParam(new Param.IntParam("flag", 1));
    }
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.FlaresFilter
 * JD-Core Version:    0.7.0.1
 */