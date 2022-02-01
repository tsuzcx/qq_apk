package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.util.c;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ReturnCopyUrlWatcherRegister;", "", "()V", "watchers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/CopyType;", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/IReturnCopyUrlWatcher;", "Lkotlin/collections/HashSet;", "notify", "", "type", "url", "", "register", "delayUnregisterAutomaticallyInMs", "", "watcher", "unregister", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class bb
{
  public static final bb a = new bb();
  private static final Map<w, HashSet<aa>> b = (Map)new LinkedHashMap();
  
  public final void a(@NotNull w paramw, long paramLong, @NotNull aa paramaa)
  {
    Intrinsics.checkParameterIsNotNull(paramw, "type");
    Intrinsics.checkParameterIsNotNull(paramaa, "watcher");
    synchronized (b)
    {
      Map localMap2 = b;
      Object localObject2 = localMap2.get(paramw);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        localMap2.put(paramw, localObject1);
      }
      ((HashSet)localObject1).add(paramaa);
      c.a(paramLong, (Function0)new bb.a(paramw, paramaa));
      return;
    }
  }
  
  public final void a(@NotNull w paramw, @NotNull aa paramaa)
  {
    Intrinsics.checkParameterIsNotNull(paramw, "type");
    Intrinsics.checkParameterIsNotNull(paramaa, "watcher");
    synchronized (b)
    {
      paramw = (HashSet)b.get(paramw);
      if (paramw != null) {
        paramw.remove(paramaa);
      }
      return;
    }
  }
  
  public final void a(@NotNull w paramw, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramw, "type");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    synchronized (b)
    {
      HashSet localHashSet = new HashSet();
      Map localMap2 = b;
      Object localObject2 = localMap2.get(paramw);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new HashSet();
        localMap2.put(paramw, localObject1);
      }
      localHashSet.addAll((Collection)localObject1);
      paramw = ((Iterable)localHashSet).iterator();
      while (paramw.hasNext()) {
        ((aa)paramw.next()).a(paramString);
      }
      return;
    }
    for (;;)
    {
      throw paramw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.bb
 * JD-Core Version:    0.7.0.1
 */