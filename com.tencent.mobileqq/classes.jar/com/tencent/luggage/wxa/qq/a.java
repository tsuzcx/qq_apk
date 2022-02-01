package com.tencent.luggage.wxa.qq;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;

public class a
{
  private AudioManager a = (AudioManager)r.a().getSystemService("audio");
  private AudioManager.OnAudioFocusChangeListener b = new a.1(this);
  
  public boolean a()
  {
    AudioManager localAudioManager = this.a;
    boolean bool2 = false;
    if (localAudioManager == null) {
      return false;
    }
    int i = localAudioManager.requestAudioFocus(this.b, 3, 2);
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    o.d("MicroMsg.Music.MusicAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool1) });
    boolean bool1 = bool2;
    if (i == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void b()
  {
    o.d("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
    AudioManager localAudioManager = this.a;
    if (localAudioManager == null) {
      return;
    }
    localAudioManager.abandonAudioFocus(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qq.a
 * JD-Core Version:    0.7.0.1
 */