package com.tencent.ark.open;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import java.util.Map;

final class ArkAppCacheMgr$2
  implements Runnable
{
  ArkAppCacheMgr$2(ArkAppCacheMgr.ArkDescIconInfo paramArkDescIconInfo, String paramString, ArkAppCacheMgr.OnGetAppIcon paramOnGetAppIcon) {}
  
  public void run()
  {
    ArkAppCacheMgr.ApplicationIconHolder localApplicationIconHolder = new ArkAppCacheMgr.ApplicationIconHolder(null);
    localApplicationIconHolder.bmp = ArkAppCacheMgr.access$200(this.val$iconInfo.iconPath);
    synchronized (ArkAppCacheMgr.access$300())
    {
      ArkAppCacheMgr.access$300().put(this.val$appName, localApplicationIconHolder);
      ArkAppCacheMgr.access$000().logI("ArkApp.ArkAppCacheMgr", "ArkTemp.getAppIcon from template app, local iconfile exist, appName=" + this.val$appName);
      ArkDispatchTask.getInstance().postToMainThread(new ArkAppCacheMgr.2.1(this, localApplicationIconHolder));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCacheMgr.2
 * JD-Core Version:    0.7.0.1
 */