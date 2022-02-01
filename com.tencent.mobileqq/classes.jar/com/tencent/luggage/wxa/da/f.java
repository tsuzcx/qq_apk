package com.tencent.luggage.wxa.da;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.wxa.ea.i;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/task/WxaProcessManager;", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;", "Lcom/tencent/luggage/launch/task/WxaMiniProgramProcess;", "Lcom/tencent/luggage/launch/task/WxaStartParams;", "processes", "", "([Lcom/tencent/luggage/launch/task/WxaMiniProgramProcess;)V", "getProcesses", "()[Lcom/tencent/luggage/launch/task/WxaMiniProgramProcess;", "[Lcom/tencent/luggage/launch/task/WxaMiniProgramProcess;", "getAllProcessName", "", "()[Ljava/lang/String;", "isPersistentApp", "", "params", "killSurplusProcess", "", "maxAllowedCount", "", "onStartWxaApp", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "strategy", "Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;", "permissionRequested", "sendCloseRuntimeMessage", "record", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "sendFinishMessage", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class f
  extends com.tencent.luggage.wxa.ea.c<e, h>
{
  public static final f.a a = new f.a(null);
  @NotNull
  private final e[] d;
  
  public f(@NotNull e[] paramArrayOfe)
  {
    this.d = paramArrayOfe;
  }
  
  private final boolean i()
  {
    return w.a("WxaTaskManager.permissionRequested", 2).getBoolean("WxaTaskManager.permissionRequested", false);
  }
  
  @NotNull
  public final List<e> a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= d().size()))
    {
      Object localObject2 = (Iterable)d().subList(paramInt, d().size());
      Object localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if (((e)localObject3).i()) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        com.tencent.luggage.wxa.hj.h.a(((e)((Iterator)localObject1).next()).c(), (Parcelable)com.tencent.luggage.wxa.hu.d.a, a.class, (com.tencent.luggage.wxa.hj.e)f.b.a);
      }
      return d().subList(0, paramInt);
    }
    return d();
  }
  
  public void a(@NotNull Context paramContext, @NotNull Intent paramIntent, @NotNull h paramh, @NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Intrinsics.checkParameterIsNotNull(paramh, "params");
    Intrinsics.checkParameterIsNotNull(parami, "strategy");
    com.tencent.luggage.wxa.ew.b localb = paramh.a();
    localb.n = paramIntent.getIntExtra("key_index", -1);
    g.a(localb, paramIntent, "action");
    Object localObject = paramh.b();
    if (localObject != null) {
      paramIntent.putExtra("statObject", (Parcelable)localObject);
    }
    paramh = paramh.c();
    if (paramh != null) {
      paramIntent.putExtra("referrer", (Parcelable)paramh);
    }
    boolean bool = true;
    paramIntent.putExtra("intentForStartWxa", true);
    if (i())
    {
      paramContext.startActivity(paramIntent);
      bool = false;
    }
    else
    {
      paramh = (b)com.tencent.luggage.wxa.ba.e.a(b.class);
      if (paramh != null)
      {
        paramh = paramh.a(paramContext);
        if (paramh != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putParcelable("WxaTaskManager.launchWxaIntent", (Parcelable)paramIntent);
          paramh.putExtra("WxaTaskManager.launchWxaIntent", (Bundle)localObject);
          if (!(paramContext instanceof Activity)) {
            paramh.addFlags(268435456);
          }
          paramh.addFlags(8388608);
          paramContext.startActivity(paramh);
          if (paramh != null) {
            break label219;
          }
        }
      }
      paramContext.startActivity(paramIntent);
      paramContext = Unit.INSTANCE;
    }
    label219:
    paramContext = new StringBuilder();
    paramContext.append("startApp, appId:");
    paramContext.append(localb.a);
    paramContext.append(", versionType:");
    paramContext.append(localb.e);
    paramContext.append(", startByProxy:");
    paramContext.append(bool);
    paramContext.append(", ");
    paramContext.append("strategy:");
    paramContext.append(parami);
    paramContext.append(", path:");
    paramContext.append(localb.d);
    o.d("Luggage.WXA.AppBrandProcessesManager", paramContext.toString());
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.ea.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "record");
    com.tencent.luggage.wxa.ea.b.a((e)c(paramd), (com.tencent.luggage.wxa.eb.a)new d(paramd.b(), null, 2, null), null, 2, null);
  }
  
  public boolean a(@NotNull h paramh)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "params");
    return paramh.a().m;
  }
  
  @NotNull
  public final String[] a()
  {
    Object localObject2 = (Iterable)d();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = ((e)((Iterator)localObject2).next()).c();
      if (str != null) {
        ((Collection)localObject1).add(str);
      }
    }
    localObject1 = ((Collection)localObject1).toArray(new String[0]);
    if (localObject1 != null) {
      return (String[])localObject1;
    }
    localObject1 = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  public void b(@NotNull com.tencent.luggage.wxa.ea.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "record");
    com.tencent.luggage.wxa.ea.b.a((e)c(paramd), (com.tencent.luggage.wxa.eb.a)new c(paramd.b()), null, 2, null);
  }
  
  @NotNull
  protected e[] b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.da.f
 * JD-Core Version:    0.7.0.1
 */