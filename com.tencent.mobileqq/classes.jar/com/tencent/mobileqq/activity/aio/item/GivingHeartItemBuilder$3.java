package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;

class GivingHeartItemBuilder$3
  extends AnimatorListenerAdapter
{
  GivingHeartItemBuilder$3(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (this.a.A != null)
    {
      this.a.A.mImageLayer = null;
      paramAnimator = ((ViewGroup)((Activity)this.a.e).getWindow().getDecorView()).getChildAt(0).findViewById(2131427887);
      if (paramAnimator != null)
      {
        this.a.A.setDuration(this.a.z.getDuration());
        paramAnimator.startAnimation(this.a.A);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */