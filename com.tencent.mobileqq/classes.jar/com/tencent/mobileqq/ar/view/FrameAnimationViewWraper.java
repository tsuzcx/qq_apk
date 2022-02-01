package com.tencent.mobileqq.ar.view;

import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class FrameAnimationViewWraper
{
  private int jdField_a_of_type_Int = 1;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new FrameAnimationViewWraper.1(this);
  private SparseArray<FrameAnimationDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private FrameAnimationViewWraper.OnEnterAnimationEndListener jdField_a_of_type_ComTencentMobileqqArViewFrameAnimationViewWraper$OnEnterAnimationEndListener;
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((FrameAnimationDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).stop();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    FrameAnimationDrawable localFrameAnimationDrawable1 = (FrameAnimationDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    FrameAnimationDrawable localFrameAnimationDrawable2 = (FrameAnimationDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    localFrameAnimationDrawable1.a(false, null);
    localFrameAnimationDrawable2.a(true, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
  }
  
  public void a()
  {
    int i = 1;
    while (i <= 3)
    {
      a(i);
      i += 1;
    }
  }
  
  public void a(int paramInt, FrameAnimationDrawable paramFrameAnimationDrawable)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramFrameAnimationDrawable);
  }
  
  public void a(int paramInt, FrameAnimationViewWraper.OnEnterAnimationEndListener paramOnEnterAnimationEndListener)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == paramInt) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArViewFrameAnimationViewWraper$OnEnterAnimationEndListener = paramOnEnterAnimationEndListener;
    a(i, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_ComTencentMobileqqArViewFrameAnimationViewWraper$OnEnterAnimationEndListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.FrameAnimationViewWraper
 * JD-Core Version:    0.7.0.1
 */