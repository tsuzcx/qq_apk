package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.cx.q;
import com.tencent.luggage.wxa.ea.c;
import com.tencent.luggage.wxa.ea.c.a;
import com.tencent.luggage.wxa.ew.b;
import com.tencent.luggage.wxa.ou.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.TdiAuthCheckStateListener;
import com.tencent.luggage.wxaapi.TdiAuthState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "authState", "Lcom/tencent/luggage/wxaapi/TdiAuthState;", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onStateChecked"}, k=3, mv={1, 1, 16})
final class g$l$1$1
  implements TdiAuthCheckStateListener
{
  g$l$1$1(g.l.1 param1) {}
  
  public final void onStateChecked(@NotNull TdiAuthState paramTdiAuthState, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramTdiAuthState, "authState");
    g.a();
    paramString = new StringBuilder();
    paramString.append("launchByUsername username:");
    paramString.append(this.a.a.c);
    paramString.append(" appId:");
    paramString.append(this.a.b);
    paramString.append(" authState:");
    paramString.append(paramTdiAuthState);
    o.d("Luggage.WxaApiImpl", paramString.toString());
    if (h.d[paramTdiAuthState.ordinal()] != 1)
    {
      g.a();
      paramString = new StringBuilder();
      paramString.append("launchWxaApp rejected, authState:");
      paramString.append(paramTdiAuthState);
      o.b("Luggage.WxaApiImpl", paramString.toString());
      com.tencent.luggage.wxa.ft.a.a.a(this.a.a.b, LaunchWxaAppResult.FailNoAuth);
      return;
    }
    com.tencent.luggage.wxa.standalone_open_runtime.container.a.a.b();
    if (c.c.a())
    {
      c.c.a(false);
      c.c.c();
    }
    j.a.a(this.a.b);
    f.a.e((Runnable)g.l.1.1.1.a);
    paramTdiAuthState = this.a.a.d;
    paramString = new b();
    paramString.a = this.a.b;
    paramString.e = this.a.a.e;
    paramString.d = this.a.a.f;
    paramString.j = this.a.a.b;
    d locald = new d();
    locald.c = 1168;
    locald.d = g.b(this.a.a.a);
    q.a(paramTdiAuthState, paramString, locald);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.l.1.1
 * JD-Core Version:    0.7.0.1
 */