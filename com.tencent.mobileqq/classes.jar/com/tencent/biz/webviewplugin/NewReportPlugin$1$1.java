package com.tencent.biz.webviewplugin;

import ajyc;
import bcpq;
import bcpw;
import com.tencent.qphone.base.util.QLog;
import xkr;

public class NewReportPlugin$1$1
  implements Runnable
{
  public NewReportPlugin$1$1(xkr paramxkr) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.jdField_a_of_type_Bcpq.isShowing()) {
        this.this$0.jdField_a_of_type_Bcpq.dismiss();
      }
      bcpw.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, ajyc.a(2131707558), 0).a();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NewReportPlugin", 2, "handleGetTinyId, exp=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */