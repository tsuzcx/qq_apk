package com.tencent.luggage.opensdk;

import android.os.Looper;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.qz.v.a;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.rm.a;
import com.tencent.luggage.wxa.ro.e.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/QRCodeTransferLongPullingConnect$Connector;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "env", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "uuid", "", "callback", "Lcom/tencent/luggage/opensdk/QRCodeTransferLongPullingConnect$LongPullingCallback;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;Ljava/lang/String;Lcom/tencent/luggage/opensdk/QRCodeTransferLongPullingConnect$LongPullingCallback;)V", "callbackRef", "Ljava/util/concurrent/atomic/AtomicReference;", "getCallbackRef$luggage_standalone_mode_ext_release", "()Ljava/util/concurrent/atomic/AtomicReference;", "envRef", "getEnvRef$luggage_standalone_mode_ext_release", "pullingTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getPullingTimer$luggage_standalone_mode_ext_release", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "scanned", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getScanned$luggage_standalone_mode_ext_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "state", "Lcom/tencent/luggage/opensdk/QRCodeTransferLongPullingConnect$PullingState;", "getState$luggage_standalone_mode_ext_release", "getUuid$luggage_standalone_mode_ext_release", "()Ljava/lang/String;", "dead", "", "keepPulling", "", "onTimerExpired", "releaseInternal", "startPulling", "startPulling$luggage_standalone_mode_ext_release", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class n$a
  implements v.a, a
{
  @NotNull
  private final AtomicReference<com.tencent.luggage.wxa.jx.h> a;
  @NotNull
  private final v b;
  @NotNull
  private final AtomicReference<n.b> c;
  @NotNull
  private final AtomicReference<n.c> d;
  @NotNull
  private final AtomicBoolean e;
  @NotNull
  private final String f;
  
  public n$a(@NotNull com.tencent.luggage.wxa.jx.h paramh, @NotNull String paramString, @NotNull n.b paramb)
  {
    this.f = paramString;
    this.a = new AtomicReference(paramh);
    this.b = new v(Looper.getMainLooper(), (v.a)this, true);
    this.c = new AtomicReference(paramb);
    this.d = new AtomicReference(n.c.a);
    this.e = new AtomicBoolean(false);
    paramh.q().a((a)this);
  }
  
  private final boolean g()
  {
    if (this.c.get() == null) {
      return false;
    }
    if ((n.c)this.d.get() == n.c.b) {
      return true;
    }
    this.d.set(n.c.b);
    com.tencent.luggage.wxa.ro.h.a().b((b)new n.a.a(this)).a((com.tencent.luggage.wxa.rp.d)com.tencent.luggage.wxa.rp.d.b, (e.c)new n.a.b(this));
    return true;
  }
  
  private final void h()
  {
    this.b.c();
    this.a.set(null);
    this.c.set(null);
  }
  
  public void a()
  {
    n.b localb = (n.b)this.c.get();
    if (localb != null) {
      localb.c();
    }
    h();
  }
  
  @NotNull
  public final AtomicReference<n.b> b()
  {
    return this.c;
  }
  
  @NotNull
  public final AtomicReference<n.c> c()
  {
    return this.d;
  }
  
  @NotNull
  public final AtomicBoolean d()
  {
    return this.e;
  }
  
  public final void e()
  {
    this.b.a(1000L, 3000L);
  }
  
  @NotNull
  public final String f()
  {
    return this.f;
  }
  
  public boolean p_()
  {
    return g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.n.a
 * JD-Core Version:    0.7.0.1
 */