package com.tencent.mobileqq.activity.aio.navigate;

import ahqq;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TroopDNANavBar$1
  implements Runnable
{
  public TroopDNANavBar$1(ahqq paramahqq) {}
  
  public void run()
  {
    ahqq.a(this.this$0, AnimationUtils.loadAnimation(this.this$0.a, 2130772055));
    ahqq.a(this.this$0).clearAnimation();
    ahqq.a(this.this$0).startAnimation(ahqq.a(this.this$0));
    ahqq.a(this.this$0).setAnimationListener(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar.1
 * JD-Core Version:    0.7.0.1
 */