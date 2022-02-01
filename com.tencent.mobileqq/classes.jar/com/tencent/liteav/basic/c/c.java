package com.tencent.liteav.basic.c;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;

@TargetApi(17)
public class c
{
  private static int a = 2;
  private static final String b = "c";
  private static int[] k;
  private static int[] l;
  private EGLDisplay c = EGL14.EGL_NO_DISPLAY;
  private EGLContext d = EGL14.EGL_NO_CONTEXT;
  private EGLConfig e = null;
  private int f = 0;
  private int g = 0;
  private boolean h;
  private EGLSurface i;
  private int j = -1;
  
  static
  {
    int n = 4;
    int m;
    if (a == 2) {
      m = 4;
    } else {
      m = 68;
    }
    k = new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, m, 12610, 1, 12344 };
    if (a == 2) {
      m = n;
    } else {
      m = 68;
    }
    l = new int[] { 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, m, 12610, 1, 12344 };
  }
  
  private static EGLContext a(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt, EGLContext paramEGLContext)
  {
    paramEGLDisplay = EGL14.eglCreateContext(paramEGLDisplay, paramEGLConfig, paramEGLContext, new int[] { 12440, paramInt, 12344 }, 0);
    f();
    return paramEGLDisplay;
  }
  
  public static c a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface, int paramInt1, int paramInt2)
  {
    c localc = new c();
    localc.f = paramInt1;
    localc.g = paramInt2;
    if (localc.a(paramEGLConfig, paramEGLContext, paramSurface)) {
      return localc;
    }
    return null;
  }
  
  private boolean a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface)
  {
    this.c = EGL14.eglGetDisplay(0);
    if (this.c == EGL14.EGL_NO_DISPLAY) {
      TXCLog.e(b, "unable to get EGL14 display");
    }
    Object localObject = new int[2];
    if (!EGL14.eglInitialize(this.c, (int[])localObject, 0, (int[])localObject, 1))
    {
      this.c = null;
      TXCLog.e(b, "unable to initialize EGL14");
    }
    if (paramEGLConfig != null)
    {
      this.e = paramEGLConfig;
    }
    else
    {
      localObject = new EGLConfig[1];
      int[] arrayOfInt = new int[1];
      EGLDisplay localEGLDisplay = this.c;
      if (paramSurface == null) {
        paramEGLConfig = l;
      } else {
        paramEGLConfig = k;
      }
      if (!EGL14.eglChooseConfig(localEGLDisplay, paramEGLConfig, 0, (EGLConfig[])localObject, 0, localObject.length, arrayOfInt, 0)) {
        return false;
      }
      this.e = localObject[0];
    }
    if (paramEGLContext != null)
    {
      this.h = true;
      paramEGLConfig = paramEGLContext;
    }
    else
    {
      paramEGLConfig = EGL14.EGL_NO_CONTEXT;
    }
    try
    {
      this.d = a(this.c, this.e, 2, paramEGLConfig);
    }
    catch (d paramEGLContext)
    {
      label171:
      break label171;
    }
    TXCLog.i(b, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
    try
    {
      this.d = a(this.c, this.e, 3, paramEGLConfig);
      if (paramSurface == null)
      {
        int m = this.f;
        int n = this.g;
        this.i = EGL14.eglCreatePbufferSurface(this.c, this.e, new int[] { 12375, m, 12374, n, 12344 }, 0);
      }
      else
      {
        this.i = EGL14.eglCreateWindowSurface(this.c, this.e, paramSurface, new int[] { 12344 }, 0);
      }
      a();
      paramEGLConfig = this.c;
      paramEGLContext = this.i;
      if (!EGL14.eglMakeCurrent(paramEGLConfig, paramEGLContext, paramEGLContext, this.d))
      {
        a();
        return false;
      }
      return true;
    }
    catch (d paramEGLConfig)
    {
      paramEGLContext = b;
      paramSurface = new StringBuilder();
      paramSurface.append("failed to create EGLContext of 3.0. ");
      paramSurface.append(paramEGLConfig);
      TXCLog.e(paramEGLContext, paramSurface.toString());
      return false;
    }
  }
  
  private static void f()
  {
    int m = EGL14.eglGetError();
    if (m == 12288) {
      return;
    }
    throw new d(m);
  }
  
  public void a()
  {
    int m = EGL14.eglGetError();
    if (m != 12288)
    {
      String str = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EGL error:");
      localStringBuilder.append(m);
      TXCLog.e(str, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong)
  {
    EGLExt.eglPresentationTimeANDROID(this.c, this.i, paramLong);
  }
  
  public void b()
  {
    if (this.c == EGL14.EGL_NO_DISPLAY) {
      Log.d(b, "NOTE: makeCurrent w/o display");
    }
    EGLDisplay localEGLDisplay = this.c;
    EGLSurface localEGLSurface = this.i;
    if (!EGL14.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.d)) {
      TXCLog.e(b, "eglMakeCurrent failed");
    }
  }
  
  public void c()
  {
    if (this.c != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglMakeCurrent(this.c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.c, this.i);
      EGL14.eglDestroyContext(this.c, this.d);
      this.d = EGL14.EGL_NO_CONTEXT;
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.c);
    }
    this.c = EGL14.EGL_NO_DISPLAY;
  }
  
  public boolean d()
  {
    return EGL14.eglSwapBuffers(this.c, this.i);
  }
  
  public EGLContext e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.c.c
 * JD-Core Version:    0.7.0.1
 */