package com.tencent.biz.subscribe;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;

final class SubscribeGlobalInfo$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetMainPageRsp>
{
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (paramStGetMainPageRsp != null) {
        SubscribeGlobalInfo.a((CertifiedAccountMeta.StUser)paramStGetMainPageRsp.user.get());
      }
    }
    else {
      return;
    }
    QLog.w(SubscribeGlobalInfo.class.getSimpleName(), 1, "getPuinUser empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeGlobalInfo.1
 * JD-Core Version:    0.7.0.1
 */