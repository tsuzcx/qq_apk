package com.tencent.biz.webviewplugin;

import abes;
import anzj;
import bjbs;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class NewReportPlugin$2$1
  implements Runnable
{
  public NewReportPlugin$2$1(abes paramabes) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.jdField_a_of_type_Bjbs.isShowing()) {
        this.this$0.jdField_a_of_type_Bjbs.dismiss();
      }
      QQToast.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, anzj.a(2131706437), 0).a();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NewReportPlugin", 2, "handleGetTinyId, exp=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */