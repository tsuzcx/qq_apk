package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QFragmentManagerImpl$5
  implements Animation.AnimationListener
{
  QFragmentManagerImpl$5(QFragmentManagerImpl paramQFragmentManagerImpl, QFragment paramQFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.val$fragment.mAnimatingAway != null)
    {
      this.val$fragment.mAnimatingAway = null;
      this.this$0.moveToState(this.val$fragment, this.val$fragment.mStateAfterAnimating, 0, 0, false);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QFragmentManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */