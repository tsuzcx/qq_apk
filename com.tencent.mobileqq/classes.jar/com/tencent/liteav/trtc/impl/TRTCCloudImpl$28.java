package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.g.a;
import com.tencent.trtc.TRTCCloudDef.TRTCScreenShareParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;

class TRTCCloudImpl$28
  implements Runnable
{
  TRTCCloudImpl$28(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams paramTRTCScreenShareParams) {}
  
  public void run()
  {
    if (TRTCCloudImpl.access$1600(this.this$0) != TRTCCloudImpl.VideoSourceType.NONE)
    {
      TRTCCloudImpl.access$3300(this.this$0, "Has started capturing, ignore startScreenCapture");
      return;
    }
    TRTCCloudImpl.access$1602(this.this$0, TRTCCloudImpl.VideoSourceType.SCREEN);
    TRTCCloudImpl.access$3402(this.this$0, 0);
    TRTCCloudImpl.access$2200(this.this$0).disable();
    TRTCCloudImpl.access$1300(this.this$0);
    if (this.val$param != null)
    {
      TRTCCloudImpl.access$3502(this.this$0, false);
      TRTCCloudImpl.access$3600(this.this$0, this.val$param);
    }
    else
    {
      TRTCCloudImpl.access$3502(this.this$0, true);
    }
    if (this.this$0.mCurrentRole == 21)
    {
      this.this$0.runOnListenerThread(new TRTCCloudImpl.28.1(this));
      this.this$0.apiLog("ignore startLocalPreview for audience");
    }
    this.this$0.apiOnlineLog("startScreenCapture");
    this.this$0.mCaptureAndEnc.a(0);
    if ((this.this$0.mConfig.m != 1) && (this.this$0.mConfig.m != 3))
    {
      localObject = this.this$0;
      TRTCCloudImpl.access$3700((TRTCCloudImpl)localObject, false, ((TRTCCloudImpl)localObject).mConfig.b, this.this$0.mConfig.a, this.this$0.mConfig.i, this.this$0.mConfig.c, this.this$0.mConfig.q, this.this$0.mConfig.e, this.this$0.mConfig.h);
    }
    else
    {
      localObject = this.this$0;
      TRTCCloudImpl.access$3700((TRTCCloudImpl)localObject, true, ((TRTCCloudImpl)localObject).mConfig.a, this.this$0.mConfig.b, this.this$0.mConfig.i, this.this$0.mConfig.c, this.this$0.mConfig.q, this.this$0.mConfig.e, this.this$0.mConfig.h);
    }
    Object localObject = this.this$0;
    localObject = TRTCCloudImpl.access$3800((TRTCCloudImpl)localObject, TRTCCloudImpl.access$1000((TRTCCloudImpl)localObject).videoResolution, TRTCCloudImpl.access$1000(this.this$0).videoResolutionMode);
    TRTCCloudImpl.access$3900(this.this$0, ((g.a)localObject).a, ((g.a)localObject).b, TRTCCloudImpl.access$1000(this.this$0).videoFps, TRTCCloudImpl.access$1000(this.this$0).videoBitrate, TRTCCloudImpl.access$1000(this.this$0).minVideoBitrate);
    this.this$0.mRoomInfo.localView = null;
    this.this$0.enableVideoStream(true);
    TXCKeyPointReportProxy.a(40046, 1, 2);
    TXCEventRecorderProxy.a("18446744073709551615", 4006, 2L, -1L, "", 2);
    this.this$0.mCaptureAndEnc.a(this.this$0);
    this.this$0.runOnMainThread(new TRTCCloudImpl.28.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.28
 * JD-Core Version:    0.7.0.1
 */