package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.module.Monitor;

class TRTCCloudImpl$52
  implements Runnable
{
  TRTCCloudImpl$52(TRTCCloudImpl paramTRTCCloudImpl, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.mRoomInfo.getUser(this.val$userId);
    if (localObject1 == null)
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("muteRemoteAudio ");
      ((StringBuilder)localObject2).append(this.val$userId);
      ((StringBuilder)localObject2).append(" no exist.");
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      localObject1 = TRTCCloudImpl.access$2300(this.this$0, this.val$userId);
      ((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteAudio = this.val$mute;
      this.this$0.mRoomInfo.addUserInfo(this.val$userId, (TRTCRoomInfo.UserInfo)localObject1);
      return;
    }
    ((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteAudio = this.val$mute;
    Object localObject2 = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("muteRemoteAudio ");
    localStringBuilder.append(this.val$userId);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.val$mute);
    ((TRTCCloudImpl)localObject2).apiLog(localStringBuilder.toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.format("muteRemoteAudio userId:%s mute:%b", new Object[] { this.val$userId, Boolean.valueOf(this.val$mute) }));
    ((StringBuilder)localObject2).append(" self:");
    ((StringBuilder)localObject2).append(this.this$0.hashCode());
    Monitor.a(1, ((StringBuilder)localObject2).toString(), "", 0);
    if (((TRTCRoomInfo.UserInfo)localObject1).tinyID == 0L) {
      return;
    }
    TXCAudioEngine.getInstance().muteRemoteAudio(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), this.val$mute);
    if (this.val$mute)
    {
      localObject2 = this.this$0;
      TRTCCloudImpl.access$2700((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, 1, true);
      return;
    }
    localObject2 = this.this$0;
    TRTCCloudImpl.access$2600((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.52
 * JD-Core Version:    0.7.0.1
 */