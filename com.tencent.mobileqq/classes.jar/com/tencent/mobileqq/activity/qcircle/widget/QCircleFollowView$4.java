package com.tencent.mobileqq.activity.qcircle.widget;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBBoolField;
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
    QLog.d("QCircleFollowView", 1, "doFollow: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + paramString);
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null)
      {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFollowUpdateEvent(this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get()));
        QCircleFollowView.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), this.jdField_a_of_type_Int);
        ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).setUinFollowed(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), this.jdField_a_of_type_Int);
        if (paramStDoFollowRsp != null) {
          ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).updateFollowUser(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.nick.get(), paramStDoFollowRsp.isDoubly.get());
        }
      }
      return;
    }
    paramBaseRequest = BaseApplicationImpl.getContext();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2131697900;; i = 2131698032)
    {
      QQToast.a(paramBaseRequest, 1, i, 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView.4
 * JD-Core Version:    0.7.0.1
 */