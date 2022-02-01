package com.tencent.mobileqq.applets;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import cooperation.vip.tianshu.TianShuManager;
import mqq.app.AppRuntime;

final class PublicAccountEventReport$13
  implements Runnable
{
  PublicAccountEventReport$13(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2) {}
  
  public void run()
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.f = "vab_push";
    localTianShuReportData.g = "vab_push";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.c = 1;
    localTianShuReportData.h = this.a;
    localTianShuReportData.i = "";
    localTianShuReportData.o = l;
    localTianShuReportData.p = this.b;
    localTianShuReportData.l = Integer.toString(this.c);
    localTianShuReportData.q = 1;
    localTianShuReportData.r = this.d;
    localTianShuReportData.s = this.e;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.13
 * JD-Core Version:    0.7.0.1
 */