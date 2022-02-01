package com.google.android.material.internal;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class StateListAnimator
{
  private final Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new StateListAnimator.1(this);
  @Nullable
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  @Nullable
  private StateListAnimator.Tuple jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator$Tuple = null;
  private final ArrayList<StateListAnimator.Tuple> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private void a(@NonNull StateListAnimator.Tuple paramTuple)
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = paramTuple.jdField_a_of_type_AndroidAnimationValueAnimator;
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void b()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.end();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      localTuple = (StateListAnimator.Tuple)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (StateSet.stateSetMatches(localTuple.jdField_a_of_type_ArrayOfInt, paramArrayOfInt))
      {
        paramArrayOfInt = localTuple;
        break label55;
      }
      i += 1;
    }
    paramArrayOfInt = null;
    label55:
    StateListAnimator.Tuple localTuple = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator$Tuple;
    if (paramArrayOfInt == localTuple) {
      return;
    }
    if (localTuple != null) {
      b();
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalStateListAnimator$Tuple = paramArrayOfInt;
    if (paramArrayOfInt != null) {
      a(paramArrayOfInt);
    }
  }
  
  public void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new StateListAnimator.Tuple(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.StateListAnimator
 * JD-Core Version:    0.7.0.1
 */