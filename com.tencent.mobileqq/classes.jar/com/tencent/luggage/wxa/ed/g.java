package com.tencent.luggage.wxa.ed;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.ec.e;
import com.tencent.luggage.wxa.ec.h;
import com.tencent.luggage.wxa.iu.n;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.f;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/runtime/LuggagePersistentRuntimeStore;", "", "()V", "TAG", "", "runtimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "getRuntimeMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "runtimeMap$delegate", "Lkotlin/Lazy;", "detachRuntimeView", "", "isEmpty", "", "isPersistent", "cfg", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "rt", "poll", "runtimeContainer", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeContainerLU;", "pop", "stash", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class g
{
  public static final g a = new g();
  private static final Lazy b = LazyKt.lazy((Function0)g.a.a);
  
  private final boolean a(com.tencent.luggage.wxa.do.c paramc)
  {
    return paramc.s;
  }
  
  private final ConcurrentHashMap<String, d> c()
  {
    return (ConcurrentHashMap)b.getValue();
  }
  
  @Nullable
  public final d a(@NotNull com.tencent.luggage.wxa.do.c paramc, @NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "cfg");
    Intrinsics.checkParameterIsNotNull(paramb, "runtimeContainer");
    Object localObject = paramc.D;
    if (!a(paramc)) {
      return null;
    }
    d locald = (d)c().remove(localObject);
    if (locald != null) {
      Intrinsics.checkExpressionValueIsNotNull(locald, "runtimeMap.remove(appId) ?: return null");
    }
    try
    {
      new e(locald).f();
      label67:
      Boolean[] arrayOfBoolean = new Boolean[4];
      arrayOfBoolean[0] = Boolean.valueOf(locald.aw());
      arrayOfBoolean[1] = Boolean.valueOf(Intrinsics.areEqual(locald.aa(), paramc.D));
      arrayOfBoolean[2] = Boolean.valueOf(locald.av() ^ true);
      arrayOfBoolean[3] = Boolean.valueOf(locald.au() ^ true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("poll existed runtime[");
      ((StringBuilder)localObject).append(paramc.D);
      ((StringBuilder)localObject).append("], conditions[");
      ((StringBuilder)localObject).append(ArrayUtils.toString(arrayOfBoolean));
      ((StringBuilder)localObject).append(']');
      o.d("Luggage.LuggageRuntimeStore", ((StringBuilder)localObject).toString());
      int i;
      if (arrayOfBoolean.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        localObject = arrayOfBoolean[0];
        int j = ArraysKt.getLastIndex(arrayOfBoolean);
        paramc = (com.tencent.luggage.wxa.do.c)localObject;
        if (1 <= j)
        {
          i = 1;
          for (;;)
          {
            boolean bool = arrayOfBoolean[i].booleanValue();
            if ((((Boolean)localObject).booleanValue()) && (bool)) {
              bool = true;
            } else {
              bool = false;
            }
            localObject = Boolean.valueOf(bool);
            paramc = (com.tencent.luggage.wxa.do.c)localObject;
            if (i == j) {
              break;
            }
            i += 1;
          }
        }
        if (!paramc.booleanValue()) {
          return null;
        }
        locald.a((n)paramb);
        return locald;
      }
      throw ((Throwable)new UnsupportedOperationException("Empty array can't be reduced."));
      return null;
    }
    catch (com.tencent.luggage.wxa.ho.c localc)
    {
      break label67;
    }
  }
  
  public final void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    o.d("Luggage.LuggageRuntimeStore", "stash: appId [%s]", new Object[] { paramd.aa() });
    paramd.a((n)null);
    Map localMap = (Map)c();
    String str = paramd.aa();
    Intrinsics.checkExpressionValueIsNotNull(str, "rt.appId");
    localMap.put(str, paramd);
    try
    {
      new h(paramd).f();
      return;
    }
    catch (com.tencent.luggage.wxa.ho.c localc)
    {
      label73:
      break label73;
    }
    o.d("Luggage.LuggageRuntimeStore", "stash: stash fail, give up");
    c().remove(paramd.aa());
  }
  
  public final boolean a()
  {
    return c().isEmpty();
  }
  
  public final void b()
  {
    Object localObject1 = c().values();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "runtimeMap.values");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(locald, "rt");
      localObject1 = locald.ai();
      if (localObject1 != null) {
        localObject1 = ((f)localObject1).getParent();
      } else {
        localObject1 = null;
      }
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof ViewGroup)) {
        localObject2 = null;
      }
      localObject1 = (ViewGroup)localObject2;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).removeView((View)locald.ai());
      }
    }
  }
  
  public final boolean b(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    d locald = (d)c().get(paramd.aa());
    if ((Intrinsics.areEqual(locald, paramd) ^ true)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pop appId:");
    localStringBuilder.append(paramd.aa());
    localStringBuilder.append(", rt:");
    localStringBuilder.append(paramd);
    o.d("Luggage.LuggageRuntimeStore", localStringBuilder.toString());
    c().remove(locald.aa());
    try
    {
      new e(locald).f();
      return true;
    }
    catch (com.tencent.luggage.wxa.ho.c paramd) {}
    return true;
  }
  
  public final boolean c(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    paramd = paramd.j();
    Intrinsics.checkExpressionValueIsNotNull(paramd, "rt.initConfig");
    return a(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ed.g
 * JD-Core Version:    0.7.0.1
 */