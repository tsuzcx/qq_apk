package com.tencent.mobileqq.activity.pendant;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import java.util.List;

class AvatarPendantActivity$8
  implements ValueAnimator.AnimatorUpdateListener
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
  private IntEvaluator jdField_a_of_type_AndroidAnimationIntEvaluator = new IntEvaluator();
  
  AvatarPendantActivity$8(AvatarPendantActivity paramAvatarPendantActivity, List paramList1, List paramList2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() / 100.0F;
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      paramValueAnimator = (View)this.jdField_a_of_type_JavaUtilList.get(i);
      AvatarPendantActivity.AnimRect localAnimRect = (AvatarPendantActivity.AnimRect)this.b.get(i);
      ViewGroup.LayoutParams localLayoutParams = paramValueAnimator.getLayoutParams();
      if (localAnimRect.jdField_a_of_type_Int != localAnimRect.b)
      {
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)paramValueAnimator.getLayoutParams();
        localLayoutParams1.topMargin = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localAnimRect.jdField_a_of_type_Int), Integer.valueOf(localAnimRect.b)).intValue();
        paramValueAnimator.setLayoutParams(localLayoutParams1);
      }
      if (localAnimRect.c != localAnimRect.d) {
        localLayoutParams.height = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localAnimRect.c), Integer.valueOf(localAnimRect.d)).intValue();
      }
      if (localAnimRect.e != localAnimRect.f) {
        localLayoutParams.width = this.jdField_a_of_type_AndroidAnimationIntEvaluator.evaluate(f, Integer.valueOf(localAnimRect.e), Integer.valueOf(localAnimRect.f)).intValue();
      }
      paramValueAnimator.setLayoutParams(localLayoutParams);
      paramValueAnimator.requestLayout();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.8
 * JD-Core Version:    0.7.0.1
 */