package com.tencent.imcore.message;

import acwf;
import aywe;
import com.tencent.qphone.base.util.QLog;

public class MsgProxy$1
  implements Runnable
{
  public MsgProxy$1(acwf paramacwf, aywe paramaywe, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_Aywe != null) {
        this.jdField_a_of_type_Aywe.a(this.this$0.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int), null, null);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.MsgProxy", 1, "delete slowtable excep :", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxy.1
 * JD-Core Version:    0.7.0.1
 */