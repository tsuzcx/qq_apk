package com.tencent.mobileqq.armap;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public abstract interface ARGLSurfaceView$SurfaceStateListener
{
  public abstract void onDestroy();
  
  public abstract void onEGLConfigCreated(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext, long paramLong);
  
  public abstract void onEGLContextDestroyed(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  
  public abstract void onInit(long paramLong);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARGLSurfaceView.SurfaceStateListener
 * JD-Core Version:    0.7.0.1
 */