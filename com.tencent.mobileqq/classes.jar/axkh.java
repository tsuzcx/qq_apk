import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class axkh
  extends AnimatorListenerAdapter
{
  public axkh(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    MultiAIOFragment.e(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    MultiAIOFragment.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkh
 * JD-Core Version:    0.7.0.1
 */