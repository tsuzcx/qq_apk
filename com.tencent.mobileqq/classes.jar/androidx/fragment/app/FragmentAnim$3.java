package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;

final class FragmentAnim$3
  extends AnimatorListenerAdapter
{
  FragmentAnim$3(ViewGroup paramViewGroup, View paramView, Fragment paramFragment, FragmentTransition.Callback paramCallback, CancellationSignal paramCancellationSignal) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.val$container.endViewTransition(this.val$viewToAnimate);
    paramAnimator = this.val$fragment.getAnimator();
    this.val$fragment.setAnimator(null);
    if ((paramAnimator != null) && (this.val$container.indexOfChild(this.val$viewToAnimate) < 0)) {
      this.val$callback.onComplete(this.val$fragment, this.val$signal);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentAnim.3
 * JD-Core Version:    0.7.0.1
 */