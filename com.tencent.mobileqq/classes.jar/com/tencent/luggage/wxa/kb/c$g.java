package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.rl.b;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.phonenumber.aa;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "it", "call"}, k=3, mv={1, 1, 16})
final class c$g<_Ret, _Var>
  implements b<_Ret, _Var>
{
  c$g(c paramc, u paramu, String paramString, boolean paramBoolean) {}
  
  @Nullable
  public final com.tencent.luggage.wxa.rr.c<List<r>, c.b> a(@Nullable com.tencent.luggage.wxa.rr.c<List<r>, c.b> paramc)
  {
    c localc = this.a;
    u localu = this.b;
    Object localObject = aa.a;
    String str = this.b.getAppId();
    Intrinsics.checkExpressionValueIsNotNull(str, "env.appId");
    localObject = ((aa)localObject).d(str);
    str = this.c;
    Intrinsics.checkExpressionValueIsNotNull(str, "apiName");
    return c.a(localc, paramc, localu, (z)localObject, str, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.g
 * JD-Core Version:    0.7.0.1
 */