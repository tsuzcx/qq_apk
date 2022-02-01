package com.tencent.liteav.basic.opengl;

import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.e;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class b
{
  public static final String a = "b";
  private static int[] l = { 12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344 };
  private static int[] m = { 12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344 };
  private EGL10 b;
  private EGLDisplay c;
  private EGLConfig d;
  private boolean e;
  private EGLContext f;
  private boolean g;
  private EGLSurface h;
  private int i = 0;
  private int j = 0;
  private int[] k = new int[2];
  
  public static b a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.i = paramInt1;
    localb.j = paramInt2;
    if (localb.a(paramEGLConfig, paramEGLContext, paramSurface)) {
      return localb;
    }
    return null;
  }
  
  private EGLContext a(EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt, EGLContext paramEGLContext)
  {
    EGLContext localEGLContext = paramEGLContext;
    if (paramEGLContext == null) {
      localEGLContext = EGL10.EGL_NO_CONTEXT;
    }
    paramEGLDisplay = this.b.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, new int[] { 12440, paramInt, 12344 });
    g();
    return paramEGLDisplay;
  }
  
  private boolean a(EGLConfig paramEGLConfig, EGLContext paramEGLContext, Surface paramSurface)
  {
    this.b = ((EGL10)EGLContext.getEGL());
    this.c = this.b.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    this.b.eglInitialize(this.c, this.k);
    if (paramEGLConfig == null)
    {
      int[] arrayOfInt = new int[1];
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
      EGL10 localEGL10 = this.b;
      EGLDisplay localEGLDisplay = this.c;
      if (paramSurface == null) {
        paramEGLConfig = l;
      } else {
        paramEGLConfig = m;
      }
      localEGL10.eglChooseConfig(localEGLDisplay, paramEGLConfig, arrayOfEGLConfig, 1, arrayOfInt);
      this.d = arrayOfEGLConfig[0];
      this.e = true;
    }
    else
    {
      this.d = paramEGLConfig;
    }
    if (paramEGLContext != null) {
      this.g = true;
    }
    try
    {
      this.f = a(this.c, this.d, 2, paramEGLContext);
    }
    catch (d paramEGLConfig)
    {
      label153:
      break label153;
    }
    TXCLog.i(a, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
    try
    {
      this.f = a(this.c, this.d, 3, paramEGLContext);
      int n = this.i;
      int i1 = this.j;
      if (paramSurface == null) {
        this.h = this.b.eglCreatePbufferSurface(this.c, this.d, new int[] { 12375, n, 12374, i1, 12344 });
      } else {
        this.h = this.b.eglCreateWindowSurface(this.c, this.d, paramSurface, null);
      }
      if (this.h == EGL10.EGL_NO_SURFACE)
      {
        e();
        return false;
      }
      paramEGLConfig = this.b;
      paramEGLContext = this.c;
      paramSurface = this.h;
      if (!paramEGLConfig.eglMakeCurrent(paramEGLContext, paramSurface, paramSurface, this.f))
      {
        e();
        return false;
      }
      return true;
    }
    catch (d paramEGLConfig)
    {
      paramEGLContext = a;
      paramSurface = new StringBuilder();
      paramSurface.append("failed to create EGLContext of 3.0. ");
      paramSurface.append(paramEGLConfig);
      TXCLog.e(paramEGLContext, paramSurface.toString());
      return false;
    }
  }
  
  private void g()
  {
    int n = this.b.eglGetError();
    EGL10 localEGL10 = this.b;
    if (n == 12288) {
      return;
    }
    throw new d(n);
  }
  
  public boolean a()
  {
    boolean bool = this.b.eglSwapBuffers(this.c, this.h);
    e();
    return bool;
  }
  
  public void b()
  {
    EGL10 localEGL10 = this.b;
    EGLDisplay localEGLDisplay = this.c;
    EGLSurface localEGLSurface = this.h;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.f);
    e();
  }
  
  public void c()
  {
    this.b.eglMakeCurrent(this.c, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    Object localObject = this.h;
    if (localObject != null) {
      this.b.eglDestroySurface(this.c, (EGLSurface)localObject);
    }
    localObject = this.f;
    if (localObject != null) {
      this.b.eglDestroyContext(this.c, (EGLContext)localObject);
    }
    this.b.eglTerminate(this.c);
    e();
    this.c = null;
    this.h = null;
    this.c = null;
  }
  
  public EGLContext d()
  {
    return this.f;
  }
  
  public void e()
  {
    int n = this.b.eglGetError();
    if (n != 12288)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EGL error: 0x");
      localStringBuilder.append(Integer.toHexString(n));
      TXCLog.e(str, localStringBuilder.toString());
    }
  }
  
  public e f()
  {
    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = new int[1];
    boolean bool1 = this.b.eglQuerySurface(this.c, this.h, 12375, arrayOfInt1);
    boolean bool2 = this.b.eglQuerySurface(this.c, this.h, 12374, arrayOfInt2);
    if ((bool1) && (bool2)) {
      return new e(arrayOfInt1[0], arrayOfInt2[0]);
    }
    return new e(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.b
 * JD-Core Version:    0.7.0.1
 */