package com.tencent.mobileqq.activity.contact.addcontact;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;

class AddContactsActivity$2$3
  implements ValueAnimator.AnimatorUpdateListener
{
  AddContactsActivity$2$3(AddContactsActivity.2 param2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (FrameLayout.LayoutParams)this.a.a.a.getLayoutParams();
    paramValueAnimator.topMargin = i;
    this.a.a.a.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity.2.3
 * JD-Core Version:    0.7.0.1
 */