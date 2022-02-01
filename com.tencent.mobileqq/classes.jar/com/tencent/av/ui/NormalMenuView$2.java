package com.tencent.av.ui;

import android.animation.Animator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class NormalMenuView$2
  extends D8SafeAnimatorListener
{
  NormalMenuView$2(NormalMenuView paramNormalMenuView, int paramInt, long paramLong) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i;
    if (this.c.c != null)
    {
      i = this.c.c.getVisibility();
      if (!this.c.e)
      {
        this.c.c.setVisibility(8);
      }
      else
      {
        this.c.c.setVisibility(0);
        if (this.c.b != null) {
          this.c.b.a(this.b, this.c.c, false);
        }
      }
      this.c.c.setAlpha(1.0F);
      this.c.c.setTranslationY(0.0F);
    }
    else
    {
      i = 4;
    }
    if (this.c.e) {
      ThreadManager.getUIHandler().post(new NormalMenuView.2.1(this));
    }
    String str = this.c.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowMenuView, onAnimationEnd, isShow[");
    localStringBuilder.append(this.c.e);
    localStringBuilder.append("], visibility[");
    localStringBuilder.append(i);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], \nlastObjectAnimator[");
    localStringBuilder.append(this.c.f);
    localStringBuilder.append("], \nanimation[");
    localStringBuilder.append(paramAnimator);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.c.f == paramAnimator) {
      this.c.f = null;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    int i;
    if (this.c.c != null)
    {
      i = this.c.c.getVisibility();
      this.c.c.setVisibility(0);
    }
    else
    {
      i = 4;
    }
    paramAnimator = this.c.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowMenuView, onAnimationStart, height[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], isShow[");
    localStringBuilder.append(this.c.e);
    localStringBuilder.append("], visibility[");
    localStringBuilder.append(i);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.w(paramAnimator, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.NormalMenuView.2
 * JD-Core Version:    0.7.0.1
 */