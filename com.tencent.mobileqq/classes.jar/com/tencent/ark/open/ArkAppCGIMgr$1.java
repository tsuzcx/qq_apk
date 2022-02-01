package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.delegate.IArkDelegateNetCallback;

class ArkAppCGIMgr$1
  extends IArkDelegateNetCallback
{
  ArkAppCGIMgr$1(ArkAppCGIMgr paramArkAppCGIMgr, ArkAppCGIMgr.ArkAppCGICallback paramArkAppCGICallback, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      ArkAppCGIMgr.access$100().logI("ArkApp.ArkAppCGIMgr", "ArkTemp.queryAppInfoByAppNameBatch, sso request failed");
      paramObject = null;
    }
    for (;;)
    {
      paramObject = ArkAppCGIMgr.access$200(this.this$0, (String)paramObject);
      if (this.val$callback != null) {
        this.val$callback.onQueryAppInfoByAppNameBatch(paramObject, this.val$userdata);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCGIMgr.1
 * JD-Core Version:    0.7.0.1
 */