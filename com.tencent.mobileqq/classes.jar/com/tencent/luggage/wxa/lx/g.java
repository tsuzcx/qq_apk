package com.tencent.luggage.wxa.lx;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.ob.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkTypeWxa;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType;", "Lcom/tencent/mm/plugin/appbrand/networking/IOnNetworkStateChanged;", "()V", "mCached", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/JsApiGetNetworkType$NetworkType;", "mCanUseCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mNetworkServiceInitialized", "getNetworkType", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "onNetworkStateChanged", "", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class g
  extends f
  implements com.tencent.luggage.wxa.ob.f
{
  @Deprecated
  public static final g.a a = new g.a(null);
  private final AtomicReference<f.c> b = new AtomicReference(null);
  private final AtomicBoolean c = new AtomicBoolean(false);
  private final AtomicBoolean d = new AtomicBoolean(false);
  
  @NotNull
  protected f.c a(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "component");
    Object localObject;
    if (!this.c.getAndSet(true))
    {
      localObject = (e)paramc.a(e.class);
      if (localObject != null)
      {
        ((e)localObject).a((com.tencent.luggage.wxa.ob.f)this);
        this.d.set(true);
      }
    }
    if (this.d.get())
    {
      localObject = (f.c)this.b.get();
      if (localObject != null) {
        return localObject;
      }
      paramc = super.a(paramc);
      this.b.set(paramc);
      Intrinsics.checkExpressionValueIsNotNull(paramc, "super.getNetworkType(com…mCached.set(fromSystem) }");
      return paramc;
    }
    paramc = super.a(paramc);
    Intrinsics.checkExpressionValueIsNotNull(paramc, "super.getNetworkType(component)");
    return paramc;
  }
  
  public void c()
  {
    this.b.set(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.g
 * JD-Core Version:    0.7.0.1
 */