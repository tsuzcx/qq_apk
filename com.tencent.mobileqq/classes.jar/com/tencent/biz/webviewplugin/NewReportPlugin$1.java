package com.tencent.biz.webviewplugin;

import aaqo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public final class NewReportPlugin$1
  implements Runnable
{
  public NewReportPlugin$1(int paramInt, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    try
    {
      Bundle localBundle = aaqo.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, this.b, null);
      String str2 = this.c;
      String str1 = str2;
      if (TextUtils.isEmpty(this.c))
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) {
          str1 = "avgame";
        }
      }
      str1 = aaqo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, null, null, this.b, this.d, this.e, this.jdField_a_of_type_Int, aaqo.a(this.jdField_a_of_type_Int), str1, "", "", "", "", "", "", "", localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 1, "safetyNewReport postData=" + str1);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new NewReportPlugin.1.1(this, str1));
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new NewReportPlugin.1.2(this, localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.1
 * JD-Core Version:    0.7.0.1
 */