package com.tencent.ilivesdk.audiomediaservice.service;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.RelayCmdRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;

final class AudioDataService$2
  implements ChannelCallback
{
  AudioDataService$2(IAudioMediaServiceAdapter paramIAudioMediaServiceAdapter, String paramString, RequestMediaChannelCallback paramRequestMediaChannelCallback) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    LogInterface localLogInterface = this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestMediaChannel onError:isTimeout");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(";code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(";msg=");
    localStringBuilder.append(paramString);
    localLogInterface.i("AudioDataService", localStringBuilder.toString(), new Object[0]);
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestMediaChannelCallback.a(paramInt);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    try
    {
      ILiveChannel.RelayCmdRsp localRelayCmdRsp = new ILiveChannel.RelayCmdRsp();
      localRelayCmdRsp.mergeFrom(paramArrayOfByte);
      int i = localRelayCmdRsp.result.get();
      paramArrayOfByte = this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestMediaChannel , cmd=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" errCode=");
      localStringBuilder.append(i);
      paramArrayOfByte.i("AudioDataService", localStringBuilder.toString(), new Object[0]);
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestMediaChannelCallback.a(i, localRelayCmdRsp.response.get().toByteArray());
        return;
      }
      this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestMediaChannelCallback.a(i);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label127:
      break label127;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestMediaChannelCallback.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.service.AudioDataService.2
 * JD-Core Version:    0.7.0.1
 */