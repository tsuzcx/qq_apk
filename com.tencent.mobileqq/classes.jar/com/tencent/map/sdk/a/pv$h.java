package com.tencent.map.sdk.a;

import android.util.Log;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class pv$h
{
  WeakReference<pv> a;
  EGL10 b;
  EGLDisplay c;
  EGLSurface d;
  EGLConfig e;
  EGLContext f;
  
  public pv$h(WeakReference<pv> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public static void a(String paramString)
  {
    throw new RuntimeException(b(paramString));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Log.w(paramString1, b(paramString2));
  }
  
  private static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" failed: ");
    return localStringBuilder.toString();
  }
  
  final void a()
  {
    Object localObject = this.d;
    if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
    {
      localObject = this.b;
      EGLDisplay localEGLDisplay = this.c;
      EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
      ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
      localObject = (pv)this.a.get();
      if (localObject != null) {
        pv.d((pv)localObject).a(this.b, this.c, this.d);
      }
      this.d = null;
    }
  }
  
  public final void b()
  {
    if (this.f != null)
    {
      localObject = (pv)this.a.get();
      if (localObject != null) {
        pv.c((pv)localObject).a(this.b, this.c, this.f);
      }
      this.f = null;
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      this.b.eglTerminate((EGLDisplay)localObject);
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pv.h
 * JD-Core Version:    0.7.0.1
 */