package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;

class ArkAppMgr$5
  implements Runnable
{
  ArkAppMgr$5(ArkAppMgr paramArkAppMgr, ArkAppMgr.GetCallBackResult paramGetCallBackResult, ArkAppMgr.IGetAppPathByNameCallbackTimeOut paramIGetAppPathByNameCallbackTimeOut) {}
  
  public void run()
  {
    ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", "getAppPathByNameTimeout timeout result =" + this.val$result);
    synchronized (this.val$result)
    {
      if (!this.val$result.hascalled)
      {
        this.val$result.hascalled = true;
        this.val$cb.onGetAppPathByNameTimeout(this.val$result.retCode, this.val$result.msg, this.val$result.appPath, this.val$result.userdata);
        return;
      }
      ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", "getAppPathByNameTimeout timeout find called:" + this.val$result);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.5
 * JD-Core Version:    0.7.0.1
 */