package com.tencent.biz.qqcircle.widgets;

import android.animation.AnimatorSet;

class QCircleProgressLoadingView$1
  implements Runnable
{
  QCircleProgressLoadingView$1(QCircleProgressLoadingView paramQCircleProgressLoadingView) {}
  
  public void run()
  {
    if (QCircleProgressLoadingView.a(this.this$0) != null)
    {
      QCircleProgressLoadingView.a(this.this$0).removeAllListeners();
      if (QCircleProgressLoadingView.b(this.this$0) != null) {
        QCircleProgressLoadingView.a(this.this$0).addListener(QCircleProgressLoadingView.b(this.this$0));
      }
      QCircleProgressLoadingView.a(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleProgressLoadingView.1
 * JD-Core Version:    0.7.0.1
 */