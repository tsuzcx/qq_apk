package com.tencent.mobileqq.apollo.store.openbox;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

class ApolloCardWindow$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ApolloCardWindow$1(ApolloCardWindow paramApolloCardWindow, TextView paramTextView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    TextView localTextView = this.a;
    if (localTextView != null)
    {
      if (localTextView == ApolloCardWindow.a(this.b))
      {
        this.a.setText(ApolloBoxData.c(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
        return;
      }
      if (this.a == ApolloCardWindow.b(this.b))
      {
        this.a.setText(ApolloBoxData.b(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
        return;
      }
      if (this.a == ApolloCardWindow.c(this.b)) {
        this.a.setText(ApolloBoxData.a(((Integer)paramValueAnimator.getAnimatedValue()).intValue()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow.1
 * JD-Core Version:    0.7.0.1
 */