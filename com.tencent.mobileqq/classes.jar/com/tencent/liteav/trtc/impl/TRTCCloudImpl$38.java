package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;

class TRTCCloudImpl$38
  implements Runnable
{
  TRTCCloudImpl$38(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vrotation setRemoteViewRotation ");
    localStringBuilder.append(this.val$userId);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.val$rotation);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = this.this$0.mRoomInfo.getUser(this.val$userId);
    if ((localObject != null) && (((TRTCRoomInfo.UserInfo)localObject).mainRender.render != null)) {
      ((TRTCRoomInfo.UserInfo)localObject).mainRender.render.setRenderRotation(this.val$rotation * 90);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.38
 * JD-Core Version:    0.7.0.1
 */