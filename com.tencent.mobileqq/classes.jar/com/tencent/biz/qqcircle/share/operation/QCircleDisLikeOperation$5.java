package com.tencent.biz.qqcircle.share.operation;

import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleRight.SetCircleUnCareRsp;

class QCircleDisLikeOperation$5
  implements VSDispatchObserver.onVSRspCallBack<QQCircleRight.SetCircleUnCareRsp>
{
  QCircleDisLikeOperation$5(QCircleDisLikeOperation paramQCircleDisLikeOperation, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleRight.SetCircleUnCareRsp paramSetCircleUnCareRsp)
  {
    if (QLog.isColorLevel())
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("uncare person: isSuccess");
      paramBaseRequest.append(paramBoolean);
      paramBaseRequest.append("retCode:");
      paramBaseRequest.append(paramLong);
      paramBaseRequest.append("    errMsg:");
      paramBaseRequest.append(paramString);
      QLog.d("QCircleDisLikeShare", 1, paramBaseRequest.toString());
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (this.a) {
        QCircleToast.a(QCircleToast.d, 2131895690, 0);
      }
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent("", 6));
      return;
    }
    QCircleToast.a(QCircleToast.c, 2131895815, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleDisLikeOperation.5
 * JD-Core Version:    0.7.0.1
 */