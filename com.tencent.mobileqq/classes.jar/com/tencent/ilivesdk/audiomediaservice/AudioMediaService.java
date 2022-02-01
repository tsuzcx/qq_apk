package com.tencent.ilivesdk.audiomediaservice;

import android.content.Context;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.audiomediaservice.interfaces.AudioEnterRoomParam;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaService;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceAdapter;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceListener;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioRecordPlayer;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioVolumeListener;
import com.tencent.ilivesdk.audiomediaservice.player.AudioRecordPlayer;

public class AudioMediaService
  implements IAudioMediaService
{
  private Context a;
  private LogInterface b;
  private IAudioRecordPlayer c;
  private IAudioMediaServiceAdapter d;
  
  public void a()
  {
    this.c.a();
  }
  
  public void a(AudioEnterRoomParam paramAudioEnterRoomParam, IAudioMediaServiceListener paramIAudioMediaServiceListener)
  {
    this.c.a(paramAudioEnterRoomParam, paramIAudioMediaServiceListener);
  }
  
  public void a(IAudioMediaServiceAdapter paramIAudioMediaServiceAdapter)
  {
    this.d = paramIAudioMediaServiceAdapter;
    this.b = this.d.c();
    this.c = new AudioRecordPlayer(this.a, this.d);
  }
  
  public void a(IAudioVolumeListener paramIAudioVolumeListener)
  {
    this.c.a(paramIAudioVolumeListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }
  
  public void clearEventOutput() {}
  
  public void onCreate(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void onDestroy()
  {
    this.b.i("AudioMediaService", "onDestroy", new Object[0]);
    this.a = null;
    IAudioRecordPlayer localIAudioRecordPlayer = this.c;
    if (localIAudioRecordPlayer != null) {
      localIAudioRecordPlayer.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.AudioMediaService
 * JD-Core Version:    0.7.0.1
 */