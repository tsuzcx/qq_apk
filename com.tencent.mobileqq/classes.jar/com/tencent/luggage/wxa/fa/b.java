package com.tencent.luggage.wxa.fa;

import android.os.Build.VERSION;
import androidx.collection.ArraySet;
import com.tencent.luggage.wxa.em.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/WxaRuntimeStore;", "", "()V", "listenerStore", "Landroidx/collection/ArraySet;", "Lcom/tencent/luggage/wxa/WxaRuntimeStore$Listener;", "maxAliveRuntimeCount", "", "getMaxAliveRuntimeCount", "()I", "setMaxAliveRuntimeCount", "(I)V", "runtimeMap", "com/tencent/luggage/wxa/WxaRuntimeStore$runtimeMap$1", "Lcom/tencent/luggage/wxa/WxaRuntimeStore$runtimeMap$1;", "addListener", "", "l", "finishAllWithCondition", "condition", "Lkotlin/Function1;", "Lcom/tencent/luggage/standalone_ext/Runtime;", "", "get", "appId", "", "isEmpty", "push", "rt", "remove", "removeListener", "size", "Listener", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  private static final ArraySet<b.a> b = new ArraySet();
  private static int c = 3;
  private static final b.b d = new b.b();
  
  @JvmStatic
  @Nullable
  public static final d a(@Nullable String paramString)
  {
    if (paramString != null) {
      synchronized (d)
      {
        paramString = (d)d.get(paramString);
        return paramString;
      }
    }
    return null;
  }
  
  public final int a()
  {
    return c;
  }
  
  public final void a(@Nullable d paramd)
  {
    if (paramd != null) {
      synchronized (d)
      {
        d.remove(paramd.aa());
        Map localMap = (Map)d;
        String str = paramd.aa();
        Intrinsics.checkExpressionValueIsNotNull(str, "rt.appId");
        localMap.put(str, paramd);
        paramd = Unit.INSTANCE;
        return;
      }
    }
  }
  
  public final void a(@Nullable b.a parama)
  {
    if (parama != null) {
      synchronized (b)
      {
        b.add(parama);
        return;
      }
    }
  }
  
  public final void a(@NotNull Function1<? super d, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "condition");
    Object localObject1;
    label239:
    synchronized (d)
    {
      localObject1 = (Map)d;
      Object localObject2 = (Collection)new ArrayList();
      Iterator localIterator = ((Map)localObject1).entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        if (!((Boolean)paramFunction1.invoke(((Map.Entry)localObject1).getValue())).booleanValue()) {
          break label239;
        }
        localObject1 = (d)((Map.Entry)localObject1).getValue();
        if (localObject1 != null) {
          ((Collection)localObject2).add(localObject1);
        }
      }
      paramFunction1 = (List)localObject2;
      localObject1 = ((Iterable)paramFunction1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        if (Build.VERSION.SDK_INT >= 24) {
          d.remove(((d)localObject2).aa(), localObject2);
        } else {
          d.remove(((d)localObject2).aa());
        }
      }
      paramFunction1 = ((Iterable)paramFunction1).iterator();
      while (paramFunction1.hasNext()) {
        ((d)paramFunction1.next()).aD();
      }
      return;
    }
  }
  
  public final void b(@Nullable d paramd)
  {
    if (paramd != null) {
      synchronized (d)
      {
        boolean bool = Intrinsics.areEqual(paramd, (d)d.remove(paramd.aa()));
        if (bool) {}
        synchronized (b)
        {
          ArraySet localArraySet = b;
          ??? = ((Iterable)new ArraySet(localArraySet)).iterator();
          if (((Iterator)???).hasNext()) {
            ((b.a)((Iterator)???).next()).a(paramd);
          }
        }
      }
    }
  }
  
  public final boolean b()
  {
    synchronized (d)
    {
      boolean bool = d.isEmpty();
      return bool;
    }
  }
  
  public final int c()
  {
    synchronized (d)
    {
      int i = d.size();
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fa.b
 * JD-Core Version:    0.7.0.1
 */