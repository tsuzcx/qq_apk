package com.tencent.luggage.wxa.ej;

import com.tencent.luggage.wxa.ih.c;
import com.tencent.luggage.wxa.ih.c.a;
import com.tencent.luggage.wxa.qw.im;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "subscribeMsgResp", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class a$c<_Ret, _Var>
  implements b<_Ret, _Var>
{
  public static final c a = new c();
  
  @Nullable
  public final c a(im paramim)
  {
    if ((paramim != null) && (paramim.n == 0)) {
      return c.a.a(paramim);
    }
    o.b("WxaSubscribeMsgSettingDataHelper", "WxaAppModAuthReq failed, response is null!");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ej.a.c
 * JD-Core Version:    0.7.0.1
 */