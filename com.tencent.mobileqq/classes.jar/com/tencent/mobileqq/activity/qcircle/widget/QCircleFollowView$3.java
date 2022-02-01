package com.tencent.mobileqq.activity.qcircle.widget;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

class QCircleFollowView$3
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudWrite.StDoFollowRsp>
{
  QCircleFollowView$3(QCircleFollowView paramQCircleFollowView, int paramInt, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    boolean bool = true;
    QLog.d("QCircleFollowView", 1, "doFollow: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + paramString);
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (!QCircleFollowView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView)) {}
      this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.a(this.jdField_a_of_type_Int, true);
      if (this.jdField_a_of_type_Int == 1) {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.a != null) {
        if (QCircleFollowView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView) != null)
        {
          paramBaseRequest = QCircleFollowView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView);
          if (this.jdField_a_of_type_Int != 1) {
            break label293;
          }
        }
      }
      label293:
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramBaseRequest.a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.a);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFollowUpdateEvent(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.a.id.get()));
        QCircleFollowView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.a.id.get(), this.jdField_a_of_type_Int);
        ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).setUinFollowed(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.a.id.get(), this.jdField_a_of_type_Int);
        if (paramStDoFollowRsp != null) {
          ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).updateFollowUser(this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.a.id.get(), this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.a.nick.get(), paramStDoFollowRsp.isDoubly.get());
        }
        return;
      }
    }
    paramBaseRequest = this.jdField_a_of_type_ComTencentMobileqqActivityQcircleWidgetQCircleFollowView.getContext();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2131697900;; i = 2131698032)
    {
      QQToast.a(paramBaseRequest, 1, i, 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView.3
 * JD-Core Version:    0.7.0.1
 */