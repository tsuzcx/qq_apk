package com.tencent.biz.qqcircle.widgets;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import java.lang.ref.WeakReference;

class QCircleProgressLoadingView$ScaleXAnimationListener
  implements ValueAnimator.AnimatorUpdateListener
{
  private WeakReference<QCircleProgressLoadingView> a;
  private int b = 16;
  
  QCircleProgressLoadingView$ScaleXAnimationListener(QCircleProgressLoadingView paramQCircleProgressLoadingView, int paramInt)
  {
    this.a = new WeakReference(paramQCircleProgressLoadingView);
    this.b = paramInt;
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
        if ((localObject != null) && (((View)localObject).getLayoutParams() != null))
        {
          int j = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
          int i;
          if (this.b == 16) {
            i = DisplayUtil.d();
          } else {
            i = DisplayUtil.e();
          }
          ((View)localObject).setX(i / 2 - j);
          ((View)localObject).getLayoutParams().width = (j * 2);
          ((View)localObject).setLayoutParams(((View)localObject).getLayoutParams());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleProgressLoadingView.ScaleXAnimationListener
 * JD-Core Version:    0.7.0.1
 */