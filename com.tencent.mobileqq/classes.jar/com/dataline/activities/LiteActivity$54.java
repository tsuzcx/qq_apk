package com.dataline.activities;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XEditTextEx;
import mqq.app.MobileQQ;

class LiteActivity$54
  implements Animator.AnimatorListener
{
  LiteActivity$54(LiteActivity paramLiteActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LiteActivity.a(this.a).setPadding(0, 0, 0, 0);
    ((FrameLayout.LayoutParams)this.a.a.getLayoutParams()).setMargins(0, 0, 0, 0);
    this.a.a.setPadding(AIOUtils.a(24.0F, this.a.app.getApplication().getResources()), AIOUtils.a(10.0F, this.a.app.getApplication().getResources()), AIOUtils.a(24.0F, this.a.app.getApplication().getResources()), 0);
    LiteActivity.a(this.a).getLayoutParams().height = -1;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.54
 * JD-Core Version:    0.7.0.1
 */