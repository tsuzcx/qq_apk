package com.tencent.biz;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import nko;

public class AuthorizeConfig$5
  implements Runnable
{
  public AuthorizeConfig$5(nko paramnko, TicketManager paramTicketManager, String paramString, String[] paramArrayOfString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_MqqManagerTicketManager != null) {
        if ((this.jdField_a_of_type_MqqManagerTicketManager.getPskey(this.jdField_a_of_type_JavaLangString, 16L, this.jdField_a_of_type_ArrayOfJavaLangString, this.this$0.a) == null) || (TextUtils.isEmpty(this.jdField_a_of_type_MqqManagerTicketManager.getSkey(this.jdField_a_of_type_JavaLangString)))) {
          break label84;
        }
      }
      label84:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("AuthorizeConfig", 1, "pre hits result : " + bool);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AuthorizeConfig", 1, "preload k exception ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.5
 * JD-Core Version:    0.7.0.1
 */