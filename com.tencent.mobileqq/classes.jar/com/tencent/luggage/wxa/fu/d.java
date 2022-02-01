package com.tencent.luggage.wxa.fu;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.luggage.wxa.dc.s;
import com.tencent.luggage.wxa.dc.x;
import com.tencent.luggage.wxa.dd.b.a;
import com.tencent.luggage.wxa.pd.u;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/process/MainProcessStartup;", "Lcom/tencent/luggage/wxaapi/internal/process/CommonProcessStartup;", "()V", "LAZY_LOAD_SERIAL_TAG", "", "TAG", "isLazyModulesLoaded", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialize", "", "context", "Landroid/content/Context;", "isActivityAlive", "", "loadLazyModulesGuarded", "safeLoadLazyModules", "waitForLoaded", "block", "Lkotlin/Function0;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class d
  extends a
{
  public static final d a = new d();
  private static final AtomicBoolean b = new AtomicBoolean(false);
  
  @ExperimentalUnsignedTypes
  private final void a()
  {
    if (!b.getAndSet(true))
    {
      Context localContext = r.a();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "MMApplicationContext.getContext()");
      c(localContext);
    }
  }
  
  private final boolean b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        if (((ActivityManager)paramContext).getRunningTasks(100).size() > 0) {
          return true;
        }
      }
      else {
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isActivityAlive fail: ");
      localStringBuilder.append(paramContext);
      o.b("Luggage.WXA.MainProcessStartup", localStringBuilder.toString());
      return false;
    }
    return false;
  }
  
  @ExperimentalUnsignedTypes
  private final void c(Context paramContext)
  {
    Object localObject1;
    if ((paramContext instanceof Application))
    {
      localObject1 = (Application)paramContext;
    }
    else
    {
      localObject1 = paramContext.getApplicationContext();
      if (localObject1 == null) {
        break label1842;
      }
      localObject1 = (Application)localObject1;
    }
    com.tencent.luggage.wxa.bb.a.a((com.tencent.luggage.wxa.bb.a.b)new com.tencent.luggage.wxa.er.b(paramContext));
    if (com.tencent.luggage.wxa.fq.f.a.e()) {
      com.tencent.luggage.wxa.fl.a.b.a((com.tencent.luggage.wxa.fl.a)new com.tencent.luggage.wxa.fl.c());
    }
    long l1 = SystemClock.elapsedRealtime();
    com.tencent.luggage.wxa.standalone_open_runtime.app.b.a.a((Application)localObject1);
    paramContext = Unit.INSTANCE;
    if ((paramContext instanceof com.tencent.luggage.wxa.ef.d.a))
    {
      paramContext = ((com.tencent.luggage.wxa.ef.d.a)paramContext).a();
    }
    else
    {
      paramContext = paramContext.toString();
      if (paramContext == null) {
        paramContext = "";
      }
    }
    boolean bool = u.a();
    long l2 = SystemClock.elapsedRealtime() - l1;
    l1 = 32;
    if ((l2 > l1) && (bool))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("block main thread and skip ");
      ((StringBuilder)localObject2).append((int)(l2 / 16));
      ((StringBuilder)localObject2).append(" frames! runProfiled:log:");
      ((StringBuilder)localObject2).append("initWxaTask");
      ((StringBuilder)localObject2).append(" cost ");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(" ms result:");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(" isMainThread: ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(' ');
      o.c("Luggage.Utils.Profile", ((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("runProfiled:log:");
      ((StringBuilder)localObject2).append("initWxaTask");
      ((StringBuilder)localObject2).append(" cost ");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(" ms result:");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(" isMainThread: ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(' ');
      o.d("Luggage.Utils.Profile", ((StringBuilder)localObject2).toString());
    }
    l2 = SystemClock.elapsedRealtime();
    com.tencent.luggage.wxa.fv.i.a.a((Application)localObject1);
    com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.de.d.class, (com.tencent.luggage.wxa.ba.b)com.tencent.luggage.wxa.de.l.a);
    s.a.a((com.tencent.luggage.wxa.ob.b)com.tencent.luggage.wxa.de.l.a);
    com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ob.b.class, (com.tencent.luggage.wxa.ba.b)s.a);
    x.a((Application)localObject1);
    paramContext = Unit.INSTANCE;
    if ((paramContext instanceof com.tencent.luggage.wxa.ef.d.a))
    {
      paramContext = ((com.tencent.luggage.wxa.ef.d.a)paramContext).a();
    }
    else
    {
      paramContext = paramContext.toString();
      if (paramContext == null) {
        paramContext = "";
      }
    }
    bool = u.a();
    l2 = SystemClock.elapsedRealtime() - l2;
    if ((l2 > l1) && (bool))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("block main thread and skip ");
      ((StringBuilder)localObject2).append((int)(l2 / 16));
      ((StringBuilder)localObject2).append(" frames! runProfiled:log:");
      ((StringBuilder)localObject2).append("installTdiCgi");
      ((StringBuilder)localObject2).append(" cost ");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(" ms result:");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(" isMainThread: ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(' ');
      o.c("Luggage.Utils.Profile", ((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("runProfiled:log:");
      ((StringBuilder)localObject2).append("installTdiCgi");
      ((StringBuilder)localObject2).append(" cost ");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(" ms result:");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append(" isMainThread: ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(' ');
      o.d("Luggage.Utils.Profile", ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = "block main thread and skip ";
    l2 = SystemClock.elapsedRealtime();
    com.tencent.luggage.wxa.fv.a.h();
    paramContext = Unit.INSTANCE;
    if ((paramContext instanceof com.tencent.luggage.wxa.ef.d.a))
    {
      paramContext = ((com.tencent.luggage.wxa.ef.d.a)paramContext).a();
    }
    else
    {
      paramContext = paramContext.toString();
      if (paramContext == null) {
        paramContext = "";
      }
    }
    bool = u.a();
    l2 = SystemClock.elapsedRealtime() - l2;
    if ((l2 > l1) && (bool))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append((int)(l2 / 16));
      ((StringBuilder)localObject3).append(" frames! runProfiled:log:");
      ((StringBuilder)localObject3).append("installDemoILinkActivateDevice");
      ((StringBuilder)localObject3).append(" cost ");
      ((StringBuilder)localObject3).append(l2);
      ((StringBuilder)localObject3).append(" ms result:");
      ((StringBuilder)localObject3).append(paramContext);
      ((StringBuilder)localObject3).append(" isMainThread: ");
      ((StringBuilder)localObject3).append(bool);
      ((StringBuilder)localObject3).append(' ');
      o.c("Luggage.Utils.Profile", ((StringBuilder)localObject3).toString());
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("runProfiled:log:");
      ((StringBuilder)localObject3).append("installDemoILinkActivateDevice");
      ((StringBuilder)localObject3).append(" cost ");
      ((StringBuilder)localObject3).append(l2);
      ((StringBuilder)localObject3).append(" ms result:");
      ((StringBuilder)localObject3).append(paramContext);
      ((StringBuilder)localObject3).append(" isMainThread: ");
      ((StringBuilder)localObject3).append(bool);
      ((StringBuilder)localObject3).append(' ');
      o.d("Luggage.Utils.Profile", ((StringBuilder)localObject3).toString());
    }
    Object localObject3 = "runProfiled:log:";
    l2 = SystemClock.elapsedRealtime();
    com.tencent.luggage.wxa.fq.l.a.a((Function0)new d.c((Application)localObject1));
    paramContext = Unit.INSTANCE;
    if ((paramContext instanceof com.tencent.luggage.wxa.ef.d.a))
    {
      paramContext = ((com.tencent.luggage.wxa.ef.d.a)paramContext).a();
    }
    else
    {
      paramContext = paramContext.toString();
      if (paramContext == null) {
        paramContext = "";
      }
    }
    bool = u.a();
    l2 = SystemClock.elapsedRealtime() - l2;
    if ((l2 > l1) && (bool))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append((int)(l2 / 16));
      ((StringBuilder)localObject1).append(" frames! runProfiled:log:");
      ((StringBuilder)localObject1).append("WxaDynamicPkgMgr.waitForLoaded");
      ((StringBuilder)localObject1).append(" cost ");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(" ms result:");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(" isMainThread: ");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(' ');
      o.c("Luggage.Utils.Profile", ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append("WxaDynamicPkgMgr.waitForLoaded");
      ((StringBuilder)localObject1).append(" cost ");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(" ms result:");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(" isMainThread: ");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(' ');
      o.d("Luggage.Utils.Profile", ((StringBuilder)localObject1).toString());
    }
    l2 = SystemClock.elapsedRealtime();
    com.tencent.luggage.wxa.dd.i.a.a(true);
    com.tencent.luggage.wxa.dd.i.a.a((b.a)new d.d());
    paramContext = Unit.INSTANCE;
    if ((paramContext instanceof com.tencent.luggage.wxa.ef.d.a))
    {
      paramContext = ((com.tencent.luggage.wxa.ef.d.a)paramContext).a();
    }
    else
    {
      paramContext = paramContext.toString();
      if (paramContext == null) {
        paramContext = "";
      }
    }
    bool = u.a();
    l2 = SystemClock.elapsedRealtime() - l2;
    if ((l2 > l1) && (bool))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append((int)(l2 / 16));
      ((StringBuilder)localObject1).append(" frames! runProfiled:log:");
      ((StringBuilder)localObject1).append("WxaAccountManager.init");
      ((StringBuilder)localObject1).append(" cost ");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(" ms result:");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(" isMainThread: ");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(' ');
      o.c("Luggage.Utils.Profile", ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append("WxaAccountManager.init");
      ((StringBuilder)localObject1).append(" cost ");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(" ms result:");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(" isMainThread: ");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(' ');
      o.d("Luggage.Utils.Profile", ((StringBuilder)localObject1).toString());
    }
    l2 = SystemClock.elapsedRealtime();
    com.tencent.luggage.wxa.ev.c.a();
    paramContext = Unit.INSTANCE;
    if ((paramContext instanceof com.tencent.luggage.wxa.ef.d.a))
    {
      paramContext = ((com.tencent.luggage.wxa.ef.d.a)paramContext).a();
    }
    else
    {
      paramContext = paramContext.toString();
      if (paramContext == null) {
        paramContext = "";
      }
    }
    bool = u.a();
    l2 = SystemClock.elapsedRealtime() - l2;
    if ((l2 > l1) && (bool))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append((int)(l2 / 16));
      ((StringBuilder)localObject1).append(" frames! runProfiled:log:");
      ((StringBuilder)localObject1).append("initXWebEnvironment");
      ((StringBuilder)localObject1).append(" cost ");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(" ms result:");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(" isMainThread: ");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(' ');
      o.c("Luggage.Utils.Profile", ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append("initXWebEnvironment");
      ((StringBuilder)localObject1).append(" cost ");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(" ms result:");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(" isMainThread: ");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(' ');
      o.d("Luggage.Utils.Profile", ((StringBuilder)localObject1).toString());
    }
    com.tencent.luggage.wxa.fj.g.b.b();
    return;
    label1842:
    throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
  }
  
  public void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    super.a(paramContext);
    o.d("Luggage.WXA.MainProcessStartup", "initialize: main process start up");
    Object localObject;
    if ((paramContext instanceof Application))
    {
      localObject = (Application)paramContext;
    }
    else
    {
      localObject = paramContext.getApplicationContext();
      if (localObject == null) {
        break label149;
      }
      localObject = (Application)localObject;
    }
    com.tencent.luggage.wxa.standalone_open_runtime.container.a.a.b();
    boolean bool = b(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("isActivityAlive:");
    paramContext.append(bool);
    o.d("Luggage.WXA.MainProcessStartup", paramContext.toString());
    if (!bool)
    {
      ((Application)localObject).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new d.a((Application)localObject));
      return;
    }
    com.tencent.luggage.wxa.rz.f.a.c((Runnable)new e((Function0)new d.b((d)this)), "MainProcessStartup-LoadLazyModules");
    return;
    label149:
    throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    if (b.get())
    {
      paramFunction0.invoke();
      return;
    }
    com.tencent.luggage.wxa.rz.f.a.c((Runnable)new d.e(paramFunction0), "MainProcessStartup-LoadLazyModules");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fu.d
 * JD-Core Version:    0.7.0.1
 */