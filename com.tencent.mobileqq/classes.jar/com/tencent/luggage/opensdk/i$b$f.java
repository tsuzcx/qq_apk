package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.qt.a;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "ticket", "", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class i$b$f<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  i$b$f(i.b paramb) {}
  
  @Nullable
  public final Void a(String paramString)
  {
    com.tencent.luggage.wxa.ro.b localb = h.c();
    a locala = new a();
    WXLaunchWxaRedirectingPage.Req localReq = new WXLaunchWxaRedirectingPage.Req();
    localReq.invokeTicket = paramString;
    a.a locala1 = i.b.b(this.a).a;
    Intrinsics.checkExpressionValueIsNotNull(locala1, "request.env");
    localReq.callbackActivity = locala1.b();
    if (!d.a(paramString, (BaseReq)localReq, (d.a)new i.b.f.a(this, locala, localb, paramString))) {
      localb.a("fail: send openapi request failed");
    } else {
      i.b.b(this.a).a.a((Runnable)new i.b.f.1(this, localb, locala, paramString));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i.b.f
 * JD-Core Version:    0.7.0.1
 */