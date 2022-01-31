package com.tencent.ark.open;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import java.util.Map;

class ArkAppCacheMgr$3$1
  implements ArkAppConfigMgr.IDownloadIconCallback
{
  ArkAppCacheMgr$3$1(ArkAppCacheMgr.3 param3) {}
  
  public void onDownloadFinised(int paramInt, String paramString1, String arg3)
  {
    ArkAppCacheMgr.access$000().logI("ArkApp.ArkAppCacheMgr", String.format("ArkTemp.getAppIcon from download sucess= %d, app=%s, iconPath=%s", new Object[] { Integer.valueOf(paramInt), paramString1, ??? }));
    ArkAppCacheMgr.ApplicationIconHolder localApplicationIconHolder;
    if (paramInt == 1)
    {
      this.this$0.val$iconInfo.iconPath = ???;
      ArkAppCacheMgr.saveDescIconInfo(paramString1, this.this$0.val$iconInfo);
      localApplicationIconHolder = new ArkAppCacheMgr.ApplicationIconHolder(null);
      localApplicationIconHolder.bmp = ArkAppCacheMgr.access$200(this.this$0.val$iconInfo.iconPath);
    }
    synchronized (ArkAppCacheMgr.access$300())
    {
      ArkAppCacheMgr.access$300().put(paramString1, localApplicationIconHolder);
      ArkDispatchTask.getInstance().postToMainThread(new ArkAppCacheMgr.3.1.1(this, paramString1, localApplicationIconHolder));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCacheMgr.3.1
 * JD-Core Version:    0.7.0.1
 */