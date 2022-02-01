package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.ilive.opensdk.callbacks.RtcCoreMessageChannel;
import com.tencent.ilive.opensdk.callbacks.RtcCsCmdCallback;
import com.tencent.ilive.opensdk.params.RtcStartParam;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.audiomediaservice.service.AudioDataService;

public class OpenSdkChannel
  extends RtcCoreMessageChannel
{
  private long jdField_a_of_type_Long = 0L;
  private final IAudioMediaServiceAdapter jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter;
  
  public OpenSdkChannel(IAudioMediaServiceAdapter paramIAudioMediaServiceAdapter, long paramLong)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter = paramIAudioMediaServiceAdapter;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public long getTinyId()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public boolean loginWithParam(RtcStartParam paramRtcStartParam)
  {
    return false;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, int paramInt, RtcCsCmdCallback paramRtcCsCmdCallback)
  {
    AudioDataService.b(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter, getTinyId(), "openim.pbvideoapp", paramArrayOfByte, new OpenSdkChannel.2(this, paramRtcCsCmdCallback, paramInt));
    return true;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback)
  {
    AudioDataService.b(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter, getTinyId(), "openim.pbvideoapp", paramArrayOfByte, new OpenSdkChannel.1(this, paramRtcCsCmdCallback));
    return true;
  }
  
  public boolean requestCmd(String paramString, byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback)
  {
    AudioDataService.a(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter, getTinyId(), paramString, paramArrayOfByte, new OpenSdkChannel.5(this, paramRtcCsCmdCallback));
    return true;
  }
  
  public boolean requestInfoCmd(byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback)
  {
    AudioDataService.b(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter, this.jdField_a_of_type_Long, "openim.pbvideoinfo", paramArrayOfByte, new OpenSdkChannel.3(this, paramRtcCsCmdCallback));
    return true;
  }
  
  public boolean requestReportCmd(int paramInt, byte[] paramArrayOfByte, RtcCsCmdCallback paramRtcCsCmdCallback)
  {
    AudioDataService.a(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter, getTinyId(), "AVQualityReportSvc.C2S", paramArrayOfByte, new OpenSdkChannel.4(this, paramRtcCsCmdCallback));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.OpenSdkChannel
 * JD-Core Version:    0.7.0.1
 */