package com.tencent.mobileqq.applets;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;
import mqq.app.AppRuntime;

public final class PublicAccountEventReport$13
  implements Runnable
{
  public PublicAccountEventReport$13(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2) {}
  
  public void run()
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.mAppId = "vab_push";
    localTianShuReportData.mPageId = "vab_push";
    localTianShuReportData.mTraceId = (str + "_" + l);
    localTianShuReportData.mTraceNum = 1;
    localTianShuReportData.mItemId = this.jdField_a_of_type_JavaLangString;
    localTianShuReportData.mSubItemId = "";
    localTianShuReportData.mOperTime = l;
    localTianShuReportData.mActionId = this.jdField_a_of_type_Int;
    localTianShuReportData.mPositionId = Integer.toString(this.jdField_b_of_type_Int);
    localTianShuReportData.mActionValue = 1;
    localTianShuReportData.mActionAttr = this.c;
    localTianShuReportData.mTriggerInfo = this.jdField_b_of_type_JavaLangString;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountEventReport.13
 * JD-Core Version:    0.7.0.1
 */