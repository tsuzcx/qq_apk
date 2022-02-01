package androidx.transition;

import android.view.View;

class Transition$AnimationInfo
{
  String mName;
  Transition mTransition;
  TransitionValues mValues;
  View mView;
  WindowIdImpl mWindowId;
  
  Transition$AnimationInfo(View paramView, String paramString, Transition paramTransition, WindowIdImpl paramWindowIdImpl, TransitionValues paramTransitionValues)
  {
    this.mView = paramView;
    this.mName = paramString;
    this.mValues = paramTransitionValues;
    this.mWindowId = paramWindowIdImpl;
    this.mTransition = paramTransition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.Transition.AnimationInfo
 * JD-Core Version:    0.7.0.1
 */