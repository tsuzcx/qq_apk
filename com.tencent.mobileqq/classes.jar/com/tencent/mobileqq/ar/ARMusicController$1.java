package com.tencent.mobileqq.ar;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;

class ARMusicController$1
  implements SoundPool.OnLoadCompleteListener
{
  ARMusicController$1(ARMusicController paramARMusicController) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {}
    try
    {
      paramSoundPool = new StringBuilder();
      paramSoundPool.append("load fire music failed. ");
      paramSoundPool.append(ARMusicController.a(this.a));
      QLog.e("ARMusicController", 2, paramSoundPool.toString());
      return;
    }
    catch (Exception paramSoundPool)
    {
      StringBuilder localStringBuilder;
      paramSoundPool.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("load fire music success. : ");
      localStringBuilder.append(ARMusicController.a(this.a));
      QLog.d("ARMusicController", 2, localStringBuilder.toString());
    }
    ARMusicController.a(this.a, true);
    if (ARMusicController.b(this.a))
    {
      paramSoundPool.play(paramInt1, 1.0F, 1.0F, 1, 0, 1.0F);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARMusicController.1
 * JD-Core Version:    0.7.0.1
 */