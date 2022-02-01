package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class MessageRoamHandler$ChatHistoryMessageObserver$1
  implements Runnable
{
  MessageRoamHandler$ChatHistoryMessageObserver$1(MessageRoamHandler.ChatHistoryMessageObserver paramChatHistoryMessageObserver, long paramLong, int paramInt, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "fetchMoreRoamMessage begin fetchNum: " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler$ChatHistoryMessageObserver.a.a(this.jdField_a_of_type_JavaLangString, (Calendar)localObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int)) {
      return;
    }
    localObject = (MessageRoamManager)MessageRoamHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler$ChatHistoryMessageObserver.a).getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      ((MessageRoamManager)localObject).a(0, i, Long.valueOf(this.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.MessageRoamHandler.ChatHistoryMessageObserver.1
 * JD-Core Version:    0.7.0.1
 */