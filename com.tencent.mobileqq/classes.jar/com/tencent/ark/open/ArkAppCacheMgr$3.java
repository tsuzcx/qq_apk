package com.tencent.ark.open;

final class ArkAppCacheMgr$3
  implements Runnable
{
  ArkAppCacheMgr$3(String paramString, ArkAppInfo.AppConfig paramAppConfig, ArkAppCacheMgr.ArkDescIconInfo paramArkDescIconInfo, ArkAppCacheMgr.OnGetAppIcon paramOnGetAppIcon) {}
  
  public void run()
  {
    ArkAppConfigMgr.getInstance().downloadAppIcon(this.val$appName, this.val$config.iconUrl, new ArkAppCacheMgr.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCacheMgr.3
 * JD-Core Version:    0.7.0.1
 */