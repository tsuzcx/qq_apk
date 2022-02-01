package com.tencent.liteav.trtc.impl;

import android.view.Surface;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.renderer.e;

class TRTCCloudImpl$84
  implements Runnable
{
  TRTCCloudImpl$84(TRTCCloudImpl paramTRTCCloudImpl, String paramString, Surface paramSurface, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRemoteSurface ");
    localStringBuilder.append(this.val$userId);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.val$surface);
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
          ((e)localObject).a(this.val$surface);
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
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.84
 * JD-Core Version:    0.7.0.1
 */