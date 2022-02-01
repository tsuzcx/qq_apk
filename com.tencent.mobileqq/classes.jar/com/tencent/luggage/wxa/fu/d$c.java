package com.tencent.luggage.wxa.fu;

import android.app.Application;
import android.os.SystemClock;
import com.tencent.luggage.wxa.dc.w;
import com.tencent.luggage.wxa.ef.d.a;
import com.tencent.luggage.wxa.fq.m;
import com.tencent.luggage.wxa.fq.r;
import com.tencent.luggage.wxa.pd.u;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/luggage/wxaapi/internal/process/MainProcessStartup$loadLazyModulesGuarded$4$1"}, k=3, mv={1, 1, 16})
final class d$c
  extends Lambda
  implements Function0<Unit>
{
  d$c(Application paramApplication)
  {
    super(0);
  }
  
  public final void a()
  {
    long l1 = SystemClock.elapsedRealtime();
    w.a.b();
    Object localObject = Unit.INSTANCE;
    if ((localObject instanceof d.a))
    {
      localObject = ((d.a)localObject).a();
    }
    else
    {
      localObject = localObject.toString();
      if (localObject == null) {
        localObject = "";
      }
    }
    boolean bool = u.a();
    long l2 = SystemClock.elapsedRealtime() - l1;
    l1 = 32;
    if ((l2 > l1) && (bool))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("block main thread and skip ");
      localStringBuilder.append((int)(l2 / 16));
      localStringBuilder.append(" frames! runProfiled:log:");
      localStringBuilder.append("WxaTdiLoginBoot.boot");
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(' ');
      o.c("Luggage.Utils.Profile", localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("runProfiled:log:");
      localStringBuilder.append("WxaTdiLoginBoot.boot");
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(' ');
      o.d("Luggage.Utils.Profile", localStringBuilder.toString());
    }
    l2 = SystemClock.elapsedRealtime();
    r.a.a(this.a);
    t.a.a(this.a);
    m.a.a(this.a);
    localObject = Unit.INSTANCE;
    if ((localObject instanceof d.a))
    {
      localObject = ((d.a)localObject).a();
    }
    else
    {
      localObject = localObject.toString();
      if (localObject == null) {
        localObject = "";
      }
    }
    bool = u.a();
    l2 = SystemClock.elapsedRealtime() - l2;
    if ((l2 > l1) && (bool))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("block main thread and skip ");
      localStringBuilder.append((int)(l2 / 16));
      localStringBuilder.append(" frames! runProfiled:log:");
      localStringBuilder.append("installPeriodChecker");
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool);
      localStringBuilder.append(' ');
      o.c("Luggage.Utils.Profile", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("runProfiled:log:");
    localStringBuilder.append("installPeriodChecker");
    localStringBuilder.append(" cost ");
    localStringBuilder.append(l2);
    localStringBuilder.append(" ms result:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" isMainThread: ");
    localStringBuilder.append(bool);
    localStringBuilder.append(' ');
    o.d("Luggage.Utils.Profile", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fu.d.c
 * JD-Core Version:    0.7.0.1
 */