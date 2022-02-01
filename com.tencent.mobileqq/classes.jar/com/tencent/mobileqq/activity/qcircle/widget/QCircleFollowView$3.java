package com.tencent.mobileqq.activity.qcircle.widget;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

class QCircleFollowView$3
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoFollowRsp>
{
  QCircleFollowView$3(QCircleFollowView paramQCircleFollowView, boolean paramBoolean, int paramInt) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("doFollow: isSuccess");
    paramBaseRequest.append(paramBoolean);
    paramBaseRequest.append("retCode:");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append("    errMsg:");
    paramBaseRequest.append(paramString);
    QLog.d("QCircleFollowView", 1, paramBaseRequest.toString());
    if ((paramBoolean) && (paramLong == 0L))
    {
      this.c.a(this.b, true);
      if (this.b == 1) {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
      }
      QCircleFollowView.a(this.c, paramStDoFollowRsp, this.b);
      return;
    }
    paramBaseRequest = this.c.getContext();
    int i;
    if (this.a) {
      i = 2131895730;
    } else {
      i = 2131895939;
    }
    QQToast.makeText(paramBaseRequest, 1, i, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView.3
 * JD-Core Version:    0.7.0.1
 */