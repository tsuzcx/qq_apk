package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.jx.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"}, k=3, mv={1, 1, 16})
final class j$b
  implements com.tencent.luggage.wxa.kl.b
{
  j$b(j paramj, String paramString, int paramInt, c paramc) {}
  
  public final void a(com.tencent.luggage.wxa.kl.j paramj)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("appId: ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", result: ");
    ((StringBuilder)localObject).append(paramj);
    com.tencent.luggage.wxa.kn.a.c("MicroMsg.AppBrand.JsApiMakeBluetoothPair", ((StringBuilder)localObject).toString(), new Object[0]);
    if (paramj.u != 0)
    {
      localObject = this.a;
      int i = this.c;
      c localc = this.d;
      int j = paramj.u;
      paramj = paramj.v;
      Intrinsics.checkExpressionValueIsNotNull(paramj, "result.errMsg");
      com.tencent.luggage.wxa.kn.b.a((com.tencent.luggage.wxa.jx.a)localObject, i, localc, j, paramj);
      return;
    }
    com.tencent.luggage.wxa.kn.b.a(this.a, this.c, this.d, null, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.j.b
 * JD-Core Version:    0.7.0.1
 */