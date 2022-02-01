package com.tencent.luggage.wxa.de;

import com.tencent.luggage.wxa.ob.a;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "TRAN_REQ", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "TRAN_RESP", "transResp", "call", "(Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;"}, k=3, mv={1, 1, 16})
final class j$i<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  j$i(j paramj, String paramString, Class paramClass) {}
  
  @Nullable
  public final RESP a(@Nullable TRAN_RESP paramTRAN_RESP)
  {
    try
    {
      paramTRAN_RESP = j.a(this.a, this.b, paramTRAN_RESP, this.c);
      return paramTRAN_RESP;
    }
    catch (a paramTRAN_RESP)
    {
      h.b().a(paramTRAN_RESP);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.j.i
 * JD-Core Version:    0.7.0.1
 */