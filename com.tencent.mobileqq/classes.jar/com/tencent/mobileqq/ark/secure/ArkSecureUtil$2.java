package com.tencent.mobileqq.ark.secure;

import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;

final class ArkSecureUtil$2
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkSecureUtil$2(ArkSecureUtil.GetAppPathTask paramGetAppPathTask, String paramString) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo)
  {
    ArkAppMgr.IGetAppPathByNameCallback localIGetAppPathByNameCallback = this.jdField_a_of_type_ComTencentMobileqqArkSecureArkSecureUtil$GetAppPathTask.a();
    if (localIGetAppPathByNameCallback != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppPathByNameTimeout success, app=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("ArkApp.ArkSecureUtil", 1, localStringBuilder.toString());
      localIGetAppPathByNameCallback.onGetAppPathByName(paramInt, paramString, paramAppPathInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.secure.ArkSecureUtil.2
 * JD-Core Version:    0.7.0.1
 */