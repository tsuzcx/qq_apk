package com.tencent.luggage.wxa.dg;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.rr.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/vending/tuple/Tuple6;", "", "kotlin.jvm.PlatformType", "", "call"}, k=3, mv={1, 1, 16})
final class d$b<_Ret, _Var>
  implements b<_Ret, _Var>
{
  public static final b a = new b();
  
  public final boolean a(g<Integer, String, String, String, String, String> paramg)
  {
    Integer localInteger = (Integer)paramg.b();
    String str1 = (String)paramg.c();
    String str2 = (String)paramg.d();
    String str3 = (String)paramg.e();
    String str4 = (String)paramg.f();
    paramg = (String)paramg.g();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("obtain token success productId:");
    ((StringBuilder)localObject).append(localInteger);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(str4);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramg);
    o.d("WxaDeviceLogic", ((StringBuilder)localObject).toString());
    localObject = d.a;
    Intrinsics.checkExpressionValueIsNotNull(localInteger, "productId");
    int i = localInteger.intValue();
    Intrinsics.checkExpressionValueIsNotNull(str1, "deviceId");
    Intrinsics.checkExpressionValueIsNotNull(str2, "username");
    Intrinsics.checkExpressionValueIsNotNull(str3, "token");
    Intrinsics.checkExpressionValueIsNotNull(str4, "hostAppId");
    Intrinsics.checkExpressionValueIsNotNull(paramg, "extraData");
    return ((d)localObject).a(i, str1, str2, str3, str4, paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dg.d.b
 * JD-Core Version:    0.7.0.1
 */