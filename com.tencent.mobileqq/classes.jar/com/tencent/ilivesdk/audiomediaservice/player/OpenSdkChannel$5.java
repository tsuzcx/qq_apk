package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.ilive.opensdk.callbacks.RtcCsCmdCallback;
import com.tencent.ilivesdk.audiomediaservice.service.RequestMediaChannelCallback;

class OpenSdkChannel$5
  implements RequestMediaChannelCallback
{
  OpenSdkChannel$5(OpenSdkChannel paramOpenSdkChannel, RtcCsCmdCallback paramRtcCsCmdCallback) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentIliveOpensdkCallbacksRtcCsCmdCallback.onError(paramInt, "");
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentIliveOpensdkCallbacksRtcCsCmdCallback.onSuccess(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.OpenSdkChannel.5
 * JD-Core Version:    0.7.0.1
 */