package com.tencent.luggage.wxa.qk;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.luggage.wxa.qz.o;

class b$2
  implements MediaPlayer.OnSeekCompleteListener
{
  b$2(b paramb) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if ((b.a(this.a) != null) && (b.a(this.a).isPlaying()))
    {
      o.d("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
      try
      {
        b.a(this.a).start();
        return;
      }
      catch (Exception paramMediaPlayer)
      {
        o.a("MicroMsg.Music.MMMediaPlayer", paramMediaPlayer, "start", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.b.2
 * JD-Core Version:    0.7.0.1
 */