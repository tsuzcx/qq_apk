package com.tencent.liteav.trtc.impl;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.liteav.basic.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.d;

class TRTCCloudImpl$167
  implements Runnable
{
  TRTCCloudImpl$167(TRTCCloudImpl paramTRTCCloudImpl, String paramString, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    TRTCCloudImpl.access$8600(this.this$0, this.val$userId, this.val$eventParam.getInt("EVT_STREAM_TYPE", 2), this.val$eventParam.getString("EVT_MSG", ""), String.format("event %d, ", new Object[] { Integer.valueOf(this.val$eventCode) }));
    int i = this.val$eventCode;
    if (i == 2029)
    {
      this.this$0.apiLog("release mic~");
      if (this.this$0.mRoomInfo.isRoomExit())
      {
        this.this$0.apiLog("onExitRoom when mic release.");
        i = this.this$0.mRoomInfo.getRoomExitCode();
        this.this$0.mRoomInfo.setRoomExit(false, 0);
        this.this$0.runOnListenerThread(new TRTCCloudImpl.167.1(this, i));
      }
      else
      {
        this.this$0.mRoomInfo.micStart(false);
      }
    }
    else if (i == 2027)
    {
      this.this$0.apiLog(String.format("onMicDidReady~", new Object[0]));
      this.this$0.mRoomInfo.micStart(true);
    }
    else
    {
      if (i == -2304)
      {
        TXCLog.i("TRTCCloudImpl", "codecability eventCode = ERR_HEVC_DECODE_FAIL");
        TRTCCloudImpl.access$6102(this.this$0, false);
        if (!a.a()) {
          TRTCCloudHevcUtil.setLifeCycleEnableHevcDecode(false);
        }
        this.this$0.mCaptureAndEnc.j(false);
        localObject = this.this$0;
        ((TRTCCloudImpl)localObject).nativeFlushC2SVideoCodecConfig(((TRTCCloudImpl)localObject).mNativeRtcContext, 3);
        return;
      }
      if ((i == -2310) || (i == -2311)) {
        break label358;
      }
      if (i == 1008)
      {
        localObject = TRTCCloudImpl.access$8700(this.this$0, this.val$eventParam);
        i = this.val$eventParam.getInt("EVT_STREAM_TYPE", 0);
        TXCEventRecorderProxy.a("18446744073709551615", 4016, ((Integer)((Pair)localObject).first).intValue(), -1L, (String)((Pair)localObject).second, i);
      }
    }
    i = TRTCCloudImpl.access$8400(this.this$0, this.val$eventParam.getInt("EVT_STREAM_TYPE", 2));
    this.this$0.runOnListenerThread(new TRTCCloudImpl.167.2(this, i));
    return;
    label358:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("codecability eventCode: ");
    ((StringBuilder)localObject).append(this.val$eventCode);
    TXCLog.i("TRTCCloudImpl", ((StringBuilder)localObject).toString());
    TRTCCloudImpl.access$6102(this.this$0, false);
    TRTCCloudHevcUtil.setLifeCycleEnableHevcEncode(false);
    i = TRTCCloudHevcUtil.getHevcDecoderValue();
    localObject = this.this$0;
    ((TRTCCloudImpl)localObject).nativeFlushC2SVideoCodecConfig(((TRTCCloudImpl)localObject).mNativeRtcContext, i | 0x3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.167
 * JD-Core Version:    0.7.0.1
 */