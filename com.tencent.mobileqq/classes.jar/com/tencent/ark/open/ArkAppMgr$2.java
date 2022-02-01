package com.tencent.ark.open;

import android.os.Looper;

class ArkAppMgr$2
  implements Runnable
{
  ArkAppMgr$2(ArkAppMgr paramArkAppMgr, String paramString1, String paramString2, String paramString3, Object paramObject, ArkAppMgr.IGetAppPathByNameCallback paramIGetAppPathByNameCallback, Looper paramLooper) {}
  
  public void run()
  {
    ArkAppMgr.access$200(this.this$0, this.val$appName, this.val$appView, this.val$minAppVersion, this.val$userdata, this.val$cb, this.val$originLooper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.2
 * JD-Core Version:    0.7.0.1
 */