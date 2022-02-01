package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class MaterialVisibility<P extends VisibilityAnimatorProvider>
  extends Visibility
{
  private final P a;
  @Nullable
  private VisibilityAnimatorProvider b;
  private final List<VisibilityAnimatorProvider> c = new ArrayList();
  
  protected MaterialVisibility(P paramP, @Nullable VisibilityAnimatorProvider paramVisibilityAnimatorProvider)
  {
    this.a = paramP;
    this.b = paramVisibilityAnimatorProvider;
    setInterpolator(AnimationUtils.b);
  }
  
  private Animator a(ViewGroup paramViewGroup, View paramView, boolean paramBoolean)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, this.a, paramViewGroup, paramView, paramBoolean);
    a(localArrayList, this.b, paramViewGroup, paramView, paramBoolean);
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      a(localArrayList, (VisibilityAnimatorProvider)localIterator.next(), paramViewGroup, paramView, paramBoolean);
    }
    AnimatorSetCompat.a(localAnimatorSet, localArrayList);
    return localAnimatorSet;
  }
  
  private static void a(List<Animator> paramList, @Nullable VisibilityAnimatorProvider paramVisibilityAnimatorProvider, ViewGroup paramViewGroup, View paramView, boolean paramBoolean)
  {
    if (paramVisibilityAnimatorProvider == null) {
      return;
    }
    if (paramBoolean) {
      paramVisibilityAnimatorProvider = paramVisibilityAnimatorProvider.a(paramViewGroup, paramView);
    } else {
      paramVisibilityAnimatorProvider = paramVisibilityAnimatorProvider.b(paramViewGroup, paramView);
    }
    if (paramVisibilityAnimatorProvider != null) {
      paramList.add(paramVisibilityAnimatorProvider);
    }
  }
  
  public Animator onAppear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    return a(paramViewGroup, paramView, true);
  }
  
  public Animator onDisappear(ViewGroup paramViewGroup, View paramView, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2)
  {
    return a(paramViewGroup, paramView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.MaterialVisibility
 * JD-Core Version:    0.7.0.1
 */