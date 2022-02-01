package androidx.fragment.app;

import android.animation.Animator;
import android.view.View;
import androidx.core.app.SharedElementCallback;

class Fragment$AnimationInfo
{
  Boolean mAllowEnterTransitionOverlap;
  Boolean mAllowReturnTransitionOverlap;
  View mAnimatingAway;
  Animator mAnimator;
  Object mEnterTransition = null;
  SharedElementCallback mEnterTransitionCallback = null;
  boolean mEnterTransitionPostponed;
  Object mExitTransition = null;
  SharedElementCallback mExitTransitionCallback = null;
  boolean mIsHideReplaced;
  int mNextAnim;
  int mNextTransition;
  Object mReenterTransition = Fragment.USE_DEFAULT_TRANSITION;
  Object mReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
  Object mSharedElementEnterTransition = null;
  Object mSharedElementReturnTransition = Fragment.USE_DEFAULT_TRANSITION;
  Fragment.OnStartEnterTransitionListener mStartEnterTransitionListener;
  int mStateAfterAnimating;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.Fragment.AnimationInfo
 * JD-Core Version:    0.7.0.1
 */