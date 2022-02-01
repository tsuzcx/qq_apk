package com.tencent.luggage.opensdk;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/opensdk/modelbiz/WXLaunchWxaRedirectingPage$Resp;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class i$b$f$a<T extends BaseResp>
  implements d.a<WXLaunchWxaRedirectingPage.Resp>
{
  i$b$f$a(i.b.f paramf, com.tencent.luggage.wxa.qt.a parama, com.tencent.luggage.wxa.ro.b paramb, String paramString) {}
  
  public final void a(WXLaunchWxaRedirectingPage.Resp paramResp)
  {
    this.b.a = true;
    Object localObject1 = com.tencent.luggage.wxa.qy.a.a;
    Object localObject2 = new b();
    ((b)localObject2).a(i.b.b(this.a.a));
    ((b)localObject2).a(paramResp);
    ((com.tencent.luggage.wxa.qy.a)localObject1).a((com.tencent.luggage.wxa.qy.b)localObject2);
    localObject1 = i.b.b(this.a.a).a;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "request.env");
    if (!((a.a)localObject1).c())
    {
      this.c.a(new Object[] { i.b.a(this.a.a, i.b.b(this.a.a), "ok", null, 2, null) });
      return;
    }
    if (paramResp.errCode != 0)
    {
      localObject1 = this.a.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("on OpenSDKApiClient.Callback, errCode:");
      ((StringBuilder)localObject2).append(paramResp.errCode);
      ((StringBuilder)localObject2).append(", errMsg:");
      ((StringBuilder)localObject2).append(paramResp.errStr);
      i.b.a((i.b)localObject1, ((StringBuilder)localObject2).toString());
      localObject1 = (Map)new HashMap();
      ((Map)localObject1).put("sdkErrCode", Integer.valueOf(paramResp.errCode));
      paramResp = paramResp.errStr;
      Intrinsics.checkExpressionValueIsNotNull(paramResp, "resp.errStr");
      ((Map)localObject1).put("sdkErrMsg", paramResp);
      this.c.a(new Object[] { i.b.a(this.a.a, i.b.b(this.a.a), "fail", (Map)localObject1) });
      return;
    }
    paramResp = i.b.b(this.a.a);
    localObject1 = this.d;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ticket");
    new j(paramResp, (String)localObject1, (Function1)new i.b.f.a.1(this), (Function1)new i.b.f.a.2(this)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i.b.f.a
 * JD-Core Version:    0.7.0.1
 */