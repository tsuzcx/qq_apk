package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;

class FrameAnimationView$1
  implements Runnable
{
  FrameAnimationView$1(FrameAnimationView paramFrameAnimationView, String[] paramArrayOfString, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (FrameAnimationView.a(this.this$0))
    {
      QQAnimationDrawable localQQAnimationDrawable = new QQAnimationDrawable();
      localQQAnimationDrawable.a(this.a);
      localQQAnimationDrawable.a(this.b);
      localQQAnimationDrawable.b(this.c);
      this.this$0.setBackgroundDrawable(localQQAnimationDrawable);
      localQQAnimationDrawable.a(this.c, 2147483647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.FrameAnimationView.1
 * JD-Core Version:    0.7.0.1
 */