package com.tencent.ilivesdk.avpreloadplayerservice;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;

class AVPreloadPlayerService$4
  implements Runnable
{
  AVPreloadPlayerService$4(AVPreloadPlayerService paramAVPreloadPlayerService) {}
  
  public void run()
  {
    this.this$0.stopPlay();
    this.this$0.resetPlayer();
    this.this$0.setPlayerSurface();
    AVPreloadPlayerService.a(this.this$0, false);
    AVPreloadPlayerService.b(this.this$0);
    AVPreloadPlayerService.B(this.this$0).getLogger().i("AVPreload|Core", "retry play time " + AVPreloadPlayerService.a(this.this$0), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.AVPreloadPlayerService.4
 * JD-Core Version:    0.7.0.1
 */