package com.tencent.liteav.trtc.impl;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import java.util.Locale;

class TRTCCloudImpl$29
  implements Runnable
{
  TRTCCloudImpl$29(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    if (TRTCCloudImpl.access$1600(this.this$0) != TRTCCloudImpl.VideoSourceType.SCREEN)
    {
      this.this$0.apiOnlineLog("stopScreenCapture been ignored for Screen capture is not started");
      return;
    }
    TRTCCloudImpl.access$1602(this.this$0, TRTCCloudImpl.VideoSourceType.NONE);
    this.this$0.apiOnlineLog("stopScreenCapture");
    this.this$0.runOnMainThread(new TRTCCloudImpl.29.1(this));
    this.this$0.mCaptureAndEnc.m();
    this.this$0.mRoomInfo.localView = null;
    this.this$0.enableVideoStream(false);
    TXCKeyPointReportProxy.a(40046, 0, 2);
    TXCEventRecorderProxy.a("18446744073709551615", 4006, 3L, -1L, "", 2);
    this.this$0.mConfig.i = TRTCCloudImpl.access$4200(this.this$0).getInt("config_fps", this.this$0.mConfig.i);
    this.this$0.mConfig.j = TRTCCloudImpl.access$4200(this.this$0).getInt("config_gop", this.this$0.mConfig.j);
    this.this$0.mConfig.q = TRTCCloudImpl.access$4200(this.this$0).getBoolean("config_adjust_resolution", this.this$0.mConfig.q);
    TRTCCloudImpl.access$1000(this.this$0).videoFps = TRTCCloudImpl.access$4300(this.this$0).getInt("config_fps", TRTCCloudImpl.access$1000(this.this$0).videoFps);
    TRTCCloudImpl.access$1000(this.this$0).enableAdjustRes = TRTCCloudImpl.access$4300(this.this$0).getBoolean("config_adjust_resolution", TRTCCloudImpl.access$1000(this.this$0).enableAdjustRes);
    TXCLog.i("TRTCCloudImpl", String.format(Locale.ENGLISH, "restore big encoder's fps: %d, gop: %d, small encoder's fps: %d", new Object[] { Integer.valueOf(this.this$0.mConfig.i), Integer.valueOf(this.this$0.mConfig.j), Integer.valueOf(TRTCCloudImpl.access$1000(this.this$0).videoFps) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.29
 * JD-Core Version:    0.7.0.1
 */