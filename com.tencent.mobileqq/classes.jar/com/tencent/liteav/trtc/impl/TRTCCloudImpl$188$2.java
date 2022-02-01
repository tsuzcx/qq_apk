package com.tencent.liteav.trtc.impl;

import android.os.Bundle;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$188$2
  implements Runnable
{
  TRTCCloudImpl$188$2(TRTCCloudImpl.188 param188, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.this$1.this$0.mTRTCListener;
    if (localObject1 == null) {
      return;
    }
    Object localObject2;
    StringBuilder localStringBuilder;
    if (this.this$1.val$eventCode == 2003)
    {
      if ((this.this$1.val$userId != null) && (this.this$1.val$userId.equals(this.this$1.this$0.mRoomInfo.getUserId())))
      {
        this.this$1.this$0.apiLog("onFirstVideoFrame local.");
        ((TRTCCloudListener)localObject1).onFirstVideoFrame(null, this.val$outStreamType, this.this$1.val$eventParam.getInt("EVT_PARAM1"), this.this$1.val$eventParam.getInt("EVT_PARAM2"));
        return;
      }
      localObject2 = this.this$1.this$0;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFirstVideoFrame ");
      localStringBuilder.append(this.this$1.val$userId);
      ((TRTCCloudImpl)localObject2).apiLog(localStringBuilder.toString());
      ((TRTCCloudListener)localObject1).onFirstVideoFrame(this.this$1.val$userId, this.val$outStreamType, this.this$1.val$eventParam.getInt("EVT_PARAM1"), this.this$1.val$eventParam.getInt("EVT_PARAM2"));
      return;
    }
    if (this.this$1.val$eventCode == 2026)
    {
      localObject2 = this.this$1.this$0;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFirstAudioFrame ");
      localStringBuilder.append(this.this$1.val$userId);
      ((TRTCCloudImpl)localObject2).apiLog(localStringBuilder.toString());
      ((TRTCCloudListener)localObject1).onFirstAudioFrame(this.this$1.val$userId);
      localObject1 = this.this$1.this$0.mRoomInfo.getUser(this.this$1.val$userId);
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((TRTCRoomInfo.UserInfo)localObject1).tinyID);
        ((StringBuilder)localObject2).append("");
        TXCKeyPointReportProxy.b(((StringBuilder)localObject2).toString(), 32006);
      }
    }
    else
    {
      if (this.this$1.val$eventCode == 1003)
      {
        ((TRTCCloudListener)localObject1).onCameraDidReady();
        this.this$1.this$0.apiOnlineLog("onCameraDidReady");
        return;
      }
      if (this.this$1.val$eventCode == 2027)
      {
        ((TRTCCloudListener)localObject1).onMicDidReady();
        this.this$1.this$0.apiOnlineLog("onMicDidReady");
        return;
      }
      if (this.this$1.val$eventCode == 1008) {
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
          Monitor.a(4, ((StringBuilder)localObject1).toString(), "", 0);
        }
        int i = this.this$1.val$eventCode;
        if ((i != 1103) && (i != 1109) && (i != 2106) && (i != 2109) && (i != 2101) && (i != 2102)) {
          return;
        }
        TXCKeyPointReportProxy.b(this.this$1.val$eventCode);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.188.2
 * JD-Core Version:    0.7.0.1
 */