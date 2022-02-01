package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler;
import org.json.JSONObject;

class CmGameAudioPlayer$2
  implements MediaPlayer.OnSeekCompleteListener
{
  CmGameAudioPlayer$2(CmGameAudioPlayer paramCmGameAudioPlayer, JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = this.a;
    if (paramMediaPlayer != null) {
      CmGameAudioPlayer.a(this.c, this.b, paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameAudioPlayer.2
 * JD-Core Version:    0.7.0.1
 */