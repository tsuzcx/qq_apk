package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import thq;
import tht;
import tlo;

public class WSVideoPluginInstall$2
  implements Runnable
{
  public WSVideoPluginInstall$2(thq paramthq) {}
  
  public void run()
  {
    tlo.e("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] start install video sdk in subThread.");
    if (!thq.b()) {
      thq.a(this.this$0);
    }
    try
    {
      TVK_SDKMgr.installPlugin(BaseApplicationImpl.getContext(), new tht(thq.a(this.this$0)));
      return;
    }
    catch (Exception localException)
    {
      tlo.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] ERROR e:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2
 * JD-Core Version:    0.7.0.1
 */