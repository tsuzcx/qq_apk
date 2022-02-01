package com.tencent.av.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.VideoController;

class QavInOutAnimation$InDelayAnimationListener
  implements Animation.AnimationListener
{
  QavInOutAnimation$InDelayAnimationListener(QavInOutAnimation paramQavInOutAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.i != null)
    {
      this.a.i.clearAnimation();
      this.a.i.startAnimation(this.a.o);
      if (this.a.i.getWave() != null) {
        this.a.i.getWave().startAnimation(this.a.p);
      }
    }
    if (this.a.b != null)
    {
      this.a.b.clearAnimation();
      if (this.a.b.getVisibility() == 0) {
        this.a.b.startAnimation(this.a.l);
      }
    }
    if (this.a.c != null)
    {
      this.a.c.clearAnimation();
      if (this.a.c.getVisibility() == 0) {
        this.a.c.startAnimation(this.a.m);
      }
    }
    if (this.a.d != null)
    {
      this.a.d.clearAnimation();
      if (this.a.d.getVisibility() == 0) {
        this.a.d.startAnimation(this.a.m);
      }
    }
    if (this.a.e != null)
    {
      this.a.e.clearAnimation();
      if (this.a.e.getVisibility() == 0) {
        this.a.e.startAnimation(this.a.n);
      }
    }
    if (this.a.f != null)
    {
      this.a.f.clearAnimation();
      if (this.a.f.getVisibility() == 0) {
        this.a.f.startAnimation(this.a.n);
      }
    }
    if (this.a.h != null)
    {
      this.a.h.clearAnimation();
      if (this.a.h.getVisibility() == 0) {
        this.a.h.startAnimation(this.a.n);
      }
    }
    if ((this.a.x != null) && (this.a.x.k() != null)) {
      this.a.x.k().bD = true;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavInOutAnimation.InDelayAnimationListener
 * JD-Core Version:    0.7.0.1
 */