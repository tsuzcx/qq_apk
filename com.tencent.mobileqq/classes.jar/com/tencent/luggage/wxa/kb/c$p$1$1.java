package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.kc.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.phonenumber.aa;
import com.tencent.mm.plugin.appbrand.phonenumber.s;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$p$1$1
  implements Runnable
{
  c$p$1$1(c.p.1 param1) {}
  
  public final void run()
  {
    Object localObject1 = this.a.a.c;
    Object localObject2 = s.a.a();
    if (localObject2 != null)
    {
      ((a)localObject1).a((ArrayList)localObject2);
      localObject2 = aa.a;
      localObject1 = this.a.a.b;
      if (localObject1 != null) {
        localObject1 = ((u)localObject1).getAppId();
      } else {
        localObject1 = null;
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "env?.appId");
      ((aa)localObject2).c((String)localObject1);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> /* = java.util.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> */");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.p.1.1
 * JD-Core Version:    0.7.0.1
 */