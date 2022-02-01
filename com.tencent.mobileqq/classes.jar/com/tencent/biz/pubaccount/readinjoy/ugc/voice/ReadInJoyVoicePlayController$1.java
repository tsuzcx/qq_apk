package com.tencent.biz.pubaccount.readinjoy.ugc.voice;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;

class ReadInJoyVoicePlayController$1
  implements MediaPlayer.OnPreparedListener
{
  ReadInJoyVoicePlayController$1(ReadInJoyVoicePlayController paramReadInJoyVoicePlayController) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.start();
      ReadInJoyVoicePlayController.a(this.a).isPlaying = true;
      paramMediaPlayer = (ReadInJoyVoicePlayController.IPlayCallback)ReadInJoyVoicePlayController.a(this.a).get();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.a(ReadInJoyVoicePlayController.a(this.a));
        this.a.a(true, "ugc voice play");
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        paramMediaPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController.1
 * JD-Core Version:    0.7.0.1
 */