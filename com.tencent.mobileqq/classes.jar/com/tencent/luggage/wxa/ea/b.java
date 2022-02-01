package com.tencent.luggage.wxa.ea;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import com.tencent.luggage.wxa.hj.m;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "", "()V", "allAppId", "", "", "getAllAppId", "()Ljava/util/Collection;", "appList", "", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "getAppList", "()Ljava/util/Set;", "isNoAppAttached", "", "()Z", "isProcessAlive", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pluginUIClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "getPluginUIClass", "()Ljava/lang/Class;", "processName", "getProcessName", "()Ljava/lang/String;", "remoteProcDiedListener", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "value", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "supportType", "getSupportType", "()Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "setSupportType", "(Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)V", "uiClass", "getUiClass", "usedAs", "getUsedAs", "setUsedAs", "attachApp", "params", "isPersistentApp", "(Lcom/tencent/luggage/sdk/processes/LuggageStartParams;Z)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "createRecord", "appId", "versionType", "", "detachApp", "", "record", "findAppRecord", "getAllRecord", "initProcessIsAlive", "killAllRuntime", "type", "Lcom/tencent/luggage/sdk/processes/KillType;", "killProcess", "registerApp", "instanceId", "sendMessageToLuggageProcess", "message", "Lkotlin/Function0;", "onReceived", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "setProcessAlive", "support", "toString", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public abstract class b<PARAMS extends h>
{
  public static final b.a a = new b.a(null);
  @NotNull
  private final Set<d> b = (Set)new HashSet();
  private AtomicBoolean c = new AtomicBoolean(false);
  @Nullable
  private final String d;
  @NotNull
  private g e = g.c;
  @Nullable
  private g f;
  private final m g = (m)new b.b(this);
  
  @NotNull
  public d a(@NotNull PARAMS paramPARAMS, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramPARAMS, "params");
    return a(paramPARAMS.d(), paramBoolean, paramPARAMS.f(), "");
  }
  
  @Nullable
  public final d a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    synchronized (this.b)
    {
      Iterator localIterator = ((Iterable)this.b).iterator();
      Object localObject;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!Intrinsics.areEqual(((d)localObject).b(), paramString));
      paramString = localObject;
      paramString = (d)paramString;
      return paramString;
    }
  }
  
  @NotNull
  public d a(@NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    return new d(paramString, paramInt, e.a, paramBoolean);
  }
  
  @NotNull
  public final d a(@NotNull String arg1, boolean paramBoolean, int paramInt, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(???, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "instanceId");
    d locald = a(???);
    if ((locald != null) && (locald.d() == paramBoolean) && (locald.c() == paramInt))
    {
      o.d("Luggage.LuggageMiniProgramProcess", "registerApp: use existed[%s][%d][%b]", new Object[] { ???, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    }
    else
    {
      o.d("Luggage.LuggageMiniProgramProcess", "registerApp: createRecord stack:[%s]", new Object[] { Log.getStackTraceString(new Throwable()) });
      locald = a(???, paramInt, paramBoolean);
    }
    o.d("Luggage.LuggageMiniProgramProcess", "registerApp: appId[%s]isPersistent[%s]record_hash[%s]instanceId[%s]", new Object[] { ???, Boolean.valueOf(paramBoolean), Integer.valueOf(locald.hashCode()), paramString2 });
    locald.a(paramString2);
    synchronized (this.b)
    {
      if (!this.b.add(locald))
      {
        paramString2 = new StringBuilder();
        paramString2.append("registerApp: ");
        paramString2.append(locald);
        paramString2.append(" already added");
        o.c("Luggage.LuggageMiniProgramProcess", paramString2.toString());
      }
      paramString2 = Unit.INSTANCE;
      return locald;
    }
  }
  
  @NotNull
  public abstract Class<? extends Activity> a();
  
  public abstract void a(@NotNull a parama);
  
  public final void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "record");
    if (paramd.d())
    {
      o.d("Luggage.LuggageMiniProgramProcess", "detachApp: [%s][%d] is persistent, do not detach", new Object[] { paramd.b(), Integer.valueOf(paramd.c()) });
      return;
    }
    synchronized (this.b)
    {
      boolean bool = this.b.remove(paramd);
      if (!bool) {
        o.c("Luggage.LuggageMiniProgramProcess", "detachApp: detach[%s] fail", new Object[] { paramd });
      }
      if (e()) {
        this.e = g.c;
      }
      return;
    }
  }
  
  public final void a(@NotNull g paramg)
  {
    Intrinsics.checkParameterIsNotNull(paramg, "<set-?>");
    this.e = paramg;
  }
  
  public final void a(@NotNull com.tencent.luggage.wxa.eb.a<? extends com.tencent.luggage.wxa.ed.d> parama, @Nullable Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(parama, "message");
    com.tencent.luggage.wxa.hj.h.a(c(), (Parcelable)parama, j.class, (com.tencent.luggage.wxa.hj.e)new b.c(paramFunction0));
  }
  
  @NotNull
  public abstract Class<? extends Activity> b();
  
  public final boolean b(@NotNull g paramg)
  {
    Intrinsics.checkParameterIsNotNull(paramg, "type");
    g localg = this.f;
    if (localg == null) {
      return true;
    }
    return localg == paramg;
  }
  
  @Nullable
  public final String c()
  {
    String str2 = this.d;
    String str1 = str2;
    if (str2 == null) {
      str1 = a.a(a());
    }
    return str1;
  }
  
  @NotNull
  public final g d()
  {
    return this.e;
  }
  
  public final boolean e()
  {
    return this.b.isEmpty();
  }
  
  @NotNull
  public final Collection<String> f()
  {
    synchronized (this.b)
    {
      Object localObject3 = (Iterable)this.b;
      Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject1).add(((d)((Iterator)localObject3).next()).b());
      }
      localObject1 = new ArrayList((Collection)localObject1);
      return (Collection)localObject1;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public final void g()
  {
    com.tencent.luggage.wxa.hj.h.a(c(), this.g);
    this.c.set(true);
  }
  
  public final void h()
  {
    String str = c();
    if (str != null)
    {
      AtomicBoolean localAtomicBoolean = this.c;
      b.a locala = a;
      Context localContext = r.a();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "MMApplicationContext.getContext()");
      localAtomicBoolean.set(b.a.a(locala, localContext, str));
    }
  }
  
  public final boolean i()
  {
    return this.c.get();
  }
  
  @NotNull
  public final Collection<d> j()
  {
    synchronized (this.b)
    {
      ArrayList localArrayList = new ArrayList((Collection)this.b);
      return (Collection)localArrayList;
    }
  }
  
  public void k()
  {
    Object localObject = r.a().getSystemService("activity");
    if (localObject != null)
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((localRunningAppProcessInfo.processName != null) && (Intrinsics.areEqual(localRunningAppProcessInfo.processName, c()))) {
          Process.killProcess(localRunningAppProcessInfo.pid);
        }
      }
      return;
    }
    localObject = new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LuggageMiniProgramProcess(appList=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isProcessAlive=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", processName='");
    localStringBuilder.append(c());
    localStringBuilder.append("', ");
    localStringBuilder.append("usedAs=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", isNoAppAttached=");
    localStringBuilder.append(e());
    localStringBuilder.append(", allAppId=");
    localStringBuilder.append(f());
    localStringBuilder.append(", supportType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", uiClass=");
    localStringBuilder.append(a());
    localStringBuilder.append(", pluginUIClass=");
    localStringBuilder.append(b());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ea.b
 * JD-Core Version:    0.7.0.1
 */