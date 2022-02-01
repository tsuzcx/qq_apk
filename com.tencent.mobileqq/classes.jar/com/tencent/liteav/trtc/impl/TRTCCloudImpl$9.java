package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$9
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$9(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    paramUserInfo.mainRender.muteAudio = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
    paramUserInfo.mainRender.muteVideo = TRTCRoomInfo.TRTCRemoteMuteState.UNSET;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.9
 * JD-Core Version:    0.7.0.1
 */