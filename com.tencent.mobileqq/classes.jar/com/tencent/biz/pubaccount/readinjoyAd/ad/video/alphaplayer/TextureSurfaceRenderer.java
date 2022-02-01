package com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public abstract class TextureSurfaceRenderer
  implements Runnable
{
  protected final SurfaceTexture a;
  protected int b;
  protected int c;
  private EGL10 d;
  private EGLDisplay e;
  private EGLContext f;
  private EGLSurface g;
  private boolean h;
  private TextureSurfaceRenderer.RendererStatusChangeListener i;
  private long j = 0L;
  private int k;
  
  public TextureSurfaceRenderer(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.a = paramSurfaceTexture;
    this.b = paramInt1;
    this.c = paramInt2;
    this.h = true;
    new Thread(this).start();
  }
  
  private EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  private void d()
  {
    if (this.j == 0L) {
      this.j = System.currentTimeMillis();
    }
    this.k += 1;
    if (System.currentTimeMillis() - this.j > 1000L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FPS: ");
      localStringBuilder.append(this.k);
      Log.d("SurfaceTest.GL", localStringBuilder.toString());
      this.j = System.currentTimeMillis();
      this.k = 0;
    }
  }
  
  private void g()
  {
    this.d = ((EGL10)EGLContext.getEGL());
    this.e = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject = new int[2];
    this.d.eglInitialize(this.e, (int[])localObject);
    localObject = i();
    this.f = a(this.d, this.e, (EGLConfig)localObject);
    this.g = this.d.eglCreateWindowSurface(this.e, (EGLConfig)localObject, this.a, null);
    localObject = this.g;
    if ((localObject != null) && (localObject != EGL10.EGL_NO_SURFACE))
    {
      localObject = this.d;
      EGLDisplay localEGLDisplay = this.e;
      EGLSurface localEGLSurface = this.g;
      if (((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.f)) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GL Make current error: ");
      ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.d.eglGetError()));
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("GL Error: ");
    ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.d.eglGetError()));
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  private void h()
  {
    this.d.eglMakeCurrent(this.e, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    this.d.eglDestroySurface(this.e, this.g);
    this.d.eglDestroyContext(this.e, this.f);
    this.d.eglTerminate(this.e);
    Log.d("SurfaceTest.GL", "OpenGL deinit OK.");
  }
  
  private EGLConfig i()
  {
    Object localObject = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = j();
    if (this.d.eglChooseConfig(this.e, arrayOfInt, arrayOfEGLConfig, 1, (int[])localObject))
    {
      if (localObject[0] > 0) {
        return arrayOfEGLConfig[0];
      }
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to choose config: ");
    ((StringBuilder)localObject).append(GLUtils.getEGLErrorString(this.d.eglGetError()));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private int[] j()
  {
    return new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 };
  }
  
  public void a(TextureSurfaceRenderer.RendererStatusChangeListener paramRendererStatusChangeListener)
  {
    this.i = paramRendererStatusChangeListener;
  }
  
  protected abstract boolean a();
  
  protected abstract void b();
  
  protected abstract void c();
  
  public void e()
  {
    this.h = false;
  }
  
  public void f()
  {
    this.h = false;
  }
  
  protected void finalize()
  {
    super.finalize();
    this.h = false;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        g();
        TextureSurfaceRenderer.RendererStatusChangeListener localRendererStatusChangeListener1 = this.i;
        if (localRendererStatusChangeListener1 != null) {
          localRendererStatusChangeListener1.b();
        }
        try
        {
          b();
          localRendererStatusChangeListener1 = this.i;
          if (localRendererStatusChangeListener1 != null) {
            localRendererStatusChangeListener1.d();
          }
          Log.d("SurfaceTest.GL", "OpenGL init OK.");
          if (this.h)
          {
            l = System.currentTimeMillis();
            d();
            if (a()) {
              this.d.eglSwapBuffers(this.e, this.g);
            }
            l = 16L - (System.currentTimeMillis() - l);
            if (l <= 0L) {
              continue;
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          long l;
          Log.e("SurfaceTest.GL", "initGLComponents failed", localThrowable1);
          TextureSurfaceRenderer.RendererStatusChangeListener localRendererStatusChangeListener2 = this.i;
          if (localRendererStatusChangeListener2 != null) {
            localRendererStatusChangeListener2.e();
          }
          return;
        }
      }
      catch (Throwable localThrowable2)
      {
        Log.e("SurfaceTest.GL", "initGL failed", localThrowable2);
        TextureSurfaceRenderer.RendererStatusChangeListener localRendererStatusChangeListener3 = this.i;
        if (localRendererStatusChangeListener3 != null) {
          localRendererStatusChangeListener3.c();
        }
        return;
      }
      try
      {
        Thread.sleep(l);
      }
      catch (InterruptedException localInterruptedException) {}
    }
    c();
    localRendererStatusChangeListener1 = this.i;
    if (localRendererStatusChangeListener1 != null) {
      localRendererStatusChangeListener1.f();
    }
    h();
    localRendererStatusChangeListener1 = this.i;
    if (localRendererStatusChangeListener1 != null) {
      localRendererStatusChangeListener1.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer.TextureSurfaceRenderer
 * JD-Core Version:    0.7.0.1
 */