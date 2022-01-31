package com.tencent.mobileqq.app.utils;

import ajmp;
import akhq;
import akhr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class MessageRoamHandler$ChatHistoryMessageObserver$1
  implements Runnable
{
  public MessageRoamHandler$ChatHistoryMessageObserver$1(akhr paramakhr, long paramLong, int paramInt, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "fetchMoreRoamMessage begin fetchNum: " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Akhr.a.a(this.jdField_a_of_type_JavaLangString, (Calendar)localObject, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int)) {
      return;
    }
    localObject = (ajmp)this.jdField_a_of_type_Akhr.a.app.getManager(92);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      ((ajmp)localObject).a(0, i, Long.valueOf(this.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.MessageRoamHandler.ChatHistoryMessageObserver.1
 * JD-Core Version:    0.7.0.1
 */