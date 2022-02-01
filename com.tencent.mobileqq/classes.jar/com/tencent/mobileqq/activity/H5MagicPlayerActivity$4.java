package com.tencent.mobileqq.activity;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.qphone.base.util.QLog;

class H5MagicPlayerActivity$4
  implements SoundPool.OnLoadCompleteListener
{
  H5MagicPlayerActivity$4(H5MagicPlayerActivity paramH5MagicPlayerActivity, String paramString) {}
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if ((this.b.i.play(paramInt1, 1.0F, 1.0F, 0, this.b.k - 1, 1.0F) == 0) && (QLog.isColorLevel()))
    {
      paramSoundPool = new StringBuilder();
      paramSoundPool.append("play failure filepath=");
      paramSoundPool.append(this.a);
      QLog.d("SoundPoolUtil", 2, paramSoundPool.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.H5MagicPlayerActivity.4
 * JD-Core Version:    0.7.0.1
 */