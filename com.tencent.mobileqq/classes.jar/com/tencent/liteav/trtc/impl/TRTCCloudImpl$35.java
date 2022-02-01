package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;

class TRTCCloudImpl$35
  implements Runnable
{
  TRTCCloudImpl$35(TRTCCloudImpl paramTRTCCloudImpl, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.mRoomInfo.getUser(this.val$userId);
    if (localObject2 == null)
    {
      localObject1 = this.this$0;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("muteRemoteVideoStream ");
      ((StringBuilder)localObject2).append(this.val$userId);
      ((StringBuilder)localObject2).append(" no exist.");
      ((TRTCCloudImpl)localObject1).apiLog(((StringBuilder)localObject2).toString());
      localObject2 = TRTCCloudImpl.access$2600(this.this$0, this.val$userId);
      localObject3 = ((TRTCRoomInfo.UserInfo)localObject2).mainRender;
      if (this.val$mute) {
        localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;
      } else {
        localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE;
      }
      ((TRTCRoomInfo.RenderInfo)localObject3).muteVideo = ((TRTCRoomInfo.TRTCRemoteMuteState)localObject1);
      this.this$0.mRoomInfo.addUserInfo(this.val$userId, (TRTCRoomInfo.UserInfo)localObject2);
      return;
    }
    Object localObject3 = ((TRTCRoomInfo.UserInfo)localObject2).mainRender;
    if (this.val$mute) {
      localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;
    } else {
      localObject1 = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE;
    }
    ((TRTCRoomInfo.RenderInfo)localObject3).muteVideo = ((TRTCRoomInfo.TRTCRemoteMuteState)localObject1);
    Object localObject1 = this.this$0;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("muteRemoteVideoStream userId:");
    ((StringBuilder)localObject3).append(this.val$userId);
    ((StringBuilder)localObject3).append(", mute:");
    ((StringBuilder)localObject3).append(this.val$mute);
    ((TRTCCloudImpl)localObject1).apiOnlineLog(((StringBuilder)localObject3).toString());
    long l2 = ((TRTCRoomInfo.UserInfo)localObject2).tinyID;
    long l1 = 0L;
    if (l2 == 0L) {
      return;
    }
    if (((TRTCRoomInfo.UserInfo)localObject2).mainRender.render != null)
    {
      ((TRTCRoomInfo.UserInfo)localObject2).mainRender.render.resetPeriodStatistics();
      ((TRTCRoomInfo.UserInfo)localObject2).mainRender.render.enableReport(this.val$mute ^ true);
    }
    if (this.val$mute)
    {
      localObject1 = this.this$0;
      TRTCCloudImpl.access$2900((TRTCCloudImpl)localObject1, ((TRTCCloudImpl)localObject1).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject2).tinyID, 2, true);
      localObject1 = this.this$0;
      TRTCCloudImpl.access$2900((TRTCCloudImpl)localObject1, ((TRTCCloudImpl)localObject1).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject2).tinyID, 3, true);
    }
    else
    {
      localObject1 = this.this$0;
      TRTCCloudImpl.access$3000((TRTCCloudImpl)localObject1, ((TRTCCloudImpl)localObject1).mNativeRtcContext, ((TRTCRoomInfo.UserInfo)localObject2).tinyID, ((TRTCRoomInfo.UserInfo)localObject2).streamType, true);
      TXCKeyPointReportProxy.a(String.valueOf(((TRTCRoomInfo.UserInfo)localObject2).tinyID), 40021, 0L, ((TRTCRoomInfo.UserInfo)localObject2).streamType);
    }
    l2 = ((TRTCRoomInfo.UserInfo)localObject2).tinyID;
    if (this.val$mute) {
      l1 = 1L;
    }
    TXCEventRecorderProxy.a(String.valueOf(l2), 4014, l1, -1L, "", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.35
 * JD-Core Version:    0.7.0.1
 */