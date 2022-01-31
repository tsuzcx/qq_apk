package com.tencent.mobileqq.app.message;

import ajmm;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QQMessageFacade$3
  implements Runnable
{
  QQMessageFacade$3(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord, ajmm paramajmm, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      this.this$0.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Ajmm, this.jdField_a_of_type_Boolean);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.QQMessageFacade", 1, "smr error :", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.QQMessageFacade.3
 * JD-Core Version:    0.7.0.1
 */