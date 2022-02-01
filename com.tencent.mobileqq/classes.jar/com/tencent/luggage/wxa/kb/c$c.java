package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.qz.o;
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
final class c$c
  extends Lambda
  implements Function4<Boolean, String, List<? extends r>, c.b, Unit>
{
  c$c(b paramb, List paramList)
  {
    super(4);
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString, @Nullable List<r> paramList, @Nullable c.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getPhoneNumber isSuccess:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", ");
    localStringBuilder.append("phoneItems:");
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    o.d("MicroMsg.JsApiGetPhoneNumberNew", localStringBuilder.toString());
    int i = 1;
    if (!paramBoolean)
    {
      paramList = this.a;
      if (((CharSequence)paramString).length() != 0) {
        i = 0;
      }
      if (i != 0) {
        paramString = "network request fail";
      }
      paramList.a(paramString);
      return;
    }
    this.a.a(new Object[] { a.a(s.a.a(paramList, this.b), paramb) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.c
 * JD-Core Version:    0.7.0.1
 */