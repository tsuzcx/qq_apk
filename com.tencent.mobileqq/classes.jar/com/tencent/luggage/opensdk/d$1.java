package com.tencent.luggage.opensdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

final class d$1
  implements IWXAPIEventHandler
{
  d$1(Context paramContext, boolean[] paramArrayOfBoolean, Intent paramIntent) {}
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    if (!d.a(paramBaseResp))
    {
      if ((paramBaseResp instanceof WXLaunchMiniProgram.Resp))
      {
        paramBaseResp = g.b.a((WXLaunchMiniProgram.Resp)paramBaseResp);
        if ((this.a != null) && (paramBaseResp.c) && (!af.c(paramBaseResp.d)))
        {
          this.b[0] = true;
          o.d("Luggage.OpenSDKApiClient", "startActivity name:%s", new Object[] { paramBaseResp.d });
          this.c.setClassName(this.a, paramBaseResp.d);
          this.a.startActivity(this.c);
        }
      }
      else if ((paramBaseResp instanceof WXLaunchWxaRedirectingPage.Resp))
      {
        this.b[0] = true;
        paramBaseResp = (WXLaunchWxaRedirectingPage.Resp)paramBaseResp;
        if ((this.a != null) && (!TextUtils.isEmpty(paramBaseResp.callbackActivity)))
        {
          if (this.a.getClass().getName().equals(paramBaseResp.callbackActivity))
          {
            o.c("Luggage.OpenSDKApiClient", "already in target callbackActivity %s", new Object[] { paramBaseResp.callbackActivity });
            return;
          }
          this.c.setClassName(this.a, paramBaseResp.callbackActivity);
          if (!(this.a instanceof Activity)) {
            this.c.addFlags(268435456);
          }
          this.c.addFlags(603979776);
          this.a.startActivity(this.c);
        }
      }
    }
    else {
      this.b[0] = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.d.1
 * JD-Core Version:    0.7.0.1
 */