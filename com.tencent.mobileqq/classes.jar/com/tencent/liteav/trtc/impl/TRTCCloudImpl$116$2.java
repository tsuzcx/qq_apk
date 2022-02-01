package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;

class TRTCCloudImpl$116$2
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$116$2(TRTCCloudImpl.116 param116) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(paramUserInfo.tinyID), this.this$1.val$refThis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.116.2
 * JD-Core Version:    0.7.0.1
 */