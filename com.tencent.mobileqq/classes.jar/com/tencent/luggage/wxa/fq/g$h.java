package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.fv.f;
import com.tencent.luggage.wxa.fv.f.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.luggage.wxaapi.TdiAuthListener;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendTdiAuth.Resp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/WxaApiImpl$handleIntentImpl$1", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "onReq", "", "p0", "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "onResp", "resp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class g$h
  implements IWXAPIEventHandler
{
  g$h(boolean[] paramArrayOfBoolean) {}
  
  public void onReq(@Nullable BaseReq paramBaseReq) {}
  
  public void onResp(@NotNull BaseResp paramBaseResp)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseResp, "resp");
    Object localObject1 = (g.a)g.a(this.a).remove(paramBaseResp.transaction);
    if (localObject1 != null)
    {
      TdiAuthListener localTdiAuthListener = ((g.a)localObject1).a();
      IWXAPIEventHandler localIWXAPIEventHandler = ((g.a)localObject1).b();
      localObject1 = this.b;
      int i = 1;
      localObject1[0] = 1;
      g.a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleIntentImpl, resp.transaction=");
      ((StringBuilder)localObject1).append(paramBaseResp.transaction);
      o.d("Luggage.WxaApiImpl", ((StringBuilder)localObject1).toString());
      boolean bool = paramBaseResp instanceof SendTdiAuth.Resp;
      StringBuilder localStringBuilder = null;
      if (!bool) {
        localObject1 = null;
      } else {
        localObject1 = paramBaseResp;
      }
      SendTdiAuth.Resp localResp = (SendTdiAuth.Resp)localObject1;
      localObject1 = localStringBuilder;
      if (localResp != null) {
        localObject1 = localResp.tdiAuthBuffer;
      }
      if (localObject1 != null)
      {
        if (localObject1.length != 0) {
          i = 0;
        }
        if (i == 0)
        {
          try
          {
            f.a.a((byte[])localObject1, localTdiAuthListener);
          }
          catch (Exception localException)
          {
            g.a();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleIntentImpl fail, e:");
            localStringBuilder.append(localException);
            o.b("Luggage.WxaApiImpl", localStringBuilder.toString());
            if (localTdiAuthListener == null) {
              break label380;
            }
          }
          localTdiAuthListener.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_System, paramBaseResp.errStr);
          break label380;
        }
      }
      g.a();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleIntentImpl, tdiAuthBuffer invalid, resp.errCode=");
      ((StringBuilder)localObject2).append(paramBaseResp.errCode);
      ((StringBuilder)localObject2).append(", resp.errStr=");
      ((StringBuilder)localObject2).append(paramBaseResp.errStr);
      o.b("Luggage.WxaApiImpl", ((StringBuilder)localObject2).toString());
      i = paramBaseResp.errCode;
      if (i != -4)
      {
        if (i != -2)
        {
          if (localTdiAuthListener != null) {
            localTdiAuthListener.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_System, paramBaseResp.errStr);
          }
        }
        else if (localTdiAuthListener != null) {
          localTdiAuthListener.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_UserCanceled, paramBaseResp.errStr);
        }
      }
      else if (localTdiAuthListener != null) {
        localTdiAuthListener.onAuthFinish(TdiAuthErrCode.WechatTdi_Auth_Err_UserDenied, paramBaseResp.errStr);
      }
      label380:
      if (localIWXAPIEventHandler != null)
      {
        localObject2 = new SendAuth.Resp();
        ((SendAuth.Resp)localObject2).fromBundle(i.a(paramBaseResp));
        localIWXAPIEventHandler.onResp((BaseResp)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.h
 * JD-Core Version:    0.7.0.1
 */