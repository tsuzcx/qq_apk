package com.tencent.livesdk.livesdkplayer;

import com.tencent.thumbplayer.utils.TPLogUtil;

class LiveSdkPlayerHelper$8
  implements IMediaPlayerMgr.OnSeekCompleteListener
{
  LiveSdkPlayerHelper$8(LiveSdkPlayerHelper paramLiveSdkPlayerHelper) {}
  
  public void onSeekComplete(IMediaPlayerMgr paramIMediaPlayerMgr)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSeekComplete: ");
    localStringBuilder.append(paramIMediaPlayerMgr.getCurrentPositionMs());
    TPLogUtil.i("LiveSdkPlayerHelper", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.LiveSdkPlayerHelper.8
 * JD-Core Version:    0.7.0.1
 */