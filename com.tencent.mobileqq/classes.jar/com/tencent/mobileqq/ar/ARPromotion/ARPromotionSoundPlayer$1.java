package com.tencent.mobileqq.ar.ARPromotion;

import android.media.SoundPool;
import anyy;
import anyz;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ARPromotionSoundPlayer$1
  implements Runnable
{
  public ARPromotionSoundPlayer$1(anyy paramanyy) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = anyy.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        anyz localanyz = (anyz)((Map.Entry)localIterator.next()).getValue();
        if (localanyz != null) {
          anyy.a(this.this$0).stop(localanyz.a);
        }
      }
      anyy.a(this.this$0).release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "release exception", localException);
      }
      return;
    }
    anyy.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1
 * JD-Core Version:    0.7.0.1
 */