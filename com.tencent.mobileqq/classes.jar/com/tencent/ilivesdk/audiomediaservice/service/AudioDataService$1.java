package com.tencent.ilivesdk.audiomediaservice.service;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.UserId2TinyIdRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

final class AudioDataService$1
  implements ChannelCallback
{
  AudioDataService$1(IAudioMediaServiceAdapter paramIAudioMediaServiceAdapter, RequestTinyId2UserIdCallback paramRequestTinyId2UserIdCallback) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a().i("AudioDataService", "requestUserId2TinyId onError:isTimeout" + paramBoolean + ";code=" + paramInt + ";msg=" + paramString, new Object[0]);
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestTinyId2UserIdCallback.a(paramInt);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    try
    {
      ILiveChannel.UserId2TinyIdRsp localUserId2TinyIdRsp = new ILiveChannel.UserId2TinyIdRsp();
      localUserId2TinyIdRsp.mergeFrom(paramArrayOfByte);
      int i = localUserId2TinyIdRsp.result.get();
      this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a().i("AudioDataService", "requestUserId2TinyId success,  errCode=" + i, new Object[0]);
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestTinyId2UserIdCallback.a(localUserId2TinyIdRsp.userid.get(), localUserId2TinyIdRsp.tinyid.get());
        return;
      }
      this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestTinyId2UserIdCallback.a(i);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a().i("AudioDataService", "requestUserId2TinyId excepton ", new Object[] { paramArrayOfByte });
      this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestTinyId2UserIdCallback.a(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.service.AudioDataService.1
 * JD-Core Version:    0.7.0.1
 */