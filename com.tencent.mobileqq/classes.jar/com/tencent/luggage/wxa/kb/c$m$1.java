package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.ro.b;
import com.tencent.luggage.wxa.rr.a;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.phonenumber.s;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "errMsg", "", "phoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "info", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "invoke"}, k=3, mv={1, 1, 16})
final class c$m$1
  extends Lambda
  implements Function4<Boolean, String, List<? extends r>, c.b, Unit>
{
  c$m$1(c.m paramm)
  {
    super(4);
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString, @Nullable List<r> paramList, @Nullable c.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    int i = 0;
    if (!paramBoolean)
    {
      paramList = this.a.e;
      if (((CharSequence)paramString).length() == 0) {
        i = 1;
      }
      if (i != 0) {
        paramString = "network request fail";
      }
      paramList.a(paramString);
      return;
    }
    this.a.e.a(new Object[] { a.a(s.a.a(paramList, null), paramb) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.m.1
 * JD-Core Version:    0.7.0.1
 */