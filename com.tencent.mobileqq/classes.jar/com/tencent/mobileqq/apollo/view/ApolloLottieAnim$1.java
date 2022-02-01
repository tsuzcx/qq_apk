package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;

class ApolloLottieAnim$1
  implements OnCompositionLoadedListener
{
  ApolloLottieAnim$1(ApolloLottieAnim paramApolloLottieAnim, DiniFlyAnimationView paramDiniFlyAnimationView, boolean paramBoolean) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLottieAnim", 2, "composition is null ,return");
      }
    }
    do
    {
      return;
      if (!ApolloLottieAnim.access$000(this.this$0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloLottieAnim", 2, "anim is destroy ,return");
    return;
    this.val$animationView.setComposition(paramLottieComposition);
    this.val$animationView.setImageAssetDelegate(new ApolloLottieAnim.1.1(this));
    if (this.val$autoPlay)
    {
      this.val$animationView.setVisibility(0);
      this.val$animationView.playAnimation();
    }
    ApolloLottieAnim.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLottieAnim.1
 * JD-Core Version:    0.7.0.1
 */