package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.falco.base.libapi.log.LogInterface;

class AVPlayerModule$PreloadPlayerStatusListener
  extends AVPlayerModule.DefaultPlayerStatusListener
{
  AVPlayerModule$PreloadPlayerStatusListener(AVPlayerModule paramAVPlayerModule)
  {
    super(paramAVPlayerModule);
  }
  
  public void onReadyCompleted()
  {
    this.this$0.getLog().i(AVPlayerModule.access$400(this.this$0), "PreloadPlayerStatusListener -- onReadyCompleted", new Object[0]);
    AVPlayerModule.access$502(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPlayerModule.PreloadPlayerStatusListener
 * JD-Core Version:    0.7.0.1
 */