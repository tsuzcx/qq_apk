package com.tencent.filter;

public class AlphaAdjustFilter
  extends BaseFilter
{
  public AlphaAdjustFilter(int paramInt)
  {
    super(paramInt);
  }
  
  public void setAdjustParam(float paramFloat)
  {
    addParam(new Param.FloatParam("filterAdjustParam", paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.AlphaAdjustFilter
 * JD-Core Version:    0.7.0.1
 */