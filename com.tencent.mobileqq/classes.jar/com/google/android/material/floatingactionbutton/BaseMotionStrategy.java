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
  private final Context jdField_a_of_type_AndroidContentContext;
  @Nullable
  private MotionSpec jdField_a_of_type_ComGoogleAndroidMaterialAnimationMotionSpec;
  private final AnimatorTracker jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonAnimatorTracker;
  @NonNull
  private final ExtendedFloatingActionButton jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton;
  private final ArrayList<Animator.AnimatorListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  @Nullable
  private MotionSpec b;
  
  BaseMotionStrategy(@NonNull ExtendedFloatingActionButton paramExtendedFloatingActionButton, AnimatorTracker paramAnimatorTracker)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton = paramExtendedFloatingActionButton;
    this.jdField_a_of_type_AndroidContentContext = paramExtendedFloatingActionButton.getContext();
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonAnimatorTracker = paramAnimatorTracker;
  }
  
  public AnimatorSet a()
  {
    return a(a());
  }
  
  @NonNull
  AnimatorSet a(@NonNull MotionSpec paramMotionSpec)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMotionSpec.b("opacity")) {
      localArrayList.add(paramMotionSpec.a("opacity", this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, View.ALPHA));
    }
    if (paramMotionSpec.b("scale"))
    {
      localArrayList.add(paramMotionSpec.a("scale", this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, View.SCALE_Y));
      localArrayList.add(paramMotionSpec.a("scale", this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, View.SCALE_X));
    }
    if (paramMotionSpec.b("width")) {
      localArrayList.add(paramMotionSpec.a("width", this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, ExtendedFloatingActionButton.a));
    }
    if (paramMotionSpec.b("height")) {
      localArrayList.add(paramMotionSpec.a("height", this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, ExtendedFloatingActionButton.b));
    }
    if (paramMotionSpec.b("paddingStart")) {
      localArrayList.add(paramMotionSpec.a("paddingStart", this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, ExtendedFloatingActionButton.c));
    }
    if (paramMotionSpec.b("paddingEnd")) {
      localArrayList.add(paramMotionSpec.a("paddingEnd", this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, ExtendedFloatingActionButton.d));
    }
    if (paramMotionSpec.b("labelOpacity")) {
      localArrayList.add(paramMotionSpec.a("labelOpacity", this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, new BaseMotionStrategy.1(this, Float.class, "LABEL_OPACITY_PROPERTY")));
    }
    paramMotionSpec = new AnimatorSet();
    AnimatorSetCompat.a(paramMotionSpec, localArrayList);
    return paramMotionSpec;
  }
  
  public final MotionSpec a()
  {
    MotionSpec localMotionSpec = this.b;
    if (localMotionSpec != null) {
      return localMotionSpec;
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationMotionSpec == null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationMotionSpec = MotionSpec.a(this.jdField_a_of_type_AndroidContentContext, a());
    }
    return (MotionSpec)Preconditions.checkNotNull(this.jdField_a_of_type_ComGoogleAndroidMaterialAnimationMotionSpec);
  }
  
  @NonNull
  public final List<Animator.AnimatorListener> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  @CallSuper
  public void a()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonAnimatorTracker.b();
  }
  
  @CallSuper
  public void a(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonAnimatorTracker.a(paramAnimator);
  }
  
  public final void a(@Nullable MotionSpec paramMotionSpec)
  {
    this.b = paramMotionSpec;
  }
  
  @CallSuper
  public void b()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonAnimatorTracker.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.BaseMotionStrategy
 * JD-Core Version:    0.7.0.1
 */