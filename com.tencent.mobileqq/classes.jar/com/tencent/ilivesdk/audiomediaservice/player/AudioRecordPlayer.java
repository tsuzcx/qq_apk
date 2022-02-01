package com.tencent.ilivesdk.audiomediaservice.player;

import android.content.Context;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilive.opensdk.apiinterfaces.IOpenSdk;
import com.tencent.ilive.opensdk.callbacks.RtcCoreEventCallback;
import com.tencent.ilive.opensdk.params.OpenSdkParams;
import com.tencent.ilive.opensdk.params.OpenSdkParams.OpenSdkParamsBuilder;
import com.tencent.ilive.opensdk.params.RtcInitParam;
import com.tencent.ilive.opensdk.params.RtcRoomEnterParams;
import com.tencent.ilivesdk.audiomediaservice.interfaces.AudioEnterRoomParam;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceListener;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioRecordPlayer;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioVolumeListener;
import com.tencent.ilivesdk.audiomediaservice.service.AudioDataService;
import java.util.ArrayList;
import java.util.List;

public class AudioRecordPlayer
  implements IAudioRecordPlayer
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LogInterface jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface;
  private IOpenSdk jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk;
  private RtcCoreEventCallback jdField_a_of_type_ComTencentIliveOpensdkCallbacksRtcCoreEventCallback = new AudioRecordPlayer.5(this);
  private AudioEnterRoomParam jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesAudioEnterRoomParam;
  private IAudioMediaServiceAdapter jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter;
  private IAudioMediaServiceListener jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceListener;
  private OpenSdkChannel jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerOpenSdkChannel;
  private VoiceWaveScheduled jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerVoiceWaveScheduled = new VoiceWaveScheduled(new AudioRecordPlayer.6(this), true);
  private List<IAudioVolumeListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public AudioRecordPlayer(Context paramContext, IAudioMediaServiceAdapter paramIAudioMediaServiceAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter = paramIAudioMediaServiceAdapter;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface = paramIAudioMediaServiceAdapter.a();
  }
  
  private void a(IOpenSdk paramIOpenSdk, AudioEnterRoomParam paramAudioEnterRoomParam)
  {
    try
    {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("AudioRecordPlayer", "initOpenSdk: the openSdk init start.", new Object[0]);
      paramIOpenSdk.setSelfUin(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a().getLoginInfo().uid);
      paramIOpenSdk.setTinyId(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a().getLoginInfo().tinyid);
      RtcInitParam localRtcInitParam = new RtcInitParam();
      localRtcInitParam.sdkAppID = paramAudioEnterRoomParam.jdField_a_of_type_Int;
      localRtcInitParam.sdkAccountType = paramAudioEnterRoomParam.jdField_b_of_type_Int;
      localRtcInitParam.selfUin = this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a().getLoginInfo().uid;
      paramIOpenSdk.setMessageChannel(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerOpenSdkChannel);
      paramIOpenSdk.setReporter(new SimpleHttpInterfaceTransfer(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a()));
      paramIOpenSdk.setLoger(new SimpleLogTransfer(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a()));
      paramIOpenSdk.initEngine(localRtcInitParam, new AudioRecordPlayer.3(this, paramAudioEnterRoomParam));
      return;
    }
    finally
    {
      paramIOpenSdk = finally;
      throw paramIOpenSdk;
    }
  }
  
  private void a(AudioEnterRoomParam paramAudioEnterRoomParam)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter.a(IOpenSdk.class, "com.tencent.ilive.opensdk.plugin.OpenSdkImpl", new AudioRecordPlayer.2(this, paramAudioEnterRoomParam));
  }
  
  private void b()
  {
    IOpenSdk localIOpenSdk = this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk;
    if (localIOpenSdk == null)
    {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("AudioRecordPlayer", "changeRolesToLinkMicAudio.", new Object[0]);
      return;
    }
    localIOpenSdk.changeRole(3, new AudioRecordPlayer.4(this));
  }
  
  private void b(AudioEnterRoomParam paramAudioEnterRoomParam)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("AudioRecordPlayer", "openAudioStream: start open audio stream.", new Object[0]);
    int i = paramAudioEnterRoomParam.d;
    String str = "audience";
    if ((i != 0) && (paramAudioEnterRoomParam.d == 3)) {
      str = "voicelianmai";
    }
    OpenSdkParams localOpenSdkParams = new OpenSdkParams.OpenSdkParamsBuilder().setSelfUid(paramAudioEnterRoomParam.jdField_b_of_type_Long).setAuthEncryptionType(1).setUid(paramAudioEnterRoomParam.jdField_a_of_type_Long).setRoomId(paramAudioEnterRoomParam.jdField_c_of_type_Long).setRoomSig(paramAudioEnterRoomParam.jdField_a_of_type_ArrayOfByte).setSwitchRoom(Boolean.valueOf(false)).setRoles(str).build();
    RtcRoomEnterParams localRtcRoomEnterParams = new RtcRoomEnterParams((int)paramAudioEnterRoomParam.jdField_c_of_type_Long, paramAudioEnterRoomParam.jdField_c_of_type_Int);
    localRtcRoomEnterParams.setOpenSdkParams(localOpenSdkParams);
    localRtcRoomEnterParams.controlRole = str;
    localRtcRoomEnterParams.setAVCoreEventCallback(this.jdField_a_of_type_ComTencentIliveOpensdkCallbacksRtcCoreEventCallback);
    this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk.initAnchor(1, paramAudioEnterRoomParam.d, paramAudioEnterRoomParam.jdField_a_of_type_ArrayOfByte, null);
    this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk.start();
    this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk.enterRoom(localRtcRoomEnterParams);
  }
  
  public long a(long paramLong)
  {
    IOpenSdk localIOpenSdk = this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk;
    if (localIOpenSdk != null) {
      return localIOpenSdk.getDynamicVolume(paramLong);
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.c)
    {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("AudioRecordPlayer", "release: the audioRecordPlayer had released.", new Object[0]);
      return;
    }
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("AudioRecordPlayer", "release: the audioRecordPlayer release.", new Object[0]);
    this.c = true;
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerVoiceWaveScheduled.b();
    IOpenSdk localIOpenSdk = this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk;
    if (localIOpenSdk != null)
    {
      localIOpenSdk.enableMic(false);
      this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk.stop();
      this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk.exitRoom();
      this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk.release();
    }
    this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk = null;
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceListener = null;
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesAudioEnterRoomParam = null;
  }
  
  public void a(AudioEnterRoomParam paramAudioEnterRoomParam, IAudioMediaServiceListener paramIAudioMediaServiceListener)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("AudioRecordPlayer", "start", new Object[0]);
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceListener = paramIAudioMediaServiceListener;
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesAudioEnterRoomParam = paramAudioEnterRoomParam;
    paramIAudioMediaServiceListener = new ArrayList();
    paramIAudioMediaServiceListener.add(Long.valueOf(paramAudioEnterRoomParam.jdField_b_of_type_Long));
    AudioDataService.a(this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesIAudioMediaServiceAdapter, paramIAudioMediaServiceListener, new AudioRecordPlayer.1(this));
  }
  
  public void a(IAudioVolumeListener paramIAudioVolumeListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramIAudioVolumeListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramIAudioVolumeListener);
    }
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerVoiceWaveScheduled.a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("AudioRecordPlayer", "enableMic: enable mic %s.", new Object[] { String.valueOf(paramBoolean) });
    if ((this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk != null) && (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentIlivesdkAudiomediaserviceInterfacesAudioEnterRoomParam.d != 3)
      {
        this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("AudioRecordPlayer", "enableMic: change roles to link mic audio.", new Object[0]);
        b();
        return;
      }
      this.jdField_a_of_type_ComTencentIliveOpensdkApiinterfacesIOpenSdk.enableMic(paramBoolean);
      return;
    }
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.i("AudioRecordPlayer", "enableMic: the openSdk is not started.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.AudioRecordPlayer
 * JD-Core Version:    0.7.0.1
 */