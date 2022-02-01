package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class ARPromotionMediaPlayerWrapper$3
  implements Runnable
{
  ARPromotionMediaPlayerWrapper$3(ARPromotionMediaPlayerWrapper paramARPromotionMediaPlayerWrapper) {}
  
  public void run()
  {
    if (ARPromotionMediaPlayerWrapper.b(this.this$0)) {
      ARPromotionMediaPlayerWrapper.c(this.this$0);
    }
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "onCompletion, mNeedAddPlayCount=" + ARPromotionMediaPlayerWrapper.b(this.this$0) + " mCurrentPlayTimes=" + ARPromotionMediaPlayerWrapper.d(this.this$0) + "|" + ARPromotionMediaPlayerWrapper.e(this.this$0));
    if ((ARPromotionMediaPlayerWrapper.d(this.this$0) < ARPromotionMediaPlayerWrapper.e(this.this$0)) && (ARPromotionMediaPlayerWrapper.a(this.this$0) != null) && (!ARPromotionMediaPlayerWrapper.a(this.this$0))) {}
    do
    {
      try
      {
        ARPromotionMediaPlayerWrapper.a(this.this$0).stop();
        ARPromotionMediaPlayerWrapper.a(this.this$0).setOutputMute(ARPromotionMediaPlayerWrapper.c(this.this$0));
        ARPromotionMediaPlayerWrapper.a(this.this$0, ARPromotionMediaPlayerWrapper.a(this.this$0));
        ARPromotionMediaPlayerWrapper.a(this.this$0, false);
        if ((ARPromotionMediaPlayerWrapper.d(this.this$0)) && (ARPromotionMediaPlayerWrapper.a(this.this$0) != null) && (ARPromotionMediaPlayerWrapper.a(this.this$0) != null)) {
          ARPromotionMediaPlayerWrapper.a(this.this$0).a(ARPromotionMediaPlayerWrapper.b(this.this$0), 1, ARPromotionMediaPlayerWrapper.e(this.this$0) - ARPromotionMediaPlayerWrapper.d(this.this$0));
        }
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer. restart remian times:" + (ARPromotionMediaPlayerWrapper.e(this.this$0) - ARPromotionMediaPlayerWrapper.d(this.this$0)) + "video resources:" + ARPromotionMediaPlayerWrapper.a(this.this$0));
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
      ARPromotionMediaPlayerWrapper.a(this.this$0, 0);
      ARPromotionMediaPlayerWrapper.b(this.this$0, 1);
      ARPromotionMediaPlayerWrapper.a(this.this$0, true);
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onCompletion");
    } while ((ARPromotionMediaPlayerWrapper.a(this.this$0) == null) || (ARPromotionMediaPlayerWrapper.a(this.this$0) == null));
    ARPromotionMediaPlayerWrapper.a(this.this$0).a(ARPromotionMediaPlayerWrapper.b(this.this$0), 1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */