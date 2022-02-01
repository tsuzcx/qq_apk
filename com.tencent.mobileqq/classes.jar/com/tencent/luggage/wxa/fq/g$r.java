package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.fs.a;
import com.tencent.luggage.wxa.fs.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.DebugApi;
import com.tencent.luggage.wxaapi.WxaApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/wxaapi/DebugApi;", "invoke"}, k=3, mv={1, 1, 16})
final class g$r
  extends Lambda
  implements Function0<DebugApi>
{
  g$r(g paramg)
  {
    super(0);
  }
  
  @NotNull
  public final DebugApi a()
  {
    g.a();
    o.d("Luggage.WxaApiImpl", "getDebugApi");
    if (f.a.b()) {
      return (DebugApi)new b((WxaApi)this.a);
    }
    return (DebugApi)new a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.r
 * JD-Core Version:    0.7.0.1
 */