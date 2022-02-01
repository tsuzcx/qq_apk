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
    localTianShuReportData.jdField_e_of_type_JavaLangString = "vab_push";
    localTianShuReportData.jdField_f_of_type_JavaLangString = "vab_push";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    localTianShuReportData.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.g = this.jdField_a_of_type_JavaLangString;
    localTianShuReportData.h = "";
    localTianShuReportData.jdField_a_of_type_Long = l;
    localTianShuReportData.d = this.jdField_a_of_type_Int;
    localTianShuReportData.k = Integer.toString(this.jdField_b_of_type_Int);
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.jdField_f_of_type_Int = this.c;
    localTianShuReportData.l = this.jdField_b_of_type_JavaLangString;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.13
 * JD-Core Version:    0.7.0.1
 */