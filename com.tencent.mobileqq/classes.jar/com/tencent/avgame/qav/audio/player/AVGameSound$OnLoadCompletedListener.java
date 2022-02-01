package com.tencent.avgame.qav.audio.player;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import java.util.concurrent.ConcurrentHashMap;

public class AVGameSound$OnLoadCompletedListener
  implements SoundPool.OnLoadCompleteListener
{
  public AVGameSound$OnLoadCompletedListener(AVGameSound paramAVGameSound) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      paramSoundPool = (AVGameSound.SoundInfoForLoadedCompleted)AVGameSound.a(this.a).get(Integer.valueOf(paramInt1));
      if (paramSoundPool != null)
      {
        paramSoundPool.f = AVGameSound.a(this.a, paramSoundPool.e, paramInt1, paramSoundPool.a, paramSoundPool.b, paramSoundPool.c, paramSoundPool.d);
        try
        {
          paramSoundPool.notifyAll();
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.player.AVGameSound.OnLoadCompletedListener
 * JD-Core Version:    0.7.0.1
 */