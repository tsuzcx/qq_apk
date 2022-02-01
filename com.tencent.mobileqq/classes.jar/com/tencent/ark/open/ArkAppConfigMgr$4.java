package com.tencent.ark.open;

import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import java.io.File;

class ArkAppConfigMgr$4
  implements Runnable
{
  ArkAppConfigMgr$4(ArkAppConfigMgr paramArkAppConfigMgr, ArkAppInfo.AppConfig paramAppConfig, String paramString) {}
  
  public void run()
  {
    if (this.val$config != null)
    {
      if (TextUtils.isEmpty(this.val$appName)) {
        return;
      }
      Object localObject2 = String.format("%s/%s", new Object[] { ArkEnvironmentManager.getInstance().getAppIconDirectory(), this.val$appName });
      Object localObject1 = this.this$0.getAppIconFilePath(this.val$appName);
      localObject2 = new File((String)localObject2);
      if (localObject1 != null)
      {
        localObject1 = new File((String)localObject1);
        if ((!((File)localObject2).exists()) || (!((File)localObject1).exists()))
        {
          Logger.logI("ArkApp.ArkAppConfigMgr", "ArkSafe.checkAppIcon find local config need to download iconUrl:");
          this.this$0.downloadAppIcon(this.val$appName, this.val$config.iconUrl, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppConfigMgr.4
 * JD-Core Version:    0.7.0.1
 */