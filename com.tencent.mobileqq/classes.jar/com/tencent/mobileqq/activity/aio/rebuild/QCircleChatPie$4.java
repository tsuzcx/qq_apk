package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp;

class QCircleChatPie$4
  implements VSDispatchObserver.onVSRspCallBack<QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp>
{
  QCircleChatPie$4(QCircleChatPie paramQCircleChatPie) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp paramStGetPMBeginShowMsgRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetPMBeginShowMsgRsp == null)) {
      QLog.e(this.a.b, 1, "requestNewestShowFuelTips error:" + paramLong + "  errorMsg:" + paramString);
    }
    label269:
    label297:
    do
    {
      do
      {
        do
        {
          return;
        } while (!paramStGetPMBeginShowMsgRsp.pmBeginShow.has());
        paramBaseRequest = paramStGetPMBeginShowMsgRsp.pmBeginShow.get();
        if (QCircleChatPie.a(this.a) == null) {
          break label297;
        }
        if ((TextUtils.isEmpty(QCircleChatPie.a(this.a))) || (QCircleChatPie.a(this.a).equals(paramBaseRequest))) {
          break label269;
        }
        QCircleChatPie.a(this.a, paramBaseRequest);
        if (TextUtils.isEmpty(QCircleChatPie.a(this.a))) {
          break;
        }
      } while (!QCircleChatUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, QCircleChatPie.a(this.a), QCircleChatPie.a(this.a)));
      this.a.a(QCircleChatPie.a(this.a), 0);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, QCircleChatPie.a(this.a).msgtype, QCircleChatPie.a(this.a).uniseq);
      this.a.g(131072);
      return;
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
      return;
      QCircleChatPie.a(this.a, paramBaseRequest);
    } while (TextUtils.isEmpty(QCircleChatPie.a(this.a)));
    QCircleChatPie.a(this.a, QCircleChatUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, QCircleChatPie.a(this.a), QCircleChatPie.a(this.a)));
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.4
 * JD-Core Version:    0.7.0.1
 */