package com.tencent.livesdk.livesdkplayer;

import com.tencent.falco.utils.ThreadCenter;

class LiveSdkPlayerHelper$11
  implements Runnable
{
  LiveSdkPlayerHelper$11(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void run()
  {
    long l = LiveSdkPlayerHelper.access$200(this.this$0).getRenderFrameCount();
    if (l > 0L) {
      LiveSdkPlayerHelper.access$300(this.this$0).d(l);
    }
    LiveSdkPlayerHelper localLiveSdkPlayerHelper = this.this$0;
    ThreadCenter.postDelayedUITask(localLiveSdkPlayerHelper, LiveSdkPlayerHelper.access$1200(localLiveSdkPlayerHelper), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.11
 * JD-Core Version:    0.7.0.1
 */