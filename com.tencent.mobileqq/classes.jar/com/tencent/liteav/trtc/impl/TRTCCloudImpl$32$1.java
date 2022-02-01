package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;

class TRTCCloudImpl$32$1
  implements TRTCRoomInfo.UserAction
{
  TRTCCloudImpl$32$1(TRTCCloudImpl.32 param32) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    paramUserInfo.mainRender.muteVideo = this.this$1.val$mute;
    paramString = this.this$1.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("muteRemoteVideoStream ");
    localStringBuilder.append(paramUserInfo.userID);
    localStringBuilder.append(", mute ");
    localStringBuilder.append(this.this$1.val$mute);
    paramString.apiLog(localStringBuilder.toString());
    if (paramUserInfo.mainRender.render != null) {
      paramUserInfo.mainRender.render.muteVideo(this.this$1.val$mute);
    }
    if (this.this$1.val$mute)
    {
      TRTCCloudImpl.access$2700(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 2, true);
      TRTCCloudImpl.access$2700(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 3, true);
      TRTCCloudImpl.access$2700(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 7, true);
      return;
    }
    if ((paramUserInfo.mainRender.render != null) && (paramUserInfo.mainRender.render.isRendering())) {
      TRTCCloudImpl.access$2600(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, paramUserInfo.streamType, true);
    }
    if ((paramUserInfo.subRender.render != null) && (paramUserInfo.subRender.render.isRendering())) {
      TRTCCloudImpl.access$2600(this.this$1.this$0, this.this$1.this$0.mNativeRtcContext, paramUserInfo.tinyID, 7, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.32.1
 * JD-Core Version:    0.7.0.1
 */