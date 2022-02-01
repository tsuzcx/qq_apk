package com.dataline.activities;

import android.animation.Animator;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.widget.XEditTextEx;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

class LiteActivity$54
  extends D8SafeAnimatorListener
{
  LiteActivity$54(LiteActivity paramLiteActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LiteActivity.a(this.a).setPadding(0, AIOUtils.b(8.0F, this.a.app.getApplication().getResources()), 0, 0);
    this.a.q.getLayoutParams().height = -2;
    ((FrameLayout.LayoutParams)this.a.q.getLayoutParams()).setMargins(AIOUtils.b(14.0F, this.a.app.getApplication().getResources()), 0, 0, 0);
    this.a.q.setMaxLines(6);
    this.a.q.setBackgroundResource(2130851969);
    this.a.q.setGravity(16);
    this.a.q.setPadding(AIOUtils.b(11.0F, this.a.app.getApplication().getResources()), AIOUtils.b(6.0F, this.a.app.getApplication().getResources()), AIOUtils.b(11.0F, this.a.app.getApplication().getResources()), AIOUtils.b(6.0F, this.a.app.getApplication().getResources()));
    this.a.q.requestLayout();
    this.a.y.postDelayed(new LiteActivity.54.1(this), 100L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.54
 * JD-Core Version:    0.7.0.1
 */