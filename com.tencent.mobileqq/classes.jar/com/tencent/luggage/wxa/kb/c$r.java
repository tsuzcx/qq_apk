package com.tencent.luggage.wxa.kb;

import android.content.Context;
import com.tencent.luggage.wxa.jx.m.a;
import com.tencent.luggage.wxa.qw.hn;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.phonenumber.n;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.phonenumber.s;
import com.tencent.mm.plugin.appbrand.phonenumber.v;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "invoke"}, k=3, mv={1, 1, 16})
final class c$r
  extends Lambda
  implements Function1<r, Unit>
{
  c$r(z paramz, u paramu, c.b paramb, b paramb1)
  {
    super(1);
  }
  
  public final void a(@NotNull r paramr)
  {
    Intrinsics.checkParameterIsNotNull(paramr, "phoneItem");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select phoneItem ");
    ((StringBuilder)localObject1).append(paramr);
    o.e("MicroMsg.JsApiGetPhoneNumberNew", ((StringBuilder)localObject1).toString());
    Object localObject4 = this.a;
    Object localObject3 = null;
    Object localObject2 = null;
    if (localObject4 != null)
    {
      if (localObject4 != null) {
        localObject1 = Long.valueOf(((z)localObject4).c());
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((z)localObject4).d(((Long)localObject1).longValue() + 1L);
    }
    if (paramr.g())
    {
      localObject2 = v.a.a();
      localObject3 = this.b.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "env.context");
      localObject4 = this.b.getAppId();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "env.appId");
      localObject1 = this.c;
      if (localObject1 != null)
      {
        localObject1 = ((c.b)localObject1).a();
        if (localObject1 != null)
        {
          localObject1 = ((hn)localObject1).d;
          if (localObject1 != null) {
            break label168;
          }
        }
      }
      localObject1 = "";
      label168:
      ((n)localObject2).a((Context)localObject3, (String)localObject4, (String)localObject1, this.a, paramr, (Function2)new c.r.a(this, paramr));
      return;
    }
    if (paramr.i())
    {
      localObject3 = this.a;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = Long.valueOf(((z)localObject3).f());
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((z)localObject3).g(((Long)localObject1).longValue() + 1L);
      }
    }
    else
    {
      localObject2 = this.a;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (localObject2 != null) {
          localObject1 = Long.valueOf(((z)localObject2).g());
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((z)localObject2).h(((Long)localObject1).longValue() + 1L);
      }
    }
    localObject1 = this.d;
    localObject2 = new m.a("ok", new Object[0]);
    localObject3 = new HashMap();
    ((HashMap)localObject3).put("encryptedData", paramr.d());
    ((HashMap)localObject3).put("iv", paramr.e());
    ((HashMap)localObject3).put("cloud_id", paramr.f());
    ((m.a)localObject2).a((Map)localObject3);
    ((b)localObject1).a(new Object[] { localObject2 });
    s.a.a(paramr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.r
 * JD-Core Version:    0.7.0.1
 */