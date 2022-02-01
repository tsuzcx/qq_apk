package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class f
  implements i
{
  public final Animator a(@NonNull View paramView)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F, 1.0F });
    paramView.setDuration(2000L);
    paramView.setInterpolator(new AccelerateInterpolator());
    paramView.setRepeatCount(-1);
    paramView.setRepeatMode(1);
    return paramView;
  }
  
  protected abstract void a(int paramInt);
  
  protected abstract void a(@Nullable Drawable paramDrawable);
  
  protected abstract void a(@Nullable CharSequence paramCharSequence);
  
  protected abstract void a(Runnable paramRunnable);
  
  protected abstract Context b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.f
 * JD-Core Version:    0.7.0.1
 */