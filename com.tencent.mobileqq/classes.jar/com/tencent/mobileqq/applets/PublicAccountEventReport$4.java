package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.vip.tianshu.TianShuManager;

final class PublicAccountEventReport$4
  implements Runnable
{
  PublicAccountEventReport$4(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject = PublicAccountEventReport.b(this.a);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      int i = (int)(System.currentTimeMillis() / 1000L);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("_");
      localStringBuilder.append(i);
      localObject = new TianShuReportData(localStringBuilder.toString(), 1, this.c, 1, "vab_push", "vab_push", (String)localObject, "vab_push", i);
      ((TianShuReportData)localObject).s = this.a;
      ((TianShuReportData)localObject).g = "vab_push";
      if (this.d) {
        i = 6;
      } else {
        i = -1;
      }
      ((TianShuReportData)localObject).r = i;
      ((TianShuReportData)localObject).t = this.e;
      ((TianShuReportData)localObject).l = this.f;
      TianShuManager.getInstance().report((TianShuReportData)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.4
 * JD-Core Version:    0.7.0.1
 */