package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.common.app.BaseApplicationImpl;
import vgj;
import vgm;
import vha;
import vmp;

public class WSVideoPluginInstall$2
  implements Runnable
{
  public WSVideoPluginInstall$2(vgj paramvgj) {}
  
  public void run()
  {
    vmp.e("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] start install video sdk in subThread.");
    if (!vgj.a(this.this$0)) {
      vgj.a(this.this$0);
    }
    try
    {
      vgj.a(this.this$0).a(BaseApplicationImpl.getContext(), new vgm(vgj.a(this.this$0)));
      return;
    }
    catch (Exception localException)
    {
      vmp.d("WS_VIDEO_WSVideoPluginInstall", "[WSVideoPluginInstall.java][installPlugin] ERROR e:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPluginInstall.2
 * JD-Core Version:    0.7.0.1
 */