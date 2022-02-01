package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.event.QCircleAddblackUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleRight.SetCircleUnCareRsp;

class QCirclePersonalTitleBarPart$13$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleRight.SetCircleUnCareRsp>
{
  QCirclePersonalTitleBarPart$13$1(QCirclePersonalTitleBarPart.13 param13) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleRight.SetCircleUnCareRsp paramSetCircleUnCareRsp)
  {
    if (QLog.isColorLevel())
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("black person: isSuccess");
      paramBaseRequest.append(paramBoolean);
      paramBaseRequest.append("retCode:");
      paramBaseRequest.append(paramLong);
      paramBaseRequest.append("    errMsg:");
      paramBaseRequest.append(paramString);
      QLog.d("QCirclePersonalTitleBar", 1, paramBaseRequest.toString());
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      QCircleToast.a(QCircleToast.d, 2131895623, 0);
      this.a.a.a(QCirclePersonalTitleBarPart.c(this.a.a).id.get());
      SimpleEventBus.getInstance().dispatchEvent(new QCircleAddblackUpdateEvent(1, QCirclePersonalTitleBarPart.c(this.a.a).id.get()));
      QCirclePersonalTitleBarPart.a(this.a.a.g(), QCirclePersonalTitleBarPart.c(this.a.a).id.get(), 0, 1);
      return;
    }
    QCircleToast.a(QCircleToast.c, 2131895815, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.13.1
 * JD-Core Version:    0.7.0.1
 */