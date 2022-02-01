package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;

class TRTCCloudImpl$53$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$53$1(TRTCCloudImpl.53 param53) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    paramUserInfo.mainRender.muteAudio = this.this$1.val$mute;
    TXCAudioEngine.getInstance().muteRemoteAudio(String.valueOf(paramUserInfo.tinyID), this.this$1.val$mute);
    if (this.this$1.val$mute)
    {
      TRTCCloudImpl.access$2700(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 1, true);
      return;
    }
    TRTCCloudImpl.access$2600(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.53.1
 * JD-Core Version:    0.7.0.1
 */