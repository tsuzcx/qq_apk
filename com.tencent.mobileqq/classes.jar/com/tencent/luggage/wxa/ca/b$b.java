package com.tencent.luggage.wxa.ca;

import com.tencent.luggage.wxa.qw.c;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/AdDataReportResponse;", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class b$b<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  b$b(b paramb, com.tencent.luggage.wxa.iu.b paramb1, int paramInt) {}
  
  public final void a(c paramc)
  {
    if (paramc.a == 0)
    {
      this.b.a(this.c, this.a.b("ok"));
      return;
    }
    com.tencent.luggage.wxa.iu.b localb = this.b;
    int i = this.c;
    b localb1 = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail:");
    localStringBuilder.append(paramc.b);
    localb.a(i, localb1.b(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ca.b.b
 * JD-Core Version:    0.7.0.1
 */