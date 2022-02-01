package com.huawei.hms.aaid.task;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.n;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.support.log.HMSLog;

final class ReportAaidToken$1
  extends Thread
{
  ReportAaidToken$1(Context paramContext, String paramString) {}
  
  public void run()
  {
    if (!o.a()) {
      HMSLog.d("ReportAaidToken", "Not HW Phone.");
    }
    String str1;
    do
    {
      do
      {
        return;
      } while (ReportAaidToken.a(this.a));
      str1 = n.c(this.a);
      if (TextUtils.isEmpty(str1))
      {
        HMSLog.w("ReportAaidToken", "AAID is empty.");
        return;
      }
      if (!ReportAaidToken.a(this.a, str1, this.b))
      {
        HMSLog.d("ReportAaidToken", "This time need not report.");
        return;
      }
      str2 = f.a(this.a);
    } while (TextUtils.isEmpty(str2));
    String str3 = ReportAaidToken.b(this.a, str1, this.b);
    String str2 = e.a(this.a, str2 + "/rest/appdata/v1/aaid/report", str3, null);
    ReportAaidToken.a(this.a, str2, str1, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.aaid.task.ReportAaidToken.1
 * JD-Core Version:    0.7.0.1
 */