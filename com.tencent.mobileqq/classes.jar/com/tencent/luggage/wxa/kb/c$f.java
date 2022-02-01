package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.rl.b;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.phonenumber.aa;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "localPhoneItems", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class c$f<_Ret, _Var>
  implements b<_Ret, _Var>
{
  c$f(c paramc, u paramu, String paramString, boolean paramBoolean) {}
  
  @Nullable
  public final com.tencent.luggage.wxa.rr.c<List<r>, c.b> a(List<r> paramList)
  {
    c localc = this.a;
    u localu = this.b;
    String str1 = this.c;
    Intrinsics.checkExpressionValueIsNotNull(str1, "apiName");
    boolean bool = this.d;
    aa localaa = aa.a;
    String str2 = this.b.getAppId();
    Intrinsics.checkExpressionValueIsNotNull(str2, "env.appId");
    return c.a(localc, localu, str1, bool, paramList, localaa.d(str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.f
 * JD-Core Version:    0.7.0.1
 */