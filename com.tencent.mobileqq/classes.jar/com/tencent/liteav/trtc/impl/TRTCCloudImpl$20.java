package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;

class TRTCCloudImpl$20
  implements Runnable
{
  TRTCCloudImpl$20(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt) {}
  
  public void run()
  {
    TRTCRoomInfo.UserInfo localUserInfo = this.this$0.mRoomInfo.getUser(this.val$userId);
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSubStreamRemoteViewFillMode->userId: ");
    localStringBuilder.append(this.val$userId);
    localStringBuilder.append(", fillMode: ");
    localStringBuilder.append(this.val$mode);
    localTRTCCloudImpl.apiLog(localStringBuilder.toString());
    if ((localUserInfo != null) && (localUserInfo.subRender.render != null)) {
      localUserInfo.subRender.render.setRenderMode(this.val$mode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.20
 * JD-Core Version:    0.7.0.1
 */