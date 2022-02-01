package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.opensdk.callbacks.RtcCoreEventObserver;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceListener;
import java.util.Map;

class AudioRecordPlayer$4
  extends RtcCoreEventObserver
{
  AudioRecordPlayer$4(AudioRecordPlayer paramAudioRecordPlayer) {}
  
  public void onEventProcess(int paramInt, Map<String, Object> paramMap)
  {
    LogInterface localLogInterface = AudioRecordPlayer.a(this.a);
    if (paramMap == null) {
      paramMap = "";
    } else {
      paramMap = paramMap.toString();
    }
    localLogInterface.d("AudioRecordPlayer", "onEventProcess: eventType[%d] dictionary[%s]", new Object[] { Integer.valueOf(paramInt), paramMap });
    if (paramInt != 0)
    {
      AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "onEventProcess: change roles fail.", new Object[0]);
      if (AudioRecordPlayer.d(this.a) != null) {
        AudioRecordPlayer.d(this.a).a(paramInt, "chang roles to link mic audio fail.");
      }
      return;
    }
    AudioRecordPlayer.c(this.a).h = 3;
    if (AudioRecordPlayer.f(this.a)) {
      this.a.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.AudioRecordPlayer.4
 * JD-Core Version:    0.7.0.1
 */