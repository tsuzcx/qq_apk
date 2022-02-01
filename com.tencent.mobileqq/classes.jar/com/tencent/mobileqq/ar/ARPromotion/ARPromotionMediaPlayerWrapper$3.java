package com.tencent.mobileqq.ar.ARPromotion;

import apby;
import apbz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class ARPromotionMediaPlayerWrapper$3
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$3(apby paramapby) {}
  
  public void run()
  {
    if (apby.b(this.this$0)) {
      apby.c(this.this$0);
    }
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, mNeedAddPlayCount=" + apby.b(this.this$0) + " mCurrentPlayTimes=" + apby.d(this.this$0) + "|" + apby.e(this.this$0));
    if ((apby.d(this.this$0) < apby.e(this.this$0)) && (apby.a(this.this$0) != null) && (!apby.a(this.this$0))) {}
    do
    {
      try
      {
        apby.a(this.this$0).stop();
        apby.a(this.this$0).setOutputMute(apby.c(this.this$0));
        apby.a(this.this$0, apby.a(this.this$0));
        apby.a(this.this$0, false);
        if ((apby.d(this.this$0)) && (apby.a(this.this$0) != null) && (apby.a(this.this$0) != null)) {
          apby.a(this.this$0).a(apby.b(this.this$0), 1, apby.e(this.this$0) - apby.d(this.this$0));
        }
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer. restart remian times:" + (apby.e(this.this$0) - apby.d(this.this$0)) + "video resources:" + apby.a(this.this$0));
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
      apby.a(this.this$0, 0);
      apby.b(this.this$0, 1);
      apby.a(this.this$0, true);
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onCompletion");
    } while ((apby.a(this.this$0) == null) || (apby.a(this.this$0) == null));
    apby.a(this.this$0).a(apby.b(this.this$0), 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */