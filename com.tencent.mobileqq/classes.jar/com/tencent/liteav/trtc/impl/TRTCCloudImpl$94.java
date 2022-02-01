package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.trtc.TRTCCloud.BGMNotify;

class TRTCCloudImpl$94
  implements Runnable
{
  TRTCCloudImpl$94(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloud.BGMNotify paramBGMNotify, String paramString) {}
  
  public void run()
  {
    this.this$0.apiLog("playBGM");
    TRTCCloudImpl.access$8102(this.this$0, this.val$notify);
    if (TRTCCloudImpl.access$8100(this.this$0) != null) {
      TXCLiveBGMPlayer.getInstance().setOnPlayListener(this.this$0);
    } else {
      TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
    }
    TXCLiveBGMPlayer.getInstance().startPlay(this.val$path);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.94
 * JD-Core Version:    0.7.0.1
 */