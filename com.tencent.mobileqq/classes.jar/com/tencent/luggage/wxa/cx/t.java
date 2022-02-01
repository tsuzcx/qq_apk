package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.nn.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaLaunchTracer;", "", "()V", "TAG", "", "TRACE_LISTENER_DEFAULT_IMPL", "com/tencent/luggage/launch/WxaLaunchTracer$TRACE_LISTENER_DEFAULT_IMPL$1", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TRACE_LISTENER_DEFAULT_IMPL$1;", "traceListener", "Lcom/tencent/luggage/launch/WxaLaunchTracer$ITraceListener;", "onEvent", "", "instanceId", "eventGroup", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEventGroup;", "event", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEvent;", "message", "onInstanceCompleted", "onNewInstanceStart", "params", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "setListener", "listener", "ITraceListener", "TraceEvent", "TraceEventGroup", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class t
{
  public static final t a = new t();
  private static final t.b b = new t.b();
  private static t.a c = (t.a)b;
  
  public final void a(@Nullable t.a parama)
  {
    if (parama == null) {
      parama = (t.a)b;
    }
    c = parama;
  }
  
  public final void a(@NotNull String paramString, @NotNull t.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "instanceId");
    Intrinsics.checkParameterIsNotNull(paramc, "event");
    c.a(paramString, t.d.g, paramc, null);
  }
  
  @JvmOverloads
  public final void a(@NotNull String paramString, @NotNull t.d paramd, @NotNull t.c paramc)
  {
    a(this, paramString, paramd, paramc, null, 8, null);
  }
  
  @JvmOverloads
  public final void a(@NotNull String paramString1, @NotNull t.d paramd, @NotNull t.c paramc, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "instanceId");
    Intrinsics.checkParameterIsNotNull(paramd, "eventGroup");
    Intrinsics.checkParameterIsNotNull(paramc, "event");
    c.a(paramString1, paramd, paramc, paramString2);
  }
  
  public final void a(@NotNull String paramString, @NotNull a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "instanceId");
    Intrinsics.checkParameterIsNotNull(parama, "params");
    c.a(paramString, parama);
    c.a(paramString, t.d.g, t.c.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.t
 * JD-Core Version:    0.7.0.1
 */