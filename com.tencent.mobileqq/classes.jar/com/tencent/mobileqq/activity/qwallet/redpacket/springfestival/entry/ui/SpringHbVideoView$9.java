package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

class SpringHbVideoView$9
  implements Runnable
{
  SpringHbVideoView$9(SpringHbVideoView paramSpringHbVideoView) {}
  
  public void run()
  {
    if (SpringHbVideoView.a(this.this$0) != null)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
      localAlphaAnimation.setDuration(1000L);
      SpringHbVideoView.a(this.this$0).startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbVideoView.9
 * JD-Core Version:    0.7.0.1
 */