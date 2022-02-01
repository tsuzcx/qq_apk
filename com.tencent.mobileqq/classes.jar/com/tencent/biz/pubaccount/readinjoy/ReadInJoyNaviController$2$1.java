package com.tencent.biz.pubaccount.readinjoy;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

class ReadInJoyNaviController$2$1
  implements Animation.AnimationListener
{
  ReadInJoyNaviController$2$1(ReadInJoyNaviController.2 param2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadInJoyNaviController.a(this.a.this$0, true);
    ReadInJoyNaviController.a(this.a.this$0).setAlpha(0.0F);
    ReadInJoyNaviController.a(this.a.this$0).removeView(ReadInJoyNaviController.a(this.a.this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.2.1
 * JD-Core Version:    0.7.0.1
 */