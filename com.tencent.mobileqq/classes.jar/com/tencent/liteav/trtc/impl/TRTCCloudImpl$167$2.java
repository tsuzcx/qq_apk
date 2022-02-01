package com.tencent.liteav.trtc.impl;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$167$2
  implements Runnable
{
  TRTCCloudImpl$167$2(TRTCCloudImpl.167 param167, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.this$1.this$0.mTRTCListener;
    if (localObject1 == null) {
      return;
    }
    Object localObject2;
    Object localObject3;
    if (this.this$1.val$eventCode == 2003)
    {
      if ((this.this$1.val$userId != null) && (this.this$1.val$userId.equals(this.this$1.this$0.mRoomInfo.getUserId())))
      {
        this.this$1.this$0.apiLog("onFirstVideoFrame local.");
        ((TRTCCloudListener)localObject1).onFirstVideoFrame(null, this.val$outStreamType, this.this$1.val$eventParam.getInt("EVT_PARAM1"), this.this$1.val$eventParam.getInt("EVT_PARAM2"));
        return;
      }
      localObject2 = this.this$1.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onFirstVideoFrame ");
      ((StringBuilder)localObject3).append(this.this$1.val$userId);
      ((TRTCCloudImpl)localObject2).apiLog(((StringBuilder)localObject3).toString());
      ((TRTCCloudListener)localObject1).onFirstVideoFrame(this.this$1.val$userId, this.val$outStreamType, this.this$1.val$eventParam.getInt("EVT_PARAM1"), this.this$1.val$eventParam.getInt("EVT_PARAM2"));
      return;
    }
    if (this.this$1.val$eventCode == 2026)
    {
      localObject2 = this.this$1.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onFirstAudioFrame ");
      ((StringBuilder)localObject3).append(this.this$1.val$userId);
      ((TRTCCloudImpl)localObject2).apiLog(((StringBuilder)localObject3).toString());
      ((TRTCCloudListener)localObject1).onFirstAudioFrame(this.this$1.val$userId);
      return;
    }
    if (this.this$1.val$eventCode == 1003)
    {
      ((TRTCCloudListener)localObject1).onCameraDidReady();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCameraDidReady self:");
      ((StringBuilder)localObject1).append(this.this$1.this$0.hashCode());
      Monitor.a(1, ((StringBuilder)localObject1).toString(), "", 0);
      return;
    }
    if (this.this$1.val$eventCode == 2027)
    {
      ((TRTCCloudListener)localObject1).onMicDidReady();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onMicDidReady self:");
      ((StringBuilder)localObject1).append(this.this$1.this$0.hashCode());
      Monitor.a(1, ((StringBuilder)localObject1).toString(), "", 0);
      return;
    }
    if (this.this$1.val$eventCode == 1008)
    {
      localObject2 = new Bundle();
      localObject3 = TRTCCloudImpl.access$8700(this.this$1.this$0, this.this$1.val$eventParam);
      ((Bundle)localObject2).putInt("type", ((Integer)((Pair)localObject3).first).intValue());
      ((TRTCCloudListener)localObject1).onWarning(1104, (String)((Pair)localObject3).second, (Bundle)localObject2);
      return;
    }
    if (this.this$1.val$eventCode < 0)
    {
      ((TRTCCloudListener)localObject1).onError(this.this$1.val$eventCode, this.this$1.val$eventParam.getString("EVT_MSG", ""), this.this$1.val$eventParam);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(String.format("onError event:%d, msg:%s", new Object[] { Integer.valueOf(this.this$1.val$eventCode), this.this$1.val$eventParam }));
      ((StringBuilder)localObject1).append(" self:");
      ((StringBuilder)localObject1).append(this.this$1.this$0.hashCode());
      Monitor.a(3, ((StringBuilder)localObject1).toString(), "", 0);
      TXCKeyPointReportProxy.b(this.this$1.val$eventCode);
      return;
    }
    if (((this.this$1.val$eventCode > 1100) && (this.this$1.val$eventCode < 1110)) || ((this.this$1.val$eventCode > 1200) && (this.this$1.val$eventCode < 1206)) || ((this.this$1.val$eventCode > 2100) && (this.this$1.val$eventCode < 2110)) || ((this.this$1.val$eventCode > 3001) && (this.this$1.val$eventCode < 3011)) || ((this.this$1.val$eventCode > 5100) && (this.this$1.val$eventCode < 5104)))
    {
      ((TRTCCloudListener)localObject1).onWarning(this.this$1.val$eventCode, this.this$1.val$eventParam.getString("EVT_MSG", ""), this.this$1.val$eventParam);
      if (this.this$1.val$eventCode != 2105)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(String.format("onWarning event:%d, msg:%s", new Object[] { Integer.valueOf(this.this$1.val$eventCode), this.this$1.val$eventParam }));
        ((StringBuilder)localObject1).append(" self:");
        ((StringBuilder)localObject1).append(this.this$1.this$0.hashCode());
        Monitor.a(1, ((StringBuilder)localObject1).toString(), "", 0);
      }
      int i = this.this$1.val$eventCode;
      if ((i != 1103) && (i != 1109) && (i != 2106) && (i != 2109) && (i != 2101) && (i != 2102)) {
        return;
      }
      TXCKeyPointReportProxy.b(this.this$1.val$eventCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.167.2
 * JD-Core Version:    0.7.0.1
 */