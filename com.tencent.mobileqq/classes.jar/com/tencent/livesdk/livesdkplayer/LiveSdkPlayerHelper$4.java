package com.tencent.livesdk.livesdkplayer;

import com.tencent.thumbplayer.utils.TPLogUtil;

class LiveSdkPlayerHelper$4
  implements IMediaPlayerMgr.OnPreparedListener
{
  LiveSdkPlayerHelper$4(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void onPrepared(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    TPLogUtil.i("LiveSdkPlayerHelper", "onVideoPrepared:  调用 videoPlayer.start() 开始播放");
    if (LiveSdkPlayerHelper.access$400(this.this$0) == null) {
      TPLogUtil.e("LiveSdkPlayerHelper", "player status listener is null");
    }
    while (LiveSdkPlayerHelper.access$500(this.this$0) == null) {
      return;
    }
    LiveSdkPlayerHelper.access$400(this.this$0).onReadyLayout(LiveSdkPlayerHelper.access$500(this.this$0), paramIMediaPlayerMgr.getVideoWidth(), paramIMediaPlayerMgr.getVideoHeight());
    LiveSdkPlayerHelper.access$400(this.this$0).onReadyCompleted(paramIMediaPlayerMgr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.4
 * JD-Core Version:    0.7.0.1
 */