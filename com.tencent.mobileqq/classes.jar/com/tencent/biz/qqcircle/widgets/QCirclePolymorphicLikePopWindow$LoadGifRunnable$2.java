package com.tencent.biz.qqcircle.widgets;

import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.widget.AnimationView;
import java.lang.ref.WeakReference;

class QCirclePolymorphicLikePopWindow$LoadGifRunnable$2
  implements Runnable
{
  QCirclePolymorphicLikePopWindow$LoadGifRunnable$2(QCirclePolymorphicLikePopWindow.LoadGifRunnable paramLoadGifRunnable, AnimationView paramAnimationView, QQAnimationDrawable paramQQAnimationDrawable) {}
  
  public void run()
  {
    if ((QCirclePolymorphicLikePopWindow.LoadGifRunnable.a(this.this$0).get() != null) && (((QCirclePolymorphicLikePopWindow)QCirclePolymorphicLikePopWindow.LoadGifRunnable.a(this.this$0).get()).isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow.LoadGifRunnable.2
 * JD-Core Version:    0.7.0.1
 */