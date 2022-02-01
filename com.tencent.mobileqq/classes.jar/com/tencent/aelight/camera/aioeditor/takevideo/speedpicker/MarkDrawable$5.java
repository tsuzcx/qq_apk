package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class MarkDrawable$5
  extends D8SafeAnimatorListener
{
  MarkDrawable$5(MarkDrawable paramMarkDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("onAnimationCancel: mState:");
      paramAnimator.append(MarkDrawable.d(this.a));
      paramAnimator.append(" isrun:");
      paramAnimator.append(MarkDrawable.e(this.a));
      QLog.d("MarkDrawable", 2, paramAnimator.toString());
    }
    if (this.a.isRunning())
    {
      paramAnimator = this.a;
      MarkDrawable.f(paramAnimator, MarkDrawable.d(paramAnimator));
      if (MarkDrawable.d(this.a) == 2) {
        this.a.a(3);
      } else if (MarkDrawable.d(this.a) == 4) {
        this.a.a(5);
      } else if (MarkDrawable.d(this.a) == 5) {
        this.a.a(1);
      }
      MarkDrawable.a(this.a, false);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("onAnimationEnd: mState:");
      paramAnimator.append(MarkDrawable.d(this.a));
      paramAnimator.append(" isrun:");
      paramAnimator.append(MarkDrawable.e(this.a));
      QLog.d("MarkDrawable", 2, paramAnimator.toString());
    }
    if (this.a.isRunning())
    {
      paramAnimator = this.a;
      MarkDrawable.d(paramAnimator, MarkDrawable.d(paramAnimator));
      if (MarkDrawable.d(this.a) == 2)
      {
        this.a.a(3);
      }
      else if (MarkDrawable.d(this.a) == 4)
      {
        this.a.a(0);
      }
      else if (MarkDrawable.d(this.a) == 5)
      {
        this.a.a(1);
        MarkDrawable.e(this.a, 0);
      }
      else if (MarkDrawable.d(this.a) == 6)
      {
        this.a.a(2);
      }
      MarkDrawable.a(this.a, false);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("onAnimationStart: mState:");
      paramAnimator.append(MarkDrawable.d(this.a));
      paramAnimator.append(" isrun:");
      paramAnimator.append(MarkDrawable.e(this.a));
      QLog.d("MarkDrawable", 2, paramAnimator.toString());
    }
    if (this.a.isRunning())
    {
      paramAnimator = this.a;
      MarkDrawable.c(paramAnimator, MarkDrawable.d(paramAnimator));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.MarkDrawable.5
 * JD-Core Version:    0.7.0.1
 */