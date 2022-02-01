package com.tencent.av.wtogether.util;

import android.app.Activity;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.qphone.base.util.QLog;

final class WTogetherUtil$2
  implements Runnable
{
  WTogetherUtil$2(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void run()
  {
    try
    {
      String str = NewReportPlugin.a(this.a, this.b, null, null, this.c, this.d, this.e, this.f, NewReportPlugin.a(this.f), "avreport", "", "", "", "", "", "", "", null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("safetyNewReport postData=");
        localStringBuilder.append(str);
        QLog.d("WTogether", 1, localStringBuilder.toString());
      }
      this.a.runOnUiThread(new WTogetherUtil.2.1(this, str));
      return;
    }
    catch (Exception localException)
    {
      this.a.runOnUiThread(new WTogetherUtil.2.2(this, localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WTogetherUtil.2
 * JD-Core Version:    0.7.0.1
 */