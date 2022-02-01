package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

abstract class BaseMotionStrategy
  implements MotionStrategy
{
  private final Context a;
  @NonNull
  private final ExtendedFloatingActionButton b;
  private final ArrayList<Animator.AnimatorListener> c = new ArrayList();
  private final AnimatorTracker d;
  @Nullable
  private MotionSpec e;
  @Nullable
  private MotionSpec f;
  
  BaseMotionStrategy(@NonNull ExtendedFloatingActionButton paramExtendedFloatingActionButton, AnimatorTracker paramAnimatorTracker)
  {
    this.b = paramExtendedFloatingActionButton;
    this.a = paramExtendedFloatingActionButton.getContext();
    this.d = paramAnimatorTracker;
  }
  
  public final MotionSpec a()
  {
    MotionSpec localMotionSpec = this.f;
    if (localMotionSpec != null) {
      return localMotionSpec;
    }
    if (this.e == null) {
      this.e = MotionSpec.a(this.a, h());
    }
    return (MotionSpec)Preconditions.checkNotNull(this.e);
  }
  
  @CallSuper
  public void a(Animator paramAnimator)
  {
    this.d.a(paramAnimator);
  }
  
  public final void a(@Nullable MotionSpec paramMotionSpec)
  {
    this.f = paramMotionSpec;
  }
  
  @NonNull
  AnimatorSet b(@NonNull MotionSpec paramMotionSpec)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMotionSpec.c("opacity")) {
      localArrayList.add(paramMotionSpec.a("opacity", this.b, View.ALPHA));
    }
    if (paramMotionSpec.c("scale"))
    {
      localArrayList.add(paramMotionSpec.a("scale", this.b, View.SCALE_Y));
      localArrayList.add(paramMotionSpec.a("scale", this.b, View.SCALE_X));
    }
    if (paramMotionSpec.c("width")) {
      localArrayList.add(paramMotionSpec.a("width", this.b, ExtendedFloatingActionButton.b));
    }
    if (paramMotionSpec.c("height")) {
      localArrayList.add(paramMotionSpec.a("height", this.b, ExtendedFloatingActionButton.c));
    }
    if (paramMotionSpec.c("paddingStart")) {
      localArrayList.add(paramMotionSpec.a("paddingStart", this.b, ExtendedFloatingActionButton.d));
    }
    if (paramMotionSpec.c("paddingEnd")) {
      localArrayList.add(paramMotionSpec.a("paddingEnd", this.b, ExtendedFloatingActionButton.e));
    }
    if (paramMotionSpec.c("labelOpacity")) {
      localArrayList.add(paramMotionSpec.a("labelOpacity", this.b, new BaseMotionStrategy.1(this, Float.class, "LABEL_OPACITY_PROPERTY")));
    }
    paramMotionSpec = new AnimatorSet();
    AnimatorSetCompat.a(paramMotionSpec, localArrayList);
    return paramMotionSpec;
  }
  
  @NonNull
  public final List<Animator.AnimatorListener> b()
  {
    return this.c;
  }
  
  @Nullable
  public MotionSpec c()
  {
    return this.f;
  }
  
  @CallSuper
  public void d()
  {
    this.d.b();
  }
  
  @CallSuper
  public void e()
  {
    this.d.b();
  }
  
  public AnimatorSet f()
  {
    return b(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.BaseMotionStrategy
 * JD-Core Version:    0.7.0.1
 */