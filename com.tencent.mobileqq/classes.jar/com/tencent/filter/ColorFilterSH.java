package com.tencent.filter;

import java.util.Map;

public class ColorFilterSH
  extends BaseFilter
{
  int effectindex = 0;
  
  public ColorFilterSH()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_HARDLIGHTBLEND_SHADER);
    Object localObject = "sh/";
    switch (this.effectindex)
    {
    default: 
      localBaseFilter.addParam(new Param.TextureResParam("inputImageTexture2", (String)localObject, 33986));
      setNextFilter(localBaseFilter, null);
      localObject = new BaseFilter(GLSLRender.FILTER_ALPHA_ADJUST);
      if (this.effectindex == 2) {
        ((BaseFilter)localObject).addParam(new Param.FloatParam("filterAdjustParam", 0.6F));
      }
      break;
    }
    for (;;)
    {
      localBaseFilter.setNextFilter((BaseFilter)localObject, new int[] { this.srcTextureIndex });
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      localObject = "sh/" + "blue_sh_blend.jpg";
      break;
      localObject = "sh/" + "yellow_sh_blend.jpg";
      break;
      localObject = "sh/" + "red_sh_blend.jpg";
      break;
      localObject = "sh/" + "purple_sh_blend.jpg";
      break;
      localObject = "sh/" + "green_sh_blend.jpg";
      break;
      ((BaseFilter)localObject).addParam(new Param.FloatParam("filterAdjustParam", 0.5F));
    }
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.effectindex = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ColorFilterSH
 * JD-Core Version:    0.7.0.1
 */