package com.tencent.mobileqq.activity.qwallet;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.OvershootInterpolator;

class RedPacketPopFragment$1
  implements Runnable
{
  RedPacketPopFragment$1(RedPacketPopFragment paramRedPacketPopFragment) {}
  
  public void run()
  {
    this.this$0.c.setAlpha(0.3F);
    this.this$0.c.animate().alpha(1.0F).setDuration(200L);
    this.this$0.d.setAlpha(0.3F);
    this.this$0.d.setPivotX(this.this$0.d.getWidth() / 2);
    this.this$0.d.setPivotY(this.this$0.d.getHeight() / 2);
    this.this$0.d.setScaleX(0.5F);
    this.this$0.d.setScaleY(0.5F);
    this.this$0.d.animate().alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setDuration(300L).setInterpolator(new OvershootInterpolator(1.6F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketPopFragment.1
 * JD-Core Version:    0.7.0.1
 */