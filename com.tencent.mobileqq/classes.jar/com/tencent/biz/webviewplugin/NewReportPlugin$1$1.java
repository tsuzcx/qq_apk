package com.tencent.biz.webviewplugin;

import alud;
import bety;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import zdw;

public class NewReportPlugin$1$1
  implements Runnable
{
  public NewReportPlugin$1$1(zdw paramzdw) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.jdField_a_of_type_Bety.isShowing()) {
        this.this$0.jdField_a_of_type_Bety.dismiss();
      }
      QQToast.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, alud.a(2131707953), 0).a();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NewReportPlugin", 2, "handleGetTinyId, exp=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */