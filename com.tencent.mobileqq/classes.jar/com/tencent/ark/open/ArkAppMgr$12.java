package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;

class ArkAppMgr$12
  implements ArkAppMgr.ICheckNetworkCallback
{
  ArkAppMgr$12(ArkAppMgr paramArkAppMgr) {}
  
  public void onCheckNetwork(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", "updateInstalledApps, network not available.");
      return;
    }
    ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", "updateInstalledApps, onCheckNetwork available.");
    this.this$0.updatePredownloadAppList();
    ArkAppMgr.access$1600(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.12
 * JD-Core Version:    0.7.0.1
 */