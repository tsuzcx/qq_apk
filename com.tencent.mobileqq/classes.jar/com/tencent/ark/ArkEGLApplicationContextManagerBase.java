package com.tencent.ark;

import javax.microedition.khronos.egl.EGL10;

class ArkEGLApplicationContextManagerBase
{
  protected static final ArkEnvironmentManager ENV = ;
  protected static final String TAG = "ArkApp.ContextManager";
  
  public static EGLContextHolder createOffscreenContext()
  {
    if (!ENV.isHardwareAcceleration()) {
      return null;
    }
    EGLContextHolder localEGLContextHolder = new EGLContextHolder();
    if (!localEGLContextHolder.create(EGL10.EGL_NO_CONTEXT, null, 1, 1))
    {
      ENV.logE("ArkApp.ContextManager", "createOffscreenContext.create.fail");
      localEGLContextHolder.release();
      return null;
    }
    return localEGLContextHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkEGLApplicationContextManagerBase
 * JD-Core Version:    0.7.0.1
 */