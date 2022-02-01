package com.tencent.avgame.audio.player;

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
        paramSoundPool.jdField_a_of_type_Int = AVGameSound.a(this.a, paramSoundPool.jdField_a_of_type_JavaLangString, paramInt1, paramSoundPool.jdField_a_of_type_Boolean, paramSoundPool.jdField_a_of_type_Float, paramSoundPool.b, paramSoundPool.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.audio.player.AVGameSound.OnLoadCompletedListener
 * JD-Core Version:    0.7.0.1
 */