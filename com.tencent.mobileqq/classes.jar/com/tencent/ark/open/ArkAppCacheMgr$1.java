package com.tencent.ark.open;

import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark.Application;
import java.util.Map;

final class ArkAppCacheMgr$1
  implements Runnable
{
  ArkAppCacheMgr$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    ArkAppCacheMgr.access$000().logI("ArkApp.ArkAppCacheMgr", String.format("ArkTemp.cacheManifestInfo,name=%s, path=%s", new Object[] { this.val$name, this.val$path }));
    Object localObject1 = new ArkAppCacheMgr.ArkAppManifestInfo();
    if (TextUtils.isEmpty(this.val$path))
    {
      ArkAppCacheMgr.access$000().logI("ArkApp.ArkAppCacheMgr", String.format("cacheManifestInfo, path is empty", new Object[0]));
      return;
    }
    Object localObject2 = ark.Application.Create(this.val$name, this.val$path);
    ((ArkAppCacheMgr.ArkAppManifestInfo)localObject1).actionSet = ((ark.Application)localObject2).GetActionSet();
    ((ArkAppCacheMgr.ArkAppManifestInfo)localObject1).version = ((ark.Application)localObject2).GetVersion();
    ((ArkAppCacheMgr.ArkAppManifestInfo)localObject1).checkVersion = ((ark.Application)localObject2).CheckVersion();
    ((ArkAppCacheMgr.ArkAppManifestInfo)localObject1).launcher = ((ark.Application)localObject2).GetLauncher();
    String str = ((ark.Application)localObject2).GetDescription();
    ((ark.Application)localObject2).Release();
    ArkAppCacheMgr.sAppManifestInfoCache.put(this.val$path, localObject1);
    localObject2 = ArkAppCacheMgr.getDescIconInfo(this.val$name);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArkAppCacheMgr.ArkDescIconInfo();
    }
    ((ArkAppCacheMgr.ArkDescIconInfo)localObject1).name = str;
    ArkAppCacheMgr.saveDescIconInfo(this.val$name, (ArkAppCacheMgr.ArkDescIconInfo)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCacheMgr.1
 * JD-Core Version:    0.7.0.1
 */