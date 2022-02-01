package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.app.Activity;
import android.view.animation.AnimationSet;
import android.widget.TextView;
import sro;

class FastWebAnimationUtils$2$1
  implements Runnable
{
  FastWebAnimationUtils$2$1(FastWebAnimationUtils.2 param2) {}
  
  public void run()
  {
    AnimationSet localAnimationSet = sro.a(this.this$0.jdField_a_of_type_AndroidWidgetTextView, this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.2.1
 * JD-Core Version:    0.7.0.1
 */