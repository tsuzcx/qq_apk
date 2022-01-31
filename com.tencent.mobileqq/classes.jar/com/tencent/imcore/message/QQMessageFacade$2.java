package com.tencent.imcore.message;

import alwx;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QQMessageFacade$2
  implements Runnable
{
  QQMessageFacade$2(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord, alwx paramalwx, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      this.this$0.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_Alwx, this.jdField_a_of_type_Boolean);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.QQMessageFacade", 1, "smr error :", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.2
 * JD-Core Version:    0.7.0.1
 */