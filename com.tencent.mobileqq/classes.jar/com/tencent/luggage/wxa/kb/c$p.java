package com.tencent.luggage.wxa.kb;

import android.content.Context;
import com.tencent.luggage.wxa.kc.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.phonenumber.aa;
import com.tencent.mm.plugin.appbrand.phonenumber.n;
import com.tencent.mm.plugin.appbrand.phonenumber.v;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class c$p
  extends Lambda
  implements Function0<Unit>
{
  c$p(z paramz, u paramu, a parama)
  {
    super(0);
  }
  
  public final void a()
  {
    Object localObject2 = this.a;
    String str = null;
    if (localObject2 != null)
    {
      if (localObject2 != null) {
        localObject1 = Long.valueOf(((z)localObject2).i());
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((z)localObject2).j(((Long)localObject1).longValue() + 1L);
    }
    localObject2 = aa.a;
    Object localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((u)localObject1).getAppId();
    } else {
      localObject1 = null;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "env?.appId");
    ((aa)localObject2).b((String)localObject1);
    localObject2 = v.a.a();
    localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = ((u)localObject1).getContext();
    } else {
      localObject1 = null;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "env?.context");
    u localu = this.b;
    if (localu != null) {
      str = localu.getAppId();
    }
    Intrinsics.checkExpressionValueIsNotNull(str, "env?.appId");
    ((n)localObject2).a((Context)localObject1, str, (Function2)new c.p.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.p
 * JD-Core Version:    0.7.0.1
 */