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
  @Nullable
  ValueAnimator a = null;
  private final ArrayList<StateListAnimator.Tuple> b = new ArrayList();
  @Nullable
  private StateListAnimator.Tuple c = null;
  private final Animator.AnimatorListener d = new StateListAnimator.1(this);
  
  private void a(@NonNull StateListAnimator.Tuple paramTuple)
  {
    this.a = paramTuple.b;
    this.a.start();
  }
  
  private void b()
  {
    ValueAnimator localValueAnimator = this.a;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.a = null;
    }
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = this.a;
    if (localValueAnimator != null)
    {
      localValueAnimator.end();
      this.a = null;
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      localTuple = (StateListAnimator.Tuple)this.b.get(i);
      if (StateSet.stateSetMatches(localTuple.a, paramArrayOfInt))
      {
        paramArrayOfInt = localTuple;
        break label55;
      }
      i += 1;
    }
    paramArrayOfInt = null;
    label55:
    StateListAnimator.Tuple localTuple = this.c;
    if (paramArrayOfInt == localTuple) {
      return;
    }
    if (localTuple != null) {
      b();
    }
    this.c = paramArrayOfInt;
    if (paramArrayOfInt != null) {
      a(paramArrayOfInt);
    }
  }
  
  public void a(int[] paramArrayOfInt, ValueAnimator paramValueAnimator)
  {
    paramArrayOfInt = new StateListAnimator.Tuple(paramArrayOfInt, paramValueAnimator);
    paramValueAnimator.addListener(this.d);
    this.b.add(paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.StateListAnimator
 * JD-Core Version:    0.7.0.1
 */