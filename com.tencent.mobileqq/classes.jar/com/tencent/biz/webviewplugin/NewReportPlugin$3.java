package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import bety;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import zdv;

public final class NewReportPlugin$3
  implements Runnable
{
  public NewReportPlugin$3(int paramInt, BaseActivity paramBaseActivity, String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4, String paramString5, String paramString6, bety parambety) {}
  
  public void run()
  {
    try
    {
      Object localObject = zdv.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_AndroidOsBundle);
      localObject = zdv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.c, this.d, this.b, this.e, this.jdField_a_of_type_Int, zdv.a(this.jdField_a_of_type_Int), this.f, "", "", "", "", "", "", "", (Bundle)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 1, "safetyNewReport postData=" + (String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new NewReportPlugin.3.1(this, (String)localObject));
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new NewReportPlugin.3.2(this, localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.3
 * JD-Core Version:    0.7.0.1
 */