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
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("onCompletion, mNeedAddPlayCount=");
    localStringBuilder1.append(ARPromotionMediaPlayerWrapper.b(this.this$0));
    localStringBuilder1.append(" mCurrentPlayTimes=");
    localStringBuilder1.append(ARPromotionMediaPlayerWrapper.d(this.this$0));
    localStringBuilder1.append("|");
    localStringBuilder1.append(ARPromotionMediaPlayerWrapper.e(this.this$0));
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, localStringBuilder1.toString());
    if ((ARPromotionMediaPlayerWrapper.d(this.this$0) < ARPromotionMediaPlayerWrapper.e(this.this$0)) && (ARPromotionMediaPlayerWrapper.a(this.this$0) != null) && (!ARPromotionMediaPlayerWrapper.a(this.this$0)))
    {
      try
      {
        ARPromotionMediaPlayerWrapper.a(this.this$0).stop();
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
      ARPromotionMediaPlayerWrapper.a(this.this$0).setOutputMute(ARPromotionMediaPlayerWrapper.c(this.this$0));
      Object localObject = this.this$0;
      ARPromotionMediaPlayerWrapper.a((ARPromotionMediaPlayerWrapper)localObject, ARPromotionMediaPlayerWrapper.a((ARPromotionMediaPlayerWrapper)localObject));
      ARPromotionMediaPlayerWrapper.a(this.this$0, false);
      if ((ARPromotionMediaPlayerWrapper.d(this.this$0)) && (ARPromotionMediaPlayerWrapper.a(this.this$0) != null) && (ARPromotionMediaPlayerWrapper.a(this.this$0) != null)) {
        ARPromotionMediaPlayerWrapper.a(this.this$0).a(ARPromotionMediaPlayerWrapper.b(this.this$0), 1, ARPromotionMediaPlayerWrapper.e(this.this$0) - ARPromotionMediaPlayerWrapper.d(this.this$0));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TVK_IMediaPlayer. restart remian times:");
      ((StringBuilder)localObject).append(ARPromotionMediaPlayerWrapper.e(this.this$0) - ARPromotionMediaPlayerWrapper.d(this.this$0));
      ((StringBuilder)localObject).append("video resources:");
      ((StringBuilder)localObject).append(ARPromotionMediaPlayerWrapper.a(this.this$0));
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, ((StringBuilder)localObject).toString());
      return;
    }
    ARPromotionMediaPlayerWrapper.a(this.this$0, 0);
    ARPromotionMediaPlayerWrapper.b(this.this$0, 1);
    ARPromotionMediaPlayerWrapper.a(this.this$0, true);
    QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onCompletion");
    if ((ARPromotionMediaPlayerWrapper.a(this.this$0) != null) && (ARPromotionMediaPlayerWrapper.a(this.this$0) != null)) {
      ARPromotionMediaPlayerWrapper.a(this.this$0).a(ARPromotionMediaPlayerWrapper.b(this.this$0), 1, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.3
 * JD-Core Version:    0.7.0.1
 */