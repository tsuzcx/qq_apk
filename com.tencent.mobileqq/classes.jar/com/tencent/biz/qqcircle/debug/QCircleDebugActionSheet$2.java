package com.tencent.biz.qqcircle.debug;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import qqcircle.QQCircleFeedbackhit.StSetFeedbackHitRsp;

final class QCircleDebugActionSheet$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleFeedbackhit.StSetFeedbackHitRsp>
{
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleFeedbackhit.StSetFeedbackHitRsp paramStSetFeedbackHitRsp)
  {
    paramBaseRequest = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      paramBaseRequest = paramString;
      if (paramLong == 0L) {
        paramBaseRequest = "操作成功";
      }
    }
    QCircleToast.a(paramBaseRequest, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.debug.QCircleDebugActionSheet.2
 * JD-Core Version:    0.7.0.1
 */