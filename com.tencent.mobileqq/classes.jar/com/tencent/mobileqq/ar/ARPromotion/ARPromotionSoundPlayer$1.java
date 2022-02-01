package com.tencent.mobileqq.ar.ARPromotion;

import android.media.SoundPool;
import apfm;
import apfn;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ARPromotionSoundPlayer$1
  implements Runnable
{
  public ARPromotionSoundPlayer$1(apfm paramapfm) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = apfm.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        apfn localapfn = (apfn)((Map.Entry)localIterator.next()).getValue();
        if (localapfn != null) {
          apfm.a(this.this$0).stop(localapfn.a);
        }
      }
      apfm.a(this.this$0).release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "release exception", localException);
      }
      return;
    }
    apfm.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1
 * JD-Core Version:    0.7.0.1
 */