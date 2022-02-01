package com.tencent.mobileqq.activity.qcircle.widget;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

final class QCircleFollowView$4
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoFollowRsp>
{
  QCircleFollowView$4(FeedCloudMeta.StUser paramStUser, int paramInt, boolean paramBoolean) {}
  
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
    boolean bool = false;
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (this.a != null)
      {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFollowUpdateEvent(this.b, this.a.id.get()));
        QCircleFollowView.a(BaseApplicationImpl.getContext(), this.a.id.get(), this.b);
        ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).setUinFollowed(this.a.id.get(), this.b);
        if (paramStDoFollowRsp != null)
        {
          paramBoolean = bool;
          if (this.b == 1) {
            paramBoolean = true;
          }
          ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).updateFollowUser(this.a.id.get(), this.a.nick.get(), paramBoolean);
        }
      }
    }
    else
    {
      paramBaseRequest = BaseApplicationImpl.getContext();
      int i;
      if (this.c) {
        i = 2131895730;
      } else {
        i = 2131895939;
      }
      QQToast.makeText(paramBaseRequest, 1, i, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView.4
 * JD-Core Version:    0.7.0.1
 */