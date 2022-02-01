package com.tencent.luggage.wxa.bk;

import android.content.Context;
import com.tencent.luggage.wxa.bl.b;
import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ak;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.handler.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "", "androidContext", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "destroyTask", "Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "getJsRuntime", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "appbrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "awaitDestroyDone", "create", "destroy", "getJsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getMagicBrush", "getMagicBrushNullable", "getRawPointerOfJsRuntime", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "onAppBrandRuntimeReady", "onConfig", "onCreate", "costMs", "", "DestroyTask", "luggage-wxa-game-ext_release"}, k=1, mv={1, 1, 16})
public class g
{
  private volatile e a;
  private final f b;
  private final g.a c;
  private final Context d;
  @NotNull
  private final i e;
  
  public g(@NotNull Context paramContext, @NotNull i parami)
  {
    this.d = paramContext;
    this.e = parami;
    this.b = new f();
    this.c = new g.a((Function0)new g.b(this));
  }
  
  private final Function0<ak> a(i parami)
  {
    return (Function0)new g.c((u)parami.a(u.class));
  }
  
  private final a b(i parami)
  {
    parami = (q)parami.a(q.class);
    if (parami != null) {
      return (a)new c(parami);
    }
    throw ((Throwable)new IllegalStateException("JsRuntime don't support JsThread addon".toString()));
  }
  
  @Nullable
  public final e a()
  {
    return this.a;
  }
  
  protected void a(@NotNull com.tencent.luggage.wxa.iu.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "runtime");
    b.a.a((MBRuntime)this.a, paramd, true);
    Object localObject = paramd.A();
    if (localObject != null)
    {
      localObject = ((l)localObject).S;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.appbrand.appcache.af)localObject).md5;
        break label49;
      }
    }
    localObject = null;
    label49:
    if (!com.tencent.luggage.wxa.qz.af.c((String)localObject))
    {
      e locale = this.a;
      if (locale != null) {
        locale.a(paramd.aa(), (String)localObject);
      }
    }
    else
    {
      o.b("MicroMsg.MagicBrush", "onAppBrandRuntimeReady pkg md5 is null!!!");
    }
  }
  
  protected void a(@NotNull e parame, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(parame, "magicbrush");
  }
  
  protected void a(@NotNull f paramf)
  {
    Intrinsics.checkParameterIsNotNull(paramf, "builder");
    paramf.a(this.d);
    paramf.a(com.tencent.luggage.wxa.pc.g.a());
    paramf.a(a(this.e));
    paramf.a(b(this.e));
    paramf.a((Function1)g.d.a);
    String str = d.a();
    Intrinsics.checkExpressionValueIsNotNull(str, "MBConstants.DATAROOT_SDCARD_PATH()");
    paramf.a(str);
  }
  
  @NotNull
  public final e b()
  {
    e locale = this.a;
    if (locale == null) {
      Intrinsics.throwNpe();
    }
    return locale;
  }
  
  public final void b(@NotNull com.tencent.luggage.wxa.iu.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "runtime");
    a(paramd);
  }
  
  @NotNull
  public final e c()
  {
    long l = com.tencent.luggage.wxa.qz.af.b();
    a(this.b);
    e locale = this.b.a();
    if (locale == null) {
      Intrinsics.throwNpe();
    }
    for (;;)
    {
      try
      {
        if (this.a == null)
        {
          i = 1;
          if (i != 0)
          {
            this.a = locale;
            Unit localUnit = Unit.INSTANCE;
            a(locale, com.tencent.luggage.wxa.qz.af.c(l));
            return locale;
          }
          throw ((Throwable)new IllegalStateException("Check failed.".toString()));
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public final void d()
  {
    o.d("MicroMsg.MagicBrush", "destroy");
    ((m)this.e.a(m.class)).a((m.a)this.c);
  }
  
  public final void e()
  {
    o.d("MicroMsg.MagicBrush", "awaitDestroyDone");
    if (!this.c.a(5000L))
    {
      if (!com.tencent.luggage.wxa.qz.c.a) {
        return;
      }
      throw ((Throwable)new IllegalStateException("WAGame destroy timeout"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bk.g
 * JD-Core Version:    0.7.0.1
 */