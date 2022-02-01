package com.tencent.biz;

import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import niz;

public class AuthorizeConfig$4
  implements Runnable
{
  public AuthorizeConfig$4(niz paramniz, TicketManager paramTicketManager, String paramString, String[] paramArrayOfString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_MqqManagerTicketManager != null) {
        this.jdField_a_of_type_MqqManagerTicketManager.getPskey(this.jdField_a_of_type_JavaLangString, 16L, this.jdField_a_of_type_ArrayOfJavaLangString, this.this$0.a);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AuthorizeConfig", 1, new Object[] { "preloadPskey exception ", localException.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.4
 * JD-Core Version:    0.7.0.1
 */