package com.tencent.biz.qqcircle.widgets;

import aaak;
import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCirclePushAnimationEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import mqq.util.WeakReference;
import uyk;
import uzg;

class QCircleRecommendImageView$LongPressTimerTask$1
  implements Runnable
{
  QCircleRecommendImageView$LongPressTimerTask$1(QCircleRecommendImageView.LongPressTimerTask paramLongPressTimerTask) {}
  
  public void run()
  {
    try
    {
      QCircleRecommendImageView localQCircleRecommendImageView = (QCircleRecommendImageView)QCircleRecommendImageView.LongPressTimerTask.a(this.this$0).get();
      if (localQCircleRecommendImageView == null) {
        return;
      }
      if ((QCircleRecommendImageView.a(localQCircleRecommendImageView) != null) && (uzg.a((FeedCloudMeta.StUser)QCircleRecommendImageView.a(localQCircleRecommendImageView).poster.get())))
      {
        QCircleRecommendImageView.d(localQCircleRecommendImageView);
        return;
      }
      if (uyk.a().a() <= 0)
      {
        QCircleRecommendImageView.a(localQCircleRecommendImageView, 0, 0);
        QCircleRecommendImageView.e(localQCircleRecommendImageView);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleRecommend_", 1, localException.getMessage());
      localException.printStackTrace();
      return;
    }
    if (QCircleRecommendImageView.b(localException) < QCircleRecommendImageView.a())
    {
      QCircleRecommendImageView.c(localException);
      QCircleRecommendImageView.d(localException);
      QCircleRecommendImageView.b(localException, true);
      FeedCloudMeta.StFeed localStFeed = localException.a();
      if ((localStFeed != null) && (!TextUtils.isEmpty(localStFeed.id.get())))
      {
        aaak.a().a(new QCirclePushAnimationEvent(localStFeed.id.get(), QCircleRecommendImageView.e(localException), 3, QCircleRecommendImageView.f(localException)));
        QCircleRecommendImageView.f(localException);
      }
      ((Vibrator)localException.getContext().getSystemService("vibrator")).vibrate(50L);
      uyk.a().a(uyk.a().a() - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.LongPressTimerTask.1
 * JD-Core Version:    0.7.0.1
 */