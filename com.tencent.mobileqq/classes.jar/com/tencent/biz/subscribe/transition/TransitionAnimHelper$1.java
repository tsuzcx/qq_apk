package com.tencent.biz.subscribe.transition;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class TransitionAnimHelper$1
  implements ViewTreeObserver.OnPreDrawListener
{
  TransitionAnimHelper$1(TransitionAnimHelper paramTransitionAnimHelper) {}
  
  public boolean onPreDraw()
  {
    TransitionAnimHelper.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    Object localObject = this.a;
    TransitionAnimHelper.a((TransitionAnimHelper)localObject, TransitionAnimHelper.a((TransitionAnimHelper)localObject).getLeft(), TransitionAnimHelper.a(this.a).getTop(), TransitionAnimHelper.a(this.a).getWidth(), TransitionAnimHelper.a(this.a).getHeight());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initImageEnterAnimation left:");
    ((StringBuilder)localObject).append(TransitionAnimHelper.a(this.a).getLeft());
    QLog.d("TransitionAnimHelper", 4, new Object[] { ((StringBuilder)localObject).toString(), ",top:", Integer.valueOf(TransitionAnimHelper.a(this.a).getTop()), ",width:", Integer.valueOf(TransitionAnimHelper.a(this.a).getWidth()), ",height:", Integer.valueOf(TransitionAnimHelper.a(this.a).getHeight()) });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransitionAnimHelper.1
 * JD-Core Version:    0.7.0.1
 */