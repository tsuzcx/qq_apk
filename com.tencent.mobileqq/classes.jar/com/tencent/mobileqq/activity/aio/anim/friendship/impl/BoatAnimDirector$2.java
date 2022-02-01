package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import afws;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class BoatAnimDirector$2
  implements Runnable
{
  public BoatAnimDirector$2(afws paramafws) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      this.this$0.a.setBackgroundColor(-1442840576);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(300L);
      this.this$0.a.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.BoatAnimDirector.2
 * JD-Core Version:    0.7.0.1
 */