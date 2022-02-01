package com.tencent.luggage.wxa.lt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "()V", "typedQueues", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "[Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "poll", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "bytes", "", "push", "", "entry", "size", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
final class g$b
{
  private final g.a[] a = { new g.a(b.c.a, 3), new g.a(b.c.b, 1) };
  
  public long a()
  {
    g.a[] arrayOfa = this.a;
    Collection localCollection = (Collection)new ArrayList(arrayOfa.length);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(Long.valueOf(arrayOfa[i].a()));
      i += 1;
    }
    return CollectionsKt.sumOfLong((Iterable)localCollection);
  }
  
  @NotNull
  public List<g.d> a(long paramLong)
  {
    LinkedList localLinkedList = new LinkedList();
    g.a[] arrayOfa = this.a;
    int j = arrayOfa.length;
    long l1 = 0L;
    int i = 0;
    while (i < j)
    {
      g.a locala = arrayOfa[i];
      long l2 = locala.a();
      localLinkedList.addAll((Collection)locala.a(paramLong - l1));
      l1 += l2 - locala.a();
      i += 1;
    }
    return (List)localLinkedList;
  }
  
  public boolean a(@NotNull g.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "entry");
    g.a[] arrayOfa = this.a;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      g.a locala = arrayOfa[i];
      if (locala.b() == paramd.g()) {
        return locala.a(paramd);
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.g.b
 * JD-Core Version:    0.7.0.1
 */