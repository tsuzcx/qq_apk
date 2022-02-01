package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

final class NewReportPlugin$1
  implements Runnable
{
  NewReportPlugin$1(int paramInt, QBaseActivity paramQBaseActivity, String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    try
    {
      Bundle localBundle = NewReportPlugin.a(this.a, this.b, this.c, this.d, this.e);
      Object localObject2 = this.f;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty(this.f))
      {
        localObject1 = localObject2;
        if (this.b.getAppRuntime() == null) {
          localObject1 = "avgame";
        }
      }
      localObject1 = NewReportPlugin.a(this.b, this.c, null, null, this.d, this.g, this.h, this.a, NewReportPlugin.a(this.a), (String)localObject1, "", "", "", "", "", "", "", localBundle);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("safetyNewReport postData=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("NewReportPlugin", 2, ((StringBuilder)localObject2).toString());
      }
      this.b.runOnUiThread(new NewReportPlugin.1.1(this, (String)localObject1));
      return;
    }
    catch (Exception localException)
    {
      this.b.runOnUiThread(new NewReportPlugin.1.2(this, localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin.1
 * JD-Core Version:    0.7.0.1
 */