package com.tencent.mobileqq.activity;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetC2CFeedRsp;
import java.util.Locale;

class ChatActivityFacade$3$1
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetC2CFeedRsp>
{
  ChatActivityFacade$3$1(ChatActivityFacade.3 param3) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetC2CFeedRsp paramStGetC2CFeedRsp)
  {
    if (paramBoolean)
    {
      if (paramStGetC2CFeedRsp != null)
      {
        if ((QLog.isColorLevel()) && (paramStGetC2CFeedRsp.attchInfo != null) && (paramStGetC2CFeedRsp.attchInfo.get() != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("QCircleStGetC2CFeedRequest: response.attchInfo==");
          localStringBuilder.append(paramStGetC2CFeedRsp.attchInfo.get());
          QLog.d("ChatActivityFacade.QCircleFeeds", 2, localStringBuilder.toString());
        }
        ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramStGetC2CFeedRsp, this.a.jdField_a_of_type_Boolean);
        if ((paramStGetC2CFeedRsp.attchInfo != null) && (!StringUtil.a(paramStGetC2CFeedRsp.attchInfo.get()))) {
          ChatActivityFacade.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramStGetC2CFeedRsp.attchInfo.get());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest failed: response==null");
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("ChatActivityFacade.QCircleFeeds", 2, String.format(Locale.getDefault(), "QCircleStGetC2CFeedRequest failed: retCode=%d,errMsg=%s", new Object[] { Long.valueOf(paramLong), paramString }));
    }
    paramStGetC2CFeedRsp = new StringBuilder();
    paramStGetC2CFeedRsp.append("getSingleFeed onReceive: dispatch Success:");
    paramStGetC2CFeedRsp.append(paramBoolean);
    paramStGetC2CFeedRsp.append(" | TraceId:");
    paramStGetC2CFeedRsp.append(paramBaseRequest.getTraceId());
    paramStGetC2CFeedRsp.append(" | SeqId:");
    paramStGetC2CFeedRsp.append(paramBaseRequest.getCurrentSeq());
    paramStGetC2CFeedRsp.append(" | retCode:");
    paramStGetC2CFeedRsp.append(paramLong);
    paramStGetC2CFeedRsp.append(" | retMessage:");
    paramStGetC2CFeedRsp.append(paramString);
    QLog.d("ChatActivityFacade", 1, paramStGetC2CFeedRsp.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.3.1
 * JD-Core Version:    0.7.0.1
 */