package com.tencent.biz.videostory.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ViewAnimator
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 3000L;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView = null;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = null;
  private AnimationListener.Cancel jdField_a_of_type_ComTencentBizVideostoryAnimatorAnimationListener$Cancel;
  private AnimationListener.Repeat jdField_a_of_type_ComTencentBizVideostoryAnimatorAnimationListener$Repeat;
  private AnimationListener.Start jdField_a_of_type_ComTencentBizVideostoryAnimatorAnimationListener$Start;
  private AnimationListener.Stop jdField_a_of_type_ComTencentBizVideostoryAnimatorAnimationListener$Stop;
  private ViewAnimator jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator = null;
  private List<AnimationBuilder> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long = 0L;
  private ViewAnimator jdField_b_of_type_ComTencentBizVideostoryAnimatorViewAnimator = null;
  
  public static AnimationBuilder a(View... paramVarArgs)
  {
    return new ViewAnimator().b(paramVarArgs);
  }
  
  protected AnimatorSet a()
  {
    this.jdField_a_of_type_Boolean = false;
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AnimationBuilder)((Iterator)localObject2).next();
      List localList = ((AnimationBuilder)localObject3).a();
      if (((AnimationBuilder)localObject3).a() != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          ((Animator)localIterator.next()).setInterpolator(((AnimationBuilder)localObject3).a());
        }
      }
      ((List)localObject1).addAll(localList);
    }
    localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AnimationBuilder)((Iterator)localObject2).next();
      if (((AnimationBuilder)localObject3).a()) {
        this.jdField_a_of_type_AndroidViewView = ((AnimationBuilder)localObject3).a();
      }
    }
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Animator)((Iterator)localObject2).next();
      if ((localObject3 instanceof ValueAnimator))
      {
        localObject3 = (ValueAnimator)localObject3;
        ((ValueAnimator)localObject3).setRepeatCount(this.jdField_a_of_type_Int);
        ((ValueAnimator)localObject3).setRepeatMode(this.jdField_b_of_type_Int);
        if (!this.jdField_a_of_type_Boolean)
        {
          ((ValueAnimator)localObject3).addListener(new ViewAnimator.1(this));
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
    localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).playTogether((Collection)localObject1);
    ((AnimatorSet)localObject2).setDuration(this.jdField_a_of_type_Long);
    ((AnimatorSet)localObject2).setStartDelay(this.jdField_b_of_type_Long);
    localObject1 = this.jdField_a_of_type_AndroidViewAnimationInterpolator;
    if (localObject1 != null) {
      ((AnimatorSet)localObject2).setInterpolator((TimeInterpolator)localObject1);
    }
    ((AnimatorSet)localObject2).addListener(new ViewAnimator.2(this));
    return localObject2;
  }
  
  public ViewAnimator a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator;
    if (localObject != null)
    {
      ((ViewAnimator)localObject).a();
      return this;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = a();
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).getViewTreeObserver().addOnPreDrawListener(new ViewAnimator.3(this));
      return this;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    return this;
  }
  
  public ViewAnimator a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public ViewAnimator a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    return this;
  }
  
  public ViewAnimator a(AnimationListener.Start paramStart)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryAnimatorAnimationListener$Start = paramStart;
    return this;
  }
  
  public ViewAnimator a(AnimationListener.Stop paramStop)
  {
    this.jdField_a_of_type_ComTencentBizVideostoryAnimatorAnimationListener$Stop = paramStop;
    return this;
  }
  
  public AnimationBuilder b(View... paramVarArgs)
  {
    paramVarArgs = new AnimationBuilder(this, paramVarArgs);
    this.jdField_a_of_type_JavaUtilList.add(paramVarArgs);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.ViewAnimator
 * JD-Core Version:    0.7.0.1
 */