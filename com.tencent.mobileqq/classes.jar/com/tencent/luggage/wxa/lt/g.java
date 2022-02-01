package com.tencent.luggage.wxa.lt;

import android.os.Looper;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.qw.mx;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.qz.v.a;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue;", "", "()V", "PER_SLICE_SIZE_LIMIT", "", "REPORT_PERIOD_INTERVAL", "REQUEST_DIAGNOSE_ID", "", "REQUEST_DIAGNOSE_KEY_BATCH_COUNT", "REQUEST_DIAGNOSE_KEY_BATCH_SUCCESS_COUNT", "REQUEST_DIAGNOSE_KEY_DEQUEUE", "REQUEST_DIAGNOSE_KEY_ENQUEUE", "REQUEST_DIAGNOSE_KEY_UPLOADED", "TAG", "", "attachedRuntimes", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Lkotlin/collections/HashSet;", "bufferQueue", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$BufferQueueAIO;", "periodTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "detachCaller", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "doCgi", "queue", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$Entry;", "reason", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "enqueueReportData", "id", "type", "content", "priority", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "idkeyStat", "key", "value", "periodReport", "triggerReport", "BufferQueue", "BufferQueueAIO", "CGIReason", "Entry", "IBufferQueue", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
final class g
{
  public static final g a = new g();
  private static final long b = TimeUnit.MINUTES.toMillis(5L);
  private static final v c = new v(Looper.getMainLooper(), (v.a)g.j.a, true);
  private static final HashSet<com.tencent.luggage.wxa.iu.d> d = new HashSet();
  private static final g.b e = new g.b();
  
  private final void a()
  {
    a(g.c.a);
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    com.tencent.luggage.wxa.ot.c localc = (com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class);
    if (localc != null) {
      localc.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  private final void a(com.tencent.luggage.wxa.iu.b paramb)
  {
    synchronized (d)
    {
      d.remove(paramb.q());
      if (d.size() == 0) {
        c.c();
      }
      paramb = Unit.INSTANCE;
      return;
    }
  }
  
  private final void a(g.c paramc)
  {
    a(e.a(65536L), paramc);
  }
  
  private final void a(List<g.d> paramList, g.c paramc)
  {
    c.a(b);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doCgi queue.size=");
    ((StringBuilder)localObject).append(paramList.size());
    ((StringBuilder)localObject).append(", reason=");
    ((StringBuilder)localObject).append(paramc.name());
    o.d("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", ((StringBuilder)localObject).toString());
    localObject = (Collection)paramList;
    int i;
    if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    a(1074, 1, paramList.size());
    a(this, 1074, 4, 0, 4, null);
    localObject = new g.h();
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      g.d locald = (g.d)localIterator.next();
      mx localmx = new mx();
      localmx.a = locald.e();
      localmx.b = com.tencent.luggage.wxa.qu.b.a(locald.f());
      localmx.c = locald.a();
      localLinkedList.add(localmx);
    }
    new a((List)localLinkedList).a().b((com.tencent.luggage.wxa.rl.b)new g.e(paramList, paramc, (g.h)localObject)).a((e.c)g.f.a).a((com.tencent.luggage.wxa.rp.d)com.tencent.luggage.wxa.rp.d.b, (e.a)new g.g(paramList, paramc, (g.h)localObject));
  }
  
  public final void a(@NotNull com.tencent.luggage.wxa.iu.b paramb, int paramInt1, int paramInt2, @NotNull String paramString, @NotNull b.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    Intrinsics.checkParameterIsNotNull(paramc, "priority");
    synchronized (d)
    {
      boolean bool = d.add(paramb.q());
      if ((bool) && (d.size() == 1)) {
        c.a(b);
      }
      if (bool)
      {
        localObject = paramb.q();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "component.runtime");
        ((com.tencent.luggage.wxa.iu.d)localObject).al().a((c.a)new g.i(paramb));
      }
      Object localObject = Unit.INSTANCE;
      a(this, 1074, 0, 0, 4, null);
      e.a(new g.d(paramInt1, paramInt2, paramString, paramc, (com.tencent.luggage.wxa.jx.c)paramb));
      if (e.a() >= 65536L) {
        a(e.a(65536L), g.c.b);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.g
 * JD-Core Version:    0.7.0.1
 */