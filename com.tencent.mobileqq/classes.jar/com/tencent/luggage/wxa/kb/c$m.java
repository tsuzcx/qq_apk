package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.phonenumber.d;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class c$m
  extends Lambda
  implements Function1<Integer, Unit>
{
  c$m(z paramz, u paramu, String paramString, boolean paramBoolean, b paramb)
  {
    super(1);
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == -1)
    {
      localObject = this.a;
      if (localObject != null) {
        ((z)localObject).b(1L);
      }
      z localz = this.a;
      if (localz != null)
      {
        if (localz != null) {
          localObject = Long.valueOf(localz.b());
        } else {
          localObject = null;
        }
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localz.c(((Long)localObject).longValue() + 1L);
      }
      localObject = this.b.getAppId();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "env.appId");
      new d((String)localObject, this.c, this.d).a((Function4)new c.m.1(this));
      return;
    }
    o.b("MicroMsg.JsApiGetPhoneNumberNew", "bind wechat phone number fail");
    Object localObject = this.a;
    if (localObject != null) {
      ((z)localObject).b(0L);
    }
    this.e.a("user cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.m
 * JD-Core Version:    0.7.0.1
 */