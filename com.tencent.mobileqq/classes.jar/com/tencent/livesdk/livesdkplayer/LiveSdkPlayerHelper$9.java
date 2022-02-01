package com.tencent.livesdk.livesdkplayer;

import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

class LiveSdkPlayerHelper$9
  implements IMediaPlayerMgr.OnVideoFrameOutListener
{
  LiveSdkPlayerHelper$9(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void onVideoFrameOut(ITPPlayer paramITPPlayer, TPVideoFrameBuffer paramTPVideoFrameBuffer)
  {
    long l;
    if (LiveSdkPlayerHelper.access$300(this.this$0) == null) {
      l = 0L;
    } else {
      l = LiveSdkPlayerHelper.access$300(this.this$0).d();
    }
    LiveSdkPlayerHelper.access$300(this.this$0).d(l + 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.9
 * JD-Core Version:    0.7.0.1
 */