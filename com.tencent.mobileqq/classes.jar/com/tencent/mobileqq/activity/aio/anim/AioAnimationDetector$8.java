package com.tencent.mobileqq.activity.aio.anim;

import aeqd;
import aeqf;
import aeqg;
import android.graphics.drawable.Drawable;

public class AioAnimationDetector$8
  implements Runnable
{
  public AioAnimationDetector$8(aeqd paramaeqd, AIOAnimationConatiner paramAIOAnimationConatiner, Drawable paramDrawable, int paramInt, aeqf paramaeqf) {}
  
  public void run()
  {
    AIOAnimationConatiner localAIOAnimationConatiner = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int j = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Aeqf.a == null) {}
    for (int i = -1;; i = this.jdField_a_of_type_Aeqf.a.jdField_a_of_type_Int)
    {
      localAIOAnimationConatiner.a(2, 300, new Object[] { localDrawable, Integer.valueOf(j), Integer.valueOf(i) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector.8
 * JD-Core Version:    0.7.0.1
 */