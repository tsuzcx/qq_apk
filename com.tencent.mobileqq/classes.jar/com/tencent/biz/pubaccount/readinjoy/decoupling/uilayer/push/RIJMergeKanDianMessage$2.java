package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class RIJMergeKanDianMessage$2
  implements Runnable
{
  RIJMergeKanDianMessage$2(String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localSessionInfo.jdField_a_of_type_Int = 1008;
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_a_of_type_JavaLangString, 1008);
    QLog.d("RIJMergeKanDianMessage", 2, "puin<" + this.jdField_a_of_type_JavaLangString + "> msg setRead !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJMergeKanDianMessage.2
 * JD-Core Version:    0.7.0.1
 */