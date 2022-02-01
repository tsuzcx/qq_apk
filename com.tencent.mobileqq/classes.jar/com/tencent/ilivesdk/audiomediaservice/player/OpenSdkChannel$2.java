package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.opensdk.callbacks.RtcCsCmdCallback;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.audiomediaservice.service.RequestMediaChannelCallback;

class OpenSdkChannel$2
  implements RequestMediaChannelCallback
{
  OpenSdkChannel$2(OpenSdkChannel paramOpenSdkChannel, RtcCsCmdCallback paramRtcCsCmdCallback, int paramInt) {}
  
  public void a(int paramInt)
  {
    OpenSdkChannel.a(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerOpenSdkChannel).a().e("ChannelAdapter", "AVSdkCoreAppChannel-requestAppCmd fail 2 errCode:" + paramInt + ";roomId=" + this.jdField_a_of_type_Int, new Object[0]);
    this.jdField_a_of_type_ComTencentIliveOpensdkCallbacksRtcCsCmdCallback.onError(paramInt, "");
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentIliveOpensdkCallbacksRtcCsCmdCallback.onSuccess(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.OpenSdkChannel.2
 * JD-Core Version:    0.7.0.1
 */