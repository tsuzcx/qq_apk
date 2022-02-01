package com.tencent.luggage.wxa.qq;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.luggage.wxa.qj.i;
import com.tencent.luggage.wxa.ql.d;
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
          if (i.f().a().B())
          {
            i.f().a().a();
            i.f().e();
            i.f().a(600000);
          }
          if (a.a(this.a) != null) {
            a.a(this.a).abandonAudioFocus(a.b(this.a));
          }
        }
      }
      else
      {
        o.d("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
        if (i.f().a().B()) {
          i.f().a().s();
        }
      }
    }
    else
    {
      o.d("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
      if (i.f().a().B()) {
        i.f().a().a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qq.a.1
 * JD-Core Version:    0.7.0.1
 */