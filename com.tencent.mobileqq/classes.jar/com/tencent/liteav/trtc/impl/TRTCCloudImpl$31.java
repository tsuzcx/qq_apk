package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;

class TRTCCloudImpl$31
  implements Runnable
{
  TRTCCloudImpl$31(TRTCCloudImpl paramTRTCCloudImpl, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.mRoomInfo.getUser(this.val$userId);
    if (localObject1 == null)
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("muteRemoteVideoStream ");
      ((StringBuilder)localObject2).append(this.val$userId);
      ((StringBuilder)localObject2).append(" no exist.");
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      localObject1 = TRTCCloudImpl.access$2300(this.this$0, this.val$userId);
      ((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteVideo = this.val$mute;
      this.this$0.mRoomInfo.addUserInfo(this.val$userId, (TRTCRoomInfo.UserInfo)localObject1);
      return;
    }
    ((TRTCRoomInfo.UserInfo)localObject1).mainRender.muteVideo = this.val$mute;
    Object localObject2 = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("muteRemoteVideoStream ");
    localStringBuilder.append(this.val$userId);
    localStringBuilder.append(", mute:");
    localStringBuilder.append(this.val$mute);
    ((TRTCCloudImpl)localObject2).apiLog(localStringBuilder.toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("muteRemoteVideoStream userId:%s mute:%b self:");
    ((StringBuilder)localObject2).append(this.this$0.hashCode());
    Monitor.a(1, String.format(((StringBuilder)localObject2).toString(), new Object[] { this.val$userId, Boolean.valueOf(this.val$mute) }), "", 0);
    if (((TRTCRoomInfo.UserInfo)localObject1).tinyID == 0L) {
      return;
    }
    if (((TRTCRoomInfo.UserInfo)localObject1).mainRender.render != null) {
      ((TRTCRoomInfo.UserInfo)localObject1).mainRender.render.muteVideo(this.val$mute);
    }
    if (this.val$mute)
    {
      localObject2 = this.this$0;
      TRTCCloudImpl.access$2700((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, 2, true);
      localObject2 = this.this$0;
      TRTCCloudImpl.access$2700((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, 3, true);
      TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4014, 1L, -1L, "", 0);
      return;
    }
    localObject2 = this.this$0;
    TRTCCloudImpl.access$2600((TRTCCloudImpl)localObject2, ((TRTCCloudImpl)localObject2).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject1).tinyID, ((TRTCRoomInfo.UserInfo)localObject1).streamType, true);
    TXCEventRecorderProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID), 4014, 0L, -1L, "", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.31
 * JD-Core Version:    0.7.0.1
 */