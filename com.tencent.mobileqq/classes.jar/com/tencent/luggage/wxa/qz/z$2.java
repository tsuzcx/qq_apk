package com.tencent.luggage.wxa.qz;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class z$2
  implements MediaPlayer.OnCompletionListener
{
  z$2(String paramString, MediaPlayer paramMediaPlayer, z.a parama) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    int i;
    if (paramMediaPlayer == null) {
      i = -1;
    } else {
      i = paramMediaPlayer.hashCode();
    }
    o.d("MicroMsg.PlaySound", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.a });
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    paramMediaPlayer = this.b;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    paramMediaPlayer = this.c;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.z.2
 * JD-Core Version:    0.7.0.1
 */