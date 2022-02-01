package com.tencent.mobileqq.applets;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

final class PublicAccountEventReport$3
  implements Runnable
{
  PublicAccountEventReport$3(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, RecentBaseData paramRecentBaseData, QQAppInterface paramQQAppInterface, String paramString4) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    String str = this.b;
    boolean bool;
    if ((this.c == 0) && (this.d <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    Object localObject2 = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f.mPosition);
    localStringBuilder.append("");
    PublicAccountEventReport.a((String)localObject1, 101, str, bool, (String)localObject2, localStringBuilder.toString());
    localObject1 = this.g;
    str = this.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject1, "dc00898", "", str, "0X8009EB3", "0X8009EB3", 1, 0, (String)localObject2, localStringBuilder.toString(), this.h, "");
    if (!TextUtils.isEmpty(this.b))
    {
      localObject1 = this.g;
      str = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject1, "dc05007", "", str, "0X8009EB3", "0X8009EB3", 1, 0, (String)localObject2, localStringBuilder.toString(), this.h, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.3
 * JD-Core Version:    0.7.0.1
 */