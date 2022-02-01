package com.tencent.liteav.renderer;

import android.opengl.GLDebugHelper;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.Writer;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class TXCGLSurfaceViewBase$h
{
  EGL10 a;
  EGLDisplay b;
  EGLSurface c;
  EGLConfig d;
  EGLContext e;
  private WeakReference<TXCGLSurfaceViewBase> f;
  
  public TXCGLSurfaceViewBase$h(WeakReference<TXCGLSurfaceViewBase> paramWeakReference)
  {
    this.f = paramWeakReference;
  }
  
  private void a(String paramString)
  {
    a(paramString, this.a.eglGetError());
  }
  
  public static void a(String paramString, int paramInt)
  {
    throw new RuntimeException(b(paramString, paramInt));
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    TXCLog.w(paramString1, b(paramString2, paramInt));
  }
  
  public static String b(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" failed: ");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void i()
  {
    Object localObject = this.c;
    if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
    {
      this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      localObject = (TXCGLSurfaceViewBase)this.f.get();
      if (localObject != null)
      {
        TXCGLSurfaceViewBase.e((TXCGLSurfaceViewBase)localObject).a(this.a, this.b, this.c);
        ((TXCGLSurfaceViewBase)localObject).e = false;
      }
      this.c = null;
    }
  }
  
  public void a()
  {
    this.a = ((EGL10)EGLContext.getEGL());
    this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.b != EGL10.EGL_NO_DISPLAY)
    {
      Object localObject = new int[2];
      if (this.a.eglInitialize(this.b, (int[])localObject))
      {
        localObject = (TXCGLSurfaceViewBase)this.f.get();
        if (localObject == null)
        {
          this.d = null;
          this.e = null;
          TXCLog.w("TXCGLSurfaceViewBase", "start() error when view is null ");
        }
        else
        {
          this.d = TXCGLSurfaceViewBase.c((TXCGLSurfaceViewBase)localObject).a(this.a, this.b);
          this.e = TXCGLSurfaceViewBase.d((TXCGLSurfaceViewBase)localObject).a(this.a, this.b, this.d);
        }
        EGLContext localEGLContext = this.e;
        if ((localEGLContext == null) || (localEGLContext == EGL10.EGL_NO_CONTEXT))
        {
          this.e = null;
          a("createContext");
        }
        if (localObject != null) {
          ((TXCGLSurfaceViewBase)localObject).f = true;
        }
        this.c = null;
        return;
      }
      throw new RuntimeException("eglInitialize failed");
    }
    throw new RuntimeException("eglGetDisplay failed");
  }
  
  public boolean b()
  {
    if (this.a != null)
    {
      if (this.b != null)
      {
        if (this.d != null)
        {
          i();
          TXCGLSurfaceViewBase localTXCGLSurfaceViewBase = (TXCGLSurfaceViewBase)this.f.get();
          if (localTXCGLSurfaceViewBase != null) {
            this.c = TXCGLSurfaceViewBase.e(localTXCGLSurfaceViewBase).a(this.a, this.b, this.d, localTXCGLSurfaceViewBase.getHolder());
          } else {
            this.c = null;
          }
          Object localObject = this.c;
          if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
          {
            localObject = this.a;
            EGLDisplay localEGLDisplay = this.b;
            EGLSurface localEGLSurface = this.c;
            if (!((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.e))
            {
              a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
              return false;
            }
            if (localTXCGLSurfaceViewBase != null) {
              localTXCGLSurfaceViewBase.e = true;
            }
            return true;
          }
          if (this.a.eglGetError() == 12299) {
            TXCLog.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
          }
          return false;
        }
        throw new RuntimeException("mEglConfig not initialized");
      }
      throw new RuntimeException("eglDisplay not initialized");
    }
    throw new RuntimeException("egl not initialized");
  }
  
  public boolean c()
  {
    EGL10 localEGL10 = this.a;
    EGLDisplay localEGLDisplay = this.b;
    EGLSurface localEGLSurface = this.c;
    if (!localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.e))
    {
      a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
      return false;
    }
    return true;
  }
  
  public int d()
  {
    return f();
  }
  
  GL e()
  {
    GL localGL2 = this.e.getGL();
    TXCGLSurfaceViewBase localTXCGLSurfaceViewBase = (TXCGLSurfaceViewBase)this.f.get();
    Object localObject = localGL2;
    if (localTXCGLSurfaceViewBase != null)
    {
      GL localGL1 = localGL2;
      if (TXCGLSurfaceViewBase.f(localTXCGLSurfaceViewBase) != null) {
        localGL1 = TXCGLSurfaceViewBase.f(localTXCGLSurfaceViewBase).a(localGL2);
      }
      localObject = localGL1;
      if ((TXCGLSurfaceViewBase.g(localTXCGLSurfaceViewBase) & 0x3) != 0)
      {
        int i = 0;
        localObject = null;
        if ((TXCGLSurfaceViewBase.g(localTXCGLSurfaceViewBase) & 0x1) != 0) {
          i = 1;
        }
        if ((TXCGLSurfaceViewBase.g(localTXCGLSurfaceViewBase) & 0x2) != 0) {
          localObject = new TXCGLSurfaceViewBase.l();
        }
        localObject = GLDebugHelper.wrap(localGL1, i, (Writer)localObject);
      }
    }
    return localObject;
  }
  
  public int f()
  {
    if (!this.a.eglSwapBuffers(this.b, this.c)) {
      return this.a.eglGetError();
    }
    return 12288;
  }
  
  public void g()
  {
    i();
  }
  
  public void h()
  {
    if (this.e != null)
    {
      localObject = (TXCGLSurfaceViewBase)this.f.get();
      if (localObject != null) {
        TXCGLSurfaceViewBase.d((TXCGLSurfaceViewBase)localObject).a(this.a, this.b, this.e);
      }
      this.e = null;
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      this.a.eglTerminate((EGLDisplay)localObject);
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase.h
 * JD-Core Version:    0.7.0.1
 */