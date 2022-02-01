package com.tencent.mobileqq.activity.aio.navigate;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

class IntimateInfoNavBar$1
  implements Runnable
{
  IntimateInfoNavBar$1(IntimateInfoNavBar paramIntimateInfoNavBar) {}
  
  public void run()
  {
    IntimateInfoNavBar localIntimateInfoNavBar = this.this$0;
    IntimateInfoNavBar.a(localIntimateInfoNavBar, AnimationUtils.loadAnimation(localIntimateInfoNavBar.c, 2130772145));
    IntimateInfoNavBar.a(this.this$0).clearAnimation();
    IntimateInfoNavBar.a(this.this$0).startAnimation(IntimateInfoNavBar.b(this.this$0));
    IntimateInfoNavBar.b(this.this$0).setAnimationListener(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.IntimateInfoNavBar.1
 * JD-Core Version:    0.7.0.1
 */