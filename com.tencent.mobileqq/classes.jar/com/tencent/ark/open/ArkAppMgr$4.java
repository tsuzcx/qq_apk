package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;

class ArkAppMgr$4
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  ArkAppMgr$4(ArkAppMgr paramArkAppMgr, ArkAppMgr.GetCallBackResult paramGetCallBackResult, ArkAppMgr.IGetAppPathByNameCallbackTimeOut paramIGetAppPathByNameCallbackTimeOut) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", "getAppPathByNameTimeout onGetAppPathByName result =" + this.val$result);
    synchronized (this.val$result)
    {
      this.val$result.retCode = paramInt;
      this.val$result.msg = paramString;
      this.val$result.appPath = paramAppPathInfo;
      this.val$result.userdata = paramObject;
      if (!this.val$result.hascalled)
      {
        this.val$result.hascalled = true;
        this.val$cb.onGetAppPathByNameTimeout(this.val$result.retCode, this.val$result.msg, this.val$result.appPath, this.val$result.userdata);
        return;
      }
      ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", "getAppPathByNameTimeout onGetAppPathByName find called:" + this.val$result);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.4
 * JD-Core Version:    0.7.0.1
 */