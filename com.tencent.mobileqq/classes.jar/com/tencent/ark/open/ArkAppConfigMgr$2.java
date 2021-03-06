package com.tencent.ark.open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import java.util.HashMap;

class ArkAppConfigMgr$2
  implements Runnable
{
  ArkAppConfigMgr$2(ArkAppConfigMgr paramArkAppConfigMgr) {}
  
  public void run()
  {
    synchronized (ArkAppConfigMgr.lock)
    {
      ArkAppConfigMgr.access$000(this.this$0).clear();
      SharedPreferences localSharedPreferences = ArkEnvironmentManager.getAppConfigSharedPreferences();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().clear().commit();
      }
      ArkUtil.delete(ArkEnvironmentManager.getInstance().getAppIconDirectory(), false);
      Logger.logI("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.cleanAllConfig, env=", ArkAppConfigMgr.access$400(this.this$0) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppConfigMgr.2
 * JD-Core Version:    0.7.0.1
 */