package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;

class TRTCCloudImpl$25
  implements Runnable
{
  TRTCCloudImpl$25(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRemoteSubStreamViewRotation->userId: ");
    localStringBuilder.append(this.val$userId);
    localStringBuilder.append(", rotation: ");
    localStringBuilder.append(this.val$rotation);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = this.this$0.mRoomInfo.getUser(this.val$userId);
    if ((localObject != null) && (((TRTCRoomInfo.UserInfo)localObject).subRender.render != null)) {
      ((TRTCRoomInfo.UserInfo)localObject).subRender.render.setRenderRotation(this.val$rotation * 90);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.25
 * JD-Core Version:    0.7.0.1
 */