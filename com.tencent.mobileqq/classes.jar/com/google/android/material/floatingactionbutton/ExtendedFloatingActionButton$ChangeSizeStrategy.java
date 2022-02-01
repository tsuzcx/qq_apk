package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.animator;
import com.google.android.material.animation.MotionSpec;

class ExtendedFloatingActionButton$ChangeSizeStrategy
  extends BaseMotionStrategy
{
  private final ExtendedFloatingActionButton.Size b;
  private final boolean c;
  
  ExtendedFloatingActionButton$ChangeSizeStrategy(ExtendedFloatingActionButton paramExtendedFloatingActionButton, AnimatorTracker paramAnimatorTracker, ExtendedFloatingActionButton.Size paramSize, boolean paramBoolean)
  {
    super(paramExtendedFloatingActionButton, paramAnimatorTracker);
    this.b = paramSize;
    this.c = paramBoolean;
  }
  
  public void a(Animator paramAnimator)
  {
    super.a(paramAnimator);
    ExtendedFloatingActionButton.a(this.a, this.c);
    ExtendedFloatingActionButton.b(this.a, true);
    this.a.setHorizontallyScrolling(true);
  }
  
  public void a(@Nullable ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback)
  {
    if (paramOnChangedCallback == null) {
      return;
    }
    if (this.c)
    {
      paramOnChangedCallback.c(this.a);
      return;
    }
    paramOnChangedCallback.d(this.a);
  }
  
  public void d()
  {
    super.d();
    ExtendedFloatingActionButton.b(this.a, false);
    this.a.setHorizontallyScrolling(false);
    ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
    if (localLayoutParams == null) {
      return;
    }
    localLayoutParams.width = this.b.e().width;
    localLayoutParams.height = this.b.e().height;
  }
  
  @NonNull
  public AnimatorSet f()
  {
    MotionSpec localMotionSpec = a();
    PropertyValuesHolder[] arrayOfPropertyValuesHolder;
    if (localMotionSpec.c("width"))
    {
      arrayOfPropertyValuesHolder = localMotionSpec.d("width");
      arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { this.a.getWidth(), this.b.a() });
      localMotionSpec.a("width", arrayOfPropertyValuesHolder);
    }
    if (localMotionSpec.c("height"))
    {
      arrayOfPropertyValuesHolder = localMotionSpec.d("height");
      arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { this.a.getHeight(), this.b.b() });
      localMotionSpec.a("height", arrayOfPropertyValuesHolder);
    }
    if (localMotionSpec.c("paddingStart"))
    {
      arrayOfPropertyValuesHolder = localMotionSpec.d("paddingStart");
      arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { ViewCompat.getPaddingStart(this.a), this.b.c() });
      localMotionSpec.a("paddingStart", arrayOfPropertyValuesHolder);
    }
    if (localMotionSpec.c("paddingEnd"))
    {
      arrayOfPropertyValuesHolder = localMotionSpec.d("paddingEnd");
      arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { ViewCompat.getPaddingEnd(this.a), this.b.d() });
      localMotionSpec.a("paddingEnd", arrayOfPropertyValuesHolder);
    }
    if (localMotionSpec.c("labelOpacity"))
    {
      arrayOfPropertyValuesHolder = localMotionSpec.d("labelOpacity");
      boolean bool = this.c;
      float f2 = 0.0F;
      float f1;
      if (bool) {
        f1 = 0.0F;
      } else {
        f1 = 1.0F;
      }
      if (this.c) {
        f2 = 1.0F;
      }
      arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { f1, f2 });
      localMotionSpec.a("labelOpacity", arrayOfPropertyValuesHolder);
    }
    return super.b(localMotionSpec);
  }
  
  public void g()
  {
    ExtendedFloatingActionButton.a(this.a, this.c);
    ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
    if (localLayoutParams == null) {
      return;
    }
    localLayoutParams.width = this.b.e().width;
    localLayoutParams.height = this.b.e().height;
    ViewCompat.setPaddingRelative(this.a, this.b.c(), this.a.getPaddingTop(), this.b.d(), this.a.getPaddingBottom());
    this.a.requestLayout();
  }
  
  public int h()
  {
    if (this.c) {
      return R.animator.h;
    }
    return R.animator.g;
  }
  
  public boolean i()
  {
    return (this.c == ExtendedFloatingActionButton.g(this.a)) || (this.a.getIcon() == null) || (TextUtils.isEmpty(this.a.getText()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ChangeSizeStrategy
 * JD-Core Version:    0.7.0.1
 */