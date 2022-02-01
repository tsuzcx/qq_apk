package com.tencent.biz.richframework.animation.drawable;

import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import zve;
import zvh;
import zvi;
import zvn;

public class AnimationDrawableFactory$1$1
  implements Runnable
{
  public AnimationDrawableFactory$1$1(zvi paramzvi, String[] paramArrayOfString) {}
  
  public void run()
  {
    QQAnimationDrawable localQQAnimationDrawable = new QQAnimationDrawable();
    localQQAnimationDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString);
    if (this.jdField_a_of_type_Zvi.jdField_a_of_type_Zve.a() != 0) {
      localQQAnimationDrawable.a(this.jdField_a_of_type_Zvi.jdField_a_of_type_Zve.a());
    }
    for (;;)
    {
      QLog.d("AnimationDrawableFactory", 1, "create animationDrawable success");
      this.jdField_a_of_type_Zvi.jdField_a_of_type_Zvn.a(true, localQQAnimationDrawable);
      if (this.jdField_a_of_type_Zvi.jdField_a_of_type_Zve.a()) {
        zvh.a(this.jdField_a_of_type_Zvi.jdField_a_of_type_Zvh, this.jdField_a_of_type_Zvi.jdField_a_of_type_Zve.a(), localQQAnimationDrawable);
      }
      return;
      if (this.jdField_a_of_type_Zvi.jdField_a_of_type_Zve.b() != 0) {
        localQQAnimationDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString.length * this.jdField_a_of_type_Zvi.jdField_a_of_type_Zve.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1.1
 * JD-Core Version:    0.7.0.1
 */