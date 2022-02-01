package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;

class TRTCCloudImpl$57
  implements Runnable
{
  TRTCCloudImpl$57(TRTCCloudImpl paramTRTCCloudImpl, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.mRoomInfo.getUser(this.val$userId);
    if (localObject2 == null)
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("muteRemoteAudio ");
      ((StringBuilder)localObject2).append(this.val$userId);
      ((StringBuilder)localObject2).append(" no exist.");
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      localObject2 = TRTCCloudImpl.access$2600(this.this$0, this.val$userId);
      localRenderInfo = ((TRTCRoomInfo.UserInfo)localObject2).mainRender;
      if (this.val$mute) {
        localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;
      } else {
        localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE;
      }
      localRenderInfo.muteAudio = ((TRTCRoomInfo.TRTCRemoteMuteState)localObject1);
      this.this$0.mRoomInfo.addUserInfo(this.val$userId, (TRTCRoomInfo.UserInfo)localObject2);
      return;
    }
    TRTCRoomInfo.RenderInfo localRenderInfo = ((TRTCRoomInfo.UserInfo)localObject2).mainRender;
    if (this.val$mute) {
      localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;
    } else {
      localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE;
    }
    localRenderInfo.muteAudio = ((TRTCRoomInfo.TRTCRemoteMuteState)localObject1);
    this.this$0.apiOnlineLog("muteRemoteAudio userId:%s mute:%b", new Object[] { this.val$userId, Boolean.valueOf(this.val$mute) });
    if (((TRTCRoomInfo.UserInfo)localObject2).tinyID == 0L) {
      return;
    }
    TXCAudioEngine.getInstance().muteRemoteAudio(String.valueOf(((TRTCRoomInfo.UserInfo)localObject2).tinyID), this.val$mute);
    if (this.val$mute)
    {
      localObject1 = this.this$0;
      TRTCCloudImpl.access$2900((TRTCCloudImpl)localObject1, ((TRTCCloudImpl)localObject1).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject2).tinyID, 1, true);
      return;
    }
    Object localObject1 = this.this$0;
    TRTCCloudImpl.access$3000((TRTCCloudImpl)localObject1, ((TRTCCloudImpl)localObject1).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject2).tinyID, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.57
 * JD-Core Version:    0.7.0.1
 */