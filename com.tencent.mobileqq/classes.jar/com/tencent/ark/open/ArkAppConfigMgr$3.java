package com.tencent.ark.open;

import com.tencent.ark.ArkEnvironmentManager;

class ArkAppConfigMgr$3
  extends ArkAppCGIMgr.ArkAppCGICallback
{
  ArkAppConfigMgr$3(ArkAppConfigMgr paramArkAppConfigMgr, String paramString) {}
  
  public void onDownloadAppIcon(boolean paramBoolean, byte[] paramArrayOfByte, Object paramObject)
  {
    ArkAppConfigMgr.access$100().logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.onDownloadAppIcon,app=", this.val$appName, ",sucess=", Boolean.valueOf(paramBoolean) });
    if ((paramObject instanceof ArkAppConfigMgr.DownloadIconTask)) {
      ArkAppConfigMgr.access$700(this.this$0, this.val$appName, paramBoolean, paramArrayOfByte, (ArkAppConfigMgr.DownloadIconTask)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppConfigMgr.3
 * JD-Core Version:    0.7.0.1
 */