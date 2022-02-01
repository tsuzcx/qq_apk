package com.tencent.biz.qqcircle.widgets;

import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;

class QCircleRecommendImageView$3
  implements Runnable
{
  QCircleRecommendImageView$3(QCircleRecommendImageView paramQCircleRecommendImageView) {}
  
  public void run()
  {
    if (QCircleRecommendImageView.b(this.this$0) != null) {
      QCircleRecommendImageView.b(this.this$0).stop();
    }
    if (QCircleRecommendImageView.c(this.this$0) != null) {
      QCircleRecommendImageView.c(this.this$0).onAnimationEnd(null);
    }
    QCircleRecommendImageView.a(this.this$0, false);
    QCircleRecommendImageView localQCircleRecommendImageView = this.this$0;
    QCircleRecommendImageView.a(localQCircleRecommendImageView, QCircleRecommendImageView.d(localQCircleRecommendImageView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.3
 * JD-Core Version:    0.7.0.1
 */