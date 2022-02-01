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
    QLog.d("ApolloTianshuReportUtil", 1, new Object[] { "tianshuReport action:", Integer.valueOf(paramInt), ", itemId=", paramString1, ",traceInfo=", paramString2, ", bizInfo=", paramString3 });
    TianShuReportData localTianShuReportData = new TianShuReportData();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.b = (str + "_" + l);
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = "tianshu.75";
    localTianShuReportData.jdField_f_of_type_JavaLangString = "tianshu.75";
    localTianShuReportData.g = paramString1;
    localTianShuReportData.h = "";
    localTianShuReportData.jdField_a_of_type_Long = l;
    localTianShuReportData.d = paramInt;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.jdField_f_of_type_Int = 1;
    localTianShuReportData.l = paramString2;
    if (!TextUtils.isEmpty(paramString3)) {
      localTianShuReportData.m = paramString3;
    }
    TianShuManager.getInstance().report(localTianShuReportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil
 * JD-Core Version:    0.7.0.1
 */