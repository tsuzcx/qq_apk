package com.tencent.mobileqq.apollo.store;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;

class ApolloGameActivity$7
  implements Animation.AnimationListener
{
  ApolloGameActivity$7(ApolloGameActivity paramApolloGameActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ApolloGameActivity.a(this.a).d();
    ApolloGameActivity.a(this.a).setVisibility(4);
    ApolloGameActivity.d(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGameActivity.7
 * JD-Core Version:    0.7.0.1
 */