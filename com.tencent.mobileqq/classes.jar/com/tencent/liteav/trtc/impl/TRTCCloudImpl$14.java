package com.tencent.liteav.trtc.impl;

import android.view.Surface;
import android.view.SurfaceView;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.g;
import com.tencent.rtmp.ui.TXCloudVideoView;

class TRTCCloudImpl$14
  implements Runnable
{
  TRTCCloudImpl$14(TRTCCloudImpl paramTRTCCloudImpl, boolean paramBoolean, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void run()
  {
    int i;
    if (TRTCCloudImpl.access$1600(this.this$0) != TRTCCloudImpl.VideoSourceType.NONE) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      this.this$0.apiLog("startLocalPreview just reset view when is started");
    }
    if (this.this$0.mCurrentRole == 21)
    {
      this.this$0.runOnListenerThread(new TRTCCloudImpl.14.1(this));
      this.this$0.apiLog("ignore startLocalPreview for audience");
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startLocalPreview front:");
    ((StringBuilder)localObject2).append(this.val$frontCamera);
    ((StringBuilder)localObject2).append(", view:");
    Object localObject1 = this.val$view;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(localObject1.hashCode());
    } else {
      localObject1 = "";
    }
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(this.this$0.hashCode());
    localObject1 = ((StringBuilder)localObject2).toString();
    this.this$0.apiLog((String)localObject1);
    Monitor.a(1, (String)localObject1, "", 0);
    this.this$0.mRoomInfo.localView = this.val$view;
    this.this$0.mConfig.m = this.val$frontCamera;
    localObject1 = this.this$0.mConfig;
    boolean bool;
    if (this.this$0.mPerformanceMode == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((g)localObject1).W = bool;
    localObject1 = this.this$0.mConfig;
    if (this.this$0.mPerformanceMode == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((g)localObject1).U = bool;
    this.this$0.mCaptureAndEnc.a(this.this$0.mConfig);
    TXCKeyPointReportProxy.a(40046, 1, 2);
    TRTCCloudImpl.access$2000(this.this$0).enable();
    TRTCCloudImpl.access$2100(this.this$0);
    this.this$0.enableVideoStream(true);
    localObject1 = this.val$view;
    if (localObject1 != null) {
      localObject1 = ((TXCloudVideoView)localObject1).getSurfaceView();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      if ((i == 0) && (TRTCCloudImpl.access$1600(this.this$0) == TRTCCloudImpl.VideoSourceType.NONE))
      {
        TRTCCloudImpl.access$1602(this.this$0, TRTCCloudImpl.VideoSourceType.CAMERA);
        this.this$0.mCaptureAndEnc.a(null);
      }
      else
      {
        this.this$0.apiLog("startLocalPreview with surface view when is started");
      }
    }
    else if ((i == 0) && (TRTCCloudImpl.access$1600(this.this$0) == TRTCCloudImpl.VideoSourceType.NONE))
    {
      TRTCCloudImpl.access$1602(this.this$0, TRTCCloudImpl.VideoSourceType.CAMERA);
      this.this$0.mCaptureAndEnc.a(this.val$view);
    }
    else
    {
      this.this$0.apiLog("startLocalPreview with view view when is started");
    }
    localObject2 = new Surface[1];
    com.tencent.liteav.basic.util.d locald = new com.tencent.liteav.basic.util.d();
    TRTCCloudImpl.access$2200(this.this$0, new TRTCCloudImpl.14.2(this, (SurfaceView)localObject1, (Surface[])localObject2, locald));
    if (localObject2[0] != null)
    {
      this.this$0.mCaptureAndEnc.a(localObject2[0]);
      this.this$0.mCaptureAndEnc.a(locald.a, locald.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.14
 * JD-Core Version:    0.7.0.1
 */