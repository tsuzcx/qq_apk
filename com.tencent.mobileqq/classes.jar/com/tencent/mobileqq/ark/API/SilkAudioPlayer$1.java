package com.tencent.mobileqq.ark.API;

import android.media.AudioManager.OnAudioFocusChangeListener;

class SilkAudioPlayer$1
  implements AudioManager.OnAudioFocusChangeListener
{
  SilkAudioPlayer$1(SilkAudioPlayer paramSilkAudioPlayer) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((SilkAudioPlayer.a(this.a) != null) && (paramInt == -1)) {
      SilkAudioPlayer.a(this.a).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.SilkAudioPlayer.1
 * JD-Core Version:    0.7.0.1
 */