package com.tencent.filter;

import java.util.Map;

public class DpiLensFilter
  extends BaseFilter
{
  float scaleFact = 1.0F;
  
  public DpiLensFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    localBaseFilter.scaleFact = this.scaleFact;
    setNextFilter(localBaseFilter, null);
    localBaseFilter.setNextFilter(new BaseFilter(GLSLRender.FILTER_SHADER_NONE), null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("scalefact")) {
      this.scaleFact = ((Float)paramMap.get("scalefact")).floatValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.DpiLensFilter
 * JD-Core Version:    0.7.0.1
 */