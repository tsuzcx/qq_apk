package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.opensdk.callbacks.RtcCsCmdCallback;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.audiomediaservice.service.RequestMediaChannelCallback;

class OpenSdkChannel$3
  implements RequestMediaChannelCallback
{
  OpenSdkChannel$3(OpenSdkChannel paramOpenSdkChannel, RtcCsCmdCallback paramRtcCsCmdCallback) {}
  
  public void a(int paramInt)
  {
    LogInterface localLogInterface = OpenSdkChannel.a(this.b).c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVSdkCoreAppChannel-requestInfoCmd fail 3 errCode:");
    localStringBuilder.append(paramInt);
    localLogInterface.e("ChannelAdapter", localStringBuilder.toString(), new Object[0]);
    this.a.onError(paramInt, "");
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.a.onSuccess(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.OpenSdkChannel.3
 * JD-Core Version:    0.7.0.1
 */