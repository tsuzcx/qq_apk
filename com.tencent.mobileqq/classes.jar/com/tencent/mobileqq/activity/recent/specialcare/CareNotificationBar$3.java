package com.tencent.mobileqq.activity.recent.specialcare;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;

class CareNotificationBar$3
  implements Runnable
{
  CareNotificationBar$3(CareNotificationBar paramCareNotificationBar, View paramView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidViewView, "backgroundColor", new int[] { this.jdField_a_of_type_Int, this.b });
    localObjectAnimator1.setDuration(300L);
    localObjectAnimator1.setEvaluator(new ArgbEvaluator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidViewView, "backgroundColor", new int[] { this.b, this.jdField_a_of_type_Int });
    localObjectAnimator2.setDuration(300L);
    localObjectAnimator2.setEvaluator(new ArgbEvaluator());
    localObjectAnimator1.addListener(new CareNotificationBar.3.1(this, localObjectAnimator2));
    localObjectAnimator2.addListener(new CareNotificationBar.3.2(this));
    localObjectAnimator1.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3
 * JD-Core Version:    0.7.0.1
 */