package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxaapi.LaunchWxaAppResult;
import com.tencent.luggage.wxaapi.TdiAuthCheckStateListener;
import com.tencent.luggage.wxaapi.TdiAuthState;
import com.tencent.luggage.wxaapi.WxaApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "authState", "Lcom/tencent/luggage/wxaapi/TdiAuthState;", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onStateChecked"}, k=3, mv={1, 1, 16})
final class g$j$1
  implements TdiAuthCheckStateListener
{
  g$j$1(g.j paramj) {}
  
  public final void onStateChecked(@NotNull TdiAuthState paramTdiAuthState, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramTdiAuthState, "authState");
    g.a();
    paramString = new StringBuilder();
    paramString.append("launchByQRRawData authState:");
    paramString.append(paramTdiAuthState);
    o.d("Luggage.WxaApiImpl", paramString.toString());
    if (h.f[paramTdiAuthState.ordinal()] != 1)
    {
      com.tencent.luggage.wxa.ft.a.a.a(this.a.d, LaunchWxaAppResult.FailNoAuth);
      return;
    }
    com.tencent.luggage.wxa.standalone_open_runtime.container.a.a.b();
    b.a.a((WxaApi)this.a.a);
    paramString = b.a;
    paramTdiAuthState = this.a.b;
    if (paramTdiAuthState == null)
    {
      paramTdiAuthState = r.a();
      Intrinsics.checkExpressionValueIsNotNull(paramTdiAuthState, "MMApplicationContext.getContext()");
    }
    paramString.a(paramTdiAuthState, this.a.c, this.a.d, this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.j.1
 * JD-Core Version:    0.7.0.1
 */