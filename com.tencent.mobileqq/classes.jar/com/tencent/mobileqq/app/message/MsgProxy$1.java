package com.tencent.mobileqq.app.message;

import akpv;
import aulz;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class MsgProxy$1
  implements Runnable
{
  public MsgProxy$1(akpv paramakpv, aulz paramaulz, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Aulz != null) {
        this.jdField_a_of_type_Aulz.a(MessageRecord.getTableName(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int), null, null);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.MsgProxy", 1, "delete slowtable excep :", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MsgProxy.1
 * JD-Core Version:    0.7.0.1
 */