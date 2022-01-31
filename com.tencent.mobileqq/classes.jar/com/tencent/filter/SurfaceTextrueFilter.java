package com.tencent.filter;

public class SurfaceTextrueFilter
  extends BaseFilter
{
  public SurfaceTextrueFilter()
  {
    super(0, GLSLRender.FILTER_EGL_IMAGE);
  }
  
  public void ApplyGLSLFilter()
  {
    ApplyGLSLFilter(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.SurfaceTextrueFilter
 * JD-Core Version:    0.7.0.1
 */