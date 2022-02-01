package com.tencent.luggage.wxa.ng;

import android.content.Context;
import android.widget.Toast;
import com.tencent.luggage.util.i;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jo.e.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.qz.v.a;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;
import rx.functions.Action0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController;", "", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "eventHandler", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "videoCastHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;)V", "context", "Landroid/content/Context;", "currentPosMs", "", "interruptDetectorTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "interruptDetectorTimerInterrupted", "", "onDeviceSelectedListener", "Lkotlin/Function0;", "", "getOnDeviceSelectedListener", "()Lkotlin/jvm/functions/Function0;", "setOnDeviceSelectedListener", "(Lkotlin/jvm/functions/Function0;)V", "playRequestTimeOutTimer", "playRequestTimeOutTimerInterrupted", "postWhenPlayedAction", "progressTimer", "getProgressTimer", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "reportHelper", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "reportType", "getReportType", "()I", "setReportType", "(I)V", "selectDeviceBottomSheet", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "subEventListener", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$subEventListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$subEventListener$1;", "videoCastDeviceManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "destroy", "getProgressTimeMs", "getVolume", "action", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/Response;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/RequestedAction;", "handleBroadcast", "msg", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastController$Event;", "lookupDeviceStatus", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRState$PlayState;", "pause", "Lkotlin/ParameterName;", "name", "success", "play", "initSeekToMs", "reconnect", "searchDevice", "needCloseBottomSheet", "isSearchForSwitch", "seek", "moment", "", "sendMessage", "setVolume", "volume", "startInterruptDetector", "stop", "stopInterruptDetector", "stopTimers", "switch", "unSubscribeDeviceEvent", "Companion", "Event", "WXControlCallback", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class h
{
  public static final h.a a = new h.a(null);
  private int b;
  private final j c;
  private g d;
  private c e;
  private final Context f;
  @Nullable
  private Function0<Unit> g;
  private int h;
  private boolean i;
  private final v j;
  private Function0<Unit> k;
  private final h.x l;
  @NotNull
  private final v m;
  private boolean n;
  private final v o;
  private final com.tencent.luggage.wxa.fx.a p;
  private final com.tencent.luggage.wxa.ge.a q;
  private final com.tencent.luggage.wxa.nf.b r;
  
  public h(@NotNull com.tencent.luggage.wxa.fx.a parama, @NotNull com.tencent.luggage.wxa.ge.a parama1, @NotNull com.tencent.luggage.wxa.nf.b paramb)
  {
    this.p = parama;
    this.q = parama1;
    this.r = paramb;
    this.b = -1;
    this.c = new j();
    this.e = ((c)e.a(c.class));
    parama = this.p.b();
    Intrinsics.checkExpressionValueIsNotNull(parama, "invokeContext.context");
    this.f = parama;
    this.j = new v((v.a)new h.n(this), false);
    this.l = new h.x(this);
    this.m = new v((v.a)new h.o(this), true);
    this.o = new v((v.a)new h.h(this), true);
  }
  
  private final void a(h.b paramb)
  {
    try
    {
      Observable.empty().observeOn(com.tencent.luggage.wxa.jt.a.a()).doOnCompleted((Action0)new h.t(this, paramb)).subscribe();
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  private final void b(h.b paramb)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleBroadcast: ");
    ((StringBuilder)localObject1).append(paramb.a().name());
    o.d("MicroMsg.VideoCast.VideoCastController", ((StringBuilder)localObject1).toString());
    localObject1 = new h.g(this);
    Object localObject2 = paramb.a();
    int i1 = i.a[localObject2.ordinal()];
    int i2 = -1;
    switch (i1)
    {
    default: 
    case 7: 
      if (this.c.a().b() == e.a.b) {
        return;
      }
      this.q.a(false);
      ((h.g)localObject1).a(e.a.b);
      this.c.j();
      i1 = i2;
      if (paramb.b() != null)
      {
        i1 = i2;
        if ((paramb.b() instanceof Integer))
        {
          paramb = paramb.b();
          if (paramb != null) {
            i1 = ((Integer)paramb).intValue();
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
          }
        }
      }
      if (i1 == 3)
      {
        localObject2 = this.e;
        if (localObject2 != null)
        {
          paramb = this.c.a().a();
          if (paramb != null)
          {
            paramb = paramb.i;
            if (paramb != null) {}
          }
          else
          {
            paramb = "";
          }
          localObject1 = this.c.a().a();
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.luggage.wxa.jo.b)localObject1).h;
            if (localObject1 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          ((c)localObject2).a(false, paramb, (String)localObject1, i1);
        }
      }
      else if ((i1 != 5) && (i1 != 8))
      {
        if (i1 == 8)
        {
          paramb = this.e;
          if (paramb != null) {
            c.a.a(paramb, false, null, null, i1, 6, null);
          }
        }
      }
      else
      {
        paramb = this.e;
        if (paramb != null) {
          c.a.a(paramb, false, null, null, i1, 6, null);
        }
      }
      this.c.a().k();
      this.c.a().l();
      this.c.a().a(null);
      this.r.c(false);
      k();
      return;
    case 6: 
      if ((paramb.b() != null) && ((paramb.b() instanceof Boolean)))
      {
        paramb = paramb.b();
        if (paramb != null)
        {
          boolean bool = ((Boolean)paramb).booleanValue();
          paramb = new StringBuilder();
          paramb.append("Receive Action : Mute = ");
          paramb.append(bool);
          o.d("MicroMsg.VideoCast.VideoCastController", paramb.toString());
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
      }
      break;
    case 5: 
      if ((paramb.b() != null) && ((paramb.b() instanceof Integer)))
      {
        paramb = paramb.b();
        if (paramb != null)
        {
          i1 = ((Integer)paramb).intValue();
          paramb = new StringBuilder();
          paramb.append("Receive Action : Volume = ");
          paramb.append(i1);
          o.d("MicroMsg.VideoCast.VideoCastController", paramb.toString());
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
      }
      break;
    case 4: 
      this.c.a().a(e.a.b);
      ((h.g)localObject1).a(e.a.b);
      this.q.c();
      this.r.c(false);
      return;
    case 3: 
      this.c.a().a(e.a.e);
      ((h.g)localObject1).a(e.a.e);
      this.q.b();
      this.r.c(true);
      return;
    case 2: 
      this.c.a().a(e.a.d);
      g();
      ((h.g)localObject1).a(e.a.d);
      this.j.c();
      this.i = true;
      this.q.a();
      this.m.a(1000L);
      this.r.c(true);
      this.q.a(true);
      this.c.k();
      paramb = this.k;
      if (paramb != null)
      {
        if (paramb != null) {
          paramb = (Unit)paramb.invoke();
        }
        this.k = ((Function0)null);
      }
      i1 = this.b;
      if (i1 == 3)
      {
        localObject2 = this.e;
        if (localObject2 != null)
        {
          paramb = this.c.a().a();
          if (paramb != null)
          {
            paramb = paramb.i;
            if (paramb != null) {}
          }
          else
          {
            paramb = "";
          }
          localObject1 = this.c.a().a();
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.luggage.wxa.jo.b)localObject1).h;
            if (localObject1 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          ((c)localObject2).a(true, paramb, (String)localObject1, this.b);
        }
      }
      else if ((i1 != 5) && (i1 != 8))
      {
        if (i1 == 8)
        {
          paramb = this.e;
          if (paramb != null) {
            c.a.a(paramb, true, null, null, i1, 6, null);
          }
        }
      }
      else
      {
        paramb = this.e;
        if (paramb != null) {
          c.a.a(paramb, true, null, null, this.b, 6, null);
        }
      }
      this.b = -1;
    }
  }
  
  private final void i()
  {
    this.c.a().e((com.tencent.luggage.wxa.jq.a)new h.e(this));
  }
  
  private final void j()
  {
    this.c.a().k();
    this.c.a().l();
    this.c.a().a(null);
  }
  
  private final void k()
  {
    this.m.c();
    this.o.c();
    this.j.c();
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt2;
    this.i = false;
    e.a locala = this.c.a().b();
    Object localObject = new h.k(this, paramInt1);
    h.l locall = new h.l(this, (h.k)localObject, paramInt2);
    localObject = new h.m(this, (h.k)localObject, paramInt2);
    if (locala == e.a.e)
    {
      o.d("MicroMsg.VideoCast.VideoCastController", "play: continue");
      locall.a();
      this.q.d();
      return;
    }
    o.d("MicroMsg.VideoCast.VideoCastController", "play: playNew");
    ((h.m)localObject).a();
    this.q.d();
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "moment");
    this.c.a().b(paramString, (com.tencent.luggage.wxa.jq.a)new h.s(this, paramString));
  }
  
  public final void a(@Nullable Function0<Unit> paramFunction0)
  {
    this.g = paramFunction0;
  }
  
  public final void a(@NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    this.c.a().b((com.tencent.luggage.wxa.jq.a)new h.j(this, paramFunction1));
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    t.a((Runnable)new h.q(this, paramBoolean2, paramBoolean1));
    if (!paramBoolean2) {
      this.c.i();
    }
    this.c.a((Function0)new h.r(this));
    if (!i.b(r.a()))
    {
      Context localContext = this.f;
      Toast.makeText(localContext, (CharSequence)com.tencent.luggage.wxa.qx.a.c(localContext, 2131886904), 0).show();
      o.c("MicroMsg.VideoCast.VideoCastController", "searchDevice: wifi is not connected");
    }
    this.c.f();
  }
  
  @Nullable
  public final Function0<Unit> b()
  {
    return this.g;
  }
  
  public final void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVolume: ");
    localStringBuilder.append(paramInt);
    o.d("MicroMsg.VideoCast.VideoCastController", localStringBuilder.toString());
    this.c.a().a(paramInt, (com.tencent.luggage.wxa.jq.a)new h.u(this));
  }
  
  public final void b(@NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    this.c.a().c((com.tencent.luggage.wxa.jq.a)new h.w(this, paramFunction1));
  }
  
  @NotNull
  public final v c()
  {
    return this.m;
  }
  
  public final void c(@NotNull Function1<? super f<Integer>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    this.c.a().d((com.tencent.luggage.wxa.jq.a)new h.f(this, paramFunction1));
  }
  
  public final void d()
  {
    o.d("MicroMsg.VideoCast.VideoCastController", "onDestroy");
    t.a((Runnable)new h.d(this));
    j();
    this.m.c();
    this.c.i();
    h();
    this.j.c();
  }
  
  public final void e()
  {
    if (this.c.a().b() == e.a.d)
    {
      this.q.a(true);
      return;
    }
    this.c.a((Function1)new h.p(this));
  }
  
  public final void f()
  {
    a(false, true);
  }
  
  public final void g()
  {
    if (this.o.d())
    {
      this.n = false;
      this.o.a(5000L);
    }
  }
  
  public final void h()
  {
    if (this.o.d()) {
      return;
    }
    this.o.c();
    this.n = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h
 * JD-Core Version:    0.7.0.1
 */