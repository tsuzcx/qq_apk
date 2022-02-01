package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.google.android.material.internal.CheckableImageButton;

class DropdownMenuEndIconDelegate$9
  extends AnimatorListenerAdapter
{
  DropdownMenuEndIconDelegate$9(DropdownMenuEndIconDelegate paramDropdownMenuEndIconDelegate) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c.setChecked(DropdownMenuEndIconDelegate.f(this.a));
    DropdownMenuEndIconDelegate.g(this.a).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.DropdownMenuEndIconDelegate.9
 * JD-Core Version:    0.7.0.1
 */