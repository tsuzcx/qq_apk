package com.tencent.biz.richframework.animation.drawable;

import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import yyk;
import yyl;
import yym;
import yyr;

public class AnimationDrawableFactory$1$1
  implements Runnable
{
  public AnimationDrawableFactory$1$1(yym paramyym, String[] paramArrayOfString) {}
  
  public void run()
  {
    QQAnimationDrawable localQQAnimationDrawable = new QQAnimationDrawable();
    localQQAnimationDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString);
    if (this.jdField_a_of_type_Yym.jdField_a_of_type_Yyk.a() != 0) {
      localQQAnimationDrawable.a(this.jdField_a_of_type_Yym.jdField_a_of_type_Yyk.a());
    }
    for (;;)
    {
      QLog.d("AnimationDrawableFactory", 1, "create animationDrawable success");
      this.jdField_a_of_type_Yym.jdField_a_of_type_Yyr.a(true, localQQAnimationDrawable);
      if (this.jdField_a_of_type_Yym.jdField_a_of_type_Yyk.a()) {
        yyl.a(this.jdField_a_of_type_Yym.jdField_a_of_type_Yyl, this.jdField_a_of_type_Yym.jdField_a_of_type_Yyk.a(), localQQAnimationDrawable);
      }
      return;
      if (this.jdField_a_of_type_Yym.jdField_a_of_type_Yyk.b() != 0) {
        localQQAnimationDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString.length * this.jdField_a_of_type_Yym.jdField_a_of_type_Yyk.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1.1
 * JD-Core Version:    0.7.0.1
 */