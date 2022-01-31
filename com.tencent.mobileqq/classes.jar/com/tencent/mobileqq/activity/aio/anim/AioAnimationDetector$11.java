package com.tencent.mobileqq.activity.aio.anim;

import acyt;
import acyu;
import acyv;
import android.graphics.drawable.Drawable;

public class AioAnimationDetector$11
  implements Runnable
{
  public AioAnimationDetector$11(acyt paramacyt, AIOAnimationConatiner paramAIOAnimationConatiner, Drawable paramDrawable, acyu paramacyu) {}
  
  public void run()
  {
    AIOAnimationConatiner localAIOAnimationConatiner = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (this.jdField_a_of_type_Acyu.a == null) {}
    for (int i = -1;; i = this.jdField_a_of_type_Acyu.a.a)
    {
      localAIOAnimationConatiner.a(2, 300, new Object[] { localDrawable, Integer.valueOf(0), Integer.valueOf(i) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.11
 * JD-Core Version:    0.7.0.1
 */