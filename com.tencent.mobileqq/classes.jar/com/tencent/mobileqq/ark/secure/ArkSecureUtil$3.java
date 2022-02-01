package com.tencent.mobileqq.ark.secure;

import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

final class ArkSecureUtil$3
  implements Runnable
{
  ArkSecureUtil$3(ArkSecureUtil.GetAppPathTask paramGetAppPathTask, String paramString) {}
  
  public void run()
  {
    ArkAppMgr.IGetAppPathByNameCallback localIGetAppPathByNameCallback = this.jdField_a_of_type_ComTencentMobileqqArkSecureArkSecureUtil$GetAppPathTask.a();
    if (localIGetAppPathByNameCallback != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppPathByNameTimeout timeout, app=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("ArkApp.ArkSecureUtil", 1, localStringBuilder.toString());
      localIGetAppPathByNameCallback.onGetAppPathByName(-7, HardCodeUtil.a(2131693800), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.secure.ArkSecureUtil.3
 * JD-Core Version:    0.7.0.1
 */