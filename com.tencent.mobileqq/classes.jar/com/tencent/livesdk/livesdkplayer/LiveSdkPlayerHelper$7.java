package com.tencent.livesdk.livesdkplayer;

import com.tencent.thumbplayer.utils.TPLogUtil;

class LiveSdkPlayerHelper$7
  implements IMediaPlayerMgr.OnCompletionListener
{
  LiveSdkPlayerHelper$7(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void onCompletion(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    TPLogUtil.i("LiveSdkPlayerHelper", "onCompletion: 视频播放结束");
    if (LiveSdkPlayerHelper.access$400(this.this$0) != null) {
      LiveSdkPlayerHelper.access$400(this.this$0).onPlayCompleted(LiveSdkPlayerHelper.access$200(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.7
 * JD-Core Version:    0.7.0.1
 */