package com.tencent.mobileqq.ark;

import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;

class ArkAppPreDownloadMgr$4$1
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkAppPreDownloadMgr$4$1(ArkAppPreDownloadMgr.4 param4, String paramString) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling onReleaseAndReload onGetAppPathByName app=" + this.jdField_a_of_type_JavaLangString + ",retcode=" + paramInt + ",msg=" + paramString);
    if ((paramInt == 0) && (paramAppPathInfo != null) && (paramAppPathInfo.path != null)) {
      ArkAppPreDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppPreDownloadMgr$4.a, this.jdField_a_of_type_JavaLangString, paramAppPathInfo.path, ArkAppPreDownloadMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAppPreDownloadMgr$4.a), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.4.1
 * JD-Core Version:    0.7.0.1
 */