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
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetPMBeginShowMsgRsp != null))
    {
      if (paramStGetPMBeginShowMsgRsp.pmBeginShow.has())
      {
        paramBaseRequest = paramStGetPMBeginShowMsgRsp.pmBeginShow.get();
        if (QCircleChatPie.a(this.a) != null)
        {
          if ((!TextUtils.isEmpty(QCircleChatPie.a(this.a))) && (!QCircleChatPie.a(this.a).equals(paramBaseRequest)))
          {
            QCircleChatPie.a(this.a, paramBaseRequest);
            if (!TextUtils.isEmpty(QCircleChatPie.a(this.a)))
            {
              if (QCircleChatUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, QCircleChatPie.a(this.a), QCircleChatPie.a(this.a)))
              {
                paramBaseRequest = this.a;
                paramBaseRequest.a(QCircleChatPie.a(paramBaseRequest), 0);
                ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
              }
            }
            else
            {
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, QCircleChatPie.a(this.a).msgtype, QCircleChatPie.a(this.a).uniseq);
              this.a.e(131072);
            }
          }
          else
          {
            ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
          }
        }
        else
        {
          QCircleChatPie.a(this.a, paramBaseRequest);
          if (!TextUtils.isEmpty(QCircleChatPie.a(this.a)))
          {
            paramBaseRequest = this.a;
            QCircleChatPie.a(paramBaseRequest, QCircleChatUtil.a(paramBaseRequest.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, QCircleChatPie.a(this.a), QCircleChatPie.a(this.a)));
            ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 3, 1);
          }
        }
      }
      return;
    }
    paramBaseRequest = this.a.b;
    paramStGetPMBeginShowMsgRsp = new StringBuilder();
    paramStGetPMBeginShowMsgRsp.append("requestNewestShowFuelTips error:");
    paramStGetPMBeginShowMsgRsp.append(paramLong);
    paramStGetPMBeginShowMsgRsp.append("  errorMsg:");
    paramStGetPMBeginShowMsgRsp.append(paramString);
    QLog.e(paramBaseRequest, 1, paramStGetPMBeginShowMsgRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.4
 * JD-Core Version:    0.7.0.1
 */