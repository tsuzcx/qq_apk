package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

class SpringHbVideoView$8
  implements Runnable
{
  SpringHbVideoView$8(SpringHbVideoView paramSpringHbVideoView) {}
  
  public void run()
  {
    if (SpringHbVideoView.a(this.this$0) != null)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
      localAlphaAnimation.setStartOffset(1000L);
      localAlphaAnimation.setDuration(1000L);
      SpringHbVideoView.a(this.this$0).setAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbVideoView.8
 * JD-Core Version:    0.7.0.1
 */