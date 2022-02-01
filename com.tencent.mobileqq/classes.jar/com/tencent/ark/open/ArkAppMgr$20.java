package com.tencent.ark.open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.ark.ArkEnvironmentManager;

final class ArkAppMgr$20
  implements Runnable
{
  ArkAppMgr$20(String paramString) {}
  
  public void run()
  {
    Object localObject = ArkEnvironmentManager.getSharedPreferences("ArkAppLastUsedTime");
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong(this.val$appName, System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    ArkAppMgr.access$100().logE("ArkApp.ArkAppMgr", "updateAppLastUseTime sp is not inited");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.20
 * JD-Core Version:    0.7.0.1
 */