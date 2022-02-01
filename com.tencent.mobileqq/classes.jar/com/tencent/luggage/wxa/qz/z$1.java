package com.tencent.luggage.wxa.qz;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

final class z$1
  implements MediaPlayer.OnErrorListener
{
  z$1(MediaPlayer paramMediaPlayer) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.PlaySound", "onError, what: %d, extra: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramMediaPlayer != null) {}
    try
    {
      paramMediaPlayer.release();
      if (this.a != null) {
        this.a.release();
      }
      return false;
    }
    catch (Exception paramMediaPlayer) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.z.1
 * JD-Core Version:    0.7.0.1
 */