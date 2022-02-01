package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.kl.j;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "kotlin.jvm.PlatformType", "onResult"}, k=3, mv={1, 1, 16})
final class e$b
  implements com.tencent.luggage.wxa.kl.b
{
  e$b(e parame, String paramString, int paramInt, c paramc) {}
  
  public final void a(j paramj)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("appId: ");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(", result: ");
    ((StringBuilder)localObject1).append(paramj);
    com.tencent.luggage.wxa.kn.a.c("MicroMsg.AppBrand.JsApiGetBLEDeviceRSSI", ((StringBuilder)localObject1).toString(), new Object[0]);
    int i;
    Object localObject2;
    int j;
    if (paramj.u != 0)
    {
      localObject1 = this.a;
      i = this.c;
      localObject2 = this.d;
      j = paramj.u;
      paramj = paramj.v;
      Intrinsics.checkExpressionValueIsNotNull(paramj, "result.errMsg");
      com.tencent.luggage.wxa.kn.b.a((com.tencent.luggage.wxa.jx.a)localObject1, i, (c)localObject2, j, paramj);
      return;
    }
    localObject1 = paramj.w;
    paramj = (j)localObject1;
    if (!(localObject1 instanceof Integer)) {
      paramj = null;
    }
    paramj = (Integer)paramj;
    if (paramj == null)
    {
      paramj = this.a;
      i = this.c;
      localObject1 = this.d;
      j = j.b.u;
      localObject2 = j.b.v;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "Result.FAIL.errMsg");
      com.tencent.luggage.wxa.kn.b.a(paramj, i, (c)localObject1, j, (String)localObject2);
      return;
    }
    com.tencent.luggage.wxa.kn.b.a(this.a, this.c, this.d, MapsKt.hashMapOf(new Pair[] { TuplesKt.to("RSSI", paramj) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.e.b
 * JD-Core Version:    0.7.0.1
 */