package com.tencent.luggage.wxa.qk;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.luggage.wxa.qz.o;

class b$1
  implements MediaPlayer.OnCompletionListener
{
  b$1(b paramb) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    o.b("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
    b.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qk.b.1
 * JD-Core Version:    0.7.0.1
 */