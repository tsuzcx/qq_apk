package com.tencent.biz.qqcircle.share.operation;

import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleRight.SetCircleUnCareRsp;

class QCircleHideOperation$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleRight.SetCircleUnCareRsp>
{
  QCircleHideOperation$1(QCircleHideOperation paramQCircleHideOperation) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleRight.SetCircleUnCareRsp paramSetCircleUnCareRsp)
  {
    if (QLog.isColorLevel())
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("unCare person: isSuccess");
      paramBaseRequest.append(paramBoolean);
      paramBaseRequest.append("retCode:");
      paramBaseRequest.append(paramLong);
      paramBaseRequest.append("    errMsg:");
      paramBaseRequest.append(paramString);
      QLog.d("QCircleHideShare", 1, paramBaseRequest.toString());
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      QCircleHideOperation.a(this.a);
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent("", 6));
      return;
    }
    QCircleHideOperation.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.operation.QCircleHideOperation.1
 * JD-Core Version:    0.7.0.1
 */