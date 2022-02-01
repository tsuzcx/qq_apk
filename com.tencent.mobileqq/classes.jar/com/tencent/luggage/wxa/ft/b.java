package com.tencent.luggage.wxa.ft;

import android.app.Application;
import android.os.Parcelable;
import com.tencent.luggage.wxa.cx.t;
import com.tencent.luggage.wxa.cx.t.a;
import com.tencent.luggage.wxa.cx.t.c;
import com.tencent.luggage.wxa.cx.t.d;
import com.tencent.luggage.wxa.nn.a;
import com.tencent.luggage.wxa.ou.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/launch/WxaAppLaunchTraceEventDispatcher;", "Lcom/tencent/luggage/launch/WxaLaunchTracer$ITraceListener;", "()V", "TAG", "", "mapInstanceId2LaunchTimestampNs", "Ljava/util/concurrent/ConcurrentHashMap;", "", "install", "", "application", "Landroid/app/Application;", "onEvent", "instanceId", "eventGroup", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEventGroup;", "event", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEvent;", "message", "onInstanceColdLaunchInitReady", "timestampNs", "onInstanceWarmLaunchCompleted", "onMiniGameUnsupported", "onNewInstanceStart", "params", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "TraceEvent", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  implements t.a
{
  public static final b a = new b();
  private static final ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
  
  public final void a(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "application");
    t.a.a((t.a)this);
  }
  
  public final void a(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "instanceId");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInstanceColdLaunchInitReady instanceId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" timestampNs:");
    localStringBuilder.append(paramLong);
    o.d("Luggage.WxaAppLaunchTraceEventDispatcher", localStringBuilder.toString());
    paramString = r.i();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "MMApplicationContext.getMainProcessName()");
    com.tencent.luggage.wxa.hj.b.a(paramString, (Parcelable)new com.tencent.luggage.wxa.hu.c(paramLong), (com.tencent.luggage.wxa.hj.c)b.c.a, null, 8, null);
  }
  
  public void a(@NotNull String paramString1, @NotNull t.d paramd, @NotNull t.c paramc, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "instanceId");
    Intrinsics.checkParameterIsNotNull(paramd, "eventGroup");
    Intrinsics.checkParameterIsNotNull(paramc, "event");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEvent instanceId[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("] group[");
    ((StringBuilder)localObject).append(paramd);
    ((StringBuilder)localObject).append("] event[");
    ((StringBuilder)localObject).append(paramc);
    ((StringBuilder)localObject).append("] message[");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(']');
    o.d("Luggage.WxaAppLaunchTraceEventDispatcher", ((StringBuilder)localObject).toString());
    String str = r.i();
    Intrinsics.checkExpressionValueIsNotNull(str, "MMApplicationContext.getMainProcessName()");
    localObject = (Long)b.get(paramString1);
    if (localObject == null) {
      localObject = Long.valueOf(0L);
    }
    com.tencent.luggage.wxa.hj.b.a(str, (Parcelable)new b.a(((Long)localObject).longValue(), paramString1, paramd, paramc, paramString2), (com.tencent.luggage.wxa.hj.c)b.b.a, null);
  }
  
  public void a(@NotNull String paramString, @NotNull a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "instanceId");
    Intrinsics.checkParameterIsNotNull(parama, "params");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNewInstanceStart instanceId[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("] appId[");
    localStringBuilder.append(parama.b);
    localStringBuilder.append("] versionType[");
    localStringBuilder.append(parama.d);
    localStringBuilder.append("] scene[");
    d locald = parama.f;
    int i;
    if (locald != null) {
      i = locald.c;
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(']');
    o.d("Luggage.WxaAppLaunchTraceEventDispatcher", localStringBuilder.toString());
    ((Map)b).put(paramString, Long.valueOf(parama.j));
  }
  
  public final void b(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "instanceId");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInstanceWarmStartCompleted instanceId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" timestampNs:");
    localStringBuilder.append(paramLong);
    o.d("Luggage.WxaAppLaunchTraceEventDispatcher", localStringBuilder.toString());
    paramString = r.i();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "MMApplicationContext.getMainProcessName()");
    com.tencent.luggage.wxa.hj.b.a(paramString, (Parcelable)new com.tencent.luggage.wxa.hu.c(paramLong), (com.tencent.luggage.wxa.hj.c)b.d.a, null, 8, null);
  }
  
  public final void c(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "instanceId");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMiniGameUnsupported instanceId:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" timestampNs:");
    localStringBuilder.append(paramLong);
    o.d("Luggage.WxaAppLaunchTraceEventDispatcher", localStringBuilder.toString());
    paramString = r.i();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "MMApplicationContext.getMainProcessName()");
    com.tencent.luggage.wxa.hj.b.a(paramString, (Parcelable)new com.tencent.luggage.wxa.hu.c(paramLong), (com.tencent.luggage.wxa.hj.c)b.e.a, null, 8, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ft.b
 * JD-Core Version:    0.7.0.1
 */