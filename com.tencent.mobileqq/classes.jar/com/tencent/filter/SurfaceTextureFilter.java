package com.tencent.filter;

public class SurfaceTextureFilter
  extends BaseFilter
{
  public SurfaceTextureFilter()
  {
    super(BaseFilter.getVertexShader(1), BaseFilter.getFragmentShader(9));
  }
  
  public void apply()
  {
    applyForOES();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.filter.SurfaceTextureFilter
 * JD-Core Version:    0.7.0.1
 */