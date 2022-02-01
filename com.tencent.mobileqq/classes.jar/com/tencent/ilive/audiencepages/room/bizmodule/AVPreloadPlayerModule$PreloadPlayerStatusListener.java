package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.falco.base.libapi.log.LogInterface;

class AVPreloadPlayerModule$PreloadPlayerStatusListener
  extends AVPreloadPlayerModule.DefaultPlayerStatusListener
{
  AVPreloadPlayerModule$PreloadPlayerStatusListener(AVPreloadPlayerModule paramAVPreloadPlayerModule)
  {
    super(paramAVPreloadPlayerModule);
  }
  
  public void onReadyCompleted()
  {
    this.b.getLog().i(AVPreloadPlayerModule.a(this.b), "PreloadPlayerStatusListener -- onReadyCompleted", new Object[0]);
    AVPreloadPlayerModule.c(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule.PreloadPlayerStatusListener
 * JD-Core Version:    0.7.0.1
 */