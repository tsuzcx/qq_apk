package com.tencent.magicbrush;

import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.luggage.wxa.gk.c;
import com.tencent.magicbrush.handler.a;
import com.tencent.magicbrush.internal.EventDispatcher;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.mm.appbrand.v8.BufferURLManager;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MagicBrush;", "Lcom/tencent/magicbrush/MBRuntime;", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "(Lcom/tencent/magicbrush/MagicBrushBuilder;)V", "bufferURLManager", "Lcom/tencent/mm/appbrand/v8/BufferURLManager;", "getBufferURLManager", "()Lcom/tencent/mm/appbrand/v8/BufferURLManager;", "canvasHandler", "Lcom/tencent/magicbrush/MBCanvasHandler;", "getCanvasHandler", "()Lcom/tencent/magicbrush/MBCanvasHandler;", "config", "Lcom/tencent/magicbrush/MagicBrushConfig;", "getConfig", "()Lcom/tencent/magicbrush/MagicBrushConfig;", "firstFrameListeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/MagicBrush$FirstFrameListener;", "getFirstFrameListeners", "()Lcom/tencent/magicbrush/utils/ListenerList;", "jsStuffListeners", "Lcom/tencent/magicbrush/MagicBrush$JSStuffListener;", "getJSStuffListeners", "viewManager", "Lcom/tencent/magicbrush/ui/MBViewManager;", "getViewManager", "()Lcom/tencent/magicbrush/ui/MBViewManager;", "bindTo", "", "fn", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "isolatePtr", "", "contextPtr", "uvLoopPtr", "destroy", "lazyLoadBox2D", "lazyLoadPhysx", "setAnimationFrameHandler", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "Companion", "FirstFrameListener", "ImageDecodeListener", "JSStuffListener", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class e
  extends MBRuntime
{
  public static final e.a h = new e.a(null);
  @NotNull
  private final g i;
  @NotNull
  private final BufferURLManager j;
  @NotNull
  private final c<e.d> k;
  @NotNull
  private final c<e.b> l;
  @NotNull
  private final MBViewManager m;
  @NotNull
  private final b n;
  
  private e(f paramf)
  {
    this.i = ((g)paramf);
    this.j = new BufferURLManager();
    this.k = new c();
    this.l = new c();
    this.m = new MBViewManager();
    this.n = new b(this);
    this.b = paramf.s();
    this.a = nativeCreate(this.b);
    nativeSetEventListener(this.a, new EventDispatcher(this));
    Object localObject = paramf.c();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    a((a)localObject);
    localObject = paramf.k();
    if (localObject != null) {
      ((BaseImageDecodeService)localObject).addDecodeEventListener((IImageDecodeService.b)new e.c(this));
    }
    a((BaseImageDecodeService)localObject);
    a(paramf.l());
    a();
    paramf = paramf.d();
    if (paramf == null) {
      Intrinsics.throwNpe();
    }
    a(paramf);
    paramf = (CharSequence)this.i.q();
    int i2 = 0;
    int i1;
    if ((paramf != null) && (paramf.length() != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0) {
      v();
    }
    paramf = (CharSequence)this.i.r();
    if (paramf != null)
    {
      i1 = i2;
      if (paramf.length() != 0) {}
    }
    else
    {
      i1 = 1;
    }
    if (i1 == 0) {
      w();
    }
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3)
  {
    a((Function0)new e.f(paramLong1, paramLong2, paramLong3));
  }
  
  public final void a(@NotNull Function0<ak> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "fn");
    a((Runnable)new e.e(this, paramFunction0));
  }
  
  public void g()
  {
    c.c.b("MagicBrush", "MagicBrush is destroying...", new Object[0]);
    super.g();
    this.m.clear$lib_magicbrush_nano_release();
    this.k.a();
    this.l.a();
    this.j.a();
    c.c.b("MagicBrush", "MagicBrush is destroying...[done]", new Object[0]);
  }
  
  @NotNull
  protected b j()
  {
    return this.n;
  }
  
  @NotNull
  protected MBViewManager k()
  {
    return this.m;
  }
  
  @NotNull
  public final g p()
  {
    return this.i;
  }
  
  @NotNull
  public final BufferURLManager q()
  {
    return this.j;
  }
  
  @JvmName(name="getJSStuffListeners")
  @NotNull
  public final c<e.d> r()
  {
    return this.k;
  }
  
  @NotNull
  public final c<e.b> s()
  {
    return this.l;
  }
  
  @NotNull
  public final MBViewManager t()
  {
    return this.m;
  }
  
  @NotNull
  public final b u()
  {
    return this.n;
  }
  
  public final void v()
  {
    a((Runnable)new e.g(this));
  }
  
  public final void w()
  {
    a((Runnable)new e.h(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.e
 * JD-Core Version:    0.7.0.1
 */