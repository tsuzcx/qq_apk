package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.event.QCircleAddblackUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleRight.SetCircleUnCareRsp;

class QCircleAddBlackListView$2
  implements VSDispatchObserver.onVSRspCallBack<QQCircleRight.SetCircleUnCareRsp>
{
  QCircleAddBlackListView$2(QCircleAddBlackListView paramQCircleAddBlackListView, int paramInt1, int paramInt2) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleRight.SetCircleUnCareRsp paramSetCircleUnCareRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      QCircleAddBlackListView.a(this.c, this.a);
      paramBaseRequest = this.c;
      paramBaseRequest.a(QCircleAddBlackListView.a(paramBaseRequest).id.get());
      QCircleToast.a(QCircleToast.d, 2131895623, 0);
      SimpleEventBus.getInstance().dispatchEvent(new QCircleAddblackUpdateEvent(this.a, QCircleAddBlackListView.a(this.c).id.get()));
      QCircleAddBlackListView.a(this.c.getContext(), QCircleAddBlackListView.a(this.c).id.get(), 0, this.a);
      return;
    }
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("revertBlackUI:");
    paramBaseRequest.append(this.b);
    paramBaseRequest.append(" retCode =");
    paramBaseRequest.append(paramLong);
    QLog.e("QCircleAddBlackListView", 1, paramBaseRequest.toString());
    QCircleToast.a(QCircleToast.c, 2131895815, 0);
    QCircleAddBlackListView.a(this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAddBlackListView.2
 * JD-Core Version:    0.7.0.1
 */