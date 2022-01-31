package com.tencent.mobileqq.ar.ARPromotion;

import akjp;
import akjq;
import android.media.SoundPool;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ARPromotionSoundPlayer$1
  implements Runnable
{
  public ARPromotionSoundPlayer$1(akjp paramakjp) {}
  
  public void run()
  {
    try
    {
      if (akjp.a(this.this$0) != null)
      {
        if (akjp.a(this.this$0).isPlaying()) {
          akjp.a(this.this$0).stop();
        }
        akjp.a(this.this$0).release();
        akjp.a(this.this$0, null);
      }
      Iterator localIterator = akjp.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        akjq localakjq = (akjq)((Map.Entry)localIterator.next()).getValue();
        if (localakjq != null) {
          akjp.a(this.this$0).stop(localakjq.a);
        }
      }
      akjp.a(this.this$0).release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "release exception", localException);
      }
      return;
    }
    akjp.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1
 * JD-Core Version:    0.7.0.1
 */