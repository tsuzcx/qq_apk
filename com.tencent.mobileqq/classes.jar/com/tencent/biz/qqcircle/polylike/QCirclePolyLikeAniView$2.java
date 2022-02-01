package com.tencent.biz.qqcircle.polylike;

import android.view.View;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.animation.support.AnimationListener.Stop;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCirclePolyLikeAniView$2
  implements AnimationDrawableFactory.CreateResultListener
{
  QCirclePolyLikeAniView$2(QCirclePolyLikeAniView paramQCirclePolyLikeAniView, String paramString, boolean paramBoolean1, QQCircleFeedBase.StPolyLike paramStPolyLike, View paramView1, View paramView2, boolean paramBoolean2, AnimationListener.Stop paramStop) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      QLog.d("QCirclePolymorphicAniView", 1, "create ain success");
      this.h.post(new QCirclePolyLikeAniView.2.1(this, paramQQAnimationDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView.2
 * JD-Core Version:    0.7.0.1
 */