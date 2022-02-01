package com.tencent.mobileqq.activity.aio.navigate;

import ahqp;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TroopAppShortcutNavBar$1
  implements Runnable
{
  public TroopAppShortcutNavBar$1(ahqp paramahqp) {}
  
  public void run()
  {
    ahqp.a(this.this$0, AnimationUtils.loadAnimation(this.this$0.a, 2130772055));
    ahqp.a(this.this$0).clearAnimation();
    ahqp.a(this.this$0).startAnimation(ahqp.a(this.this$0));
    ahqp.a(this.this$0).setAnimationListener(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.1
 * JD-Core Version:    0.7.0.1
 */