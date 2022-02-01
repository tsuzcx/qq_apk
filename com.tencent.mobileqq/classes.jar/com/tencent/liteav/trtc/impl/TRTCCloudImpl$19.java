package com.tencent.liteav.trtc.impl;

import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.d;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$19
  implements Runnable
{
  TRTCCloudImpl$19(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    this.this$0.apiOnlineLog("stopLocalPreview");
    if (TRTCCloudImpl.access$1600(this.this$0) == TRTCCloudImpl.VideoSourceType.CAMERA)
    {
      TRTCCloudImpl.access$1602(this.this$0, TRTCCloudImpl.VideoSourceType.NONE);
      this.this$0.mCaptureAndEnc.d(true);
    }
    if (this.this$0.mRoomInfo.localView != null)
    {
      SurfaceView localSurfaceView = this.this$0.mRoomInfo.localView.getSurfaceView();
      TextureView localTextureView = this.this$0.mRoomInfo.localView.getHWVideoView();
      this.this$0.runOnMainThread(new TRTCCloudImpl.19.1(this, localSurfaceView, localTextureView));
    }
    this.this$0.mRoomInfo.localView = null;
    TRTCCloudImpl.access$2102(this.this$0, false);
    TRTCCloudImpl.access$2200(this.this$0).disable();
    if (!TRTCCloudImpl.access$2500(this.this$0)) {
      this.this$0.enableVideoStream(false);
    }
    TXCKeyPointReportProxy.a(40046, 0, 2);
    TXCEventRecorderProxy.a("18446744073709551615", 4006, 3L, -1L, "", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.19
 * JD-Core Version:    0.7.0.1
 */