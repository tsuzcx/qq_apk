package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class ARPromotionMediaPlayerWrapper$3
  implements Runnable
{
  ARPromotionMediaPlayerWrapper$3(ARPromotionMediaPlayerWrapper paramARPromotionMediaPlayerWrapper) {}
  
  public void run()
  {
    if (ARPromotionMediaPlayerWrapper.o(this.this$0)) {
      ARPromotionMediaPlayerWrapper.p(this.this$0);
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("onCompletion, mNeedAddPlayCount=");
    localStringBuilder1.append(ARPromotionMediaPlayerWrapper.o(this.this$0));
    localStringBuilder1.append(" mCurrentPlayTimes=");
    localStringBuilder1.append(ARPromotionMediaPlayerWrapper.q(this.this$0));
    localStringBuilder1.append("|");
    localStringBuilder1.append(ARPromotionMediaPlayerWrapper.r(this.this$0));
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, localStringBuilder1.toString());
    if ((ARPromotionMediaPlayerWrapper.q(this.this$0) < ARPromotionMediaPlayerWrapper.r(this.this$0)) && (ARPromotionMediaPlayerWrapper.s(this.this$0) != null) && (!ARPromotionMediaPlayerWrapper.a(this.this$0)))
    {
      try
      {
        ARPromotionMediaPlayerWrapper.s(this.this$0).stop();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("onCompletion, stop, exception=");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("ARWorldCupMediaPlayerWrapper", 1, localStringBuilder2.toString());
      }
      ARPromotionMediaPlayerWrapper.s(this.this$0).setOutputMute(ARPromotionMediaPlayerWrapper.t(this.this$0));
      Object localObject = this.this$0;
      ARPromotionMediaPlayerWrapper.a((ARPromotionMediaPlayerWrapper)localObject, ARPromotionMediaPlayerWrapper.u((ARPromotionMediaPlayerWrapper)localObject));
      ARPromotionMediaPlayerWrapper.a(this.this$0, false);
      if ((ARPromotionMediaPlayerWrapper.v(this.this$0)) && (ARPromotionMediaPlayerWrapper.k(this.this$0) != null) && (ARPromotionMediaPlayerWrapper.g(this.this$0) != null)) {
        ARPromotionMediaPlayerWrapper.k(this.this$0).a(ARPromotionMediaPlayerWrapper.l(this.this$0), 1, ARPromotionMediaPlayerWrapper.r(this.this$0) - ARPromotionMediaPlayerWrapper.q(this.this$0));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TVK_IMediaPlayer. restart remian times:");
      ((StringBuilder)localObject).append(ARPromotionMediaPlayerWrapper.r(this.this$0) - ARPromotionMediaPlayerWrapper.q(this.this$0));
      ((StringBuilder)localObject).append("video resources:");
      ((StringBuilder)localObject).append(ARPromotionMediaPlayerWrapper.u(this.this$0));
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ARPromotionMediaPlayerWrapper.a(this.this$0, 0);
    ARPromotionMediaPlayerWrapper.b(this.this$0, 1);
    ARPromotionMediaPlayerWrapper.a(this.this$0, true);
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onCompletion");
    if ((ARPromotionMediaPlayerWrapper.k(this.this$0) != null) && (ARPromotionMediaPlayerWrapper.g(this.this$0) != null)) {
      ARPromotionMediaPlayerWrapper.k(this.this$0).a(ARPromotionMediaPlayerWrapper.l(this.this$0), 1, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */