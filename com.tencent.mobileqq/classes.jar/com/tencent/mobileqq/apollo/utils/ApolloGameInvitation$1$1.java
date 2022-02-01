package com.tencent.mobileqq.apollo.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.apollo.api.model.ApolloGameMsgInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ApolloGameInvitation$1$1
  implements WXShareHelper.WXShareListener
{
  ApolloGameInvitation$1$1(ApolloGameInvitation.1 param1) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (paramBaseResp == null) {}
    do
    {
      do
      {
        return;
      } while ((ApolloGameInvitation.a(this.a.this$0) == null) || (!ApolloGameInvitation.a(this.a.this$0).equals(paramBaseResp.transaction)));
      QLog.i("ApolloGameInvitation", 1, "[onWXShareResp], resp.errCode:" + paramBaseResp.errCode);
      if (paramBaseResp.errCode != 0) {
        break;
      }
    } while ((ApolloGameInvitation.a(this.a.this$0) == null) || (ApolloGameInvitation.a(this.a.this$0) == null) || ((AppInterface)ApolloGameInvitation.a(this.a.this$0).get() == null));
    VipUtils.a(null, "cmshow", "Apollo", "wechat_invite_sent", 0, 0, new String[] { Integer.toString(ApolloGameInvitation.a(this.a.this$0).gameId) });
    if (paramBaseResp.errCode == 0) {
      ApolloGameInvitation.a(this.a.this$0, 0, 2);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      if (paramBaseResp.errCode == -2) {
        ApolloGameInvitation.a(this.a.this$0, 2, 2);
      } else {
        ApolloGameInvitation.a(this.a.this$0, 1, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameInvitation.1.1
 * JD-Core Version:    0.7.0.1
 */