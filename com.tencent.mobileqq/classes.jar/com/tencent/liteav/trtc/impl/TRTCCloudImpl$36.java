package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$36
  implements Runnable
{
  TRTCCloudImpl$36(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("muteAllRemoteVideoStreams mute ");
    ((StringBuilder)localObject2).append(this.val$mute);
    ((TRTCCloudImpl)localObject1).apiOnlineLog(((StringBuilder)localObject2).toString());
    localObject2 = this.this$0.mRoomInfo;
    if (this.val$mute) {
      localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;
    } else {
      localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE;
    }
    ((TRTCRoomInfo)localObject2).muteRemoteVideo = ((TRTCRoomInfo.TRTCRemoteMuteState)localObject1);
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.36.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.36
 * JD-Core Version:    0.7.0.1
 */