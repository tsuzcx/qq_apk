package com.tencent.biz.richframework.animation.drawable;

import com.tencent.biz.richframework.delegate.impl.RFLog;

class AnimationDrawableFactory$1$1
  implements Runnable
{
  AnimationDrawableFactory$1$1(AnimationDrawableFactory.1 param1, String[] paramArrayOfString) {}
  
  public void run()
  {
    QQAnimationDrawable localQQAnimationDrawable = new QQAnimationDrawable();
    localQQAnimationDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString);
    if (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$1.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableCreateOption.a() != 0) {
      localQQAnimationDrawable.a(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$1.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableCreateOption.a());
    }
    for (;;)
    {
      RFLog.d("AnimationDrawableFactory", RFLog.USR, "create animationDrawable success");
      this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$1.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateResultListener.a(true, localQQAnimationDrawable);
      if (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$1.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableCreateOption.a()) {
        AnimationDrawableFactory.a(this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$1.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory, this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$1.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableCreateOption.a(), localQQAnimationDrawable);
      }
      return;
      if (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$1.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableCreateOption.b() != 0) {
        localQQAnimationDrawable.a(this.jdField_a_of_type_ArrayOfJavaLangString.length * this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$1.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableCreateOption.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1.1
 * JD-Core Version:    0.7.0.1
 */