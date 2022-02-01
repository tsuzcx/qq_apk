package com.tencent.mobileqq.apollo.view.opengl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract interface Renderer
{
  public abstract void onDrawFrame(GL10 paramGL10);
  
  public abstract void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2);
  
  public abstract void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.Renderer
 * JD-Core Version:    0.7.0.1
 */