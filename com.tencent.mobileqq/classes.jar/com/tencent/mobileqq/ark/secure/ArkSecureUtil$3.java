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
    ArkAppMgr.IGetAppPathByNameCallback localIGetAppPathByNameCallback = this.a.a();
    if (localIGetAppPathByNameCallback != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppPathByNameTimeout timeout, app=");
      localStringBuilder.append(this.b);
      QLog.i("ArkApp.ArkSecureUtil", 1, localStringBuilder.toString());
      localIGetAppPathByNameCallback.onGetAppPathByName(-7, HardCodeUtil.a(2131891375), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.secure.ArkSecureUtil.3
 * JD-Core Version:    0.7.0.1
 */