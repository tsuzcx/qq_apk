package com.tencent.mobileqq.activity.aio.navigate;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

class TroopDNANavBar$1
  implements Runnable
{
  TroopDNANavBar$1(TroopDNANavBar paramTroopDNANavBar) {}
  
  public void run()
  {
    TroopDNANavBar.a(this.this$0, AnimationUtils.loadAnimation(this.this$0.a, 2130772073));
    TroopDNANavBar.a(this.this$0).clearAnimation();
    TroopDNANavBar.a(this.this$0).startAnimation(TroopDNANavBar.a(this.this$0));
    TroopDNANavBar.a(this.this$0).setAnimationListener(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar.1
 * JD-Core Version:    0.7.0.1
 */