package com.tencent.luggage.wxa.qk;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.luggage.wxa.qz.o;

class b$3
  implements MediaPlayer.OnPreparedListener
{
  b$3(b paramb) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (b.a(this.a) != null)
    {
      o.d("MicroMsg.Music.MMMediaPlayer", "onPrepared");
      try
      {
        b.a(this.a).start();
      }
      catch (Exception paramMediaPlayer)
      {
        o.a("MicroMsg.Music.MMMediaPlayer", paramMediaPlayer, "start", new Object[0]);
      }
      b.b(this.a, false);
      b.b(this.a);
      if (b.c(this.a) != null) {
        b.c(this.a).b();
      }
      paramMediaPlayer = this.a;
      b.a(paramMediaPlayer, new b.a(paramMediaPlayer, null));
      b.c(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.b.3
 * JD-Core Version:    0.7.0.1
 */