package com.tencent.avgame.qav.audio;

import android.os.Build.VERSION;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.qav.audio.player.AVSoundHelper;

class AvGameSysMusicPlayer$1
  extends AVGameUIEventCallback
{
  AvGameSysMusicPlayer$1(AvGameSysMusicPlayer paramAvGameSysMusicPlayer) {}
  
  public void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (paramBoolean)
      {
        AVSoundHelper.g();
        AVSoundHelper.c();
        return;
      }
      AVSoundHelper.h();
      AVSoundHelper.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.AvGameSysMusicPlayer.1
 * JD-Core Version:    0.7.0.1
 */