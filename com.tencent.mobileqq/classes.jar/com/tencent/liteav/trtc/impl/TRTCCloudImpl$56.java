package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import java.util.HashMap;

class TRTCCloudImpl$56
  implements Runnable
{
  TRTCCloudImpl$56(TRTCCloudImpl paramTRTCCloudImpl1, boolean paramBoolean, TRTCCloudImpl paramTRTCCloudImpl2) {}
  
  public void run()
  {
    ??? = this.this$0.mCurrentPublishClouds;
    Integer localInteger = Integer.valueOf(1);
    ??? = (TRTCCloudImpl)((HashMap)???).get(localInteger);
    if (!this.val$mute)
    {
      if (??? != this.val$cloud)
      {
        this.this$0.enableAudioStream(false);
        synchronized (this.this$0.mCurrentPublishClouds)
        {
          this.this$0.mCurrentPublishClouds.put(localInteger, this.val$cloud);
          TRTCCloudImpl.access$5400(this.this$0);
        }
      }
      this.this$0.mRoomInfo.muteLocalAudio = this.val$mute;
      TXCAudioEngine.getInstance().muteLocalAudio(this.val$mute);
      TRTCCloudImpl.access$4400(this.this$0, 1, this.val$mute);
      this.this$0.enableAudioStream(true);
      return;
    }
    if (??? == this.val$cloud)
    {
      this.this$0.mRoomInfo.muteLocalAudio = this.val$mute;
      TXCAudioEngine.getInstance().muteLocalAudio(this.val$mute);
      TRTCCloudImpl.access$4400(this.this$0, 1, this.val$mute);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.56
 * JD-Core Version:    0.7.0.1
 */