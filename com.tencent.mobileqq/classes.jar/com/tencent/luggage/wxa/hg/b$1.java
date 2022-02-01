package com.tencent.luggage.wxa.hg;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.luggage.wxa.qz.o;

class b$1
  implements AudioManager.OnAudioFocusChangeListener
{
  b$1(b paramb) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (b.a(this.a) != null)
    {
      o.e("MicroMsg.AudioFocusHelper", "jacks change: %d", new Object[] { Integer.valueOf(paramInt) });
      b.a(this.a).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hg.b.1
 * JD-Core Version:    0.7.0.1
 */