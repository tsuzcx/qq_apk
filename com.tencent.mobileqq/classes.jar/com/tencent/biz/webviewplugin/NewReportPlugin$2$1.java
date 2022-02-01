package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class NewReportPlugin$2$1
  implements Runnable
{
  NewReportPlugin$2$1(NewReportPlugin.2 param2) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      QQToast.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2, HardCodeUtil.a(2131707569), 0).a();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleGetTinyId, exp=");
        localStringBuilder.append(localException.toString());
        QLog.e("NewReportPlugin", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */