package com.tencent.ark.open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.ark.ArkEnvironmentManager;

class ArkAppMgr$13
  implements Runnable
{
  ArkAppMgr$13(ArkAppMgr paramArkAppMgr) {}
  
  public void run()
  {
    Object localObject = ArkEnvironmentManager.getSharedPreferences("ArkLocalAppUpdateTime");
    long l1 = ((SharedPreferences)localObject).getLong("PredownloadAppUpdateTime", 0L);
    long l2 = (System.currentTimeMillis() - l1) / 1000L / 60L;
    if ((l2 < ArkAppMgr.access$1700()) && (!ArkAppMgr.access$1800())) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("PredownloadAppUpdateTime", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject).commit();
    ArkAppMgr.access$100().logI("ArkApp.ArkAppMgr", String.format("updatePredownloadAppList, delta=%d, lastUpdateTime=%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) }));
    if (!ArkEnvironmentManager.getInstance().isTestEnv()) {}
    for (localObject = "https://cdn.ark.qq.com/arkapp/app_config.json";; localObject = "https://test.ark.qq.com/arkapp/app_config.json")
    {
      ArkAppCGIMgr.getInstance().getPredownloadAppList((String)localObject, null, new ArkAppMgr.13.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.13
 * JD-Core Version:    0.7.0.1
 */