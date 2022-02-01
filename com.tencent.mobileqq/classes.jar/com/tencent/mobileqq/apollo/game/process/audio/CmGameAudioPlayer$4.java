package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler;
import org.json.JSONObject;

class CmGameAudioPlayer$4
  implements MediaPlayer.OnPreparedListener
{
  CmGameAudioPlayer$4(CmGameAudioPlayer paramCmGameAudioPlayer, JSONObject paramJSONObject, CmGameNativeMethodHandler paramCmGameNativeMethodHandler) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.c.a(3);
    if (CmGameAudioPlayer.a(this.c)) {
      this.c.b(this.a, this.b);
    }
    paramMediaPlayer = this.a;
    if (paramMediaPlayer != null) {
      CmGameAudioPlayer.a(this.c, this.b, paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameAudioPlayer.4
 * JD-Core Version:    0.7.0.1
 */