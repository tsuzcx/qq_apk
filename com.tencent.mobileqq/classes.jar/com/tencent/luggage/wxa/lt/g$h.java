package com.tencent.luggage.wxa.lt;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$doCgi$Dispatcher", "", "()V", "eventEntriesMap", "Ljava/util/WeakHashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "dispatch", "", "errCode", "", "errMsg", "", "pushEventEntry", "component", "entry", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class g$h
{
  private final WeakHashMap<c, LinkedList<g.d>> a = new WeakHashMap();
  
  public final void a(int paramInt, @Nullable String paramString)
  {
    Object localObject1 = this.a.entrySet();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "eventEntriesMap.entries");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = (c)((Map.Entry)localObject3).getKey();
      if (localObject2 != null)
      {
        localObject2 = new b.b().a((c)localObject2);
        HashMap localHashMap = new HashMap();
        localHashMap.put("errcode", Integer.valueOf(paramInt));
        localHashMap.put("errmsg", paramString);
        Object localObject4 = ((Map.Entry)localObject3).getValue();
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "entry.value");
        Object localObject5 = (Iterable)localObject4;
        localObject4 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject5, 10));
        localObject5 = ((Iterable)localObject5).iterator();
        while (((Iterator)localObject5).hasNext()) {
          ((Collection)localObject4).add(Long.valueOf(((g.d)((Iterator)localObject5).next()).f().length()));
        }
        localHashMap.put("dataSize", Long.valueOf(CollectionsKt.sumOfLong((Iterable)localObject4)));
        localObject3 = ((Map.Entry)localObject3).getValue();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "entry.value");
        localObject4 = (Iterable)localObject3;
        localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((Collection)localObject3).add(Integer.valueOf(((g.d)((Iterator)localObject4).next()).d()));
        }
        localHashMap.put("idList", new JSONArray((Collection)CollectionsKt.toList((Iterable)localObject3)));
        ((n)localObject2).a((Map)localHashMap).a();
      }
    }
  }
  
  public final void a(@Nullable c paramc, @NotNull g.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "entry");
    if (paramc != null)
    {
      LinkedList localLinkedList = (LinkedList)this.a.get(paramc);
      if (localLinkedList != null)
      {
        paramc = localLinkedList;
      }
      else
      {
        localLinkedList = new LinkedList();
        ((Map)this.a).put(paramc, localLinkedList);
        paramc = localLinkedList;
      }
      paramc.addLast(paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.g.h
 * JD-Core Version:    0.7.0.1
 */