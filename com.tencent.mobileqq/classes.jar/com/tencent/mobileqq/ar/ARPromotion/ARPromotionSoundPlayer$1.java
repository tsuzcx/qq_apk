package com.tencent.mobileqq.ar.ARPromotion;

import android.media.SoundPool;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ARPromotionSoundPlayer$1
  implements Runnable
{
  ARPromotionSoundPlayer$1(ARPromotionSoundPlayer paramARPromotionSoundPlayer) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = ARPromotionSoundPlayer.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        ARPromotionSoundPlayer.ARSoundModel localARSoundModel = (ARPromotionSoundPlayer.ARSoundModel)((Map.Entry)localIterator.next()).getValue();
        if (localARSoundModel != null) {
          ARPromotionSoundPlayer.b(this.this$0).stop(localARSoundModel.a);
        }
      }
      ARPromotionSoundPlayer.b(this.this$0).release();
      ARPromotionSoundPlayer.a(this.this$0).clear();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "release exception", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1
 * JD-Core Version:    0.7.0.1
 */