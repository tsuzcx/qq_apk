package com.tencent.ilive.audiencepages.room.bizmodule;

import android.os.Handler;
import android.os.Message;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;

class AVPreloadPlayerModule$2
  extends Handler
{
  AVPreloadPlayerModule$2(AVPreloadPlayerModule paramAVPreloadPlayerModule) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 100) && (AVPreloadPlayerModule.a(this.a) != null))
    {
      AVPreloadPlayerModule.a(this.a).stopPlay();
      AVPreloadPlayerModule.a(this.a).resetPlayer();
      AVPreloadPlayerModule.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule.2
 * JD-Core Version:    0.7.0.1
 */