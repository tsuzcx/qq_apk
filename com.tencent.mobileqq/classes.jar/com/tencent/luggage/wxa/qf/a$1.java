package com.tencent.luggage.wxa.qf;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.luggage.wxa.qz.o;

class a$1
  implements AudioManager.OnAudioFocusChangeListener
{
  a$1(a parama) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    o.d("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != -2) && (paramInt != -3))
    {
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
      {
        if (paramInt == -1)
        {
          o.d("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
          if (a.a(this.a) != null) {
            a.a(this.a).abandonAudioFocus(a.b(this.a));
          }
          a.a(this.a, false);
        }
      }
      else {
        o.d("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
      }
    }
    else {
      o.d("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qf.a.1
 * JD-Core Version:    0.7.0.1
 */