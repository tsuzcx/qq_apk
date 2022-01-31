package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import mqq.util.WeakReference;
import tra;
import yiw;

class QCircleRecommendImageView$LongPressTimerTask$1
  implements Runnable
{
  QCircleRecommendImageView$LongPressTimerTask$1(QCircleRecommendImageView.LongPressTimerTask paramLongPressTimerTask) {}
  
  public void run()
  {
    try
    {
      QCircleRecommendImageView localQCircleRecommendImageView = (QCircleRecommendImageView)QCircleRecommendImageView.LongPressTimerTask.a(this.this$0).get();
      if (localQCircleRecommendImageView != null)
      {
        if ((QCircleRecommendImageView.a(localQCircleRecommendImageView) != null) && (tra.a((FeedCloudMeta.StUser)QCircleRecommendImageView.a(localQCircleRecommendImageView).poster.get())))
        {
          QCircleRecommendImageView.h(localQCircleRecommendImageView);
          return;
        }
        if (QCircleRecommendImageView.b(localQCircleRecommendImageView) < QCircleRecommendImageView.a())
        {
          QCircleRecommendImageView.c(localQCircleRecommendImageView);
          QCircleRecommendImageView.d(localQCircleRecommendImageView);
          QCircleRecommendImageView.b(localQCircleRecommendImageView, true);
          FeedCloudMeta.StFeed localStFeed = localQCircleRecommendImageView.a();
          if ((localStFeed != null) && (!TextUtils.isEmpty(localStFeed.id.get()))) {
            yiw.a().a(new QCirclePushAnimationEvent(localStFeed.id.get(), QCircleRecommendImageView.e(localQCircleRecommendImageView), 3, QCircleRecommendImageView.f(localQCircleRecommendImageView)));
          }
          ((Vibrator)localQCircleRecommendImageView.getContext().getSystemService("vibrator")).vibrate(50L);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleRecommend_", 1, localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.LongPressTimerTask.1
 * JD-Core Version:    0.7.0.1
 */