package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

final class NewReportPlugin$5
  implements Runnable
{
  NewReportPlugin$5(int paramInt1, QBaseActivity paramQBaseActivity, String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    try
    {
      Object localObject = NewReportPlugin.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
      localObject = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaLangString, this.c, this.jdField_b_of_type_JavaLangString, this.d, this.jdField_a_of_type_Int, NewReportPlugin.a(this.jdField_a_of_type_Int), this.e, this.jdField_b_of_type_Int, this.f, (Bundle)localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionSheetReport postData=");
        localStringBuilder.append((String)localObject);
        QLog.d("NewReportPlugin", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new NewReportPlugin.5.1(this, (String)localObject));
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new NewReportPlugin.5.2(this, localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.5
 * JD-Core Version:    0.7.0.1
 */