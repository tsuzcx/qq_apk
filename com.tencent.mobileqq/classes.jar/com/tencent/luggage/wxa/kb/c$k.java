package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.phonenumber.aa;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "res", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class c$k<T>
  implements e.a<Object>
{
  c$k(c paramc, u paramu, int paramInt) {}
  
  public final void a(Object paramObject)
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
    int i;
    StringBuilder localStringBuilder;
    if ((paramObject instanceof String))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getphonenumber fail:");
      ((StringBuilder)localObject1).append(paramObject);
      o.b("MicroMsg.JsApiGetPhoneNumberNew", ((StringBuilder)localObject1).toString());
      localObject1 = this.b;
      if (localObject1 != null)
      {
        i = this.c;
        localObject2 = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fail:");
        localStringBuilder.append(paramObject);
        ((u)localObject1).a(i, ((c)localObject2).b(localStringBuilder.toString()));
      }
    }
    else if ((paramObject instanceof Exception))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getphonenumber fail:{");
      ((StringBuilder)localObject1).append(paramObject);
      ((StringBuilder)localObject1).append(".message}");
      o.b("MicroMsg.JsApiGetPhoneNumberNew", ((StringBuilder)localObject1).toString());
      localObject1 = this.b;
      if (localObject1 != null)
      {
        i = this.c;
        localObject2 = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fail:{");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(".message}");
        ((u)localObject1).a(i, ((c)localObject2).b(localStringBuilder.toString()));
      }
    }
    else
    {
      o.b("MicroMsg.JsApiGetPhoneNumberNew", "getphonenumber fail");
      paramObject = this.b;
      if (paramObject != null) {
        paramObject.a(this.c, this.a.b("fail"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.k
 * JD-Core Version:    0.7.0.1
 */