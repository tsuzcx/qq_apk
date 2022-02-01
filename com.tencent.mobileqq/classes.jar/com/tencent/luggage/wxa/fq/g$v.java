package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.luggage.wxaapi.TdiAuthListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "authErrCode", "Lcom/tencent/luggage/wxaapi/TdiAuthErrCode;", "authErrMsg", "", "onAuthFinish"}, k=3, mv={1, 1, 16})
final class g$v
  implements TdiAuthListener
{
  g$v(TdiAuthListener paramTdiAuthListener) {}
  
  public final void onAuthFinish(@NotNull TdiAuthErrCode paramTdiAuthErrCode, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramTdiAuthErrCode, "authErrCode");
    if (paramTdiAuthErrCode != TdiAuthErrCode.WechatTdi_Auth_Err_OK)
    {
      g.a();
      o.b("Luggage.WxaApiImpl", "sendCombineAuth: fail: [%s, %s]", new Object[] { paramTdiAuthErrCode.name(), paramString });
    }
    else
    {
      g.a();
      o.d("Luggage.WxaApiImpl", "sendCombineAuth success");
    }
    TdiAuthListener localTdiAuthListener = this.a;
    if (localTdiAuthListener != null) {
      localTdiAuthListener.onAuthFinish(paramTdiAuthErrCode, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.v
 * JD-Core Version:    0.7.0.1
 */