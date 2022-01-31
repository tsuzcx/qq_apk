package com.tencent.biz.qqstory.view;

import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.Animation.AnimationListener;

class AnimationPoint$1
  implements Runnable
{
  AnimationPoint$1(AnimationPoint paramAnimationPoint) {}
  
  public void run()
  {
    if (this.this$0.jdField_b_of_type_Boolean) {
      return;
    }
    if ((SystemClock.uptimeMillis() - this.this$0.c < this.this$0.jdField_b_of_type_Long) || (this.this$0.jdField_b_of_type_Long < 0L)) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 30L);
    }
    for (;;)
    {
      this.this$0.invalidate();
      return;
      if (this.this$0.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) {
        this.this$0.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationEnd(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.AnimationPoint.1
 * JD-Core Version:    0.7.0.1
 */