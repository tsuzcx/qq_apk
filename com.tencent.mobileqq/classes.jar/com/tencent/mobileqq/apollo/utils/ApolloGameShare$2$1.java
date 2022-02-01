package com.tencent.mobileqq.apollo.utils;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class ApolloGameShare$2$1
  implements WXShareHelper.WXShareListener
{
  ApolloGameShare$2$1(ApolloGameShare.2 param2) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (paramBaseResp == null) {}
    do
    {
      do
      {
        return;
      } while ((ApolloGameShare.a(this.a.this$0) == null) || (!ApolloGameShare.a(this.a.this$0).equals(paramBaseResp.transaction)));
      QLog.i("ApolloGameShare", 1, "[shareResult2WXFriendOrCircle], resp.errCode:" + paramBaseResp.errCode);
    } while (paramBaseResp.errCode != 0);
    paramBaseResp = this.a.this$0.a();
    int j;
    int i;
    if (paramBaseResp == null)
    {
      j = -1;
      if (1 != this.a.a) {
        break label169;
      }
      i = 3;
    }
    for (;;)
    {
      VipUtils.a(ApolloGameShare.a(this.a.this$0), "cmshow", "Apollo", "share_url_succeed", j, i, new String[] { Integer.toString(ApolloGameShare.a(this.a.this$0)) });
      return;
      j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramBaseResp.a.a);
      break;
      label169:
      if (2 == this.a.a) {
        i = 4;
      } else {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameShare.2.1
 * JD-Core Version:    0.7.0.1
 */