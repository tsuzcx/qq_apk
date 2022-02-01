package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.core.os.CancellationSignal;

final class FragmentAnim$2
  implements Animation.AnimationListener
{
  FragmentAnim$2(ViewGroup paramViewGroup, Fragment paramFragment, FragmentTransition.Callback paramCallback, CancellationSignal paramCancellationSignal) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$container.post(new FragmentAnim.2.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentAnim.2
 * JD-Core Version:    0.7.0.1
 */