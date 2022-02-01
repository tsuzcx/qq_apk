package com.tencent.ark.open.internal;

import com.tencent.ark.Logger;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import java.util.HashMap;

class ArkAppCGIMgr$5
  implements Runnable
{
  ArkAppCGIMgr$5(ArkAppCGIMgr paramArkAppCGIMgr, ArkAppCGIMgr.QueryTask paramQueryTask) {}
  
  public void run()
  {
    try
    {
      IArkDelegateNet localIArkDelegateNet = ArkDelegateManager.getInstance().getNetDelegate();
      if (localIArkDelegateNet != null)
      {
        HashMap localHashMap = new HashMap(2);
        if (this.val$task.cookie != null) {
          localHashMap.put("Cookie", this.val$task.cookie);
        }
        if (this.val$task.referer != null) {
          localHashMap.put("Referer", this.val$task.referer);
        }
        localIArkDelegateNet.get(this.val$task.url, localHashMap, new ArkAppCGIMgr.5.1(this));
        return;
      }
      Logger.logI("ArkApp.ArkAppCGIMgr", String.format("download fail, url=%s for ark net delegate is null", new Object[] { this.val$task.url }));
      return;
    }
    catch (Exception localException)
    {
      Logger.logI("ArkApp.ArkAppCGIMgr", String.format("runTask fail, url=%s, msg=%s", new Object[] { this.val$task.url, localException.getMessage() }));
      ArkAppCGIMgr.access$300(this.this$0, this.val$task, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.internal.ArkAppCGIMgr.5
 * JD-Core Version:    0.7.0.1
 */