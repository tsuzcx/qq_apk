package com.tencent.luggage.wxa.ea;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;", "PROCESS", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "", "()V", "availableProcess", "", "getAvailableProcess", "()Ljava/util/List;", "availableProcess$delegate", "Lkotlin/Lazy;", "processes", "", "getProcesses", "()[Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "sRuntimeEventListener", "Ljava/util/ArrayList;", "Lcom/tencent/luggage/sdk/processes/LuggageRuntimeEventListener;", "Lkotlin/collections/ArrayList;", "addRuntimeEventListener", "", "runtimeEventListener", "allAppRecords", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "clearDuplicatedApp", "excludeProcessIndex", "", "appId", "", "closeByAppId", "versionType", "dumpDebugInfo", "findProcess", "record", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "index", "(I)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "(Ljava/lang/String;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "findProcesses", "predicate", "Lkotlin/Function1;", "", "findRecord", "findRecords", "(Ljava/lang/String;I)[Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;", "command", "Lkotlin/ParameterName;", "name", "getAliveInstanceId", "getAvailableProcessToPreload", "serviceType", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "(Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "getAvailableProcessToStartup", "type", "(Ljava/lang/String;Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "getAvailableTaskToPreRender", "ret", "Lkotlin/Function2;", "p", "getPersistentTask", "Lkotlin/Pair;", "Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;", "getPluginTaskToStartup", "getStartStrategyAndTask", "params", "isPersistentApp", "(Lcom/tencent/luggage/sdk/processes/LuggageStartParams;Z)Lkotlin/Pair;", "indexOf", "process", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;)I", "(Lcom/tencent/luggage/sdk/processes/LuggageStartParams;)Z", "killAll", "killType", "Lcom/tencent/luggage/sdk/processes/KillType;", "killByAppId", "killEmptyProcess", "notifyRuntimeClose", "timestamp", "", "notifyRuntimeFinish", "onPreRenderedAdded", "processIndex", "(ILcom/tencent/luggage/sdk/processes/LuggageStartParams;)V", "onPreRenderedRemoved", "onRuntimeClose", "onRuntimeFinish", "onStartWxaApp", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "strategy", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;)V", "popPersistentApp", "removeApp", "removeRuntimeEventListener", "reusePluginTaskIfHadRecords", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramRecord;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;)Lkotlin/Pair;", "sendCloseRuntimeMessage", "sendFinishMessage", "startApp", "(Landroid/content/Context;Lcom/tencent/luggage/sdk/processes/LuggageStartParams;)Lcom/tencent/luggage/sdk/processes/LuggageStartStrategy;", "stashPersistentApp", "instanceId", "taskAlive", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public abstract class c<PROCESS extends b<PARAMS>, PARAMS extends h>
{
  @NotNull
  public static c<b<h>, h> b;
  public static final c.a c = new c.a(null);
  @NotNull
  private static final com.tencent.luggage.wxa.ef.h e = new com.tencent.luggage.wxa.ef.h(Boolean.valueOf(true), null, 2, null);
  @NotNull
  private final Lazy a = LazyKt.lazy((Function0)new c.b(this));
  private final ArrayList<f> d = new ArrayList();
  
  private final PROCESS a(String paramString, g paramg)
  {
    Object localObject1 = b(paramString);
    Object localObject2 = null;
    paramString = (String)localObject1;
    Object localObject3;
    int i;
    if (localObject1 == null)
    {
      localObject1 = ((Iterable)d()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramString = ((Iterator)localObject1).next();
        localObject3 = (b)paramString;
        if ((((b)localObject3).e()) && (((b)localObject3).i()) && ((((b)localObject3).d() == g.c) || (((b)localObject3).d() == paramg))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          break label108;
        }
      }
      paramString = null;
      label108:
      paramString = (b)paramString;
    }
    localObject1 = paramString;
    if (paramString == null)
    {
      localObject1 = ((Iterable)d()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramString = ((Iterator)localObject1).next();
        localObject3 = (b)paramString;
        if ((((b)localObject3).e()) && ((((b)localObject3).d() == g.c) || (((b)localObject3).d() == paramg))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          break label202;
        }
      }
      paramString = null;
      label202:
      localObject1 = (b)paramString;
    }
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      localObject3 = ((Iterable)d()).iterator();
      if (!((Iterator)localObject3).hasNext())
      {
        paramString = (String)localObject2;
      }
      else
      {
        paramString = ((Iterator)localObject3).next();
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = (Iterable)((b)paramString).j();
          paramg = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramg.add(Long.valueOf(((d)((Iterator)localObject1).next()).a()));
          }
          paramg = (Long)CollectionsKt.min((Iterable)paramg);
          long l1;
          if (paramg != null)
          {
            l1 = paramg.longValue();
            paramg = paramString;
          }
          else
          {
            l1 = 0L;
            paramg = paramString;
          }
          do
          {
            localObject1 = ((Iterator)localObject3).next();
            localObject2 = (Iterable)((b)localObject1).j();
            paramString = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              paramString.add(Long.valueOf(((d)((Iterator)localObject2).next()).a()));
            }
            paramString = (Long)CollectionsKt.min((Iterable)paramString);
            long l2;
            if (paramString != null) {
              l2 = paramString.longValue();
            } else {
              l2 = 0L;
            }
            paramString = paramg;
            long l3 = l1;
            if (l1 > l2)
            {
              paramString = (String)localObject1;
              l3 = l2;
            }
            paramg = paramString;
            l1 = l3;
          } while (((Iterator)localObject3).hasNext());
        }
      }
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      paramString = (b)paramString;
    }
    return paramString;
  }
  
  private final Pair<i, PROCESS> a(PARAMS paramPARAMS, boolean paramBoolean)
  {
    Object localObject1 = paramPARAMS.d();
    int i = paramPARAMS.f();
    g localg = g.d.a(paramPARAMS.e());
    d[] arrayOfd = d((String)localObject1, i);
    if (arrayOfd.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = i ^ 0x1;
    if ((paramBoolean) && (!bool)) {
      i = 1;
    } else {
      i = 0;
    }
    if (1 == i)
    {
      paramPARAMS = d((String)localObject1);
    }
    else
    {
      if ((paramBoolean) && (bool)) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject2 = null;
      Object localObject3 = null;
      int j;
      if (1 == i)
      {
        j = arrayOfd.length;
        i = 0;
        for (;;)
        {
          localObject1 = localObject3;
          if (i >= j) {
            break;
          }
          localObject1 = arrayOfd[i];
          if (((d)localObject1).d()) {
            break;
          }
          i += 1;
        }
        if (localObject1 == null)
        {
          o.c("Luggage.LuggageMiniProgramProcessManager", "getStartStrategyAndTask: stash task lost, fallback");
          paramPARAMS = a((d)ArraysKt.first(arrayOfd), paramPARAMS);
        }
        else
        {
          paramPARAMS = a((d)localObject1, paramPARAMS);
        }
      }
      else
      {
        if ((!paramBoolean) && (!bool)) {
          i = 1;
        } else {
          i = 0;
        }
        if (1 == i)
        {
          paramPARAMS = new Pair(i.a, a((String)localObject1, localg));
        }
        else
        {
          if ((!paramBoolean) && (bool)) {
            i = 1;
          } else {
            i = 0;
          }
          if (1 != i) {
            break label456;
          }
          j = arrayOfd.length;
          i = 0;
          while (i < j)
          {
            paramPARAMS = arrayOfd[i];
            if (paramPARAMS.d()) {
              break label292;
            }
            i += 1;
          }
          paramPARAMS = null;
          label292:
          if (paramPARAMS != null)
          {
            j = arrayOfd.length;
            i = 0;
            for (;;)
            {
              localObject1 = localObject2;
              if (i >= j) {
                break;
              }
              localObject1 = arrayOfd[i];
              if (((d)localObject1).d()) {
                break;
              }
              i += 1;
            }
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            localObject1 = c((d)localObject1);
            paramPARAMS.a(false);
            paramPARAMS = new Pair(i.b, localObject1);
          }
          else
          {
            paramPARAMS = new Pair(i.b, c((d)ArraysKt.first(arrayOfd)));
          }
        }
      }
    }
    ((b)paramPARAMS.getSecond()).a(localg);
    o.d("Luggage.LuggageMiniProgramProcessManager", "getStartStrategyAndTask: isPluginTask[%b]hasLocalRecords[%b]processIndex[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(a((b)paramPARAMS.getSecond())) });
    return paramPARAMS;
    label456:
    paramPARAMS = (Throwable)new IllegalStateException("never!");
    for (;;)
    {
      throw paramPARAMS;
    }
  }
  
  private final void b(long paramLong, String paramString)
  {
    Object localObject = new ArrayList();
    try
    {
      ((ArrayList)localObject).addAll((Collection)this.d);
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((f)((Iterator)localObject).next()).a(paramLong, paramString);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private final Pair<i, PROCESS> d(String paramString)
  {
    return new Pair(i.a, a(paramString));
  }
  
  public final int a(@NotNull PROCESS paramPROCESS)
  {
    Intrinsics.checkParameterIsNotNull(paramPROCESS, "process");
    return d().indexOf(paramPROCESS);
  }
  
  @Nullable
  public PROCESS a(@NotNull g paramg)
  {
    Intrinsics.checkParameterIsNotNull(paramg, "serviceType");
    int i;
    if (paramg != g.c) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Object localObject2 = (Iterable)d();
      Object localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (b)localObject3;
        if ((paramg == ((b)localObject4).d()) && (((b)localObject4).e())) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject2 = (List)localObject1;
      Object localObject3 = null;
      localObject1 = (b)null;
      if ((((Collection)localObject2).isEmpty() ^ true))
      {
        localObject4 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject1 = ((Iterator)localObject4).next();
          if (((b)localObject1).i()) {
            break label194;
          }
        }
        localObject1 = null;
        label194:
        localObject1 = (b)localObject1;
        if (localObject1 == null) {
          localObject1 = (b)CollectionsKt.first((List)localObject2);
        }
        o.d("Luggage.LuggageMiniProgramProcessManager", "getAvailableTaskToPreload found empty task[%s], which can be used as [%s]", new Object[] { ((b)localObject1).a().getSimpleName(), paramg });
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject4 = (Iterable)d();
        localObject2 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          b localb = (b)localObject5;
          if ((localb.d() == g.c) && (localb.b(paramg))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            ((Collection)localObject2).add(localObject5);
          }
        }
        localObject2 = (List)localObject2;
        if ((((Collection)localObject2).isEmpty() ^ true))
        {
          localObject4 = ((Iterable)localObject2).iterator();
          do
          {
            localObject1 = localObject3;
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            localObject1 = ((Iterator)localObject4).next();
          } while (!((b)localObject1).i());
          localObject1 = (b)localObject1;
          if (localObject1 == null) {
            localObject1 = (b)CollectionsKt.first((List)localObject2);
          }
        }
        if (localObject1 != null)
        {
          localObject2 = ((b)localObject1).a();
          if (localObject2 != null)
          {
            localObject2 = ((Class)localObject2).getSimpleName();
            if (localObject2 != null) {
              break label470;
            }
          }
        }
        localObject2 = "null";
        label470:
        o.d("Luggage.LuggageMiniProgramProcessManager", "tryPreloadNextTaskProcess serviceType = [%s] not reached max limit , got ui task = [%s]", new Object[] { paramg, localObject2 });
        localObject2 = localObject1;
      }
      return localObject2;
    }
    paramg = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
    for (;;)
    {
      throw paramg;
    }
  }
  
  @NotNull
  public PROCESS a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    return a(paramString, g.a);
  }
  
  @NotNull
  public final i a(@NotNull Context paramContext, @NotNull PARAMS paramPARAMS)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramPARAMS, "params");
    String str = paramPARAMS.d();
    boolean bool = a(paramPARAMS);
    Object localObject = a(paramPARAMS, bool);
    i locali = (i)((Pair)localObject).component1();
    b localb = (b)((Pair)localObject).component2();
    localb.a(paramPARAMS, bool);
    if ((locali != i.a) && ((paramContext instanceof Activity))) {
      localObject = null;
    } else {
      localObject = Integer.valueOf(268435456);
    }
    Class localClass;
    if (bool) {
      localClass = localb.b();
    } else {
      localClass = localb.a();
    }
    Intent localIntent = new Intent(paramContext, localClass);
    if (localObject != null) {
      localIntent.setFlags(((Integer)localObject).intValue());
    }
    localIntent.putExtra("key_index", d().indexOf(localb));
    o.d("Luggage.LuggageMiniProgramProcessManager", "startApp: appId:[%s] strategy:[%s] index:[%d] process:[%s],isPersistent:[%b],versionType:[%d],uiClass:[%s]", new Object[] { str, locali.name(), Integer.valueOf(a(localb)), localb.c(), Boolean.valueOf(bool), Integer.valueOf(paramPARAMS.f()), localClass.getName() });
    a(paramContext, localIntent, paramPARAMS, locali);
    c(str);
    return locali;
  }
  
  @NotNull
  public final List<PROCESS> a(@NotNull Function1<? super PROCESS, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "predicate");
    Object localObject1 = (Iterable)d();
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((Boolean)paramFunction1.invoke((b)localObject2)).booleanValue()) {
        localCollection.add(localObject2);
      }
    }
    return (List)localCollection;
  }
  
  @NotNull
  protected Pair<i, PROCESS> a(@NotNull d paramd, @NotNull PARAMS paramPARAMS)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "record");
    Intrinsics.checkParameterIsNotNull(paramPARAMS, "params");
    paramPARAMS = c(paramd);
    i locali = i.b;
    paramd.a(true);
    return new Pair(locali, paramPARAMS);
  }
  
  public void a(long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    b(paramLong, paramString);
  }
  
  public void a(@NotNull Context paramContext, @NotNull Intent paramIntent, @NotNull PARAMS paramPARAMS, @NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Intrinsics.checkParameterIsNotNull(paramPARAMS, "params");
    Intrinsics.checkParameterIsNotNull(parami, "strategy");
    paramContext.startActivity(paramIntent);
  }
  
  public final void a(@NotNull a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "killType");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("killAll(type:");
    ((StringBuilder)localObject).append(parama);
    ((StringBuilder)localObject).append(')');
    o.d("Luggage.LuggageMiniProgramProcessManager", ((StringBuilder)localObject).toString());
    if (parama == a.c)
    {
      e();
      return;
    }
    localObject = ((Iterable)d()).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b)((Iterator)localObject).next()).a(parama);
    }
  }
  
  public abstract void a(@NotNull d paramd);
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    a(paramString, -1, (Function1)new c.f((b)d().get(paramInt)));
  }
  
  public final void a(@NotNull String paramString1, int paramInt1, int paramInt2, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    Intrinsics.checkParameterIsNotNull(paramString2, "instanceId");
    o.d("Luggage.LuggageMiniProgramProcessManager", "stashPersistentApp: appId[%s]versionType[%d]instanceId[%s]processIndex[%d]", new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, Integer.valueOf(paramInt2) });
    d locald = b(paramInt2).a(paramString1);
    if (locald == null)
    {
      b(paramInt2).a(paramString1, true, paramInt1, paramString2);
      return;
    }
    locald.a(true);
  }
  
  public final void a(@NotNull String paramString, int paramInt, @NotNull Function1<? super d, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "command");
    Object localObject2 = (Iterable)d();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((b)((Iterator)localObject2).next()).a(paramString);
      if (localObject3 != null) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (List)localObject1;
    if (((List)localObject1).isEmpty()) {
      o.c("Luggage.LuggageMiniProgramProcessManager", "findRecords: ([%s][%s]) not found", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    localObject2 = (Iterable)localObject1;
    paramString = (Collection)new ArrayList();
    Object localObject3 = ((Iterable)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if (((d)localObject4).d()) {
        paramString.add(localObject4);
      }
    }
    int i = ((List)paramString).size();
    paramString = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if ((((d)localObject4).d() ^ true)) {
        paramString.add(localObject4);
      }
    }
    int j = ((List)paramString).size();
    if ((((List)localObject1).size() <= 2) && (i <= 1) && (j <= 1))
    {
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramString = ((Iterator)localObject1).next();
        if ((((d)paramString).d() ^ true)) {
          break label351;
        }
      }
      paramString = null;
      label351:
      localObject1 = (d)paramString;
      if (localObject1 != null)
      {
        if (paramInt >= 0)
        {
          paramString = (String)localObject1;
          if (((d)localObject1).c() != paramInt) {}
        }
        else
        {
          paramFunction1.invoke(localObject1);
          paramString = (String)localObject1;
        }
      }
      else {
        paramString = null;
      }
      if (paramString == null)
      {
        localObject1 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramString = ((Iterator)localObject1).next();
          if (((d)paramString).d()) {
            break label441;
          }
        }
        paramString = null;
        label441:
        paramString = (d)paramString;
        if ((paramString != null) && ((paramInt < 0) || (paramString.c() == paramInt))) {
          paramFunction1.invoke(paramString);
        }
      }
      return;
    }
    paramString = StringCompanionObject.INSTANCE;
    paramString = new Object[3];
    paramString[0] = Integer.valueOf(((List)localObject1).size());
    paramString[1] = Integer.valueOf(i);
    paramString[2] = Integer.valueOf(j);
    paramString = String.format("records size[%d] persistent size[%d] !persistent size[%d]", Arrays.copyOf(paramString, paramString.length));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.String.format(format, *args)");
    paramString = (Throwable)new IllegalStateException(paramString);
    for (;;)
    {
      throw paramString;
    }
  }
  
  public abstract boolean a(@NotNull PARAMS paramPARAMS);
  
  @NotNull
  public final PROCESS b(int paramInt)
  {
    return (b)d().get(paramInt);
  }
  
  @Nullable
  public final PROCESS b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    Iterator localIterator = ((Iterable)d()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((b)localObject).f().contains(paramString))
      {
        paramString = localObject;
        break label59;
      }
    }
    paramString = null;
    label59:
    return (b)paramString;
  }
  
  public abstract void b(@NotNull d paramd);
  
  public final void b(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    a(paramString, paramInt, (Function1)new c.c(this));
  }
  
  @NotNull
  public final PROCESS c(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "record");
    Iterator localIterator = ((Iterable)d()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((b)localObject).j().contains(paramd))
      {
        paramd = localObject;
        break label59;
      }
    }
    paramd = null;
    label59:
    if (paramd == null) {
      Intrinsics.throwNpe();
    }
    return (b)paramd;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    a(paramString, -1, (Function1)c.g.a);
  }
  
  public final void c(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("killByAppId(appId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", versionType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(')');
    o.d("Luggage.LuggageMiniProgramProcessManager", localStringBuilder.toString());
    a(paramString, paramInt, (Function1)new c.e(this, paramString));
  }
  
  @NotNull
  protected abstract PROCESS[] c();
  
  @NotNull
  protected final List<PROCESS> d()
  {
    return (List)this.a.getValue();
  }
  
  public final void d(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "record");
    c(paramd).a(paramd);
  }
  
  @NotNull
  public final d[] d(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    ArrayList localArrayList = new ArrayList();
    a(paramString, paramInt, (Function1)new c.d(localArrayList));
    paramString = ((Collection)localArrayList).toArray(new d[0]);
    if (paramString != null) {
      return (d[])paramString;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  public void e()
  {
    Object localObject1 = new ConcurrentHashMap();
    Iterator localIterator = ((Iterable)d()).iterator();
    Object localObject2;
    String str;
    while (localIterator.hasNext())
    {
      localObject2 = (b)localIterator.next();
      str = ((b)localObject2).c();
      if (str != null) {
        if (((b)localObject2).e())
        {
          ((ConcurrentHashMap)localObject1).putIfAbsent(str, Boolean.TRUE);
        }
        else
        {
          localObject2 = (Map)localObject1;
          Boolean localBoolean = Boolean.FALSE;
          Intrinsics.checkExpressionValueIsNotNull(localBoolean, "java.lang.Boolean.FALSE");
          ((Map)localObject2).put(str, localBoolean);
        }
      }
    }
    localIterator = ((Map)localObject1).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject1).getKey();
      if (((Boolean)((Map.Entry)localObject1).getValue()).booleanValue())
      {
        o.d("Luggage.LuggageMiniProgramProcessManager", "killAll SILENT_IF_INACTIVE kill process(%s)", new Object[] { str });
        localObject2 = ((Iterable)d()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (Intrinsics.areEqual(((b)localObject1).c(), str)) {
            break label231;
          }
        }
        localObject1 = null;
        label231:
        localObject1 = (b)localObject1;
        if (localObject1 != null) {
          ((b)localObject1).k();
        }
      }
    }
    o.d("Luggage.LuggageMiniProgramProcessManager", "killAll SILENT_IF_INACTIVE");
  }
  
  @NotNull
  public final String f()
  {
    Object localObject2 = (Iterable)d();
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    StringBuilder localStringBuilder;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (b)((Iterator)localObject2).next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((b)localObject3).c());
      localStringBuilder.append("#");
      localStringBuilder.append(((b)localObject3).toString());
      ((Collection)localObject1).add(localStringBuilder.toString());
    }
    localObject2 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      for (localObject1 = ((Iterator)localObject2).next(); ((Iterator)localObject2).hasNext(); localObject1 = localStringBuilder.toString())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject1 = (String)localObject1;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\n\n");
        localStringBuilder.append((String)localObject3);
      }
      return (String)localObject1;
    }
    localObject1 = (Throwable)new UnsupportedOperationException("Empty collection can't be reduced.");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ea.c
 * JD-Core Version:    0.7.0.1
 */