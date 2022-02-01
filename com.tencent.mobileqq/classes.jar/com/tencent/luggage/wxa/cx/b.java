package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.dc.f;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/BonusStepCheckWxaDebugInfo;", "DELIVER", "Lcom/tencent/mm/vending/functional/Functional;", "appId", "", "(Ljava/lang/String;)V", "TAG", "call", "p0", "(Ljava/lang/Object;)Ljava/lang/Object;", "traceEvent", "", "o", "eventGroup", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEventGroup;", "event", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEvent;", "message", "(Ljava/lang/Object;Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEventGroup;Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEvent;Ljava/lang/String;)V", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b<DELIVER>
  implements com.tencent.luggage.wxa.rl.b<DELIVER, DELIVER>
{
  private final String a;
  private final String b;
  
  public b(@NotNull String paramString)
  {
    this.b = paramString;
    paramString = new StringBuilder();
    paramString.append("BonusStepCheckWxaDebugInfo[");
    paramString.append(this.b);
    paramString.append(']');
    this.a = paramString.toString();
  }
  
  private final void a(DELIVER paramDELIVER, t.d paramd, t.c paramc, String paramString)
  {
    if ((paramDELIVER instanceof c))
    {
      t localt = t.a;
      paramDELIVER = ((c)paramDELIVER).i();
      Intrinsics.checkExpressionValueIsNotNull(paramDELIVER, "o.wxaLaunchInstanceId");
      localt.a(paramDELIVER, paramd, paramc, paramString);
      return;
    }
    if ((paramDELIVER instanceof p)) {
      t.a.a(((p)paramDELIVER).a(), paramd, paramc, paramString);
    }
  }
  
  public DELIVER a(DELIVER paramDELIVER)
  {
    a(this, paramDELIVER, t.d.f, t.c.b, null, 8, null);
    com.tencent.luggage.wxa.ro.b localb = h.c();
    f.b(this.b, 1).a((e.c)new b.a(this, paramDELIVER, localb)).a((e.a)new b.b(this, localb, paramDELIVER));
    return paramDELIVER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.b
 * JD-Core Version:    0.7.0.1
 */