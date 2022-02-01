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
    AVPreloadPlayerService.a(this.this$0);
    LogInterface localLogInterface = AVPreloadPlayerService.x(this.this$0).getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("retry play time ");
    localStringBuilder.append(AVPreloadPlayerService.b(this.this$0));
    localLogInterface.i("AVPreload|Core", localStringBuilder.toString(), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadplayerservice.AVPreloadPlayerService.4
 * JD-Core Version:    0.7.0.1
 */