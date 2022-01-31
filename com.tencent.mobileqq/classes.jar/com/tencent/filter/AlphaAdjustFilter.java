package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;

public class AlphaAdjustFilter
  extends BaseFilter
{
  public AlphaAdjustFilter(int paramInt)
  {
    super(BaseFilter.getFragmentShader(paramInt));
  }
  
  public void setAdjustParam(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("filterAdjustParam", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.filter.AlphaAdjustFilter
 * JD-Core Version:    0.7.0.1
 */