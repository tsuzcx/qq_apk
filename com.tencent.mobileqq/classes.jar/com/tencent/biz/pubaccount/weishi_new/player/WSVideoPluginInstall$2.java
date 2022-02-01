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
    WSLog.e("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] start install video sdk in subThread.");
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
      WSLog.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] ERROR e:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2
 * JD-Core Version:    0.7.0.1
 */