package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.Animator;
import android.graphics.RectF;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class GroundDrawable$10
  extends D8SafeAnimatorListener
{
  GroundDrawable$10(GroundDrawable paramGroundDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (GroundDrawable.n(this.a))
    {
      GroundDrawable.a(this.a, false);
      paramAnimator = this.a;
      GroundDrawable.g(paramAnimator, GroundDrawable.i(paramAnimator));
      if (GroundDrawable.i(this.a) == 1)
      {
        this.a.a(2);
        return;
      }
      if (GroundDrawable.i(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
      if (GroundDrawable.i(this.a) == 4)
      {
        if ((GroundDrawable.j(this.a)) && (GroundDrawable.k(this.a) != null))
        {
          paramAnimator = (GroundDrawable.GroundDrawableListener)GroundDrawable.k(this.a).get();
          if (paramAnimator != null)
          {
            RectF localRectF = GroundDrawable.m(this.a).a(GroundDrawable.l(this.a));
            if (localRectF != null)
            {
              paramAnimator.a(GroundDrawable.i(this.a), GroundDrawable.l(this.a), localRectF);
            }
            else
            {
              paramAnimator = new StringBuilder();
              paramAnimator.append("onGroundMarkSelected error 2 !! rc is null:");
              paramAnimator.append(GroundDrawable.l(this.a));
              QLog.d("GroundDrawable", 2, paramAnimator.toString());
            }
            GroundDrawable.b(this.a, false);
          }
        }
        this.a.a(0);
      }
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      GroundDrawable.a(this.a, false);
      paramAnimator = this.a;
      GroundDrawable.f(paramAnimator, GroundDrawable.i(paramAnimator));
      if (GroundDrawable.i(this.a) == 1)
      {
        this.a.a(2);
        return;
      }
      if (GroundDrawable.i(this.a) == 3)
      {
        this.a.a(0);
        return;
      }
      if (GroundDrawable.i(this.a) == 4)
      {
        if ((GroundDrawable.j(this.a)) && (GroundDrawable.k(this.a) != null))
        {
          paramAnimator = (GroundDrawable.GroundDrawableListener)GroundDrawable.k(this.a).get();
          if (paramAnimator != null)
          {
            RectF localRectF = GroundDrawable.m(this.a).a(GroundDrawable.l(this.a));
            if (localRectF != null)
            {
              paramAnimator.a(GroundDrawable.i(this.a), GroundDrawable.l(this.a), localRectF);
            }
            else
            {
              paramAnimator = new StringBuilder();
              paramAnimator.append("onGroundMarkSelected error!! rc is null:");
              paramAnimator.append(GroundDrawable.l(this.a));
              QLog.d("GroundDrawable", 2, paramAnimator.toString());
            }
            GroundDrawable.b(this.a, false);
          }
        }
        this.a.a(0);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.isRunning())
    {
      paramAnimator = this.a;
      GroundDrawable.e(paramAnimator, GroundDrawable.i(paramAnimator));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.GroundDrawable.10
 * JD-Core Version:    0.7.0.1
 */