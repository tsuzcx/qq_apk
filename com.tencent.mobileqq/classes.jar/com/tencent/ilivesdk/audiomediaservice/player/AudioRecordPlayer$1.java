package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.audiomediaservice.interfaces.IAudioMediaServiceListener;
import com.tencent.ilivesdk.audiomediaservice.service.RequestTinyId2UserIdCallback;
import java.util.List;

class AudioRecordPlayer$1
  implements RequestTinyId2UserIdCallback
{
  AudioRecordPlayer$1(AudioRecordPlayer paramAudioRecordPlayer) {}
  
  public void a(int paramInt)
  {
    AudioRecordPlayer.a(this.a).e("AudioRecordPlayer", "requestUserId2TinyId: fail. errCode = %d .", new Object[] { Integer.valueOf(paramInt) });
    if (AudioRecordPlayer.a(this.a) != null) {
      AudioRecordPlayer.a(this.a).a(paramInt, "request userId to tiny id fail.");
    }
  }
  
  public void a(List<Long> paramList1, List<Long> paramList2)
  {
    if ((paramList2 != null) && (paramList2.size() != 0))
    {
      AudioRecordPlayer.a(this.a).i("AudioRecordPlayer", "requestUserId2TinyId: request user tiny success.", new Object[0]);
      paramList1 = this.a;
      AudioRecordPlayer.a(paramList1, new OpenSdkChannel(AudioRecordPlayer.a(paramList1), ((Long)paramList2.get(0)).longValue()));
      paramList1 = this.a;
      AudioRecordPlayer.a(paramList1, AudioRecordPlayer.a(paramList1));
      return;
    }
    AudioRecordPlayer.a(this.a).e("AudioRecordPlayer", "requestUserId2TinyId: tinyId is null.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.AudioRecordPlayer.1
 * JD-Core Version:    0.7.0.1
 */