package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.jx.m.a;
import com.tencent.luggage.wxa.kc.a;
import com.tencent.luggage.wxa.kc.a.b;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.phonenumber.aa;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "Lcom/tencent/mm/vending/tuple/Tuple2;", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "call"}, k=3, mv={1, 1, 16})
final class c$i<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  c$i(c paramc, u paramu, e parame) {}
  
  @NotNull
  public final m.a a(@Nullable com.tencent.luggage.wxa.rr.c<List<r>, c.b> paramc)
  {
    a locala = a.b.a((com.tencent.luggage.wxa.iu.b)this.b);
    c localc = this.a;
    u localu = this.b;
    e locale = this.c;
    aa localaa = aa.a;
    String str = this.b.getAppId();
    Intrinsics.checkExpressionValueIsNotNull(str, "env.appId");
    return c.a(localc, paramc, localu, locale, locala, localaa.d(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.i
 * JD-Core Version:    0.7.0.1
 */