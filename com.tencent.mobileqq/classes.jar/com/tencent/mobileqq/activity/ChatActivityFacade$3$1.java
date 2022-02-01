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
    if (paramBoolean) {
      if (paramStGetC2CFeedRsp != null)
      {
        if ((QLog.isColorLevel()) && (paramStGetC2CFeedRsp.attchInfo != null) && (paramStGetC2CFeedRsp.attchInfo.get() != null)) {
          QLog.d("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest: response.attchInfo==" + paramStGetC2CFeedRsp.attchInfo.get());
        }
        ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramStGetC2CFeedRsp, this.a.jdField_a_of_type_Boolean);
        if ((paramStGetC2CFeedRsp.attchInfo != null) && (!StringUtil.a(paramStGetC2CFeedRsp.attchInfo.get()))) {
          ChatActivityFacade.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramStGetC2CFeedRsp.attchInfo.get());
        }
      }
    }
    for (;;)
    {
      QLog.d("ChatActivityFacade", 1, "getSingleFeed onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + paramBaseRequest.getTraceId() + " | SeqId:" + paramBaseRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
      return;
      if (QLog.isColorLevel())
      {
        QLog.e("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest failed: response==null");
        continue;
        if (QLog.isColorLevel()) {
          QLog.e("ChatActivityFacade.QCircleFeeds", 2, String.format(Locale.getDefault(), "QCircleStGetC2CFeedRequest failed: retCode=%d,errMsg=%s", new Object[] { Long.valueOf(paramLong), paramString }));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.3.1
 * JD-Core Version:    0.7.0.1
 */