package com.tencent.luggage.wxa.lt;

import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$IBufferQueue;", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "requestTryCountLimit", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;I)V", "bytesCount", "", "getPriority", "()Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "queueImpl", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "getRequestTryCountLimit", "()I", "poll", "", "_bytes", "push", "", "entry", "size", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
final class g$a
{
  @Deprecated
  public static final g.a.a a = new g.a.a(null);
  private final LinkedList<g.d> b;
  private long c;
  @NotNull
  private final b.c d;
  private final int e;
  
  public g$a(@NotNull b.c paramc, int paramInt)
  {
    this.d = paramc;
    this.e = paramInt;
    this.b = new LinkedList();
  }
  
  public long a()
  {
    synchronized (this.b)
    {
      long l = this.c;
      return l;
    }
  }
  
  @NotNull
  public List<g.d> a(long paramLong)
  {
    synchronized (this.b)
    {
      if (this.b.isEmpty())
      {
        localObject1 = CollectionsKt.emptyList();
        return localObject1;
      }
      long l = paramLong;
      if (paramLong < 0L) {
        l = ((g.d)this.b.peekFirst()).f().length();
      }
      Object localObject1 = new LinkedList();
      paramLong = l;
      Object localObject3;
      while ((!this.b.isEmpty()) && (paramLong > 0L))
      {
        localObject3 = this.b.pollFirst();
        g.d locald = (g.d)localObject3;
        locald.a(locald.c() + 1);
        paramLong -= locald.f().length();
        ((LinkedList)localObject1).addLast(localObject3);
      }
      this.c -= l - paramLong;
      if (this.c < 0L)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append('[');
        ((StringBuilder)localObject3).append(this.d.name());
        ((StringBuilder)localObject3).append("] poll(");
        ((StringBuilder)localObject3).append(l);
        ((StringBuilder)localObject3).append(") final bytesCount becomes minus");
        o.b("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", ((StringBuilder)localObject3).toString());
        this.c = 0L;
      }
      localObject1 = (List)localObject1;
      return localObject1;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean a(@NotNull g.d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "entry");
    if (paramd.c() > this.e)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("push reach TryCountLimit priority[");
      ((StringBuilder)???).append(this.d.name());
      ((StringBuilder)???).append("], entry[");
      ((StringBuilder)???).append(paramd.a());
      ((StringBuilder)???).append(", ");
      ((StringBuilder)???).append(paramd.d());
      ((StringBuilder)???).append(", ");
      ((StringBuilder)???).append(paramd.e());
      ((StringBuilder)???).append(']');
      o.b("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue.BufferQueue", ((StringBuilder)???).toString());
      return false;
    }
    synchronized (this.b)
    {
      this.b.addLast(paramd);
      this.c += paramd.f().length();
      paramd = Unit.INSTANCE;
      return true;
    }
  }
  
  @NotNull
  public final b.c b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.g.a
 * JD-Core Version:    0.7.0.1
 */