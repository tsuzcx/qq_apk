package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$58
  implements Runnable
{
  TRTCCloudImpl$58(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("muteAllRemoteAudio ");
    ((StringBuilder)localObject2).append(this.val$mute);
    ((TRTCCloudImpl)localObject1).apiOnlineLog(((StringBuilder)localObject2).toString());
    localObject2 = this.this$0.mRoomInfo;
    if (this.val$mute) {
      localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;
    } else {
      localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE;
    }
    ((TRTCRoomInfo)localObject2).muteRemoteAudio = ((TRTCRoomInfo.TRTCRemoteMuteState)localObject1);
    this.this$0.mRoomInfo.forEachUser(new TRTCCloudImpl.58.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.58
 * JD-Core Version:    0.7.0.1
 */