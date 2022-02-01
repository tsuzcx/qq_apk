package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;

class SubscriptRecommendController$8
  implements Animation.AnimationListener
{
  SubscriptRecommendController$8(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    ((ViewGroup)this.a.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.a.jdField_a_of_type_AndroidViewView);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.a.b > 0) && (this.a.c > 0)) {
      ((ImageView)((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131373220)).setLayoutParams(new LinearLayout.LayoutParams(this.a.c, this.a.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.8
 * JD-Core Version:    0.7.0.1
 */