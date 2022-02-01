package com.tencent.ark.open.appmanage;

import com.tencent.ark.Logger;

class AppUpdateManager$1
  implements AppUpdateManager.ICheckNetworkCallback
{
  AppUpdateManager$1(AppUpdateManager paramAppUpdateManager, AppUpdateTask.IUpdateAppByNameCallback paramIUpdateAppByNameCallback) {}
  
  public void onCheckNetwork(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Logger.logI("ArkApp.ArkAppMgr", "updateInstalledApps, network not available.");
      return;
    }
    Logger.logI("ArkApp.ArkAppMgr", "updateInstalledApps, onCheckNetwork available.");
    AppUpdateManager.access$000(this.this$0, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.AppUpdateManager.1
 * JD-Core Version:    0.7.0.1
 */