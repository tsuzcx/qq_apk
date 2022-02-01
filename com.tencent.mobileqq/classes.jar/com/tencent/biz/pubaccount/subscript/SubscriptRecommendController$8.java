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
    this.a.a.setVisibility(8);
    this.a.b.setVisibility(8);
    ((ViewGroup)this.a.b.getParent()).removeView(this.a.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.a.k > 0) && (this.a.l > 0)) {
      ((ImageView)((Activity)this.a.e.get()).findViewById(2131440829)).setLayoutParams(new LinearLayout.LayoutParams(this.a.l, this.a.k));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.8
 * JD-Core Version:    0.7.0.1
 */