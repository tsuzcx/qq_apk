package com.tencent.luggage.wxa.mu;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.luggage.wxa.qz.o;

class c$1
  implements AudioManager.OnAudioFocusChangeListener
{
  c$1(c paramc) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    o.d("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != -2) && (paramInt != -3))
    {
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
      {
        if (paramInt == -1)
        {
          o.d("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus loss, passive pause");
          c.a(this.a).e();
          if (c.b(this.a) != null) {
            c.b(this.a).abandonAudioFocus(c.c(this.a));
          }
        }
      }
      else
      {
        o.d("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus gain");
        c.a(this.a).c();
      }
    }
    else
    {
      o.d("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus lossTransient");
      c.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mu.c.1
 * JD-Core Version:    0.7.0.1
 */