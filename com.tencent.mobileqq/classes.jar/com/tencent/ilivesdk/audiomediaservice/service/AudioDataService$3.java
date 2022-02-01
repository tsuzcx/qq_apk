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
    LogInterface localLogInterface = this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestCmd onError:isTimeout");
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
      Object localObject = new ILiveChannel.RelayCmdRsp();
      ((ILiveChannel.RelayCmdRsp)localObject).mergeFrom(paramArrayOfByte);
      int i = ((ILiveChannel.RelayCmdRsp)localObject).result.get();
      paramArrayOfByte = this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestCmd , cmd=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" errCode=");
      localStringBuilder.append(i);
      paramArrayOfByte.i("AudioDataService", localStringBuilder.toString(), new Object[0]);
      paramArrayOfByte = new ILiveChannel.AppCmdRspBody();
      paramArrayOfByte.mergeFrom(((ILiveChannel.RelayCmdRsp)localObject).response.get().toByteArray());
      localObject = this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestCmd , cmd=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" internal errCode=");
      localStringBuilder.append(paramArrayOfByte.msg_cmd_error_code.code.get());
      localStringBuilder.append(" msg:");
      localStringBuilder.append(paramArrayOfByte.msg_cmd_error_code.err_msg.get());
      ((LogInterface)localObject).i("AudioDataService", localStringBuilder.toString(), new Object[0]);
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
      label252:
      break label252;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceServiceRequestMediaChannelCallback.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.service.AudioDataService.3
 * JD-Core Version:    0.7.0.1
 */