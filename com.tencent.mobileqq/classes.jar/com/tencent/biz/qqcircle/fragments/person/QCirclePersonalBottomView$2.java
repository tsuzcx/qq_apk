package com.tencent.biz.qqcircle.fragments.person;

import android.widget.ImageView;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;

class QCirclePersonalBottomView$2
  implements AnimationDrawableFactory.CreateResultListener
{
  QCirclePersonalBottomView$2(QCirclePersonalBottomView paramQCirclePersonalBottomView, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (QCirclePersonalBottomView.b(this.b) != null) && (paramQQAnimationDrawable != null))
    {
      paramQQAnimationDrawable.b(true);
      QCirclePersonalBottomView.b(this.b).setImageDrawable(paramQQAnimationDrawable);
      paramQQAnimationDrawable.b(true);
      paramQQAnimationDrawable.start();
      this.b.postDelayed(new QCirclePersonalBottomView.2.1(this), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView.2
 * JD-Core Version:    0.7.0.1
 */