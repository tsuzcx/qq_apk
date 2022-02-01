package com.tencent.luggage.wxa.qz;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

final class z$3
  implements MediaPlayer.OnPreparedListener
{
  z$3(String paramString, MediaPlayer paramMediaPlayer, int paramInt) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    int i;
    if (paramMediaPlayer == null) {
      i = -1;
    } else {
      i = paramMediaPlayer.hashCode();
    }
    o.d("MicroMsg.PlaySound", "play onPrepared mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.a });
    try
    {
      if (this.b != null)
      {
        this.b.start();
        return;
      }
    }
    catch (Exception paramMediaPlayer)
    {
      o.a("MicroMsg.PlaySound", paramMediaPlayer, "play failed pathId:%d", new Object[] { Integer.valueOf(this.c) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.z.3
 * JD-Core Version:    0.7.0.1
 */