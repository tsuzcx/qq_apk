package com.tencent.mobileqq.activity.springfestival.entry;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;

class SpringFestivalEntryManager$17
  implements SoundPool.OnLoadCompleteListener
{
  SpringFestivalEntryManager$17(SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramSoundPool = new StringBuilder();
      paramSoundPool.append("onLoadComplete, ");
      paramSoundPool.append(paramInt1);
      paramSoundPool.append(", ");
      paramSoundPool.append(paramInt2);
      paramSoundPool.append(", mPlayCountDownStreamId=");
      paramSoundPool.append(SpringFestivalEntryManager.k(this.a));
      paramSoundPool.append(", mPlayCountDownState=");
      paramSoundPool.append(this.a.c);
      QLog.d("shua2021_SpringFestivalEntryManager", 2, paramSoundPool.toString());
    }
    int i = 0;
    while ((i < 5) && (SpringFestivalEntryManager.l(this.a)[i] != paramInt1)) {
      i += 1;
    }
    if (i == 5) {
      return;
    }
    if (paramInt2 == 0)
    {
      SpringFestivalEntryManager.p()[i] = 1;
      this.a.a(i, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager.17
 * JD-Core Version:    0.7.0.1
 */