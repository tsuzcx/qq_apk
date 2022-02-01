package com.tencent.mobileqq.ar.ARPromotion;

import aoru;
import aorv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class ARPromotionMediaPlayerWrapper$3
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$3(aoru paramaoru) {}
  
  public void run()
  {
    if (aoru.b(this.this$0)) {
      aoru.c(this.this$0);
    }
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, mNeedAddPlayCount=" + aoru.b(this.this$0) + " mCurrentPlayTimes=" + aoru.d(this.this$0) + "|" + aoru.e(this.this$0));
    if ((aoru.d(this.this$0) < aoru.e(this.this$0)) && (aoru.a(this.this$0) != null) && (!aoru.a(this.this$0))) {}
    do
    {
      try
      {
        aoru.a(this.this$0).stop();
        aoru.a(this.this$0).setOutputMute(aoru.c(this.this$0));
        aoru.a(this.this$0, aoru.a(this.this$0));
        aoru.a(this.this$0, false);
        if ((aoru.d(this.this$0)) && (aoru.a(this.this$0) != null) && (aoru.a(this.this$0) != null)) {
          aoru.a(this.this$0).a(aoru.b(this.this$0), 1, aoru.e(this.this$0) - aoru.d(this.this$0));
        }
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer. restart remian times:" + (aoru.e(this.this$0) - aoru.d(this.this$0)) + "video resources:" + aoru.a(this.this$0));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            localException.printStackTrace();
          }
          QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, stop, exception=" + localException.getMessage());
        }
      }
      aoru.a(this.this$0, 0);
      aoru.b(this.this$0, 1);
      aoru.a(this.this$0, true);
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onCompletion");
    } while ((aoru.a(this.this$0) == null) || (aoru.a(this.this$0) == null));
    aoru.a(this.this$0).a(aoru.b(this.this$0), 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */