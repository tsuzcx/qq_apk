package com.tencent.biz.videostory.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import java.util.ArrayList;
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
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AnimationBuilder)((Iterator)localObject1).next();
      List localList = ((AnimationBuilder)localObject2).a();
      if (((AnimationBuilder)localObject2).a() != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          ((Animator)localIterator.next()).setInterpolator(((AnimationBuilder)localObject2).a());
        }
      }
      localArrayList.addAll(localList);
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AnimationBuilder)((Iterator)localObject1).next();
      if (((AnimationBuilder)localObject2).a()) {
        this.jdField_a_of_type_AndroidViewView = ((AnimationBuilder)localObject2).a();
      }
    }
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Animator)((Iterator)localObject1).next();
      if ((localObject2 instanceof ValueAnimator))
      {
        localObject2 = (ValueAnimator)localObject2;
        ((ValueAnimator)localObject2).setRepeatCount(this.jdField_a_of_type_Int);
        ((ValueAnimator)localObject2).setRepeatMode(this.jdField_b_of_type_Int);
        if (!this.jdField_a_of_type_Boolean)
        {
          ((ValueAnimator)localObject2).addListener(new ViewAnimator.1(this));
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(localArrayList);
    ((AnimatorSet)localObject1).setDuration(this.jdField_a_of_type_Long);
    ((AnimatorSet)localObject1).setStartDelay(this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_AndroidViewAnimationInterpolator != null) {
      ((AnimatorSet)localObject1).setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    }
    ((AnimatorSet)localObject1).addListener(new ViewAnimator.2(this));
    return localObject1;
  }
  
  public ViewAnimator a()
  {
    if (this.jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator != null)
    {
      this.jdField_a_of_type_ComTencentBizVideostoryAnimatorViewAnimator.a();
      return this;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = a();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnPreDrawListener(new ViewAnimator.3(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.ViewAnimator
 * JD-Core Version:    0.7.0.1
 */