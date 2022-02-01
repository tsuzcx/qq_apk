package com.tencent.ilive.audiencepages.room.bizmodule;

import android.os.Handler;
import android.os.Message;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;

class AVPlayerModule$2
  extends Handler
{
  AVPlayerModule$2(AVPlayerModule paramAVPlayerModule) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 100) && (AVPlayerModule.access$000(this.this$0) != null))
    {
      AVPlayerModule.access$000(this.this$0).stopPlay();
      AVPlayerModule.access$000(this.this$0).resetPlayer();
      AVPlayerModule.access$202(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPlayerModule.2
 * JD-Core Version:    0.7.0.1
 */