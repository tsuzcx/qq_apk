package com.tencent.luggage.wxa.cw;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qw.cr;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/GetWeRunUserStateResponse;", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class a$b<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  a$b(a parama, h paramh, int paramInt, JSONObject paramJSONObject) {}
  
  public final void a(cr paramcr)
  {
    if ((paramcr != null) && (paramcr.a == true))
    {
      this.b.a(this.c, this.a.b("ok"));
      return;
    }
    a.a(this.a, (com.tencent.luggage.wxa.iu.b)this.b, this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cw.a.b
 * JD-Core Version:    0.7.0.1
 */