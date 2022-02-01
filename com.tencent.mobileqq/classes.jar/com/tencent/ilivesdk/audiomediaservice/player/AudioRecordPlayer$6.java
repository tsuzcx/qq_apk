package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioVolumeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AudioRecordPlayer$6
  implements VoiceWaveScheduled.IVoiceWaveScheduleAdapter
{
  AudioRecordPlayer$6(AudioRecordPlayer paramAudioRecordPlayer) {}
  
  public List<Long> a(List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      localArrayList.add(Long.valueOf(this.a.a(l)));
    }
    AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "getDynamicVolume: uin[%s] volumes[%s]", new Object[] { paramList.toString(), localArrayList.toString() });
    return localArrayList;
  }
  
  public void a(List<String> paramList)
  {
    AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "startSpeakingEvent uin[%s] ", new Object[] { paramList.toString() });
    Iterator localIterator = AudioRecordPlayer.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IAudioVolumeListener)localIterator.next()).a(paramList);
    }
  }
  
  public void b(List<String> paramList)
  {
    AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "stopSpeakingEvent uin[%s] ", new Object[] { paramList.toString() });
    Iterator localIterator = AudioRecordPlayer.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((IAudioVolumeListener)localIterator.next()).b(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.AudioRecordPlayer.6
 * JD-Core Version:    0.7.0.1
 */