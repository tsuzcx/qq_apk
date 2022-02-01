package com.tencent.ark.open.internal;

import com.tencent.ark.Logger;
import com.tencent.ark.open.delegate.IArkDelegateSSOCallback;

class ArkAppCGIMgr$2
  implements IArkDelegateSSOCallback
{
  ArkAppCGIMgr$2(ArkAppCGIMgr paramArkAppCGIMgr, ArkAppCGIMgr.IQueryAppInfoRequestCallback paramIQueryAppInfoRequestCallback) {}
  
  public void onComplete(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      Logger.logI("ArkApp.ArkAppCGIMgr", "sendQueryAppInfoRequestBySSO, sso request failed");
      this.val$callback.onResult(null);
      return;
    }
    this.val$callback.onResult((String)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.internal.ArkAppCGIMgr.2
 * JD-Core Version:    0.7.0.1
 */