package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark.Application;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallbackTimeOut;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;

final class ArkSecureUtil$1
  implements ArkAppMgr.IGetAppPathByNameCallbackTimeOut
{
  ArkSecureUtil$1(String paramString1, String paramString2, ArkAppModuleReg.CheckShareUrlResult paramCheckShareUrlResult) {}
  
  public void onGetAppPathByNameTimeout(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if ((paramInt == 0) && (paramAppPathInfo != null) && (paramAppPathInfo.path != null))
    {
      paramString = ark.Application.Create(this.jdField_a_of_type_JavaLangString, paramAppPathInfo.path);
      if (paramString != null)
      {
        boolean bool = paramString.CheckShareUrlLegality(this.b);
        paramString.Release();
        if (bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$CheckShareUrlResult.a(true);
          ArkAppCenter.c("ArkApp.ArkSecureUtil", String.format("CheckShareUrlLegality, url is in whileList, appName=%s and url=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
        }
      }
      else
      {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$CheckShareUrlResult.a(false);
      ArkAppCenter.c("ArkApp.ArkSecureUtil", String.format("CheckShareUrlLegality, url is not in whileList, appName=%s and url=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$CheckShareUrlResult.a(false);
    ArkAppDataReport.a(ArkCommonUtil.a(), this.jdField_a_of_type_JavaLangString, "ArkCheckShareUrlLegality", paramInt, 0, 0L, 0L, 0L, "", "");
    ArkAppCenter.c("ArkApp.ArkSecureUtil", String.format("CheckShareUrlLegality,getAppInfo is failed and msg=%s", new Object[] { paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkSecureUtil.1
 * JD-Core Version:    0.7.0.1
 */