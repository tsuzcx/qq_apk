package com.tencent.mobileqq.ar;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class ARMusicController$4
  implements SoundPool.OnLoadCompleteListener
{
  ARMusicController$4(ARMusicController paramARMusicController) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {}
    try
    {
      QLog.e("ARMusicController", 2, "load fire music failed. id=" + paramInt1);
      return;
    }
    catch (Exception paramSoundPool)
    {
      paramSoundPool.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMusicController", 2, "load fire music success. id=" + paramInt1);
    }
    ARMusicController.a(this.a).add(Integer.valueOf(paramInt1));
    if (ARMusicController.b(this.a).contains(Integer.valueOf(paramInt1)))
    {
      paramSoundPool.play(paramInt1, 1.0F, 1.0F, 1, 0, 1.0F);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARMusicController.4
 * JD-Core Version:    0.7.0.1
 */