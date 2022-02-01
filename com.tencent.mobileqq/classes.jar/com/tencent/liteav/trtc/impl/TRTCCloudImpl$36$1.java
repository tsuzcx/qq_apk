package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;

class TRTCCloudImpl$36$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$36$1(TRTCCloudImpl.36 param36) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    Object localObject = paramUserInfo.mainRender;
    if (this.this$1.val$mute) {
      paramString = TRTCRoomInfo.TRTCRemoteMuteState.MUTE;
    } else {
      paramString = TRTCRoomInfo.TRTCRemoteMuteState.UNMUTE;
    }
    ((TRTCRoomInfo.RenderInfo)localObject).muteVideo = paramString;
    paramString = this.this$1.this$0;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("muteRemoteVideoStream ");
    ((StringBuilder)localObject).append(paramUserInfo.userID);
    ((StringBuilder)localObject).append(", mute ");
    ((StringBuilder)localObject).append(this.this$1.val$mute);
    paramString.apiLog(((StringBuilder)localObject).toString());
    if (paramUserInfo.mainRender.render != null)
    {
      paramUserInfo.mainRender.render.resetPeriodStatistics();
      paramUserInfo.mainRender.render.enableReport(this.this$1.val$mute ^ true);
    }
    if (paramUserInfo.subRender.render != null)
    {
      paramUserInfo.subRender.render.resetPeriodStatistics();
      paramUserInfo.subRender.render.enableReport(this.this$1.val$mute ^ true);
    }
    if (this.this$1.val$mute)
    {
      TRTCCloudImpl.access$2900(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 2, true);
      TRTCCloudImpl.access$2900(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 3, true);
      TRTCCloudImpl.access$2900(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 7, true);
    }
    else
    {
      if ((paramUserInfo.mainRender.render != null) && (paramUserInfo.mainRender.render.isRendering()))
      {
        TRTCCloudImpl.access$3000(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, paramUserInfo.streamType, true);
        TXCKeyPointReportProxy.a(String.valueOf(paramUserInfo.tinyID), 40021, 0L, paramUserInfo.streamType);
      }
      if ((paramUserInfo.subRender.render != null) && (paramUserInfo.subRender.render.isRendering()))
      {
        TRTCCloudImpl.access$3000(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 7, true);
        TXCKeyPointReportProxy.a(String.valueOf(paramUserInfo.tinyID), 40021, 0L, 7);
      }
    }
    long l2 = paramUserInfo.tinyID;
    long l1;
    if (this.this$1.val$mute) {
      l1 = 1L;
    } else {
      l1 = 0L;
    }
    TXCEventRecorderProxy.a(String.valueOf(l2), 4014, l1, -1L, "", 2);
    l2 = paramUserInfo.tinyID;
    if (this.this$1.val$mute) {
      l1 = 1L;
    } else {
      l1 = 0L;
    }
    TXCEventRecorderProxy.a(String.valueOf(l2), 4014, l1, -1L, "", 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.36.1
 * JD-Core Version:    0.7.0.1
 */