package com.tencent.biz.qqcircle.transition;

import android.widget.FrameLayout;

class QCircleTransitionAnimHelper$3
  implements QCircleTransitionImageView.TranAnimListener
{
  QCircleTransitionAnimHelper$3(QCircleTransitionAnimHelper paramQCircleTransitionAnimHelper, QCircleTransitionImageView.TranAnimListener paramTranAnimListener) {}
  
  public void a()
  {
    if (QCircleTransitionAnimHelper.c(this.b) != null) {
      QCircleTransitionAnimHelper.c(this.b).a(3);
    }
    QCircleTransitionAnimHelper.d(this.b).setAlpha(0.0F);
    QCircleTransitionAnimHelper.a(null);
    QCircleTransitionImageView.TranAnimListener localTranAnimListener = this.a;
    if (localTranAnimListener != null) {
      localTranAnimListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionAnimHelper.3
 * JD-Core Version:    0.7.0.1
 */