package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.dg.b.a;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "_productId", "", "_deviceId", "", "kotlin.jvm.PlatformType", "_username", "_token", "_hostAppid", "_extraData", "callback"}, k=3, mv={1, 1, 16})
final class w$g
  implements b.a
{
  w$g(Function2 paramFunction2) {}
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    w.a(w.a, paramInt);
    w localw = w.a;
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "_deviceId");
    w.a(localw, paramString1);
    paramString1 = w.a;
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "_username");
    w.b(paramString1, paramString2);
    paramString1 = w.a;
    Intrinsics.checkExpressionValueIsNotNull(paramString3, "_token");
    w.c(paramString1, paramString3);
    paramString1 = w.a;
    Intrinsics.checkExpressionValueIsNotNull(paramString4, "_hostAppid");
    w.d(paramString1, paramString4);
    paramString1 = w.a;
    Intrinsics.checkExpressionValueIsNotNull(paramString5, "_extraData");
    w.e(paramString1, paramString5);
    paramString1 = new StringBuilder();
    paramString1.append("first boot: activate device productId:");
    paramString1.append(w.c(w.a));
    paramString1.append(" deviceId:");
    paramString1.append(w.d(w.a));
    paramString1.append(" token:");
    paramString1.append(w.f(w.a));
    paramString1.append(" hostAppId:");
    paramString1.append(w.g(w.a));
    o.d("Luggage.WxaTdiLoginBoot", paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("first boot: activate device username:");
    paramString1.append(w.e(w.a));
    paramString1.append(" token:");
    paramString1.append(w.f(w.a));
    o.f("Luggage.WxaTdiLoginBoot", paramString1.toString());
    if (w.a(w.a, Integer.valueOf(w.c(w.a)), w.d(w.a), w.e(w.a), w.f(w.a)))
    {
      this.a.invoke(Boolean.valueOf(true), "");
      return;
    }
    this.a.invoke(Boolean.valueOf(false), "first boot: activate device fail");
    paramString1 = w.h(w.a);
    if (paramString1 != null) {
      paramString1 = (Unit)paramString1.invoke(Boolean.valueOf(false), "first boot: activate device fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.g
 * JD-Core Version:    0.7.0.1
 */