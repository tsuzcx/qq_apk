package com.tencent.mobileqq.ar.ARPromotion;

import amtf;
import amtg;
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
  public ARPromotionSoundPlayer$1(amtf paramamtf) {}
  
  public void run()
  {
    try
    {
      if (amtf.a(this.this$0) != null)
      {
        if (amtf.a(this.this$0).isPlaying()) {
          amtf.a(this.this$0).stop();
        }
        amtf.a(this.this$0).release();
        amtf.a(this.this$0, null);
      }
      Iterator localIterator = amtf.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        amtg localamtg = (amtg)((Map.Entry)localIterator.next()).getValue();
        if (localamtg != null) {
          amtf.a(this.this$0).stop(localamtg.a);
        }
      }
      amtf.a(this.this$0).release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "release exception", localException);
      }
      return;
    }
    amtf.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1
 * JD-Core Version:    0.7.0.1
 */