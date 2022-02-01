package com.tencent.mobileqq.apollo.game.process.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.apollo.game.process.chanel.CmGameNativeMethodHandler;
import org.json.JSONObject;

class CmGameAudioPlayer$5
  implements MediaPlayer.OnCompletionListener
{
  CmGameAudioPlayer$5(CmGameAudioPlayer paramCmGameAudioPlayer, CmGameNativeMethodHandler paramCmGameNativeMethodHandler, JSONObject paramJSONObject) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.a.a(this.b);
    this.c.a(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.CmGameAudioPlayer.5
 * JD-Core Version:    0.7.0.1
 */