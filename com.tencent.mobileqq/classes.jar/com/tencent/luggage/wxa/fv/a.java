package com.tencent.luggage.wxa.fv;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.ilink.tdi.b.f;
import com.tencent.ilinkservice.ac;
import com.tencent.ilinkservice.ad;
import com.tencent.ilinkservice.ae;
import com.tencent.ilinkservice.ag.d;
import com.tencent.ilinkservice.ag.d.a;
import com.tencent.ilinkservice.ag.f;
import com.tencent.ilinkservice.ag.f.a;
import com.tencent.ilinkservice.ao;
import com.tencent.ilinkservice.aq;
import com.tencent.ilinkservice.y;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.fq.f;
import com.tencent.luggage.wxa.fq.g.c;
import com.tencent.luggage.wxa.fq.l;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/tdi/DemoILinkActivateDevice;", "Lcom/tencent/luggage/login/device/BaseActivateDevice;", "Lcom/tencent/luggage/login/device/IActivateDevice;", "()V", "CONST_ILINK_ID", "", "CONST_PRODUCTID", "", "STATE_INIT", "STATE_INIT_ING", "STATE_NOT_INIT", "TAG", "ilinkServiceCallback", "com/tencent/luggage/wxaapi/internal/tdi/DemoILinkActivateDevice$ilinkServiceCallback$1", "Lcom/tencent/luggage/wxaapi/internal/tdi/DemoILinkActivateDevice$ilinkServiceCallback$1;", "pendingLoginCallbacksQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/luggage/login/device/IActivateDevice$ILoginIlinkCallback;", "state", "tdiSession", "Lcom/tencent/ilinkservice/IlinkTdiSessionInterface;", "access", "", "createBaseInfo", "Lcom/tencent/ilinkservice/IlinkServiceProto$IlinkSmcBaseInfo;", "deviceLogin", "onComplete", "Lkotlin/Function1;", "", "deviceLogout", "clearIlinkAppIdStore", "getTdiCloneSession", "callback", "Lcom/tencent/luggage/login/device/IActivateDevice$ITdiCloneSessionCallback;", "getTdiSession", "getTdiSessionNullable", "hasInit", "init", "loginIlink", "needActivateDevice", "recreateTdiSession", "release", "removeCloneSession", "cloneSessionInterface", "Lcom/tencent/ilinkservice/IlinkTdiCloneSessionInterface;", "resetCloneTicket", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  extends com.tencent.luggage.wxa.dg.a
  implements com.tencent.luggage.wxa.dg.b
{
  public static final a c = new a();
  private static int d;
  private static final ConcurrentLinkedQueue<com.tencent.luggage.wxa.dg.b.a> e = new ConcurrentLinkedQueue();
  private static final a.c f = new a.c();
  private static volatile aq g;
  
  @JvmStatic
  public static final void h()
  {
    com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.dg.b.class, (com.tencent.luggage.wxa.ba.b)c);
    com.tencent.luggage.wxa.dg.d.a.e();
  }
  
  private final void j()
  {
    try
    {
      d = 0;
      ad.a().b((ac)f);
      g = (aq)null;
      Unit localUnit = Unit.INSTANCE;
      com.tencent.luggage.wxa.dc.w.a.b();
      return;
    }
    finally {}
  }
  
  private final ag.d k()
  {
    ag.d locald = ag.d.m().c(com.tencent.luggage.wxa.qv.a.e).b(com.tencent.luggage.wxa.qv.a.b).a(com.tencent.luggage.wxa.qv.a.c).e(r.d().getConfiguration().locale.getLanguage()).d(com.tencent.luggage.wxa.qv.a.f).c();
    Intrinsics.checkExpressionValueIsNotNull(locald, "IlinkServiceProto.IlinkS…ION)\n            .build()");
    return locald;
  }
  
  public void a(@Nullable ao paramao)
  {
    if (paramao != null) {
      ad.a().a(paramao);
    }
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.dg.b.a parama)
  {
    try
    {
      if (d == 1)
      {
        e.add(parama);
        return;
      }
      d = 1;
      Object localObject1 = Unit.INSTANCE;
      localObject1 = new d();
      ((d)localObject1).a(1901);
      ((d)localObject1).a(i.a.c());
      ((d)localObject1).b("hardcode_linkid");
      ((d)localObject1).c(g.c.a.a());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loginIlink, mock by ");
      ((StringBuilder)localObject2).append(localObject1);
      o.d("DemoILinkActivateDevice", ((StringBuilder)localObject2).toString());
      localObject2 = ag.f.w().a(1901).a("").b("").b(0).e(0);
      Object localObject3;
      if ((f.a.b()) && (com.tencent.luggage.wxa.fs.b.a.b()))
      {
        localObject3 = com.tencent.luggage.wxa.fs.b.a.c();
        o.e("DemoILinkActivateDevice", "debug IP is [%s]", new Object[] { localObject3 });
        ((ag.f.a)localObject2).c((String)localObject3);
      }
      localObject2 = ((ag.f.a)localObject2).f(1).c();
      try
      {
        ad.a().a((ac)f);
        ad.a().a(r.a(), (ag.f)localObject2);
        o.d("DemoILinkActivateDevice", "loginIlink, start ilink ok");
        o.b();
      }
      catch (Exception localException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("loginIlink, start ilink fail: ");
        ((StringBuilder)localObject3).append(localException);
        o.b("DemoILinkActivateDevice", ((StringBuilder)localObject3).toString());
        o.b();
      }
      ad.a().a((ae)new a.e());
      long l = af.b();
      y localy = ad.a().c();
      localy.a((com.tencent.ilinkservice.w)new a.d(l, parama, (d)localObject1));
      localy.a(f.a.b());
      localy.b();
      return;
    }
    finally {}
  }
  
  public final void a(@NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "onComplete");
    if (e())
    {
      paramFunction1.invoke(Boolean.valueOf(true));
      return;
    }
    com.tencent.luggage.wxa.dg.d.a.a(true).a((e.c)new a.a(paramFunction1)).a((e.a)new a.b(paramFunction1));
  }
  
  public final void a(boolean paramBoolean)
  {
    aq localaq = i();
    if (localaq != null)
    {
      localaq.a(b.f.b);
      localaq.d();
    }
    g.c.a.a(0L);
    if (paramBoolean) {
      e.a.clear();
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d() {}
  
  public boolean e()
  {
    try
    {
      int i = d;
      boolean bool;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Nullable
  public aq f()
  {
    if (g == null) {}
    for (;;)
    {
      try
      {
        if (g == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getTdiSession need create, state:");
          ((StringBuilder)localObject1).append(d);
          ((StringBuilder)localObject1).append(", stack:");
          ((StringBuilder)localObject1).append(Log.getStackTraceString(new Throwable()));
          o.d("DemoILinkActivateDevice", ((StringBuilder)localObject1).toString());
          localObject1 = e.a.a(g.c.a.a());
          CharSequence localCharSequence = (CharSequence)localObject1;
          if (localCharSequence == null) {
            break label255;
          }
          if (localCharSequence.length() != 0) {
            break label250;
          }
          break label255;
          if (i != 0)
          {
            o.b("DemoILinkActivateDevice", "getTdiSession return NULL by empty ilinkappid");
            return null;
          }
          if (!l.a.b())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getTdiSession WxaDynamicPkgMgr.isLoaded()==false ");
            ((StringBuilder)localObject1).append(Log.getStackTraceString(new Throwable()));
            o.c("DemoILinkActivateDevice", ((StringBuilder)localObject1).toString());
            return null;
          }
          g = ad.a().a((String)localObject1);
          localObject1 = g;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((aq)localObject1).a(c.a());
          localObject1 = g;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((aq)localObject1).a(c.k());
        }
        Object localObject1 = Unit.INSTANCE;
      }
      finally {}
      return g;
      label250:
      int i = 0;
      continue;
      label255:
      i = 1;
    }
  }
  
  public void g() {}
  
  @Nullable
  public final aq i()
  {
    aq localaq = (aq)new b((a)this).get();
    if (localaq != null) {
      return localaq;
    }
    try
    {
      localaq = (aq)new c(c).get();
      return localaq;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.a
 * JD-Core Version:    0.7.0.1
 */