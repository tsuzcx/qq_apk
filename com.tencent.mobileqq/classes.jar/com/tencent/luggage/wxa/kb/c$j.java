package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.jx.m.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.phonenumber.aa;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "kotlin.jvm.PlatformType", "onTerminate"}, k=3, mv={1, 1, 16})
final class c$j<T>
  implements e.c<m.a>
{
  c$j(c paramc, u paramu, int paramInt) {}
  
  public final void a(m.a parama)
  {
    Object localObject1 = aa.a;
    Object localObject2 = this.b.getAppId();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "env.appId");
    localObject1 = ((aa)localObject1).d((String)localObject2);
    if (localObject1 != null) {
      ((z)localObject1).a();
    }
    localObject2 = aa.a;
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((u)localObject1).getAppId();
    } else {
      localObject1 = null;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "env?.appId");
    ((aa)localObject2).e((String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("callResult: ");
    ((StringBuilder)localObject1).append(parama.b);
    ((StringBuilder)localObject1).append(' ');
    ((StringBuilder)localObject1).append(parama.a);
    o.d("MicroMsg.JsApiGetPhoneNumberNew", ((StringBuilder)localObject1).toString());
    if (parama == null)
    {
      o.b("MicroMsg.JsApiGetPhoneNumberNew", "callResult is null, fail");
      parama = this.b;
      if (parama != null) {
        parama.a(this.c, this.a.b("fail"));
      }
    }
    else
    {
      this.b.a(this.c, this.a.a(parama.b, parama.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.j
 * JD-Core Version:    0.7.0.1
 */