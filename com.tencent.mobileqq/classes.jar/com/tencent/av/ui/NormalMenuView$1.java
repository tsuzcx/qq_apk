package com.tencent.av.ui;

import android.animation.Animator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class NormalMenuView$1
  extends D8SafeAnimatorListener
{
  NormalMenuView$1(NormalMenuView paramNormalMenuView, int paramInt, long paramLong, QavPanel.OnDismissAnimationEndListener paramOnDismissAnimationEndListener) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    Object localObject = this.d;
    ((NormalMenuView)localObject).e = false;
    int i;
    if (((NormalMenuView)localObject).c != null)
    {
      i = this.d.c.getVisibility();
      if (!this.d.e) {
        this.d.c.setVisibility(8);
      } else if (this.d.b != null) {
        this.d.b.b(this.b, this.d.c, false);
      }
      this.d.c.setAlpha(1.0F);
      this.d.c.setTranslationY(0.0F);
    }
    else
    {
      i = 4;
    }
    localObject = this.d.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiddenMenuView, onAnimationEnd, isShow[");
    localStringBuilder.append(this.d.e);
    localStringBuilder.append("], visibility[");
    localStringBuilder.append(i);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], \nlastObjectAnimator[");
    localStringBuilder.append(this.d.f);
    localStringBuilder.append("], \nanimation[");
    localStringBuilder.append(paramAnimator);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.d.f == paramAnimator)
    {
      ThreadManager.getUIHandler().post(new NormalMenuView.1.1(this));
      this.d.f = null;
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    int i;
    if (this.d.c != null) {
      i = this.d.c.getVisibility();
    } else {
      i = 4;
    }
    paramAnimator = this.d.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiddenMenuView, onAnimationStart, isShow[");
    localStringBuilder.append(this.d.e);
    localStringBuilder.append("], height[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], visibility[");
    localStringBuilder.append(i);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.w(paramAnimator, 1, localStringBuilder.toString());
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.NormalMenuView.1
 * JD-Core Version:    0.7.0.1
 */