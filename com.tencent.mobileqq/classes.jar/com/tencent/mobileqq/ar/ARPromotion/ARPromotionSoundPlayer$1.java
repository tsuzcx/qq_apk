package com.tencent.mobileqq.ar.ARPromotion;

import akya;
import akyb;
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
  public ARPromotionSoundPlayer$1(akya paramakya) {}
  
  public void run()
  {
    try
    {
      if (akya.a(this.this$0) != null)
      {
        if (akya.a(this.this$0).isPlaying()) {
          akya.a(this.this$0).stop();
        }
        akya.a(this.this$0).release();
        akya.a(this.this$0, null);
      }
      Iterator localIterator = akya.a(this.this$0).entrySet().iterator();
      while (localIterator.hasNext())
      {
        akyb localakyb = (akyb)((Map.Entry)localIterator.next()).getValue();
        if (localakyb != null) {
          akya.a(this.this$0).stop(localakyb.a);
        }
      }
      akya.a(this.this$0).release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ARPromotionSoundPlayer", 2, "release exception", localException);
      }
      return;
    }
    akya.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer.1
 * JD-Core Version:    0.7.0.1
 */