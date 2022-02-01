package com.tencent.biz.richframework.animation.drawable;

import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import zyz;
import zzc;
import zzd;
import zzi;

public class AnimationDrawableFactory$1$1
  implements Runnable
{
  public AnimationDrawableFactory$1$1(zzd paramzzd, String[] paramArrayOfString) {}
  
  public void run()
  {
    QQAnimationDrawable localQQAnimationDrawable = new QQAnimationDrawable();
    localQQAnimationDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString);
    if (this.jdField_a_of_type_Zzd.jdField_a_of_type_Zyz.a() != 0) {
      localQQAnimationDrawable.a(this.jdField_a_of_type_Zzd.jdField_a_of_type_Zyz.a());
    }
    for (;;)
    {
      QLog.d("AnimationDrawableFactory", 1, "create animationDrawable success");
      this.jdField_a_of_type_Zzd.jdField_a_of_type_Zzi.a(true, localQQAnimationDrawable);
      if (this.jdField_a_of_type_Zzd.jdField_a_of_type_Zyz.a()) {
        zzc.a(this.jdField_a_of_type_Zzd.jdField_a_of_type_Zzc, this.jdField_a_of_type_Zzd.jdField_a_of_type_Zyz.a(), localQQAnimationDrawable);
      }
      return;
      if (this.jdField_a_of_type_Zzd.jdField_a_of_type_Zyz.b() != 0) {
        localQQAnimationDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString.length * this.jdField_a_of_type_Zzd.jdField_a_of_type_Zyz.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1.1
 * JD-Core Version:    0.7.0.1
 */