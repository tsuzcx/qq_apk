package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;

class TRTCCloudImpl$58$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$58$1(TRTCCloudImpl.58 param58) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    TRTCRoomInfo.RenderInfo localRenderInfo = paramUserInfo.mainRender;
    if (this.this$1.val$mute) {
      paramString = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;
    } else {
      paramString = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE;
    }
    localRenderInfo.muteAudio = paramString;
    TXCAudioEngine.getInstance().muteRemoteAudio(String.valueOf(paramUserInfo.tinyID), this.this$1.val$mute);
    if (this.this$1.val$mute)
    {
      TRTCCloudImpl.access$2900(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 1, true);
      return;
    }
    TRTCCloudImpl.access$3000(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.58.1
 * JD-Core Version:    0.7.0.1
 */