package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;

public class HDRHSVFilter$ChannelStretchFilter
  extends BaseFilter
{
  float stretechMag = 25.0F;
  
  public HDRHSVFilter$ChannelStretchFilter()
  {
    super(BaseFilter.getFragmentShader(30));
  }
  
  public void ClearGLSL()
  {
    super.ClearGLSL();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("strength", this.stretechMag));
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void updateparam(float paramFloat)
  {
    this.stretechMag = paramFloat;
    addParam(new UniformParam.FloatParam("strength", this.stretechMag));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.HDRHSVFilter.ChannelStretchFilter
 * JD-Core Version:    0.7.0.1
 */