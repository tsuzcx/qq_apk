package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;

public final class m
  extends Thread
{
  public m(Context paramContext, String paramString) {}
  
  public void run()
  {
    if (!p.a())
    {
      HMSLog.d("ReportAaidToken", "Not HW Phone.");
      return;
    }
    if (n.a(this.a)) {
      return;
    }
    String str1 = o.a(this.a);
    if (TextUtils.isEmpty(str1))
    {
      HMSLog.w("ReportAaidToken", "AAID is empty.");
      return;
    }
    if (!n.a(this.a, str1, this.b))
    {
      HMSLog.d("ReportAaidToken", "This time need not report.");
      return;
    }
    String str2 = AGConnectServicesConfig.fromContext(this.a).getString("region");
    if (TextUtils.isEmpty(str2))
    {
      HMSLog.i("ReportAaidToken", "The data storage region is empty.");
      return;
    }
    str2 = e.a(this.a, "com.huawei.hms.opendevicesdk", "ROOT", null, str2);
    if (TextUtils.isEmpty(str2)) {
      return;
    }
    String str3 = n.b(this.a, str1, this.b);
    Context localContext = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append("/rest/appdata/v1/aaid/report");
    str2 = d.a(localContext, localStringBuilder.toString(), str3, null);
    n.a(this.a, str2, str1, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.m
 * JD-Core Version:    0.7.0.1
 */