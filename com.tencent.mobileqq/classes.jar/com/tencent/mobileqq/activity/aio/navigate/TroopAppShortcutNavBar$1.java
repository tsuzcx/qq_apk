package com.tencent.mobileqq.activity.aio.navigate;

import ahpr;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TroopAppShortcutNavBar$1
  implements Runnable
{
  public TroopAppShortcutNavBar$1(ahpr paramahpr) {}
  
  public void run()
  {
    ahpr.a(this.this$0, AnimationUtils.loadAnimation(this.this$0.a, 2130772057));
    ahpr.a(this.this$0).clearAnimation();
    ahpr.a(this.this$0).startAnimation(ahpr.a(this.this$0));
    ahpr.a(this.this$0).setAnimationListener(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.1
 * JD-Core Version:    0.7.0.1
 */