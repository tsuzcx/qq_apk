package com.tencent.mobileqq.ark.secure;

import com.tencent.ark.ark.Application;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.ark.util.ArkAppDataReport;
import com.tencent.qphone.base.util.QLog;

final class ArkSecureUtil$1
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkSecureUtil$1(String paramString1, String paramString2, CheckShareUrlResult paramCheckShareUrlResult) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
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
          this.jdField_a_of_type_ComTencentMobileqqArkSecureCheckShareUrlResult.a(true);
          QLog.i("ArkApp.ArkSecureUtil", 1, String.format("CheckShareUrlLegality, url is in whileList, appName=%s and url=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqArkSecureCheckShareUrlResult.a(false);
        QLog.i("ArkApp.ArkSecureUtil", 1, String.format("CheckShareUrlLegality, url is not in whileList, appName=%s and url=%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b }));
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqArkSecureCheckShareUrlResult.a(false);
      ArkAppDataReport.a(null, this.jdField_a_of_type_JavaLangString, "ArkCheckShareUrlLegality", paramInt, 0, 0L, 0L, 0L, "", "");
      QLog.i("ArkApp.ArkSecureUtil", 1, String.format("CheckShareUrlLegality,getAppInfo is failed and msg=%s", new Object[] { paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.secure.ArkSecureUtil.1
 * JD-Core Version:    0.7.0.1
 */