package com.tencent.liteav.trtc.impl;

import android.view.SurfaceView;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.d;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$15
  implements Runnable
{
  TRTCCloudImpl$15(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stopLocalPreview self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    localObject = ((StringBuilder)localObject).toString();
    this.this$0.apiLog((String)localObject);
    Monitor.a(1, (String)localObject, "", 0);
    if (TRTCCloudImpl.access$1600(this.this$0) == TRTCCloudImpl.VideoSourceType.CAMERA)
    {
      TRTCCloudImpl.access$1602(this.this$0, TRTCCloudImpl.VideoSourceType.NONE);
      this.this$0.mCaptureAndEnc.c(true);
    }
    if (this.this$0.mRoomInfo.localView != null)
    {
      localObject = this.this$0.mRoomInfo.localView.getSurfaceView();
      if (localObject != null) {
        this.this$0.runOnMainThread(new TRTCCloudImpl.15.1(this, (SurfaceView)localObject));
      }
    }
    this.this$0.mRoomInfo.localView = null;
    TRTCCloudImpl.access$2000(this.this$0).disable();
    this.this$0.enableVideoStream(false);
    TXCKeyPointReportProxy.a(40046, 0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.15
 * JD-Core Version:    0.7.0.1
 */