import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;

public class aspc
  extends AnimatorListenerAdapter
{
  public aspc(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    MultiAIOFragment.d(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    MultiAIOFragment.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aspc
 * JD-Core Version:    0.7.0.1
 */