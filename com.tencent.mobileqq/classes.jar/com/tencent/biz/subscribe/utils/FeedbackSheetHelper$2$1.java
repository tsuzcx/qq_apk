package com.tencent.biz.subscribe.utils;

import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoTipOffRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;

class FeedbackSheetHelper$2$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDoTipOffRsp>
{
  FeedbackSheetHelper$2$1(FeedbackSheetHelper.2 param2) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoTipOffRsp paramStDoTipOffRsp)
  {
    paramBoolean = true;
    if (paramLong == 0L)
    {
      QLog.w("FeedbackSheetHelper", 1, "DoTipOffRequest success");
      if (this.a.a != null)
      {
        paramBaseRequest = this.a.a;
        if (paramLong != 0L) {
          break label76;
        }
      }
    }
    for (;;)
    {
      paramBaseRequest.a(paramBoolean);
      return;
      QLog.w("FeedbackSheetHelper", 1, "DoTipOffRequest failed retCode:" + paramLong);
      break;
      label76:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.FeedbackSheetHelper.2.1
 * JD-Core Version:    0.7.0.1
 */