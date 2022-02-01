package com.tencent.ilivesdk.audiomediaservice.player;

import android.content.Context;
import com.tencent.ilive.opensdk.apiinterfaces.IOpenSdk;
import com.tencent.ilivesdk.audiomediaservice.interfaces.AudioEnterRoomParam;
import com.tencent.ilivesdk.audiomediaservice.interfaces.ClassLoaderCallback;

class AudioRecordPlayer$2
  implements ClassLoaderCallback<IOpenSdk>
{
  AudioRecordPlayer$2(AudioRecordPlayer paramAudioRecordPlayer, AudioEnterRoomParam paramAudioEnterRoomParam) {}
  
  public void a(IOpenSdk paramIOpenSdk, Context paramContext)
  {
    if (paramIOpenSdk != null)
    {
      if (AudioRecordPlayer.e(this.b) != null) {
        return;
      }
      AudioRecordPlayer.a(this.b, paramIOpenSdk);
      paramIOpenSdk.attachContext(paramContext);
      AudioRecordPlayer.a(this.b, paramIOpenSdk, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.AudioRecordPlayer.2
 * JD-Core Version:    0.7.0.1
 */