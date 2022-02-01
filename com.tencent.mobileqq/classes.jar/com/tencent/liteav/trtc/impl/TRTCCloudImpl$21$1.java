package com.tencent.liteav.trtc.impl;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$21$1
  implements Runnable
{
  TRTCCloudImpl$21$1(TRTCCloudImpl.21 param21, TXCloudVideoView paramTXCloudVideoView, TRTCRoomInfo.UserInfo paramUserInfo) {}
  
  public void run()
  {
    Object localObject = this.val$view;
    if (localObject != null)
    {
      localObject = ((TXCloudVideoView)localObject).getSurfaceView();
      if ((localObject != null) && (this.val$userInfo.mainRender != null)) {
        ((SurfaceView)localObject).getHolder().removeCallback(this.val$userInfo.mainRender);
      }
      this.val$view.removeVideoView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.21.1
 * JD-Core Version:    0.7.0.1
 */