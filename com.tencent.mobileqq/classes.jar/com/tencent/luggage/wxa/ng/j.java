package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jo.a.a;
import com.tencent.luggage.wxa.jp.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "", "()V", "<set-?>", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "currentSelectedDevice", "getCurrentSelectedDevice", "()Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "setCurrentSelectedDevice", "(Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;)V", "currentSelectedDevice$delegate", "Lkotlin/properties/ReadWriteProperty;", "deviceDataChanged", "Lkotlin/Function0;", "", "getDeviceDataChanged", "()Lkotlin/jvm/functions/Function0;", "setDeviceDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "deviceSearchEventListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$deviceSearchEventListener$1;", "dummyMRDevice", "recentDevices", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "getRecentDevices", "()Ljava/util/ArrayList;", "reconnectCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isReconnectSuccess", "getReconnectCallback", "()Lkotlin/jvm/functions/Function1;", "setReconnectCallback", "(Lkotlin/jvm/functions/Function1;)V", "reconnectListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$reconnectListener$1;", "scannedDevices", "getScannedDevices", "subscription", "Lrx/subscriptions/CompositeSubscription;", "getSubscription", "()Lrx/subscriptions/CompositeSubscription;", "clear", "playError", "playSuccess", "prepareAndSearchDevice", "reconnect", "callback", "search", "searchReleaseTimer", "onTimeOut", "tryInit", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class j
{
  public static final j.b b = new j.b(null);
  private final com.tencent.luggage.wxa.jo.c c = new com.tencent.luggage.wxa.jo.c(null);
  @NotNull
  private final ReadWriteProperty d;
  @NotNull
  private final ArrayList<e> e;
  @NotNull
  private final ArrayList<e> f;
  @Nullable
  private Function0<Unit> g;
  @NotNull
  private final CompositeSubscription h;
  @Nullable
  private Function1<? super Boolean, Unit> i;
  private final j.d j;
  private final j.c k;
  
  public j()
  {
    Object localObject = Delegates.INSTANCE;
    localObject = this.c;
    this.d = ((ReadWriteProperty)new j.a(localObject, localObject, this));
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.h = new CompositeSubscription();
    this.j = new j.d(this);
    this.k = new j.c(this);
  }
  
  private final void b(Function0<Unit> paramFunction0)
  {
    paramFunction0 = Observable.timer(10L, TimeUnit.SECONDS).subscribe((Action1)new j.g(this));
    this.h.add(paramFunction0);
  }
  
  private final boolean l()
  {
    try
    {
      com.tencent.luggage.wxa.jm.a.a("MicroMsg.VideoCast.", (com.tencent.luggage.wxa.jm.b)new j.h());
      h.a().b();
      com.tencent.luggage.wxa.jp.c.a().b();
      return true;
    }
    catch (com.tencent.luggage.wxa.js.a locala)
    {
      locala.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepareAndSearchDevice: RouterException = ");
      localStringBuilder.append(locala.getMessage());
      o.b("MicroMsg.VideoCast.VideoCastDeviceManager", localStringBuilder.toString());
    }
    return false;
  }
  
  @NotNull
  public final com.tencent.luggage.wxa.jo.c a()
  {
    return (com.tencent.luggage.wxa.jo.c)this.d.getValue(this, a[0]);
  }
  
  public final void a(@NotNull com.tencent.luggage.wxa.jo.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "<set-?>");
    this.d.setValue(this, a[0], paramc);
  }
  
  public final void a(@Nullable Function0<Unit> paramFunction0)
  {
    this.g = paramFunction0;
  }
  
  public final void a(@NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    try
    {
      this.h.clear();
      com.tencent.luggage.wxa.jo.a locala = com.tencent.luggage.wxa.jo.a.a();
      locala.c();
      Intrinsics.checkExpressionValueIsNotNull(locala, "deviceManager");
      localObject = locala.b().iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.jo.c localc = (com.tencent.luggage.wxa.jo.c)((Iterator)localObject).next();
        localc.k();
        localc.l();
        localc.a(null);
      }
      locala.b((a.a)this.k);
      locala.b((a.a)this.j);
      locala.d();
      try
      {
        h.a().c();
      }
      catch (com.tencent.luggage.wxa.js.a locala1)
      {
        locala1.printStackTrace();
      }
      com.tencent.luggage.wxa.jp.c.a().c();
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Error happen while cleaning up ");
      ((StringBuilder)localObject).append(localException.getMessage());
      o.b("MicroMsg.VideoCast.VideoCastDeviceManager", ((StringBuilder)localObject).toString());
    }
    if (!l())
    {
      o.d("MicroMsg.VideoCast.VideoCastDeviceManager", "reconnect: not enableRouter");
      return;
    }
    this.i = paramFunction1;
    com.tencent.luggage.wxa.jo.a.a().a((a.a)this.j);
    g();
    a(this, null, 1, null);
  }
  
  @NotNull
  public final ArrayList<e> b()
  {
    return this.e;
  }
  
  @NotNull
  public final ArrayList<e> c()
  {
    return this.f;
  }
  
  @Nullable
  public final Function0<Unit> d()
  {
    return this.g;
  }
  
  @NotNull
  public final CompositeSubscription e()
  {
    return this.h;
  }
  
  public final void f()
  {
    o.d("MicroMsg.VideoCast.VideoCastDeviceManager", "prepare");
    if (!l()) {
      return;
    }
    com.tencent.luggage.wxa.jo.a.a().a((a.a)this.k);
    g();
    a(this, null, 1, null);
  }
  
  public final void g()
  {
    String str1 = com.tencent.luggage.util.i.a();
    String str2 = com.tencent.luggage.util.i.a(r.a());
    boolean bool;
    if ((com.tencent.luggage.wxa.qz.i.c(str1)) && (com.tencent.luggage.wxa.qz.i.c(str2))) {
      bool = true;
    } else {
      bool = false;
    }
    o.d("MicroMsg.VideoCast.VideoCastDeviceManager", "searchDevice: selfIp = [%s], wifiIp = [%s], ipv6 = [%b]", new Object[] { str1, str2, Boolean.valueOf(bool) });
    this.h.add(Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS).take(10).observeOn(com.tencent.luggage.wxa.jt.a.a()).subscribe((Action1)new j.e(bool)));
  }
  
  @Nullable
  public final Function1<Boolean, Unit> h()
  {
    return this.i;
  }
  
  public final void i()
  {
    try
    {
      this.h.clear();
      this.f.clear();
      this.e.clear();
      com.tencent.luggage.wxa.jo.a locala = com.tencent.luggage.wxa.jo.a.a();
      locala.c();
      Intrinsics.checkExpressionValueIsNotNull(locala, "deviceManager");
      localObject = locala.b().iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.jo.c localc = (com.tencent.luggage.wxa.jo.c)((Iterator)localObject).next();
        localc.k();
        localc.l();
        localc.a(null);
      }
      locala.b((a.a)this.k);
      locala.b((a.a)this.j);
      locala.d();
      try
      {
        h.a().c();
      }
      catch (com.tencent.luggage.wxa.js.a locala1)
      {
        locala1.printStackTrace();
      }
      com.tencent.luggage.wxa.jp.c.a().c();
      return;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Error happen while cleaning up ");
      ((StringBuilder)localObject).append(localException.getMessage());
      o.b("MicroMsg.VideoCast.VideoCastDeviceManager", ((StringBuilder)localObject).toString());
    }
  }
  
  public final void j()
  {
    Iterator localIterator = ((Iterable)this.e).iterator();
    Object localObject2;
    e locale;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      localObject2 = null;
      if (!bool) {
        break;
      }
      locale = (e)localIterator.next();
      localObject1 = locale.d().a();
      if (localObject1 != null) {
        localObject1 = ((com.tencent.luggage.wxa.jo.b)localObject1).j;
      } else {
        localObject1 = null;
      }
      com.tencent.luggage.wxa.jo.b localb = a().a();
      if (localb != null) {
        localObject2 = localb.j;
      }
      if (Intrinsics.areEqual(localObject1, localObject2))
      {
        locale.c(false);
        locale.b(false);
        locale.a(true);
      }
    }
    localIterator = ((Iterable)this.f).iterator();
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.d().a();
      if (localObject1 != null) {
        localObject1 = ((com.tencent.luggage.wxa.jo.b)localObject1).j;
      } else {
        localObject1 = null;
      }
      localObject2 = a().a();
      if (localObject2 != null) {
        localObject2 = ((com.tencent.luggage.wxa.jo.b)localObject2).j;
      } else {
        localObject2 = null;
      }
      if (Intrinsics.areEqual(localObject1, localObject2))
      {
        locale.c(false);
        locale.b(false);
        locale.a(true);
      }
    }
    Object localObject1 = this.g;
    if (localObject1 != null) {
      localObject1 = (Unit)((Function0)localObject1).invoke();
    }
  }
  
  public final void k()
  {
    Iterator localIterator = ((Iterable)this.e).iterator();
    Object localObject2;
    e locale;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      localObject2 = null;
      if (!bool) {
        break;
      }
      locale = (e)localIterator.next();
      localObject1 = locale.d().a();
      if (localObject1 != null) {
        localObject1 = ((com.tencent.luggage.wxa.jo.b)localObject1).j;
      } else {
        localObject1 = null;
      }
      com.tencent.luggage.wxa.jo.b localb = a().a();
      if (localb != null) {
        localObject2 = localb.j;
      }
      if (Intrinsics.areEqual(localObject1, localObject2))
      {
        locale.c(false);
        locale.b(true);
        locale.a(true);
      }
    }
    localIterator = ((Iterable)this.f).iterator();
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      localObject1 = locale.d().a();
      if (localObject1 != null) {
        localObject1 = ((com.tencent.luggage.wxa.jo.b)localObject1).j;
      } else {
        localObject1 = null;
      }
      localObject2 = a().a();
      if (localObject2 != null) {
        localObject2 = ((com.tencent.luggage.wxa.jo.b)localObject2).j;
      } else {
        localObject2 = null;
      }
      if (Intrinsics.areEqual(localObject1, localObject2))
      {
        locale.c(false);
        locale.b(true);
        locale.a(true);
      }
    }
    Object localObject1 = this.g;
    if (localObject1 != null) {
      localObject1 = (Unit)((Function0)localObject1).invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.j
 * JD-Core Version:    0.7.0.1
 */