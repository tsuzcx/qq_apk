package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;

class TRTCCloudImpl$125$2
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$125$2(TRTCCloudImpl.125 param125) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(paramUserInfo.tinyID), this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.125.2
 * JD-Core Version:    0.7.0.1
 */