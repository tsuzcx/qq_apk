package com.tencent.biz.richframework.animation.drawable;

import com.tencent.qphone.base.util.QLog;

class AnimationDrawableFactory$1$1
  implements Runnable
{
  AnimationDrawableFactory$1$1(AnimationDrawableFactory.1 param1, String[] paramArrayOfString) {}
  
  public void run()
  {
    QQAnimationDrawable localQQAnimationDrawable = new QQAnimationDrawable();
    localQQAnimationDrawable.a(this.a);
    if (this.b.b.d() != 0) {
      localQQAnimationDrawable.a(this.b.b.d());
    } else if (this.b.b.e() != 0) {
      localQQAnimationDrawable.a(this.a.length * this.b.b.e());
    }
    QLog.d("AnimationDrawableFactory", 1, "create animationDrawable success");
    this.b.d.a(true, localQQAnimationDrawable);
    if (this.b.b.b()) {
      AnimationDrawableFactory.a(this.b.e, this.b.b.a(), localQQAnimationDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1.1
 * JD-Core Version:    0.7.0.1
 */