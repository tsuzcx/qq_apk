package com.tencent.luggage.wxa.mu;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;

final class c
{
  private AudioManager a = (AudioManager)r.a().getSystemService("audio");
  private a b;
  private AudioManager.OnAudioFocusChangeListener c = new c.1(this);
  
  public c(a parama)
  {
    this.b = parama;
  }
  
  public boolean a()
  {
    AudioManager localAudioManager = this.a;
    boolean bool2 = false;
    if (localAudioManager == null) {
      return false;
    }
    int i = localAudioManager.requestAudioFocus(this.c, 3, 2);
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    o.d("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool1) });
    boolean bool1 = bool2;
    if (i == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    o.d("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "abandonFocus");
    AudioManager localAudioManager = this.a;
    if (localAudioManager == null) {
      return;
    }
    localAudioManager.abandonAudioFocus(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mu.c
 * JD-Core Version:    0.7.0.1
 */