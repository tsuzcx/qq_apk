package com.tencent.jalpha.videoplayer.view;

import android.opengl.GLDebugHelper;
import android.util.Log;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

class GLTextureView$EglHelper
{
  EGL10 mEgl;
  EGLConfig mEglConfig;
  EGLContext mEglContext;
  EGLDisplay mEglDisplay;
  EGLSurface mEglSurface;
  private WeakReference<GLTextureView> mGLTextureViewWeakRef;
  
  public GLTextureView$EglHelper(WeakReference<GLTextureView> paramWeakReference)
  {
    this.mGLTextureViewWeakRef = paramWeakReference;
  }
  
  private void destroySurfaceImp()
  {
    if ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE))
    {
      this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
      if (localGLTextureView != null) {
        GLTextureView.access$1300(localGLTextureView).destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
      }
      this.mEglSurface = null;
    }
  }
  
  public static String formatEglError(String paramString, int paramInt)
  {
    return paramString + " failed: " + getErrorString(paramInt);
  }
  
  public static String getErrorString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return getHex(paramInt);
    case 12288: 
      return "EGL_SUCCESS";
    case 12289: 
      return "EGL_NOT_INITIALIZED";
    case 12290: 
      return "EGL_BAD_ACCESS";
    case 12291: 
      return "EGL_BAD_ALLOC";
    case 12292: 
      return "EGL_BAD_ATTRIBUTE";
    case 12293: 
      return "EGL_BAD_CONFIG";
    case 12294: 
      return "EGL_BAD_CONTEXT";
    case 12295: 
      return "EGL_BAD_CURRENT_SURFACE";
    case 12296: 
      return "EGL_BAD_DISPLAY";
    case 12297: 
      return "EGL_BAD_MATCH";
    case 12298: 
      return "EGL_BAD_NATIVE_PIXMAP";
    case 12299: 
      return "EGL_BAD_NATIVE_WINDOW";
    case 12300: 
      return "EGL_BAD_PARAMETER";
    case 12301: 
      return "EGL_BAD_SURFACE";
    }
    return "EGL_CONTEXT_LOST";
  }
  
  private static String getHex(int paramInt)
  {
    return "0x" + Integer.toHexString(paramInt);
  }
  
  public static void logEglErrorAsWarning(String paramString1, String paramString2, int paramInt)
  {
    Log.w(paramString1, formatEglError(paramString2, paramInt));
  }
  
  private void throwEglException(String paramString)
  {
    throwEglException(paramString, this.mEgl.eglGetError());
  }
  
  public static void throwEglException(String paramString, int paramInt)
  {
    throw new RuntimeException(formatEglError(paramString, paramInt));
  }
  
  GL createGL()
  {
    GL localGL2 = this.mEglContext.getGL();
    GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
    Object localObject = localGL2;
    GL localGL1;
    int i;
    if (localGLTextureView != null)
    {
      localGL1 = localGL2;
      if (GLTextureView.access$1400(localGLTextureView) != null) {
        localGL1 = GLTextureView.access$1400(localGLTextureView).wrap(localGL2);
      }
      localObject = localGL1;
      if ((GLTextureView.access$1500(localGLTextureView) & 0x3) != 0)
      {
        i = 0;
        if ((GLTextureView.access$1500(localGLTextureView) & 0x1) != 0) {
          i = 1;
        }
        if ((GLTextureView.access$1500(localGLTextureView) & 0x2) == 0) {
          break label106;
        }
      }
    }
    label106:
    for (localObject = new GLTextureView.LogWriter();; localObject = null)
    {
      localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
      return localObject;
    }
  }
  
  public boolean createSurface()
  {
    if (this.mEgl == null) {
      throw new RuntimeException("egl not initialized");
    }
    if (this.mEglDisplay == null) {
      throw new RuntimeException("eglDisplay not initialized");
    }
    if (this.mEglConfig == null) {
      throw new RuntimeException("mEglConfig not initialized");
    }
    destroySurfaceImp();
    GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
    if (localGLTextureView != null) {
      this.mEglSurface = GLTextureView.access$1300(localGLTextureView).createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, localGLTextureView.getSurfaceTexture());
    }
    while ((this.mEglSurface != null) && (this.mEglSurface != EGL10.EGL_NO_SURFACE)) {
      if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext))
      {
        logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
        return false;
        this.mEglSurface = null;
      }
      else
      {
        return true;
      }
    }
    if (this.mEgl.eglGetError() == 12299) {
      Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
    }
    return false;
  }
  
  public void destroySurface()
  {
    destroySurfaceImp();
  }
  
  public void finish()
  {
    if (this.mEglContext != null)
    {
      GLTextureView localGLTextureView = (GLTextureView)this.mGLTextureViewWeakRef.get();
      if (localGLTextureView != null) {
        GLTextureView.access$1200(localGLTextureView).destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
      }
      this.mEglContext = null;
    }
    if (this.mEglDisplay != null)
    {
      this.mEgl.eglTerminate(this.mEglDisplay);
      this.mEglDisplay = null;
    }
  }
  
  public void start()
  {
    this.mEgl = ((EGL10)EGLContext.getEGL());
    this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
      throw new RuntimeException("eglGetDisplay failed");
    }
    Object localObject = new int[2];
    if (!this.mEgl.eglInitialize(this.mEglDisplay, (int[])localObject)) {
      throw new RuntimeException("eglInitialize failed");
    }
    localObject = (GLTextureView)this.mGLTextureViewWeakRef.get();
    if (localObject == null) {
      this.mEglConfig = null;
    }
    for (this.mEglContext = null;; this.mEglContext = GLTextureView.access$1200((GLTextureView)localObject).createContext(this.mEgl, this.mEglDisplay, this.mEglConfig))
    {
      if ((this.mEglContext == null) || (this.mEglContext == EGL10.EGL_NO_CONTEXT))
      {
        this.mEglContext = null;
        throwEglException("createContext");
      }
      this.mEglSurface = null;
      return;
      this.mEglConfig = GLTextureView.access$1100((GLTextureView)localObject).chooseConfig(this.mEgl, this.mEglDisplay);
    }
  }
  
  public int swap()
  {
    if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
      return this.mEgl.eglGetError();
    }
    return 12288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.GLTextureView.EglHelper
 * JD-Core Version:    0.7.0.1
 */