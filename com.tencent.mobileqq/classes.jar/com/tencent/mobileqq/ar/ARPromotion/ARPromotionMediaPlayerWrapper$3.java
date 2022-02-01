package com.tencent.mobileqq.ar.ARPromotion;

import apfk;
import apfl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class ARPromotionMediaPlayerWrapper$3
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$3(apfk paramapfk) {}
  
  public void run()
  {
    if (apfk.b(this.this$0)) {
      apfk.c(this.this$0);
    }
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, mNeedAddPlayCount=" + apfk.b(this.this$0) + " mCurrentPlayTimes=" + apfk.d(this.this$0) + "|" + apfk.e(this.this$0));
    if ((apfk.d(this.this$0) < apfk.e(this.this$0)) && (apfk.a(this.this$0) != null) && (!apfk.a(this.this$0))) {}
    do
    {
      try
      {
        apfk.a(this.this$0).stop();
        apfk.a(this.this$0).setOutputMute(apfk.c(this.this$0));
        apfk.a(this.this$0, apfk.a(this.this$0));
        apfk.a(this.this$0, false);
        if ((apfk.d(this.this$0)) && (apfk.a(this.this$0) != null) && (apfk.a(this.this$0) != null)) {
          apfk.a(this.this$0).a(apfk.b(this.this$0), 1, apfk.e(this.this$0) - apfk.d(this.this$0));
        }
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer. restart remian times:" + (apfk.e(this.this$0) - apfk.d(this.this$0)) + "video resources:" + apfk.a(this.this$0));
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
      apfk.a(this.this$0, 0);
      apfk.b(this.this$0, 1);
      apfk.a(this.this$0, true);
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onCompletion");
    } while ((apfk.a(this.this$0) == null) || (apfk.a(this.this$0) == null));
    apfk.a(this.this$0).a(apfk.b(this.this$0), 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */