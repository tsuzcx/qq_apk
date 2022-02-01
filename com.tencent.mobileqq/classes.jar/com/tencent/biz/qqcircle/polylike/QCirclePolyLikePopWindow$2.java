package com.tencent.biz.qqcircle.polylike;

import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;

class QCirclePolyLikePopWindow$2
  implements AnimationDrawableFactory.CreateResultListener
{
  QCirclePolyLikePopWindow$2(QCirclePolyLikePopWindow paramQCirclePolyLikePopWindow) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null)) {
      QLog.d("QCirclePolymorphicLikePopWindow", 1, "preload success");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikePopWindow.2
 * JD-Core Version:    0.7.0.1
 */