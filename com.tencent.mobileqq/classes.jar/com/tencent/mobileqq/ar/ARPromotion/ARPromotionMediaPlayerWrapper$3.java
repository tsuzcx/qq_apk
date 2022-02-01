package com.tencent.mobileqq.ar.ARPromotion;

import anyw;
import anyx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class ARPromotionMediaPlayerWrapper$3
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$3(anyw paramanyw) {}
  
  public void run()
  {
    if (anyw.b(this.this$0)) {
      anyw.c(this.this$0);
    }
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, mNeedAddPlayCount=" + anyw.b(this.this$0) + " mCurrentPlayTimes=" + anyw.d(this.this$0) + "|" + anyw.e(this.this$0));
    if ((anyw.d(this.this$0) < anyw.e(this.this$0)) && (anyw.a(this.this$0) != null) && (!anyw.a(this.this$0))) {}
    do
    {
      try
      {
        anyw.a(this.this$0).stop();
        anyw.a(this.this$0).setOutputMute(anyw.c(this.this$0));
        anyw.a(this.this$0, anyw.a(this.this$0));
        anyw.a(this.this$0, false);
        if ((anyw.d(this.this$0)) && (anyw.a(this.this$0) != null) && (anyw.a(this.this$0) != null)) {
          anyw.a(this.this$0).a(anyw.b(this.this$0), 1, anyw.e(this.this$0) - anyw.d(this.this$0));
        }
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer. restart remian times:" + (anyw.e(this.this$0) - anyw.d(this.this$0)) + "video resources:" + anyw.a(this.this$0));
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
      anyw.a(this.this$0, 0);
      anyw.b(this.this$0, 1);
      anyw.a(this.this$0, true);
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onCompletion");
    } while ((anyw.a(this.this$0) == null) || (anyw.a(this.this$0) == null));
    anyw.a(this.this$0).a(anyw.b(this.this$0), 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */