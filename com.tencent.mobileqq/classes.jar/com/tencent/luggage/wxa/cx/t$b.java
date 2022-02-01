package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.nn.a;
import com.tencent.luggage.wxa.ou.d;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/launch/WxaLaunchTracer$TRACE_LISTENER_DEFAULT_IMPL$1", "Lcom/tencent/luggage/launch/WxaLaunchTracer$ITraceListener;", "onEvent", "", "instanceId", "", "eventGroup", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEventGroup;", "event", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEvent;", "message", "onNewInstanceStart", "params", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class t$b
  implements t.a
{
  public void a(@NotNull String paramString1, @NotNull t.d paramd, @NotNull t.c paramc, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "instanceId");
    Intrinsics.checkParameterIsNotNull(paramd, "eventGroup");
    Intrinsics.checkParameterIsNotNull(paramc, "event");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEvent instanceId[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("] group[");
    localStringBuilder.append(paramd);
    localStringBuilder.append("] event[");
    localStringBuilder.append(paramc);
    localStringBuilder.append("] message[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(']');
    o.d("Luggage.WXA.Standalone.WxaLaunchTracer", localStringBuilder.toString());
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
    paramString = parama.f;
    int i;
    if (paramString != null) {
      i = paramString.c;
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(']');
    o.d("Luggage.WXA.Standalone.WxaLaunchTracer", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.t.b
 * JD-Core Version:    0.7.0.1
 */