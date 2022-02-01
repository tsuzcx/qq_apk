package com.tencent.biz.qqcircle.transition;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.qphone.base.util.QLog;

class QCircleTransitionAnimHelper$1
  implements ViewTreeObserver.OnPreDrawListener
{
  QCircleTransitionAnimHelper$1(QCircleTransitionAnimHelper paramQCircleTransitionAnimHelper) {}
  
  public boolean onPreDraw()
  {
    QCircleTransitionAnimHelper.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    QCircleTransitionAnimHelper.b(this.a);
    QLog.d("QCircleTransitionAnimHelper", 4, "initImageEnterAnimation");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionAnimHelper.1
 * JD-Core Version:    0.7.0.1
 */