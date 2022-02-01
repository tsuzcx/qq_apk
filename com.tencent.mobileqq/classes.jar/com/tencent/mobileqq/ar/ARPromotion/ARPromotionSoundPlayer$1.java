package com.tencent.mobileqq.ar.ARPromotion;

import android.media.SoundPool;
import apca;
import apcb;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ARPromotionSoundPlayer$1
  implements Runnable
{
  public ARPromotionSoundPlayer$1(apca paramapca) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = apca.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        apcb localapcb = (apcb)((Map.Entry)localIterator.next()).getValue();
        if (localapcb != null) {
          apca.a(this.this$0).stop(localapcb.a);
        }
      }
      apca.a(this.this$0).release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "release exception", localException);
      }
      return;
    }
    apca.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1
 * JD-Core Version:    0.7.0.1
 */