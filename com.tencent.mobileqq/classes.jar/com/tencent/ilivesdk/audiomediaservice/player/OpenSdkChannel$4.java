package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.ilive.opensdk.callbacks.RtcCsCmdCallback;
import com.tencent.ilivesdk.audiomediaservice.service.RequestMediaChannelCallback;

class OpenSdkChannel$4
  implements RequestMediaChannelCallback
{
  OpenSdkChannel$4(OpenSdkChannel paramOpenSdkChannel, RtcCsCmdCallback paramRtcCsCmdCallback) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentIliveOpensdkCallbacksRtcCsCmdCallback.onError(paramInt, "");
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentIliveOpensdkCallbacksRtcCsCmdCallback.onSuccess(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.OpenSdkChannel.4
 * JD-Core Version:    0.7.0.1
 */