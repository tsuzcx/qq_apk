package com.tencent.mobileqq.apollo.statistics;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import mqq.app.AppRuntime;

public class ApolloTianshuReportUtil
{
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, null);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d("[cmshow]ApolloTianshuReportUtil", 1, new Object[] { "tianshuReport action:", Integer.valueOf(paramInt), ", itemId=", paramString1, ",traceInfo=", paramString2, ", bizInfo=", paramString3 });
    TianShuReportData localTianShuReportData = new TianShuReportData();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.c = 1;
    localTianShuReportData.f = "tianshu.75";
    localTianShuReportData.g = "tianshu.75";
    localTianShuReportData.h = paramString1;
    localTianShuReportData.i = "";
    localTianShuReportData.o = l;
    localTianShuReportData.p = paramInt;
    localTianShuReportData.q = 1;
    localTianShuReportData.r = 1;
    localTianShuReportData.s = paramString2;
    if (!TextUtils.isEmpty(paramString3)) {
      localTianShuReportData.t = paramString3;
    }
    TianShuManager.getInstance().report(localTianShuReportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil
 * JD-Core Version:    0.7.0.1
 */