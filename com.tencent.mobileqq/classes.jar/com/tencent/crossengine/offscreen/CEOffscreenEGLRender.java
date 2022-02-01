package com.tencent.crossengine.offscreen;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.crossengine.CEApplication;
import com.tencent.crossengine.log.Logger;
import com.tencent.crossengine.util.IVSyncListener;
import com.tencent.crossengine.util.VSyncScheduler;
import java.util.UUID;

public class CEOffscreenEGLRender
{
  private CEApplication a;
  private String b;
  private long c;
  private VSyncScheduler d;
  private IVSyncListener e;
  private HandlerThread f;
  private Handler g;
  private boolean h = false;
  private boolean i = false;
  private volatile boolean j = false;
  
  public CEOffscreenEGLRender(CEApplication paramCEApplication, String paramString)
  {
    this.a = paramCEApplication;
    this.b = paramString;
    this.c = a();
    paramCEApplication = new StringBuilder();
    paramCEApplication.append("egl_render_");
    paramCEApplication.append(UUID.randomUUID());
    this.f = new HandlerThread(paramCEApplication.toString());
    this.f.start();
    this.g = new Handler(this.f.getLooper());
    this.e = new CEOffscreenEGLRender.1(this);
    this.d = new VSyncScheduler(this.e, 30.0F, new CEOffscreenEGLRender.2(this));
    if (this.h)
    {
      Logger.a("CEOffscreenEGLRender", "startScheduleVSync ");
      this.d.a();
      this.i = true;
    }
  }
  
  private native long nInitRender();
  
  private native void nOnDrawFrame(long paramLong1, long paramLong2, String paramString);
  
  private native void nOnSurfaceChanged(long paramLong, Surface paramSurface, int paramInt1, int paramInt2);
  
  private native void nOnSurfaceCreated(long paramLong, Surface paramSurface, int paramInt1, int paramInt2);
  
  private native void nOnSurfaceDestroyed(long paramLong);
  
  private native void nRelease(long paramLong);
  
  public long a()
  {
    return nInitRender();
  }
  
  public void a(Surface paramSurface, int paramInt1, int paramInt2)
  {
    this.g.post(new CEOffscreenEGLRender.3(this, paramSurface, paramInt1, paramInt2));
  }
  
  public void b()
  {
    this.j = false;
    this.g.removeCallbacksAndMessages(null);
    this.g.getLooper().quitSafely();
    nRelease(this.c);
  }
  
  public void b(Surface paramSurface, int paramInt1, int paramInt2)
  {
    this.g.post(new CEOffscreenEGLRender.4(this, paramSurface, paramInt1, paramInt2));
  }
  
  public void c()
  {
    Logger.a("CEOffscreenEGLRender", "onResume ");
    this.h = true;
    if ((!this.i) && (this.d != null))
    {
      Logger.a("CEOffscreenEGLRender", "startScheduleVSync ");
      this.d.a();
      this.i = true;
    }
  }
  
  public void d()
  {
    Logger.a("CEOffscreenEGLRender", "onPause ");
    this.h = false;
    if (this.i)
    {
      Logger.a("CEOffscreenEGLRender", "stopScheduleVSync ");
      this.d.b();
      this.i = false;
    }
  }
  
  public void e()
  {
    this.j = false;
    this.g.post(new CEOffscreenEGLRender.5(this));
  }
  
  public void f()
  {
    if (!this.j) {
      return;
    }
    nOnDrawFrame(this.c, this.a.getNativeHandle(), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.offscreen.CEOffscreenEGLRender
 * JD-Core Version:    0.7.0.1
 */