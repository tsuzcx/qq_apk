package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;

class FragmentAnim
{
  static void animateRemoveFragment(@NonNull Fragment paramFragment, @NonNull FragmentAnim.AnimationOrAnimator paramAnimationOrAnimator, @NonNull FragmentTransition.Callback paramCallback)
  {
    View localView = paramFragment.mView;
    ViewGroup localViewGroup = paramFragment.mContainer;
    localViewGroup.startViewTransition(localView);
    CancellationSignal localCancellationSignal = new CancellationSignal();
    localCancellationSignal.setOnCancelListener(new FragmentAnim.1(paramFragment));
    paramCallback.onStart(paramFragment, localCancellationSignal);
    if (paramAnimationOrAnimator.animation != null)
    {
      paramAnimationOrAnimator = new FragmentAnim.EndViewTransitionAnimation(paramAnimationOrAnimator.animation, localViewGroup, localView);
      paramFragment.setAnimatingAway(paramFragment.mView);
      paramAnimationOrAnimator.setAnimationListener(new FragmentAnim.2(localViewGroup, paramFragment, paramCallback, localCancellationSignal));
      paramFragment.mView.startAnimation(paramAnimationOrAnimator);
      return;
    }
    Animator localAnimator = paramAnimationOrAnimator.animator;
    paramFragment.setAnimator(paramAnimationOrAnimator.animator);
    localAnimator.addListener(new FragmentAnim.3(localViewGroup, localView, paramFragment, paramCallback, localCancellationSignal));
    localAnimator.setTarget(paramFragment.mView);
    localAnimator.start();
  }
  
  static FragmentAnim.AnimationOrAnimator loadAnimation(@NonNull Context paramContext, @NonNull FragmentContainer paramFragmentContainer, @NonNull Fragment paramFragment, boolean paramBoolean)
  {
    int j = paramFragment.getNextTransition();
    int k = paramFragment.getNextAnim();
    paramFragment.setNextAnim(0);
    paramFragmentContainer = paramFragmentContainer.onFindViewById(paramFragment.mContainerId);
    if ((paramFragmentContainer != null) && (paramFragmentContainer.getTag(2131381729) != null)) {
      paramFragmentContainer.setTag(2131381729, null);
    }
    if ((paramFragment.mContainer != null) && (paramFragment.mContainer.getLayoutTransition() != null)) {
      return null;
    }
    paramFragmentContainer = paramFragment.onCreateAnimation(j, paramBoolean, k);
    if (paramFragmentContainer != null) {
      return new FragmentAnim.AnimationOrAnimator(paramFragmentContainer);
    }
    paramFragmentContainer = paramFragment.onCreateAnimator(j, paramBoolean, k);
    if (paramFragmentContainer != null) {
      return new FragmentAnim.AnimationOrAnimator(paramFragmentContainer);
    }
    boolean bool;
    if (k != 0)
    {
      bool = "anim".equals(paramContext.getResources().getResourceTypeName(k));
      if (!bool) {
        break label259;
      }
    }
    for (;;)
    {
      try
      {
        paramFragmentContainer = AnimationUtils.loadAnimation(paramContext, k);
        if (paramFragmentContainer != null)
        {
          paramFragmentContainer = new FragmentAnim.AnimationOrAnimator(paramFragmentContainer);
          return paramFragmentContainer;
        }
        i = 1;
      }
      catch (Resources.NotFoundException paramContext)
      {
        try
        {
          paramFragmentContainer = AnimatorInflater.loadAnimator(paramContext, k);
          if (paramFragmentContainer == null) {
            break label227;
          }
          paramFragmentContainer = new FragmentAnim.AnimationOrAnimator(paramFragmentContainer);
          return paramFragmentContainer;
        }
        catch (RuntimeException paramFragmentContainer)
        {
          if (!bool) {
            break label207;
          }
          throw paramFragmentContainer;
          paramFragmentContainer = AnimationUtils.loadAnimation(paramContext, k);
          if (paramFragmentContainer == null) {
            break label227;
          }
          return new FragmentAnim.AnimationOrAnimator(paramFragmentContainer);
        }
        paramContext = paramContext;
        throw paramContext;
      }
      catch (RuntimeException paramFragmentContainer)
      {
        i = 0;
        continue;
      }
      if (i == 0) {}
      label207:
      label227:
      if (j == 0) {
        break;
      }
      int i = transitToAnimResourceId(j, paramBoolean);
      if (i < 0) {
        break;
      }
      return new FragmentAnim.AnimationOrAnimator(AnimationUtils.loadAnimation(paramContext, i));
      label259:
      i = 0;
    }
  }
  
  @AnimRes
  private static int transitToAnimResourceId(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 4097: 
      if (paramBoolean) {
        return 2130772063;
      }
      return 2130772064;
    case 8194: 
      if (paramBoolean) {
        return 2130772054;
      }
      return 2130772055;
    }
    if (paramBoolean) {
      return 2130772058;
    }
    return 2130772059;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentAnim
 * JD-Core Version:    0.7.0.1
 */