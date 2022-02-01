package com.tencent.biz.qqcircle.widgets;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

class QCircleProgressLoadingView$OpacityAnimationListener
  implements ValueAnimator.AnimatorUpdateListener
{
  private WeakReference<QCircleProgressLoadingView> a;
  
  QCircleProgressLoadingView$OpacityAnimationListener(QCircleProgressLoadingView paramQCircleProgressLoadingView)
  {
    this.a = new WeakReference(paramQCircleProgressLoadingView);
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (QCircleProgressLoadingView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        localObject = ((QCircleProgressLoadingView)localObject).getLoadingView();
        if ((localObject != null) && (((View)localObject).getBackground() != null)) {
          ((View)localObject).getBackground().setAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleProgressLoadingView.OpacityAnimationListener
 * JD-Core Version:    0.7.0.1
 */