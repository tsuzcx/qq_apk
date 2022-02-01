package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import java.lang.ref.WeakReference;

class ApolloLottieAnim$4
  implements Runnable
{
  ApolloLottieAnim$4(ApolloLottieAnim paramApolloLottieAnim) {}
  
  public void run()
  {
    if ((ApolloLottieAnim.access$300(this.this$0) != null) && (ApolloLottieAnim.access$300(this.this$0).get() != null)) {
      ((DiniFlyAnimationView)ApolloLottieAnim.access$300(this.this$0).get()).endAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLottieAnim.4
 * JD-Core Version:    0.7.0.1
 */