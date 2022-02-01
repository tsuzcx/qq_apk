package com.google.android.material.progressindicator;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;

class BaseProgressIndicator$3
  extends Animatable2Compat.AnimationCallback
{
  BaseProgressIndicator$3(BaseProgressIndicator paramBaseProgressIndicator) {}
  
  public void onAnimationEnd(Drawable paramDrawable)
  {
    this.a.setIndeterminate(false);
    this.a.setProgressCompat(0, false);
    paramDrawable = this.a;
    paramDrawable.setProgressCompat(BaseProgressIndicator.c(paramDrawable), BaseProgressIndicator.d(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.BaseProgressIndicator.3
 * JD-Core Version:    0.7.0.1
 */