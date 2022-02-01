package com.tencent.biz.richframework.animation.drawable;

import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import znn;
import znq;
import znr;
import znw;

public class AnimationDrawableFactory$1$1
  implements Runnable
{
  public AnimationDrawableFactory$1$1(znr paramznr, String[] paramArrayOfString) {}
  
  public void run()
  {
    QQAnimationDrawable localQQAnimationDrawable = new QQAnimationDrawable();
    localQQAnimationDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString);
    if (this.jdField_a_of_type_Znr.jdField_a_of_type_Znn.a() != 0) {
      localQQAnimationDrawable.a(this.jdField_a_of_type_Znr.jdField_a_of_type_Znn.a());
    }
    for (;;)
    {
      QLog.d("AnimationDrawableFactory", 1, "create animationDrawable success");
      this.jdField_a_of_type_Znr.jdField_a_of_type_Znw.a(true, localQQAnimationDrawable);
      if (this.jdField_a_of_type_Znr.jdField_a_of_type_Znn.a()) {
        znq.a(this.jdField_a_of_type_Znr.jdField_a_of_type_Znq, this.jdField_a_of_type_Znr.jdField_a_of_type_Znn.a(), localQQAnimationDrawable);
      }
      return;
      if (this.jdField_a_of_type_Znr.jdField_a_of_type_Znn.b() != 0) {
        localQQAnimationDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString.length * this.jdField_a_of_type_Znr.jdField_a_of_type_Znn.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1.1
 * JD-Core Version:    0.7.0.1
 */