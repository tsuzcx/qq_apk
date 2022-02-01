package com.tencent.avgame.gamelogic.gameres;

import android.os.Build.VERSION;
import com.tencent.avgame.audio.player.AVSoundHelper;
import com.tencent.avgame.callback.AVGameUIEventCallback;

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
      }
    }
    else {
      return;
    }
    AVSoundHelper.h();
    AVSoundHelper.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameSysMusicPlayer.1
 * JD-Core Version:    0.7.0.1
 */