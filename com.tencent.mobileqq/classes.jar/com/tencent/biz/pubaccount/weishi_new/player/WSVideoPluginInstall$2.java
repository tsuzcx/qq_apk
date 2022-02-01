package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerSdkMgr;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;

class WSVideoPluginInstall$2
  implements Runnable
{
  WSVideoPluginInstall$2(WSVideoPluginInstall paramWSVideoPluginInstall) {}
  
  public void run()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[WSVideoPluginInstall.java][installPlugin] start install video sdk in subThread. mIsInitialized:");
    localStringBuilder1.append(WSVideoPluginInstall.b());
    WSLog.e("WS_VIDEO_WSVideoPluginInstall", localStringBuilder1.toString());
    if (!WSVideoPluginInstall.b()) {
      WSVideoPluginInstall.a(this.this$0);
    }
    try
    {
      WSVideoPluginInstall.a(this.this$0).a(BaseApplicationImpl.getContext(), new WSVideoPluginInstall.SDKInstallListener(WSVideoPluginInstall.a(this.this$0)));
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[WSVideoPluginInstall.java][installPlugin] ERROR e:");
      localStringBuilder2.append(localException.getMessage());
      WSLog.d("WS_VIDEO_WSVideoPluginInstall", localStringBuilder2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2
 * JD-Core Version:    0.7.0.1
 */