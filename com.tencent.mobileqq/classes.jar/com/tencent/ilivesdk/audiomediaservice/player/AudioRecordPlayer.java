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
  private Context a;
  private LogInterface b;
  private IAudioMediaServiceAdapter c;
  private IOpenSdk d;
  private boolean e;
  private boolean f;
  private boolean g;
  private IAudioMediaServiceListener h;
  private AudioEnterRoomParam i;
  private OpenSdkChannel j;
  private List<IAudioVolumeListener> k = new ArrayList();
  private RtcCoreEventCallback l = new AudioRecordPlayer.5(this);
  private VoiceWaveScheduled m = new VoiceWaveScheduled(new AudioRecordPlayer.6(this), true);
  
  public AudioRecordPlayer(Context paramContext, IAudioMediaServiceAdapter paramIAudioMediaServiceAdapter)
  {
    this.a = paramContext;
    this.c = paramIAudioMediaServiceAdapter;
    this.b = paramIAudioMediaServiceAdapter.c();
  }
  
  private void a(IOpenSdk paramIOpenSdk, AudioEnterRoomParam paramAudioEnterRoomParam)
  {
    try
    {
      this.b.i("AudioRecordPlayer", "initOpenSdk: the openSdk init start.", new Object[0]);
      paramIOpenSdk.setSelfUin(this.c.b().getLoginInfo().uid);
      paramIOpenSdk.setTinyId(this.c.b().getLoginInfo().tinyid);
      RtcInitParam localRtcInitParam = new RtcInitParam();
      localRtcInitParam.sdkAppID = paramAudioEnterRoomParam.a;
      localRtcInitParam.sdkAccountType = paramAudioEnterRoomParam.b;
      localRtcInitParam.selfUin = this.c.b().getLoginInfo().uid;
      paramIOpenSdk.setMessageChannel(this.j);
      paramIOpenSdk.setReporter(new SimpleHttpInterfaceTransfer(this.c.e()));
      paramIOpenSdk.setLoger(new SimpleLogTransfer(this.c.c()));
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
    this.c.a(IOpenSdk.class, "com.tencent.ilive.opensdk.plugin.OpenSdkImpl", new AudioRecordPlayer.2(this, paramAudioEnterRoomParam));
  }
  
  private void b()
  {
    IOpenSdk localIOpenSdk = this.d;
    if (localIOpenSdk == null)
    {
      this.b.i("AudioRecordPlayer", "changeRolesToLinkMicAudio.", new Object[0]);
      return;
    }
    localIOpenSdk.changeRole(3, new AudioRecordPlayer.4(this));
  }
  
  private void b(AudioEnterRoomParam paramAudioEnterRoomParam)
  {
    this.b.i("AudioRecordPlayer", "openAudioStream: start open audio stream.", new Object[0]);
    int n = paramAudioEnterRoomParam.h;
    String str = "audience";
    if ((n != 0) && (paramAudioEnterRoomParam.h == 3)) {
      str = "voicelianmai";
    }
    OpenSdkParams localOpenSdkParams = new OpenSdkParams.OpenSdkParamsBuilder().setSelfUid(paramAudioEnterRoomParam.d).setAuthEncryptionType(1).setUid(paramAudioEnterRoomParam.c).setRoomId(paramAudioEnterRoomParam.f).setRoomSig(paramAudioEnterRoomParam.g).setSwitchRoom(Boolean.valueOf(false)).setRoles(str).build();
    RtcRoomEnterParams localRtcRoomEnterParams = new RtcRoomEnterParams((int)paramAudioEnterRoomParam.f, paramAudioEnterRoomParam.e);
    localRtcRoomEnterParams.setOpenSdkParams(localOpenSdkParams);
    localRtcRoomEnterParams.controlRole = str;
    localRtcRoomEnterParams.setAVCoreEventCallback(this.l);
    this.d.initAnchor(1, paramAudioEnterRoomParam.h, paramAudioEnterRoomParam.g, null);
    this.d.start();
    this.d.enterRoom(localRtcRoomEnterParams);
  }
  
  public long a(long paramLong)
  {
    IOpenSdk localIOpenSdk = this.d;
    if (localIOpenSdk != null) {
      return localIOpenSdk.getDynamicVolume(paramLong);
    }
    return 0L;
  }
  
  public void a()
  {
    if (this.g)
    {
      this.b.i("AudioRecordPlayer", "release: the audioRecordPlayer had released.", new Object[0]);
      return;
    }
    this.b.i("AudioRecordPlayer", "release: the audioRecordPlayer release.", new Object[0]);
    this.g = true;
    this.m.b();
    IOpenSdk localIOpenSdk = this.d;
    if (localIOpenSdk != null)
    {
      localIOpenSdk.enableMic(false);
      this.d.stop();
      this.d.exitRoom();
      this.d.release();
    }
    this.d = null;
    this.h = null;
    this.i = null;
  }
  
  public void a(AudioEnterRoomParam paramAudioEnterRoomParam, IAudioMediaServiceListener paramIAudioMediaServiceListener)
  {
    this.b.i("AudioRecordPlayer", "start", new Object[0]);
    this.h = paramIAudioMediaServiceListener;
    this.i = paramAudioEnterRoomParam;
    paramIAudioMediaServiceListener = new ArrayList();
    paramIAudioMediaServiceListener.add(Long.valueOf(paramAudioEnterRoomParam.d));
    AudioDataService.a(this.c, paramIAudioMediaServiceListener, new AudioRecordPlayer.1(this));
  }
  
  public void a(IAudioVolumeListener paramIAudioVolumeListener)
  {
    if (!this.k.contains(paramIAudioVolumeListener)) {
      this.k.add(paramIAudioVolumeListener);
    }
    this.m.a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.b.i("AudioRecordPlayer", "enableMic: enable mic %s.", new Object[] { String.valueOf(paramBoolean) });
    if ((this.d != null) && (this.e))
    {
      if (this.i.h != 3)
      {
        this.b.i("AudioRecordPlayer", "enableMic: change roles to link mic audio.", new Object[0]);
        b();
        return;
      }
      this.d.enableMic(paramBoolean);
      return;
    }
    this.b.i("AudioRecordPlayer", "enableMic: the openSdk is not started.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.AudioRecordPlayer
 * JD-Core Version:    0.7.0.1
 */