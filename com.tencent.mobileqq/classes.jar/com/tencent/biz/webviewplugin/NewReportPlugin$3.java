package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

final class NewReportPlugin$3
  implements Runnable
{
  NewReportPlugin$3(Bundle paramBundle, String paramString1, int paramInt, QBaseActivity paramQBaseActivity, String paramString2, String paramString3, String paramString4, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    String str1;
    try
    {
      localObject2 = this.jdField_a_of_type_AndroidOsBundle;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      str2 = ((Bundle)localObject1).getString("text_evidence", "");
      str3 = ((Bundle)localObject1).getString("img_evidence", "");
      str4 = ((Bundle)localObject1).getString("url_evidence", "");
      str5 = ((Bundle)localObject1).getString("video_evidence", "");
      str6 = ((Bundle)localObject1).getString("file_evidence", "");
      str7 = ((Bundle)localObject1).getString("audio_evidence", "");
      str8 = ((Bundle)localObject1).getString("user_input_param", "");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localObject2 = this.jdField_a_of_type_JavaLangString;
      } else {
        localObject2 = NewReportPlugin.a(this.jdField_a_of_type_Int);
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      Object localObject1;
      String str2;
      String str3;
      String str4;
      String str5;
      String str6;
      String str7;
      String str8;
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new NewReportPlugin.3.2(this, localException));
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime() instanceof QQAppInterface)) {
      str1 = NewReportPlugin.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), this.b, this.c, this.jdField_a_of_type_Int, (Bundle)localObject1);
    }
    for (;;)
    {
      localObject1 = NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.d, "", "", this.c, "", "", this.jdField_a_of_type_Int, (String)localObject2, str1, str2, str3, str4, str5, str6, str7, str8, (Bundle)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("nearbySafetyRealReport post: %s", new Object[] { localObject1 }));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new NewReportPlugin.3.1(this, (String)localObject1));
      return;
      break;
      str1 = "chatmsg%3A";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.3
 * JD-Core Version:    0.7.0.1
 */