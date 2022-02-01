package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

final class NewReportPlugin$3
  implements Runnable
{
  NewReportPlugin$3(int paramInt, QBaseActivity paramQBaseActivity, String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4, String paramString5, String paramString6, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    try
    {
      Object localObject = NewReportPlugin.a(this.a, this.b, this.c, this.d, this.e);
      localObject = NewReportPlugin.a(this.b, this.c, this.f, this.g, this.d, "", this.h, this.a, NewReportPlugin.a(this.a), this.i, "", "", "", "", "", "", "", (Bundle)localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("safetyNewReport postData=");
        localStringBuilder.append((String)localObject);
        QLog.d("NewReportPlugin", 2, localStringBuilder.toString());
      }
      this.b.runOnUiThread(new NewReportPlugin.3.1(this, (String)localObject));
      return;
    }
    catch (Exception localException)
    {
      this.b.runOnUiThread(new NewReportPlugin.3.2(this, localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.3
 * JD-Core Version:    0.7.0.1
 */