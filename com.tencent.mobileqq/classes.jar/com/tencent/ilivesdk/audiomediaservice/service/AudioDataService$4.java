package com.tencent.ilivesdk.audiomediaservice.service;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.GetIMSigRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

final class AudioDataService$4
  implements ChannelCallback
{
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    LogInterface localLogInterface = this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get userSig onError:isTimeout");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(";code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(";msg=");
    localStringBuilder.append(paramString);
    localLogInterface.i("AudioDataService", localStringBuilder.toString(), new Object[0]);
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestSigCallback.a(paramInt);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a().i("AudioDataService", "get userSig onRecv, get sig cost ", new Object[0]);
    try
    {
      ILiveChanneSvr.GetIMSigRsp localGetIMSigRsp = new ILiveChanneSvr.GetIMSigRsp();
      localGetIMSigRsp.mergeFrom(paramArrayOfByte);
      int i = localGetIMSigRsp.err.get();
      paramArrayOfByte = this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get userSig success, get sig cost errCode=");
      localStringBuilder.append(i);
      paramArrayOfByte.i("AudioDataService", localStringBuilder.toString(), new Object[0]);
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestSigCallback.a(localGetIMSigRsp.sig.get().toByteArray());
        return;
      }
      this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestSigCallback.a(i);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label130:
      break label130;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestSigCallback.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.service.AudioDataService.4
 * JD-Core Version:    0.7.0.1
 */