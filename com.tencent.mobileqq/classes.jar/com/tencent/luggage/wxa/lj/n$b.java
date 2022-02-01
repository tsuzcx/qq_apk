package com.tencent.luggage.wxa.lj;

import com.tencent.luggage.wxa.lk.e;
import com.tencent.luggage.wxa.lk.e.a;
import com.tencent.luggage.wxa.lk.e.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"}, k=3, mv={1, 1, 16})
final class n$b
  extends Lambda
  implements Function1<e<Unit>, Unit>
{
  n$b(n paramn, com.tencent.luggage.wxa.jx.c paramc, int paramInt, com.tencent.luggage.wxa.lk.c paramc1)
  {
    super(1);
  }
  
  public final void a(@NotNull e<Unit> parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "result");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stopNFCDiscovery, result: ");
    ((StringBuilder)localObject).append(parame);
    o.e("MicroMsg.AppBrand.JsApiStopNFCDiscovery", ((StringBuilder)localObject).toString());
    if ((parame instanceof e.b))
    {
      this.b.a(this.c, this.a.b("ok"));
      this.d.a((Function3)null);
      return;
    }
    if ((parame instanceof e.a))
    {
      localObject = this.b;
      int i = this.c;
      n localn = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail:");
      parame = (e.a)parame;
      localStringBuilder.append(parame.b());
      ((com.tencent.luggage.wxa.jx.c)localObject).a(i, localn.a(localStringBuilder.toString(), (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("errCode", Integer.valueOf(parame.a())) })));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lj.n.b
 * JD-Core Version:    0.7.0.1
 */