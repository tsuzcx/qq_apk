package com.google.android.material.progressindicator;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;

class BaseProgressIndicator$4
  extends Animatable2Compat.AnimationCallback
{
  BaseProgressIndicator$4(BaseProgressIndicator paramBaseProgressIndicator) {}
  
  public void onAnimationEnd(Drawable paramDrawable)
  {
    super.onAnimationEnd(paramDrawable);
    if (!BaseProgressIndicator.e(this.a))
    {
      paramDrawable = this.a;
      paramDrawable.setVisibility(BaseProgressIndicator.f(paramDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.BaseProgressIndicator.4
 * JD-Core Version:    0.7.0.1
 */