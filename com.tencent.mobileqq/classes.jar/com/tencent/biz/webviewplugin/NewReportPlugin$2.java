package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

final class NewReportPlugin$2
  implements Runnable
{
  NewReportPlugin$2(Bundle paramBundle, String paramString1, int paramInt, QBaseActivity paramQBaseActivity, String paramString2, String paramString3, String paramString4, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    String str1;
    try
    {
      localObject2 = this.a;
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
      if (!TextUtils.isEmpty(this.b)) {
        localObject2 = this.b;
      } else {
        localObject2 = NewReportPlugin.a(this.c);
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
      this.d.runOnUiThread(new NewReportPlugin.2.2(this, localException));
      return;
    }
    if ((this.d.getAppRuntime() instanceof QQAppInterface)) {
      str1 = NewReportPlugin.a((QQAppInterface)this.d.getAppRuntime(), this.e, this.f, this.c, (Bundle)localObject1);
    }
    for (;;)
    {
      localObject1 = NewReportPlugin.a(this.d, this.g, "", "", this.f, "", "", this.c, (String)localObject2, str1, str2, str3, str4, str5, str6, str7, str8, (Bundle)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("nearbySafetyRealReport post: %s", new Object[] { localObject1 }));
      }
      this.d.runOnUiThread(new NewReportPlugin.2.1(this, (String)localObject1));
      return;
      break;
      str1 = "chatmsg%3A";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.2
 * JD-Core Version:    0.7.0.1
 */