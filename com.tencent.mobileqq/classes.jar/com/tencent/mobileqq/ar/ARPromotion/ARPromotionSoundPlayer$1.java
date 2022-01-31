package com.tencent.mobileqq.ar.ARPromotion;

import amoq;
import amor;
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
  public ARPromotionSoundPlayer$1(amoq paramamoq) {}
  
  public void run()
  {
    try
    {
      if (amoq.a(this.this$0) != null)
      {
        if (amoq.a(this.this$0).isPlaying()) {
          amoq.a(this.this$0).stop();
        }
        amoq.a(this.this$0).release();
        amoq.a(this.this$0, null);
      }
      Iterator localIterator = amoq.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        amor localamor = (amor)((Map.Entry)localIterator.next()).getValue();
        if (localamor != null) {
          amoq.a(this.this$0).stop(localamor.a);
        }
      }
      amoq.a(this.this$0).release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "release exception", localException);
      }
      return;
    }
    amoq.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1
 * JD-Core Version:    0.7.0.1
 */