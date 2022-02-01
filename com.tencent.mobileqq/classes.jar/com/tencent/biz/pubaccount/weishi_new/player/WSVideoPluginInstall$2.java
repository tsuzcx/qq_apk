package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.common.app.BaseApplicationImpl;
import ury;
import usb;
import usp;
import uya;

public class WSVideoPluginInstall$2
  implements Runnable
{
  public WSVideoPluginInstall$2(ury paramury) {}
  
  public void run()
  {
    uya.e("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] start install video sdk in subThread.");
    if (!ury.a(this.this$0)) {
      ury.a(this.this$0);
    }
    try
    {
      ury.a(this.this$0).a(BaseApplicationImpl.getContext(), new usb(ury.a(this.this$0)));
      return;
    }
    catch (Exception localException)
    {
      uya.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] ERROR e:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2
 * JD-Core Version:    0.7.0.1
 */