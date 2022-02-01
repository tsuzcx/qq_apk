package com.tencent.liteav.trtc.impl;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$23$1
  implements Runnable
{
  TRTCCloudImpl$23$1(TRTCCloudImpl.23 param23, TXCloudVideoView paramTXCloudVideoView, TRTCRoomInfo.UserInfo paramUserInfo) {}
  
  public void run()
  {
    Object localObject = this.val$view;
    if (localObject != null)
    {
      localObject = ((TXCloudVideoView)localObject).getSurfaceView();
      if ((localObject != null) && (this.val$userInfo.subRender != null)) {
        ((SurfaceView)localObject).getHolder().removeCallback(this.val$userInfo.subRender);
      }
      this.val$view.removeVideoView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.23.1
 * JD-Core Version:    0.7.0.1
 */