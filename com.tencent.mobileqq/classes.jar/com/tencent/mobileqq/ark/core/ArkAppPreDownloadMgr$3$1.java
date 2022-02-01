package com.tencent.mobileqq.ark.core;

import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;

class ArkAppPreDownloadMgr$3$1
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkAppPreDownloadMgr$3$1(ArkAppPreDownloadMgr.3 param3, String paramString) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("profiling onReleaseAndReload onGetAppPathByName app=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",retcode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",msg=");
    localStringBuilder.append(paramString);
    QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, localStringBuilder.toString());
    if ((paramInt == 0) && (paramAppPathInfo != null) && (paramAppPathInfo.path != null)) {
      ArkAppPreDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$3.a, this.jdField_a_of_type_JavaLangString, paramAppPathInfo.path, ArkAppPreDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr$3.a), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr.3.1
 * JD-Core Version:    0.7.0.1
 */