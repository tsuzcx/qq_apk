package com.tencent.magicbrush;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.AnyThread;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService.c;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.luggage.wxa.gk.e;
import com.tencent.luggage.wxa.gk.f;
import com.tencent.magicbrush.handler.JsTouchEventHandler.a;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.magicbrush.internal.EventDispatcher;
import com.tencent.magicbrush.ui.MBViewManager;
import java.nio.ByteBuffer;

public abstract class MBRuntime
{
  protected volatile long a;
  protected MBRuntime.MBParams b;
  protected IMBFileSystem c = null;
  protected BaseImageDecodeService d = null;
  protected IMBFontHandler e = null;
  protected c f = null;
  protected com.tencent.magicbrush.ui.a g;
  private MBRuntime.a h = null;
  private com.tencent.magicbrush.handler.b i = null;
  private volatile com.tencent.magicbrush.handler.c j;
  private d k = new d(this);
  private int l = 0;
  
  static
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "enter static block", new Object[0]);
    com.tencent.luggage.wxa.gi.b.a();
  }
  
  private void a(int paramInt)
  {
    if (paramInt >= 0) {
      return;
    }
    throw new IllegalArgumentException("windowId < 0");
  }
  
  private boolean a(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return false;
    }
    paramRunnable = new e(paramRunnable);
    if (!b(paramRunnable)) {
      return false;
    }
    paramRunnable.a(paramLong);
    return paramRunnable.b();
  }
  
  private native void nativeMarkNeedCallbackBeforeSwapThisFrame(long paramLong);
  
  private native void nativeOnAppBrandRuntimeReady(long paramLong, String paramString1, String paramString2);
  
  private native void nativeRunOnJsThread(long paramLong, int paramInt);
  
  private native void nativeSetIsCpuProfiling(long paramLong, boolean paramBoolean);
  
  private void p()
  {
    this.d = null;
    this.e = null;
  }
  
  Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.a == 0L) {
      return null;
    }
    if (paramBoolean) {
      return nativeCaptureScreen(this.a, paramInt1);
    }
    return nativeCaptureCanvas(this.a, paramInt2);
  }
  
  @MainThread
  protected void a()
  {
    if (this.b.enable_request_animation_frame) {
      this.g = com.tencent.magicbrush.ui.a.a(this, this.j, l().animationFrameHandlerStrategy);
    }
    if (this.e == null)
    {
      this.e = new i();
      nativeSetFontHandler(this.a, this.e);
    }
    if (this.j != null)
    {
      if (this.d != null)
      {
        if (this.e != null)
        {
          if (this.a == 0L)
          {
            c.c.b("MicroMsg.MagicBrush.MBRuntime", "init. mNativeInst == 0", new Object[0]);
            return;
          }
          a(new MBRuntime.1(this));
          return;
        }
        throw new IllegalStateException("[MBRuntime] FontHandler not registered.");
      }
      throw new IllegalStateException("[MBRuntime] ImageHandler not registered.");
    }
    throw new IllegalStateException("[MBRuntime] JsThreadHandler not registered.");
  }
  
  public void a(double paramDouble)
  {
    if (this.a == 0L) {
      return;
    }
    nativeNotifyAnimationFrame(this.a, paramDouble);
  }
  
  @MainThread
  public void a(int paramInt, long paramLong, @NonNull JsTouchEventHandler.a parama)
  {
    if (this.a == 0L)
    {
      parama.a(paramLong);
      return;
    }
    com.tencent.magicbrush.handler.c localc = this.j;
    if (localc == null)
    {
      parama.a(paramLong);
      return;
    }
    localc.a(new MBRuntime.4(this, parama, paramLong, paramInt));
  }
  
  @MainThread
  public void a(int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3)
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged ", new Object[0]);
    a(paramInt1);
    b(new MBRuntime.14(this, paramSurfaceTexture, paramInt1, paramInt2, paramInt3));
  }
  
  @MainThread
  public void a(int paramInt1, SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowAvailable windowId:%d %s", new Object[] { Integer.valueOf(paramInt1), paramSurfaceTexture });
    if (paramInt1 >= 0)
    {
      b(new MBRuntime.10(this, paramSurfaceTexture, paramInt1, paramInt2, paramInt3, paramBoolean));
      return;
    }
    throw new IllegalArgumentException("windowId < 0");
  }
  
  @MainThread
  public void a(int paramInt, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowDestroyed shouldDestroySync: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.a == 0L) {
      return;
    }
    a(paramInt);
    MBRuntime.2 local2 = new MBRuntime.2(this, paramInt, paramSurfaceTexture);
    if (paramBoolean)
    {
      paramBoolean = this.b.sync_surface_destroy;
      c.c.b("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) param:true windowId:%d sync?%b %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramSurfaceTexture });
      if (paramBoolean) {
        a(local2, 3000L);
      } else {
        b(local2);
      }
      c.c.b("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) done. windowId:%d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surfacetexture) runOnJsThreadIgnorePause windowId:%d %s", new Object[] { Integer.valueOf(paramInt), paramSurfaceTexture });
    b(local2);
  }
  
  @MainThread
  public void a(int paramInt1, Surface paramSurface, int paramInt2, int paramInt3)
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "hy: notifyWindowAvailable: %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramSurface != null)
    {
      b(new MBRuntime.13(this, paramInt1, paramSurface, paramInt2, paramInt3));
      return;
    }
    throw new RuntimeException("surface == null");
  }
  
  public void a(int paramInt, Surface paramSurface, boolean paramBoolean)
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "hy: notifyWindowDestroyed: %d", new Object[] { Integer.valueOf(paramInt) });
    a(paramInt);
    if ((!this.b.sync_surface_destroy) && (!paramBoolean)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    paramSurface = new MBRuntime.3(this, paramInt);
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "[surface] destroy window(surface) windowId:%d sync?%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (!a(paramSurface, 3000L)) {
        c.c.c("MicroMsg.MagicBrush.MBRuntime", "notifyWindowDestroyed, but await fail. [deadlock]:    %s", new Object[] { o().b() });
      }
    }
    else {
      b(paramSurface);
    }
  }
  
  public void a(BaseImageDecodeService paramBaseImageDecodeService)
  {
    this.d = paramBaseImageDecodeService;
    nativeSetImageHandler(this.a, paramBaseImageDecodeService);
  }
  
  void a(MBRuntime.a parama)
  {
    this.h = parama;
    nativeMarkNeedCallbackBeforeSwapThisFrame(this.a);
  }
  
  public void a(@NonNull com.tencent.magicbrush.handler.a parama)
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.set_jsthread_handler ", new Object[0]);
    if (this.j != null)
    {
      c.c.c("MicroMsg.MagicBrush.MBRuntime", "Why you set_jsthread_handler twice, unexpected behaviour.", new Object[0]);
      return;
    }
    this.j = new com.tencent.magicbrush.handler.c(this.a, parama);
  }
  
  public void a(com.tencent.magicbrush.handler.b paramb)
  {
    this.i = paramb;
  }
  
  public void a(IMBFontHandler paramIMBFontHandler)
  {
    this.e = paramIMBFontHandler;
    nativeSetFontHandler(this.a, paramIMBFontHandler);
  }
  
  @AnyThread
  public void a(@Nullable String paramString, @Nullable Object paramObject, @NonNull IImageDecodeService.c paramc, ImageDecodeConfig paramImageDecodeConfig)
  {
    if (this.a == 0L)
    {
      paramc.a(paramString, paramObject);
      return;
    }
    com.tencent.magicbrush.handler.c localc = this.j;
    if (localc == null)
    {
      paramc.a(paramString, paramObject);
      return;
    }
    localc.a(new MBRuntime.5(this, paramc, paramString, paramObject, paramImageDecodeConfig));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a == 0L) {
      return;
    }
    nativeOnAppBrandRuntimeReady(this.a, paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a == 0L) {
      return;
    }
    nativeSetIsCpuProfiling(this.a, paramBoolean);
  }
  
  protected boolean a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    if (this.a == 0L) {
      return false;
    }
    com.tencent.magicbrush.handler.c localc = this.j;
    if (localc == null) {
      return false;
    }
    localc.a(new MBRuntime.11(this, paramRunnable));
    return true;
  }
  
  @AnyThread
  @Keep
  protected void applyWindowAttributes(int paramInt, boolean paramBoolean)
  {
    f.a(new MBRuntime.6(this, paramInt, paramBoolean));
  }
  
  public void b()
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.resume ", new Object[0]);
    this.k.a();
    b(new MBRuntime.8(this));
  }
  
  @MainThread
  public void b(int paramInt1, Surface paramSurface, int paramInt2, int paramInt3)
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.notifyWindowChanged Surface[%s] %d, %d", new Object[] { paramSurface, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    a(paramInt1);
    b(new MBRuntime.15(this, paramSurface, paramInt1, paramInt2, paramInt3));
  }
  
  protected boolean b(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    if (this.a == 0L) {
      return false;
    }
    com.tencent.magicbrush.handler.c localc = this.j;
    if (localc == null) {
      return false;
    }
    localc.a(new MBRuntime.12(this, paramRunnable), true);
    return true;
  }
  
  @Keep
  protected void beforeSwap(boolean paramBoolean)
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "hy: beforeSwap! %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MBRuntime.a locala = this.h;
    if (locala != null) {
      locala.a(paramBoolean);
    }
  }
  
  public void c()
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.pause ", new Object[0]);
    this.k.b();
    b(new MBRuntime.9(this));
  }
  
  @Keep
  @Nullable
  protected Bitmap captureScreen(int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    return j().a(paramInt1, paramInt2, paramInt3, paramBitmap);
  }
  
  public void d()
  {
    if (this.a == 0L) {
      return;
    }
    nativeNotifyAnimationFrameLooper(this.a);
  }
  
  @AnyThread
  @Keep
  protected void delayLoadLibrary(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hy: delayLoadLibrary ");
    localStringBuilder.append(paramString);
    c.c.b("MicroMsg.MagicBrush.MBRuntime", localStringBuilder.toString(), new Object[0]);
    com.tencent.luggage.wxa.gi.b.a(paramString);
  }
  
  @Keep
  protected boolean doInnerLoopTask()
  {
    if (this.j != null) {
      return this.j.d();
    }
    return true;
  }
  
  public void e()
  {
    if (this.a == 0L) {
      return;
    }
    nativeStopAnimationFrameLooper(this.a);
  }
  
  @AnyThread
  public void f()
  {
    c localc = this.f;
    if (localc != null)
    {
      localc.a();
      this.f = null;
    }
  }
  
  public void g()
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy", new Object[0]);
    this.k.b();
    if (this.a == 0L)
    {
      c.c.b("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy skip outside", new Object[0]);
      return;
    }
    long l1 = System.currentTimeMillis();
    f();
    try
    {
      if (this.a == 0L)
      {
        c.c.b("MicroMsg.MagicBrush.MBRuntime", "MBRuntime.destroy skip inside, lock [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        return;
      }
      if (this.b.enable_request_animation_frame) {
        this.g.e();
      }
      nativeDestroy(this.a);
      this.j = null;
      p();
      this.a = 0L;
      return;
    }
    finally {}
  }
  
  @Keep
  protected String[] getAsyncableJsApis()
  {
    c.c.b("MicroMsg.MagicBrush.MBRuntime", "hy: trigger get asyncable jsapis", new Object[0]);
    try
    {
      if (this.i != null) {
        return this.i.a();
      }
      c.c.c("MicroMsg.MagicBrush.MBRuntime", "hy: invoke handler not set!", new Object[0]);
      return null;
    }
    catch (Throwable localThrowable)
    {
      c.c.a("MicroMsg.MagicBrush.MBRuntime", localThrowable, "hy: get acyncable jsapis failed!", new Object[0]);
    }
    return null;
  }
  
  public BaseImageDecodeService h()
  {
    return this.d;
  }
  
  public IMBFontHandler i()
  {
    return this.e;
  }
  
  abstract b j();
  
  abstract MBViewManager k();
  
  @NonNull
  public MBRuntime.MBParams l()
  {
    return this.b;
  }
  
  @AnyThread
  @NonNull
  public a m()
  {
    return n().d();
  }
  
  @NonNull
  public d n()
  {
    return this.k;
  }
  
  protected native void nativeBindTo(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  protected native Bitmap nativeCaptureCanvas(long paramLong, int paramInt);
  
  protected native Bitmap nativeCaptureScreen(long paramLong, int paramInt);
  
  protected native long nativeCreate(@NonNull MBRuntime.MBParams paramMBParams);
  
  protected native void nativeDestroy(long paramLong);
  
  @AnyThread
  native void nativeDestroyExternalTexture(long paramLong, int paramInt);
  
  @AnyThread
  native float[] nativeGetCurrentFps(long paramLong);
  
  @AnyThread
  native int nativeGetFrameCounter(long paramLong);
  
  protected native void nativeInit(long paramLong);
  
  @Keep
  protected String nativeInvokeHandler(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    com.tencent.magicbrush.handler.b localb = this.i;
    if (localb != null) {
      try
      {
        paramString1 = localb.a(paramString1, paramString2, paramInt, paramBoolean);
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        c.c.a("MicroMsg.MagicBrush.MBRuntime", paramString1, "hy: crash when invoke jsapi!", new Object[0]);
        throw paramString1;
      }
    }
    c.c.c("MicroMsg.MagicBrush.MBRuntime", "hy: no native invoke handler", new Object[0]);
    return "";
  }
  
  protected native void nativeLazyLoadBox2D(long paramLong, String paramString);
  
  protected native void nativeLazyLoadPhysx(long paramLong, String paramString);
  
  protected native void nativeNotifyAnimationFrame(long paramLong, double paramDouble);
  
  protected native void nativeNotifyAnimationFrameLooper(long paramLong);
  
  protected native void nativeNotifyImageDecoded(long paramLong, String paramString, Object paramObject, ImageDecodeConfig paramImageDecodeConfig);
  
  protected native void nativeNotifyTouchEvent(long paramLong1, int paramInt, long paramLong2);
  
  protected native void nativeNotifyWindowAvailable(long paramLong, int paramInt1, @NonNull SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3, boolean paramBoolean);
  
  protected native void nativeNotifyWindowAvailableForSurface(long paramLong, int paramInt1, @NonNull Surface paramSurface, int paramInt2, int paramInt3);
  
  protected native void nativeNotifyWindowChanged(long paramLong, int paramInt1, @NonNull SurfaceTexture paramSurfaceTexture, int paramInt2, int paramInt3);
  
  protected native void nativeNotifyWindowChangedForSurface(long paramLong, int paramInt1, @NonNull Surface paramSurface, int paramInt2, int paramInt3);
  
  protected native void nativeNotifyWindowDestroyed(long paramLong, int paramInt);
  
  protected native void nativePause(long paramLong);
  
  protected native void nativeResume(long paramLong);
  
  protected native void nativeSetEventListener(long paramLong, EventDispatcher paramEventDispatcher);
  
  protected native void nativeSetFontHandler(long paramLong, @NonNull IMBFontHandler paramIMBFontHandler);
  
  protected native void nativeSetImageHandler(long paramLong, @NonNull IImageDecodeService paramIImageDecodeService);
  
  protected native void nativeStopAnimationFrameLooper(long paramLong);
  
  public com.tencent.magicbrush.handler.c o()
  {
    return this.j;
  }
  
  @Keep
  protected ByteBuffer readWeAppFile(String paramString)
  {
    com.tencent.magicbrush.handler.b localb = this.i;
    if (localb != null) {
      return localb.a(paramString);
    }
    return null;
  }
  
  @Keep
  protected void resumeLoopTasks()
  {
    if (this.j != null) {
      this.j.c();
    }
  }
  
  @AnyThread
  @Keep
  protected void switchToJsThread(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchToJsThread taskId: ");
    localStringBuilder.append(paramInt);
    c.c.b("MicroMsg.MagicBrush.MBRuntime", localStringBuilder.toString(), new Object[0]);
    if (this.j != null) {
      try
      {
        this.j.b(new MBRuntime.7(this, paramInt));
        return;
      }
      catch (Throwable localThrowable)
      {
        c.c.a("MicroMsg.MagicBrush.MBRuntime", localThrowable, "hy: switchToJsThread crash!", new Object[0]);
        throw localThrowable;
      }
    }
    c.c.c("MicroMsg.MagicBrush.MBRuntime", "hy: switchToJsThread no js thread handler", new Object[0]);
  }
  
  @Keep
  protected void touchJava()
  {
    this.l += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.MBRuntime
 * JD-Core Version:    0.7.0.1
 */