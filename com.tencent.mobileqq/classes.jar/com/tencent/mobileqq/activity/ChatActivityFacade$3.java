package com.tencent.mobileqq.activity;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleStGetC2CFeedRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetC2CFeedReq;

final class ChatActivityFacade$3
  implements Runnable
{
  ChatActivityFacade$3(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean) {}
  
  public void run()
  {
    if ((ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true)))
    {
      QCircleStGetC2CFeedRequest localQCircleStGetC2CFeedRequest = new QCircleStGetC2CFeedRequest(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      String str = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      localQCircleStGetC2CFeedRequest.mReq.attchInfo.set(str);
      QLog.d("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest: request.attchInfo==" + str);
      VSNetworkHelper.getInstance().sendRequest(localQCircleStGetC2CFeedRequest, new ChatActivityFacade.3.1(this));
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, "key_last_req_aio_qcircle_feeds_time");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.3
 * JD-Core Version:    0.7.0.1
 */