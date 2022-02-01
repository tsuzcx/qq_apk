package com.tencent.luggage.wxa.fu;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.dj.a.a;
import com.tencent.luggage.wxa.ef.d.a;
import com.tencent.luggage.wxa.fq.l;
import com.tencent.luggage.wxa.fq.s;
import com.tencent.luggage.wxa.fr.b;
import com.tencent.luggage.wxa.nk.d;
import com.tencent.luggage.wxa.pd.u;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.keylogger.e;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/process/CommonProcessStartup;", "Lcom/tencent/luggage/wxaapi/internal/process/ProcessStartup;", "()V", "initialize", "", "context", "Landroid/content/Context;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public abstract class a
  implements f
{
  @CallSuper
  public void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Object localObject1;
    if ((paramContext instanceof Application))
    {
      localObject1 = (Application)paramContext;
    }
    else
    {
      paramContext = paramContext.getApplicationContext();
      if (paramContext == null) {
        break label1259;
      }
      localObject1 = (Application)paramContext;
    }
    long l2 = SystemClock.elapsedRealtime();
    com.tencent.luggage.wxa.hz.a.a("wxa");
    long l1 = SystemClock.elapsedRealtime();
    paramContext = r.c();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "MMApplicationContext.getProcessName()");
    s.a(StringsKt.replace$default(paramContext, ":", "_", false, 4, null));
    paramContext = Unit.INSTANCE;
    if ((paramContext instanceof d.a))
    {
      paramContext = ((d.a)paramContext).a();
    }
    else
    {
      paramContext = paramContext.toString();
      if (paramContext == null) {
        paramContext = "";
      }
    }
    boolean bool1 = u.a();
    long l3 = SystemClock.elapsedRealtime() - l1;
    l1 = 32;
    if ((l3 > l1) && (bool1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("block main thread and skip ");
      ((StringBuilder)localObject2).append((int)(l3 / 16));
      ((StringBuilder)localObject2).append(" frames! runProfiled:log:");
      ((StringBuilder)localObject2).append("XLogSetup-LogImp");
      ((StringBuilder)localObject2).append(" cost ");
      ((StringBuilder)localObject2).append(l3);
      ((StringBuilder)localObject2).append(" ms result:");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(" isMainThread: ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(' ');
      o.c("Luggage.Utils.Profile", ((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("runProfiled:log:");
      ((StringBuilder)localObject2).append("XLogSetup-LogImp");
      ((StringBuilder)localObject2).append(" cost ");
      ((StringBuilder)localObject2).append(l3);
      ((StringBuilder)localObject2).append(" ms result:");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(" isMainThread: ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(' ');
      o.d("Luggage.Utils.Profile", ((StringBuilder)localObject2).toString());
    }
    l3 = SystemClock.elapsedRealtime();
    paramContext = r.c();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "processName");
    paramContext = (CharSequence)paramContext;
    if ((StringsKt.contains$default(paramContext, (CharSequence)":wxa_container", false, 2, null)) || (StringsKt.contains$default(paramContext, (CharSequence)"com.tencent.ilink", false, 2, null)) || (com.tencent.luggage.wxa.fq.f.a.b())) {
      b.a.a();
    }
    Object localObject2 = Unit.INSTANCE;
    bool1 = localObject2 instanceof d.a;
    if (bool1)
    {
      paramContext = ((d.a)localObject2).a();
    }
    else
    {
      paramContext = localObject2.toString();
      if (paramContext == null) {
        paramContext = "";
      }
    }
    boolean bool2 = u.a();
    l3 = SystemClock.elapsedRealtime() - l3;
    StringBuilder localStringBuilder;
    if ((l3 > l1) && (bool2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("block main thread and skip ");
      localStringBuilder.append((int)(l3 / 16));
      localStringBuilder.append(" frames! runProfiled:log:");
      localStringBuilder.append("XLogSetup-Crash");
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l3);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(' ');
      o.c("Luggage.Utils.Profile", localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("runProfiled:log:");
      localStringBuilder.append("XLogSetup-Crash");
      localStringBuilder.append(" cost ");
      localStringBuilder.append(l3);
      localStringBuilder.append(" ms result:");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(" isMainThread: ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(' ');
      o.d("Luggage.Utils.Profile", localStringBuilder.toString());
    }
    if (bool1)
    {
      paramContext = ((d.a)localObject2).a();
    }
    else
    {
      paramContext = localObject2.toString();
      if (paramContext == null) {
        paramContext = "";
      }
    }
    bool1 = u.a();
    l2 = SystemClock.elapsedRealtime() - l2;
    if ((l2 > l1) && (bool1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("block main thread and skip ");
      ((StringBuilder)localObject2).append((int)(l2 / 16));
      ((StringBuilder)localObject2).append(" frames! runProfiled:log:");
      ((StringBuilder)localObject2).append("XLogSetup-ALL");
      ((StringBuilder)localObject2).append(" cost ");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(" ms result:");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(" isMainThread: ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(' ');
      o.c("Luggage.Utils.Profile", ((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("runProfiled:log:");
      ((StringBuilder)localObject2).append("XLogSetup-ALL");
      ((StringBuilder)localObject2).append(" cost ");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(" ms result:");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(" isMainThread: ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(' ');
      o.d("Luggage.Utils.Profile", ((StringBuilder)localObject2).toString());
    }
    l2 = SystemClock.elapsedRealtime();
    l.a.a((Context)localObject1);
    paramContext = Unit.INSTANCE;
    if ((paramContext instanceof d.a))
    {
      paramContext = ((d.a)paramContext).a();
    }
    else
    {
      paramContext = paramContext.toString();
      if (paramContext == null) {
        paramContext = "";
      }
    }
    bool1 = u.a();
    l2 = SystemClock.elapsedRealtime() - l2;
    if ((l2 > l1) && (bool1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("block main thread and skip ");
      ((StringBuilder)localObject1).append((int)(l2 / 16));
      ((StringBuilder)localObject1).append(" frames! runProfiled:log:");
      ((StringBuilder)localObject1).append("WxaDynamicPkgMgr.initLoadLibrary");
      ((StringBuilder)localObject1).append(" cost ");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(" ms result:");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(" isMainThread: ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(' ');
      o.c("Luggage.Utils.Profile", ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("runProfiled:log:");
      ((StringBuilder)localObject1).append("WxaDynamicPkgMgr.initLoadLibrary");
      ((StringBuilder)localObject1).append(" cost ");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(" ms result:");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(" isMainThread: ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(' ');
      o.d("Luggage.Utils.Profile", ((StringBuilder)localObject1).toString());
    }
    a.a.b.a(com.tencent.luggage.wxa.fj.f.a.a());
    e.a("WeAppLaunch", (d)com.tencent.luggage.wxa.fb.a.a);
    return;
    label1259:
    throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fu.a
 * JD-Core Version:    0.7.0.1
 */