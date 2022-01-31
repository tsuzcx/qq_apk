package com.tencent.mobileqq.activity.aio.navigate;

import agcg;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TroopAppShortcutNavBar$1
  implements Runnable
{
  public TroopAppShortcutNavBar$1(agcg paramagcg) {}
  
  public void run()
  {
    agcg.a(this.this$0, AnimationUtils.loadAnimation(this.this$0.a, 2130772054));
    agcg.a(this.this$0).clearAnimation();
    agcg.a(this.this$0).startAnimation(agcg.a(this.this$0));
    agcg.a(this.this$0).setAnimationListener(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.1
 * JD-Core Version:    0.7.0.1
 */