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
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_SpringFestivalEntryManager", 2, "onLoadComplete, " + paramInt1 + ", " + paramInt2 + ", mPlayCountDownStreamId=" + SpringFestivalEntryManager.b(this.a) + ", mPlayCountDownState=" + this.a.a);
    }
    int i = 0;
    if ((i >= 5) || (SpringFestivalEntryManager.a(this.a)[i] == paramInt1)) {
      if (i != 5) {
        break label109;
      }
    }
    label109:
    while (paramInt2 != 0)
    {
      return;
      i += 1;
      break;
    }
    SpringFestivalEntryManager.a()[i] = 1;
    this.a.a(i, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager.17
 * JD-Core Version:    0.7.0.1
 */