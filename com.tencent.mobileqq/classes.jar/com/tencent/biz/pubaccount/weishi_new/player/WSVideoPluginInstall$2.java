package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import ukg;
import ukj;
import upe;

public class WSVideoPluginInstall$2
  implements Runnable
{
  public WSVideoPluginInstall$2(ukg paramukg) {}
  
  public void run()
  {
    upe.e("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] start install video sdk in subThread.");
    if (!ukg.b()) {
      ukg.a(this.this$0);
    }
    try
    {
      TVK_SDKMgr.installPlugin(BaseApplicationImpl.getContext(), new ukj(ukg.a(this.this$0)));
      return;
    }
    catch (Exception localException)
    {
      upe.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] ERROR e:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2
 * JD-Core Version:    0.7.0.1
 */