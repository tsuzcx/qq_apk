package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

final class NewReportPlugin$1
  implements Runnable
{
  NewReportPlugin$1(int paramInt, QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    try
    {
      Bundle localBundle = NewReportPlugin.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaLangString, this.b, null);
      Object localObject2 = this.c;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty(this.c))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime() == null) {
          localObject1 = "avgame";
        }
      }
      localObject1 = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaLangString, null, null, this.b, this.d, this.e, this.jdField_a_of_type_Int, NewReportPlugin.a(this.jdField_a_of_type_Int), (String)localObject1, "", "", "", "", "", "", "", localBundle);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("safetyNewReport postData=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("NewReportPlugin", 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new NewReportPlugin.1.1(this, (String)localObject1));
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new NewReportPlugin.1.2(this, localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.1
 * JD-Core Version:    0.7.0.1
 */