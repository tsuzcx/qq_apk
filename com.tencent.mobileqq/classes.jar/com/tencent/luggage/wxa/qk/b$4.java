package com.tencent.luggage.wxa.qk;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.luggage.wxa.qz.o;

class b$4
  implements MediaPlayer.OnErrorListener
{
  b$4(b paramb) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    o.b("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    b.c(this.a, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.b.4
 * JD-Core Version:    0.7.0.1
 */