package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.view.animation.AnimationSet;
import android.widget.TextView;
import tas;

public final class FastWebAnimationUtils$2
  implements Runnable
{
  public FastWebAnimationUtils$2(TextView paramTextView, Activity paramActivity) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView.getX() == 0.0F)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.post(new FastWebAnimationUtils.2.1(this));
      return;
    }
    AnimationSet localAnimationSet = tas.a(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.2
 * JD-Core Version:    0.7.0.1
 */