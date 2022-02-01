package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.renderer.e;

class TRTCCloudImpl$85
  implements Runnable
{
  TRTCCloudImpl$85(TRTCCloudImpl paramTRTCCloudImpl, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRemoteSurfaceSize: ");
    localStringBuilder.append(this.val$userId);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.val$width);
    localStringBuilder.append(",");
    localStringBuilder.append(this.val$height);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = this.this$0.mRoomInfo.getUser(this.val$userId);
    if (localObject != null)
    {
      if (this.val$streamType == 2) {
        localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender;
      } else {
        localObject = ((TRTCRoomInfo.UserInfo)localObject).mainRender;
      }
      localObject = ((TRTCRoomInfo.RenderInfo)localObject).render;
      if (localObject != null)
      {
        localObject = ((TXCRenderAndDec)localObject).getVideoRender();
        if (localObject != null)
        {
          ((e)localObject).d(this.val$width, this.val$height);
          return;
        }
        this.this$0.apiLog("videoRender no exist");
        return;
      }
      this.this$0.apiLog("render no exist");
      return;
    }
    this.this$0.apiLog("user no exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.85
 * JD-Core Version:    0.7.0.1
 */