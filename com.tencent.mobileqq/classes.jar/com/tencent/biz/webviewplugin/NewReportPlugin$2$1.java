package com.tencent.biz.webviewplugin;

import aaqp;
import anvx;
import bisl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class NewReportPlugin$2$1
  implements Runnable
{
  public NewReportPlugin$2$1(aaqp paramaaqp) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.jdField_a_of_type_Bisl.isShowing()) {
        this.this$0.jdField_a_of_type_Bisl.dismiss();
      }
      QQToast.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, anvx.a(2131707019), 0).a();
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