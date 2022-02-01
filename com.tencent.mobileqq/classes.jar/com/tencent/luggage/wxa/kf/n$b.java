package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"}, k=3, mv={1, 1, 16})
final class n$b
  implements com.tencent.luggage.wxa.kl.b
{
  n$b(n paramn, String paramString, int paramInt, c paramc) {}
  
  public final void a(j paramj)
  {
    o.e("MicroMsg.JsApiSetBLEMtu", "invoke: appid %s setMtuSize result = %s", new Object[] { this.b, paramj });
    if (paramj.u != 0)
    {
      n localn = this.a;
      int i = this.c;
      c localc = this.d;
      int j = paramj.u;
      paramj = paramj.v;
      Intrinsics.checkExpressionValueIsNotNull(paramj, "result.errMsg");
      com.tencent.luggage.wxa.kn.b.a(localn, i, localc, j, paramj);
      return;
    }
    com.tencent.luggage.wxa.kn.b.a(this.a, this.c, this.d, null, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.n.b
 * JD-Core Version:    0.7.0.1
 */