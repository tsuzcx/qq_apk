package com.tencent.mobileqq.app.utils;

import anzc;
import apac;
import apad;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class MessageRoamHandler$ChatHistoryMessageObserver$1
  implements Runnable
{
  public MessageRoamHandler$ChatHistoryMessageObserver$1(apad paramapad, long paramLong, int paramInt, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "fetchMoreRoamMessage begin fetchNum: " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Apad.a.a(this.jdField_a_of_type_JavaLangString, (Calendar)localObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int)) {
      return;
    }
    localObject = (anzc)this.jdField_a_of_type_Apad.a.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      ((anzc)localObject).a(0, i, Long.valueOf(this.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.MessageRoamHandler.ChatHistoryMessageObserver.1
 * JD-Core Version:    0.7.0.1
 */