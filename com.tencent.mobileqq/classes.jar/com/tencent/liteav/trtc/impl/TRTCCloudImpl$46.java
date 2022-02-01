package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.d;

class TRTCCloudImpl$46
  implements Runnable
{
  TRTCCloudImpl$46(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  public void run()
  {
    if (TRTCCloudImpl.access$1400(this.this$0))
    {
      this.this$0.apiLog("startLocalAudio when enable custom audio capturing, ignore!!!");
      return;
    }
    if (TRTCCloudImpl.access$1500(this.this$0))
    {
      this.this$0.apiLog("startLocalAudio when capturing audio, ignore!!!");
      return;
    }
    if (this.this$0.mCurrentRole == 21)
    {
      this.this$0.runOnListenerThread(new TRTCCloudImpl.46.1(this));
      this.this$0.apiLog("ignore startLocalAudio,for role audience");
    }
    this.this$0.apiLog("startLocalAudio");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startLocalAudio self:");
    localStringBuilder.append(this.this$0.hashCode());
    Monitor.a(1, localStringBuilder.toString(), "", 0);
    TXCEventRecorderProxy.a("18446744073709551615", 3001, 0L, -1L, "", 0);
    TRTCCloudImpl.access$1502(this.this$0, true);
    this.this$0.mCaptureAndEnc.a(this.this$0.mConfig);
    TRTCCloudImpl.access$4400(this.this$0);
    TXCAudioEngine.getInstance().enableCaptureEOSMode(this.this$0.mEnableEosMode);
    TXCAudioEngine.getInstance().enableSoftAEC(TRTCCloudImpl.access$4500(this.this$0), TRTCCloudImpl.access$4600(this.this$0));
    TXCAudioEngineJNI.nativeUseSysAudioDevice(false);
    TXCAudioEngine.getInstance().startLocalAudio(11, false);
    TXCAudioEngine.getInstance().enableEncodedDataPackWithTRAEHeaderCallback(true);
    TXCAudioEngine.getInstance().muteLocalAudio(this.this$0.mRoomInfo.muteLocalAudio);
    TXCEventRecorderProxy.a("18446744073709551615", 3003, 11L, -1L, "", 0);
    this.this$0.enableAudioStream(true);
    TXCKeyPointReportProxy.a(40050, 1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.46
 * JD-Core Version:    0.7.0.1
 */