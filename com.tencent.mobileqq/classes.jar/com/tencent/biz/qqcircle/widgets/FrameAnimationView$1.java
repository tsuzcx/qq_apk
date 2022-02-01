package com.tencent.biz.qqcircle.widgets;

import com.tencent.mobileqq.bubble.QQAnimationDrawable;

class FrameAnimationView$1
  implements Runnable
{
  FrameAnimationView$1(FrameAnimationView paramFrameAnimationView, String[] paramArrayOfString, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (FrameAnimationView.a(this.this$0))
    {
      QQAnimationDrawable localQQAnimationDrawable = new QQAnimationDrawable();
      localQQAnimationDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString);
      localQQAnimationDrawable.a(this.jdField_a_of_type_Int);
      localQQAnimationDrawable.b(this.jdField_a_of_type_Boolean);
      this.this$0.setBackgroundDrawable(localQQAnimationDrawable);
      localQQAnimationDrawable.a(this.jdField_a_of_type_Boolean, 2147483647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.FrameAnimationView.1
 * JD-Core Version:    0.7.0.1
 */