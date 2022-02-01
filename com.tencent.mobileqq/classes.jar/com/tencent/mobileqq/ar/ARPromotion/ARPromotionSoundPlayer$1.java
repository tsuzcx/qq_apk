package com.tencent.mobileqq.ar.ARPromotion;

import android.media.SoundPool;
import aorw;
import aorx;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ARPromotionSoundPlayer$1
  implements Runnable
{
  public ARPromotionSoundPlayer$1(aorw paramaorw) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = aorw.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        aorx localaorx = (aorx)((Map.Entry)localIterator.next()).getValue();
        if (localaorx != null) {
          aorw.a(this.this$0).stop(localaorx.a);
        }
      }
      aorw.a(this.this$0).release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "release exception", localException);
      }
      return;
    }
    aorw.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1
 * JD-Core Version:    0.7.0.1
 */