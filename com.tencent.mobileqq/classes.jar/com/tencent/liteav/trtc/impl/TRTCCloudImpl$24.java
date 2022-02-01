package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.g.a;
import com.tencent.trtc.TRTCCloudDef.TRTCScreenShareParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;

class TRTCCloudImpl$24
  implements Runnable
{
  TRTCCloudImpl$24(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams paramTRTCScreenShareParams) {}
  
  public void run()
  {
    if (TRTCCloudImpl.access$1600(this.this$0) != TRTCCloudImpl.VideoSourceType.NONE)
    {
      TRTCCloudImpl.access$3000(this.this$0, "Has started capturing, ignore startScreenCapture");
      return;
    }
    TRTCCloudImpl.access$1602(this.this$0, TRTCCloudImpl.VideoSourceType.SCREEN);
    TRTCCloudImpl.access$3102(this.this$0, 0);
    TRTCCloudImpl.access$2000(this.this$0).disable();
    if (this.val$param != null)
    {
      TRTCCloudImpl.access$3202(this.this$0, false);
      TRTCCloudImpl.access$3300(this.this$0, this.val$param);
    }
    else
    {
      TRTCCloudImpl.access$3202(this.this$0, true);
    }
    if (this.this$0.mCurrentRole == 21)
    {
      this.this$0.runOnListenerThread(new TRTCCloudImpl.24.1(this));
      this.this$0.apiLog("ignore startLocalPreview for audience");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start screen capture self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    localObject = ((StringBuilder)localObject).toString();
    this.this$0.apiLog((String)localObject);
    Monitor.a(1, (String)localObject, "", 0);
    this.this$0.mCaptureAndEnc.a(0);
    if ((this.this$0.mConfig.l != 1) && (this.this$0.mConfig.l != 3))
    {
      localObject = this.this$0;
      TRTCCloudImpl.access$3400((TRTCCloudImpl)localObject, false, ((TRTCCloudImpl)localObject).mConfig.b, this.this$0.mConfig.a, this.this$0.mConfig.h, this.this$0.mConfig.c, this.this$0.mConfig.p, this.this$0.mConfig.e);
    }
    else
    {
      localObject = this.this$0;
      TRTCCloudImpl.access$3400((TRTCCloudImpl)localObject, true, ((TRTCCloudImpl)localObject).mConfig.a, this.this$0.mConfig.b, this.this$0.mConfig.h, this.this$0.mConfig.c, this.this$0.mConfig.p, this.this$0.mConfig.e);
    }
    localObject = this.this$0;
    localObject = TRTCCloudImpl.access$3500((TRTCCloudImpl)localObject, TRTCCloudImpl.access$800((TRTCCloudImpl)localObject).videoResolution, TRTCCloudImpl.access$800(this.this$0).videoResolutionMode);
    TRTCCloudImpl.access$3600(this.this$0, ((g.a)localObject).a, ((g.a)localObject).b, TRTCCloudImpl.access$800(this.this$0).videoFps, TRTCCloudImpl.access$800(this.this$0).videoBitrate, TRTCCloudImpl.access$800(this.this$0).minVideoBitrate);
    this.this$0.mRoomInfo.localView = null;
    this.this$0.enableVideoStream(true);
    TXCKeyPointReportProxy.a(40046, 1, 7);
    this.this$0.mCaptureAndEnc.a(this.this$0);
    this.this$0.runOnMainThread(new TRTCCloudImpl.24.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.24
 * JD-Core Version:    0.7.0.1
 */