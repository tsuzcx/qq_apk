package com.tencent.biz.videostory.animator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class AnimationBuilder
{
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = null;
  private final ViewAnimator jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator;
  private final List<Animator> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private boolean b = false;
  
  public AnimationBuilder(ViewAnimator paramViewAnimator, View... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator = paramViewAnimator;
    this.jdField_a_of_type_ArrayOfAndroidViewView = paramVarArgs;
  }
  
  protected float a(float paramFloat)
  {
    return paramFloat * this.jdField_a_of_type_ArrayOfAndroidViewView[0].getContext().getResources().getDisplayMetrics().density;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ArrayOfAndroidViewView[0];
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  public AnimationBuilder a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator.a(paramLong);
    return this;
  }
  
  protected AnimationBuilder a(Animator paramAnimator)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramAnimator);
    return this;
  }
  
  public AnimationBuilder a(AnimationListener.Start paramStart)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator.a(paramStart);
    return this;
  }
  
  public AnimationBuilder a(AnimationListener.Update paramUpdate, float... paramVarArgs)
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(a(paramVarArgs));
      if (paramUpdate != null) {
        localValueAnimator.addUpdateListener(new AnimationBuilder.1(this, paramUpdate, localView));
      }
      a(localValueAnimator);
      i += 1;
    }
    return this;
  }
  
  public AnimationBuilder a(String paramString, float... paramVarArgs)
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      this.jdField_a_of_type_JavaUtilList.add(ObjectAnimator.ofFloat(localView, paramString, a(paramVarArgs)));
      i += 1;
    }
    return this;
  }
  
  public AnimationBuilder a(float... paramVarArgs)
  {
    return a("translationY", paramVarArgs);
  }
  
  public AnimationBuilder a(View... paramVarArgs)
  {
    return this.jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator.b(paramVarArgs);
  }
  
  public ViewAnimator a()
  {
    return this.jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator.a(new AccelerateInterpolator());
  }
  
  public ViewAnimator a(float paramFloat)
  {
    return this.jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator.a(new DecelerateInterpolator(paramFloat));
  }
  
  protected List<Animator> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected float[] a(float... paramVarArgs)
  {
    if (!this.b) {
      return paramVarArgs;
    }
    float[] arrayOfFloat = new float[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfFloat[i] = a(paramVarArgs[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public AnimationBuilder b(float... paramVarArgs)
  {
    return a("alpha", paramVarArgs);
  }
  
  public ViewAnimator b()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator.a();
    return this.jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator;
  }
  
  public AnimationBuilder c(float... paramVarArgs)
  {
    return a(new AnimationBuilder.2(this), paramVarArgs);
  }
  
  public AnimationBuilder d(float... paramVarArgs)
  {
    return a(new AnimationBuilder.3(this), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.AnimationBuilder
 * JD-Core Version:    0.7.0.1
 */