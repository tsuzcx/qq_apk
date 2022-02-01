package com.tencent.liteav.trtc.impl;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import java.util.Locale;

class TRTCCloudImpl$25
  implements Runnable
{
  TRTCCloudImpl$25(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    if (TRTCCloudImpl.access$1600(this.this$0) != TRTCCloudImpl.VideoSourceType.SCREEN)
    {
      this.this$0.apiLog("stopScreenCapture been ignored for Screen capture is not started");
      return;
    }
    TRTCCloudImpl.access$1602(this.this$0, TRTCCloudImpl.VideoSourceType.NONE);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stopScreenCapture self:");
    ((StringBuilder)localObject).append(this.this$0.hashCode());
    localObject = ((StringBuilder)localObject).toString();
    this.this$0.apiLog((String)localObject);
    Monitor.a(1, (String)localObject, "", 0);
    this.this$0.runOnMainThread(new TRTCCloudImpl.25.1(this));
    this.this$0.mCaptureAndEnc.l();
    this.this$0.mRoomInfo.localView = null;
    this.this$0.enableVideoStream(false);
    TXCKeyPointReportProxy.a(40046, 0, 7);
    this.this$0.mConfig.h = TRTCCloudImpl.access$3900(this.this$0).getInt("config_fps", this.this$0.mConfig.h);
    this.this$0.mConfig.i = TRTCCloudImpl.access$3900(this.this$0).getInt("config_gop", this.this$0.mConfig.i);
    this.this$0.mConfig.p = TRTCCloudImpl.access$3900(this.this$0).getBoolean("config_adjust_resolution", this.this$0.mConfig.p);
    TRTCCloudImpl.access$800(this.this$0).videoFps = TRTCCloudImpl.access$4000(this.this$0).getInt("config_fps", TRTCCloudImpl.access$800(this.this$0).videoFps);
    TRTCCloudImpl.access$800(this.this$0).enableAdjustRes = TRTCCloudImpl.access$4000(this.this$0).getBoolean("config_adjust_resolution", TRTCCloudImpl.access$800(this.this$0).enableAdjustRes);
    TXCLog.i("TRTCCloudImpl", String.format(Locale.ENGLISH, "restore big encoder's fps: %d, gop: %d, small encoder's fps: %d", new Object[] { Integer.valueOf(this.this$0.mConfig.h), Integer.valueOf(this.this$0.mConfig.i), Integer.valueOf(TRTCCloudImpl.access$800(this.this$0).videoFps) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.25
 * JD-Core Version:    0.7.0.1
 */