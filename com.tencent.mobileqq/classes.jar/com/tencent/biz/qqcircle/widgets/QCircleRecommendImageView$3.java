package com.tencent.biz.qqcircle.widgets;

import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;

class QCircleRecommendImageView$3
  implements Runnable
{
  QCircleRecommendImageView$3(QCircleRecommendImageView paramQCircleRecommendImageView) {}
  
  public void run()
  {
    if (QCircleRecommendImageView.a(this.this$0) != null) {
      QCircleRecommendImageView.a(this.this$0).stop();
    }
    if (QCircleRecommendImageView.a(this.this$0) != null) {
      QCircleRecommendImageView.a(this.this$0).onAnimationEnd(null);
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.3
 * JD-Core Version:    0.7.0.1
 */