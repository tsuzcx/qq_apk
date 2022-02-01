package com.tencent.mobileqq.apollo.view.opengl;

abstract interface GLRenderView
{
  public abstract int getDebugFlags();
  
  public abstract EGLConfigChooser getEGLConfigChooser();
  
  public abstract EGLContextFactory getEGLContextFactory();
  
  public abstract EGLWindowSurfaceFactory getEGLWindowSurfaceFactory();
  
  public abstract GLWrapper getGLWrapper();
  
  public abstract Object getNativeWindow();
  
  public abstract boolean getPreserveEGLContextOnPause();
  
  public abstract Renderer getRenderer();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLRenderView
 * JD-Core Version:    0.7.0.1
 */