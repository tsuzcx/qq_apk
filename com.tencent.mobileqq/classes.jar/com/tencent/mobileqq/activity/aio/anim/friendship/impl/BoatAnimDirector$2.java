package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

class BoatAnimDirector$2
  implements Runnable
{
  BoatAnimDirector$2(BoatAnimDirector paramBoatAnimDirector) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      this.this$0.b.setBackgroundColor(-1442840576);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(300L);
      this.this$0.b.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.BoatAnimDirector.2
 * JD-Core Version:    0.7.0.1
 */