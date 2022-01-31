package com.tencent.aekit.target.gl;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class EGLContextCore
{
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  private final String TAG = "EGLContextCore-" + Integer.toHexString(hashCode());
  private EGLConfig[] configs;
  private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
  
  public EGLContextCore()
  {
    eglSetup(EGL14.EGL_NO_CONTEXT);
  }
  
  public EGLContextCore(EGLContext paramEGLContext)
  {
    eglSetup(paramEGLContext);
  }
  
  private void checkEglError(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288) {
      throw new RuntimeException(paramString + ": EGL error: 0x" + Integer.toHexString(i));
    }
  }
  
  private void eglSetup(EGLContext paramEGLContext)
  {
    this.mEGLDisplay = EGL14.eglGetDisplay(0);
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      throw new RuntimeException("unable to get EGL14 display");
    }
    Object localObject1 = new int[2];
    if (!EGL14.eglInitialize(this.mEGLDisplay, (int[])localObject1, 0, (int[])localObject1, 1))
    {
      this.mEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    this.configs = new EGLConfig[1];
    localObject1 = new int[1];
    Object localObject2 = this.mEGLDisplay;
    EGLConfig[] arrayOfEGLConfig = this.configs;
    int i = this.configs.length;
    if (!EGL14.eglChooseConfig((EGLDisplay)localObject2, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 8, 12344 }, 0, arrayOfEGLConfig, 0, i, (int[])localObject1, 0)) {
      throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
    }
    localObject1 = this.mEGLDisplay;
    localObject2 = this.configs[0];
    if (paramEGLContext != null) {}
    for (;;)
    {
      this.mEGLContext = EGL14.eglCreateContext((EGLDisplay)localObject1, (EGLConfig)localObject2, paramEGLContext, new int[] { 12440, 3, 12344 }, 0);
      checkEglError("eglCreateContext");
      if (this.mEGLContext != null) {
        break;
      }
      throw new RuntimeException("null context");
      paramEGLContext = EGL14.EGL_NO_CONTEXT;
    }
  }
  
  public void config(EGLSurface paramEGLSurface, int paramInt1, int paramInt2)
  {
    EGL14.eglSurfaceAttrib(this.mEGLDisplay, paramEGLSurface, paramInt1, paramInt2);
  }
  
  public EGLSurface createDummySurface()
  {
    EGLSurface localEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.configs[0], new int[] { 12375, 100, 12374, 100, 12344 }, 0);
    checkEglError("eglCreateWindowSurface");
    return localEGLSurface;
  }
  
  public EGLSurface createSurface(SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.configs[0], paramSurfaceTexture, new int[] { 12344 }, 0);
    checkEglError("eglCreateWindowSurface");
    return paramSurfaceTexture;
  }
  
  public EGLSurface createSurface(Surface paramSurface)
  {
    paramSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.configs[0], paramSurface, new int[] { 12344 }, 0);
    checkEglError("eglCreateWindowSurface");
    return paramSurface;
  }
  
  public void destroyEGLSurface(EGLSurface paramEGLSurface)
  {
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
      EGL14.eglDestroySurface(this.mEGLDisplay, paramEGLSurface);
    }
  }
  
  public EGLContext getEGLContext()
  {
    return this.mEGLContext;
  }
  
  public void makeCurrent(EGLSurface paramEGLSurface)
  {
    EGLDisplay localEGLDisplay = this.mEGLDisplay;
    if (paramEGLSurface != EGL14.EGL_NO_SURFACE) {}
    for (EGLContext localEGLContext = this.mEGLContext; !EGL14.eglMakeCurrent(localEGLDisplay, paramEGLSurface, paramEGLSurface, localEGLContext); localEGLContext = EGL14.EGL_NO_CONTEXT) {
      throw new RuntimeException("eglMakeCurrent failed");
    }
    LogUtils.d(this.TAG, "makeCurrent: " + paramEGLSurface);
  }
  
  public void release()
  {
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.mEGLDisplay);
    }
    this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.mEGLContext = EGL14.EGL_NO_CONTEXT;
  }
  
  public void swapBuffer(EGLSurface paramEGLSurface)
  {
    EGL14.eglSwapBuffers(this.mEGLDisplay, paramEGLSurface);
  }
  
  @TargetApi(18)
  public void swapBuffer(EGLSurface paramEGLSurface, long paramLong)
  {
    GLES20.glFlush();
    EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, paramEGLSurface, paramLong);
    EGL14.eglSwapBuffers(this.mEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.target.gl.EGLContextCore
 * JD-Core Version:    0.7.0.1
 */