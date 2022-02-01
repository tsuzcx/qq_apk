package com.tencent.ilivesdk.audiomediaservice.service;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.AppCmdRspBody;
import com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.CmdErrorCode;
import com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.RelayCmdRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

final class AudioDataService$3
  implements ChannelCallback
{
  AudioDataService$3(IAudioMediaServiceAdapter paramIAudioMediaServiceAdapter, String paramString, RequestMediaChannelCallback paramRequestMediaChannelCallback) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a().i("AudioDataService", "requestCmd onError:isTimeout" + paramBoolean + ";code=" + paramInt + ";msg=" + paramString, new Object[0]);
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestMediaChannelCallback.a(paramInt);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    try
    {
      ILiveChannel.RelayCmdRsp localRelayCmdRsp = new ILiveChannel.RelayCmdRsp();
      localRelayCmdRsp.mergeFrom(paramArrayOfByte);
      int i = localRelayCmdRsp.result.get();
      this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a().i("AudioDataService", "requestCmd , cmd=" + this.jdField_a_of_type_JavaLangString + " errCode=" + i, new Object[0]);
      paramArrayOfByte = new ILiveChannel.AppCmdRspBody();
      paramArrayOfByte.mergeFrom(localRelayCmdRsp.response.get().toByteArray());
      this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a().i("AudioDataService", "requestCmd , cmd=" + this.jdField_a_of_type_JavaLangString + " internal errCode=" + paramArrayOfByte.msg_cmd_error_code.code.get() + " msg:" + paramArrayOfByte.msg_cmd_error_code.err_msg.get(), new Object[0]);
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestMediaChannelCallback.a(i, paramArrayOfByte.rspbody.get().toByteArray());
        return;
      }
      this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestMediaChannelCallback.a(i);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestMediaChannelCallback.a(-1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.service.AudioDataService.3
 * JD-Core Version:    0.7.0.1
 */