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
    int k = paramFragment.getNextTransition();
    int m = paramFragment.getNextAnim();
    j = 0;
    paramFragment.setNextAnim(0);
    paramFragmentContainer = paramFragmentContainer.onFindViewById(paramFragment.mContainerId);
    if ((paramFragmentContainer != null) && (paramFragmentContainer.getTag(2131380961) != null)) {
      paramFragmentContainer.setTag(2131380961, null);
    }
    if ((paramFragment.mContainer != null) && (paramFragment.mContainer.getLayoutTransition() != null)) {
      return null;
    }
    paramFragmentContainer = paramFragment.onCreateAnimation(k, paramBoolean, m);
    if (paramFragmentContainer != null) {
      return new FragmentAnim.AnimationOrAnimator(paramFragmentContainer);
    }
    paramFragmentContainer = paramFragment.onCreateAnimator(k, paramBoolean, m);
    if (paramFragmentContainer != null) {
      return new FragmentAnim.AnimationOrAnimator(paramFragmentContainer);
    }
    boolean bool;
    if (m != 0)
    {
      bool = "anim".equals(paramContext.getResources().getResourceTypeName(m));
      i = j;
      if (!bool) {}
    }
    try
    {
      try
      {
        paramFragmentContainer = AnimationUtils.loadAnimation(paramContext, m);
        if (paramFragmentContainer != null)
        {
          paramFragmentContainer = new FragmentAnim.AnimationOrAnimator(paramFragmentContainer);
          return paramFragmentContainer;
        }
        i = 1;
      }
      catch (Resources.NotFoundException paramContext)
      {
        throw paramContext;
      }
    }
    catch (RuntimeException paramFragmentContainer)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (i == 0) {
      try
      {
        paramFragmentContainer = AnimatorInflater.loadAnimator(paramContext, m);
        if (paramFragmentContainer != null)
        {
          paramFragmentContainer = new FragmentAnim.AnimationOrAnimator(paramFragmentContainer);
          return paramFragmentContainer;
        }
      }
      catch (RuntimeException paramFragmentContainer)
      {
        if (!bool)
        {
          paramFragmentContainer = AnimationUtils.loadAnimation(paramContext, m);
          if (paramFragmentContainer != null) {
            return new FragmentAnim.AnimationOrAnimator(paramFragmentContainer);
          }
        }
        else
        {
          throw paramFragmentContainer;
        }
      }
    }
    if (k == 0) {
      return null;
    }
    i = transitToAnimResourceId(k, paramBoolean);
    if (i < 0) {
      return null;
    }
    return new FragmentAnim.AnimationOrAnimator(AnimationUtils.loadAnimation(paramContext, i));
  }
  
  @AnimRes
  private static int transitToAnimResourceId(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 4097)
    {
      if (paramInt != 4099)
      {
        if (paramInt != 8194) {
          return -1;
        }
        if (paramBoolean) {
          return 2130772076;
        }
        return 2130772077;
      }
      if (paramBoolean) {
        return 2130772080;
      }
      return 2130772081;
    }
    if (paramBoolean) {
      return 2130772085;
    }
    return 2130772086;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentAnim
 * JD-Core Version:    0.7.0.1
 */