package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.util.LinkedList;

class d$5
  extends AnimatorListenerAdapter
{
  d$5(d paramd, View paramView, i parami) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setVisibility(8);
    d.b(this.c).remove(this.b);
    d.a(this.c, null);
    this.c.post(new d.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.d.5
 * JD-Core Version:    0.7.0.1
 */