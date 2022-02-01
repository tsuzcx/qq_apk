package com.tencent.ilivesdk.audiomediaservice.service;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.AppCmdReqBody;
import com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.AuthMsgInfo;
import com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.RelayCmdReq;
import com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.SdkData;
import com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.UserId2TinyIdReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;

public class AudioDataService
{
  public static void a(IAudioMediaServiceAdapter paramIAudioMediaServiceAdapter, long paramLong, String paramString, byte[] paramArrayOfByte, RequestMediaChannelCallback paramRequestMediaChannelCallback)
  {
    paramIAudioMediaServiceAdapter.a().i("AudioDataService", "request cmd: " + paramString + " appid:" + paramIAudioMediaServiceAdapter.a().getOpenSdkAppid(), new Object[0]);
    ILiveChannel.AuthMsgInfo localAuthMsgInfo = new ILiveChannel.AuthMsgInfo();
    localAuthMsgInfo.auth_key.set(ByteStringMicro.copyFrom(paramIAudioMediaServiceAdapter.a().getLoginInfo().a2));
    localAuthMsgInfo.auth_tinyid.set(paramIAudioMediaServiceAdapter.a().getLoginInfo().tinyid);
    localAuthMsgInfo.auth_type.set(35);
    ILiveChannel.RelayCmdReq localRelayCmdReq = new ILiveChannel.RelayCmdReq();
    localRelayCmdReq.tinyid.set(paramLong);
    localRelayCmdReq.cmd_name.set(paramString);
    localRelayCmdReq.request.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localRelayCmdReq.auth_info.set(localAuthMsgInfo);
    try
    {
      localRelayCmdReq.sdkappid.set(paramIAudioMediaServiceAdapter.a().getOpenSdkAppid());
      paramArrayOfByte = localRelayCmdReq.toByteArray();
      paramIAudioMediaServiceAdapter.a().send(29464, 1, paramArrayOfByte, new AudioDataService.2(paramIAudioMediaServiceAdapter, paramString, paramRequestMediaChannelCallback));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramIAudioMediaServiceAdapter.a().e("AudioDataService", "ERROR APPID", new Object[0]);
      }
    }
  }
  
  public static void a(IAudioMediaServiceAdapter paramIAudioMediaServiceAdapter, ArrayList<Long> paramArrayList, RequestTinyId2UserIdCallback paramRequestTinyId2UserIdCallback)
  {
    ILiveChannel.UserId2TinyIdReq localUserId2TinyIdReq = new ILiveChannel.UserId2TinyIdReq();
    localUserId2TinyIdReq.target_uid.set(paramArrayList);
    try
    {
      localUserId2TinyIdReq.sdkappid.set(paramIAudioMediaServiceAdapter.a().getOpenSdkAppid());
      paramArrayList = new ILiveChannel.AuthMsgInfo();
      paramArrayList.auth_key.set(ByteStringMicro.copyFrom(paramIAudioMediaServiceAdapter.a().getLoginInfo().a2));
      paramArrayList.auth_tinyid.set(paramIAudioMediaServiceAdapter.a().getLoginInfo().tinyid);
      paramArrayList.auth_type.set(35);
      localUserId2TinyIdReq.auth_info.set(paramArrayList);
      paramArrayList = localUserId2TinyIdReq.toByteArray();
      paramIAudioMediaServiceAdapter.a().send(29464, 5, paramArrayList, new AudioDataService.1(paramIAudioMediaServiceAdapter, paramRequestTinyId2UserIdCallback));
      return;
    }
    catch (Exception paramArrayList)
    {
      for (;;)
      {
        paramIAudioMediaServiceAdapter.a().e("AudioDataService", "ERROR APPID", new Object[0]);
      }
    }
  }
  
  public static void b(IAudioMediaServiceAdapter paramIAudioMediaServiceAdapter, long paramLong, String paramString, byte[] paramArrayOfByte, RequestMediaChannelCallback paramRequestMediaChannelCallback)
  {
    Object localObject = new ILiveChannel.AppCmdReqBody();
    ((ILiveChannel.AppCmdReqBody)localObject).reqbody.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    ((ILiveChannel.AppCmdReqBody)localObject).msg_sdk_data = new ILiveChannel.SdkData();
    ((ILiveChannel.AppCmdReqBody)localObject).msg_sdk_data.sdk_app_id.set(paramIAudioMediaServiceAdapter.a().getOpenSdkAppid());
    ((ILiveChannel.AppCmdReqBody)localObject).msg_sdk_data.sdk_app_token.set(ByteStringMicro.copyFrom(paramIAudioMediaServiceAdapter.a().getLoginInfo().a2));
    localObject = ((ILiveChannel.AppCmdReqBody)localObject).toByteArray();
    paramArrayOfByte = new ILiveChannel.RelayCmdReq();
    paramArrayOfByte.tinyid.set(paramLong);
    paramArrayOfByte.cmd_name.set(paramString);
    paramArrayOfByte.request.set(ByteStringMicro.copyFrom((byte[])localObject));
    try
    {
      paramArrayOfByte.sdkappid.set(paramIAudioMediaServiceAdapter.a().getOpenSdkAppid());
      localObject = new ILiveChannel.AuthMsgInfo();
      ((ILiveChannel.AuthMsgInfo)localObject).auth_key.set(ByteStringMicro.copyFrom(paramIAudioMediaServiceAdapter.a().getLoginInfo().a2));
      ((ILiveChannel.AuthMsgInfo)localObject).auth_tinyid.set(paramIAudioMediaServiceAdapter.a().getLoginInfo().tinyid);
      ((ILiveChannel.AuthMsgInfo)localObject).auth_type.set(35);
      paramArrayOfByte.auth_info.set((MessageMicro)localObject);
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      paramIAudioMediaServiceAdapter.a().send(29464, 1, paramArrayOfByte, new AudioDataService.3(paramIAudioMediaServiceAdapter, paramString, paramRequestMediaChannelCallback));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramIAudioMediaServiceAdapter.a().e("AudioDataService", "ERROR APPID", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.service.AudioDataService
 * JD-Core Version:    0.7.0.1
 */