package com.tencent.imcore.message;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class BaseQQMessageFacade$1
  implements Runnable
{
  BaseQQMessageFacade$1(BaseQQMessageFacade paramBaseQQMessageFacade, MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      this.this$0.c(this.a, this.b, this.c);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.QQMessageFacade", 1, "smr error :", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseQQMessageFacade.1
 * JD-Core Version:    0.7.0.1
 */