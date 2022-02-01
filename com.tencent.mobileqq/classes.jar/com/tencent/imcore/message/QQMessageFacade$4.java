package com.tencent.imcore.message;

import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;

class QQMessageFacade$4
  implements Runnable
{
  QQMessageFacade$4(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityFacade$HongbaoParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.4
 * JD-Core Version:    0.7.0.1
 */