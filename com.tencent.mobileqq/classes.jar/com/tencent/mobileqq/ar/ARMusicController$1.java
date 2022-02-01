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
      QLog.e("ARMusicController", 2, "load fire music failed. " + ARMusicController.a(this.a));
      return;
    }
    catch (Exception paramSoundPool)
    {
      paramSoundPool.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMusicController", 2, "load fire music success. : " + ARMusicController.a(this.a));
    }
    ARMusicController.a(this.a, true);
    if (ARMusicController.a(this.a))
    {
      paramSoundPool.play(paramInt1, 1.0F, 1.0F, 1, 0, 1.0F);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARMusicController.1
 * JD-Core Version:    0.7.0.1
 */