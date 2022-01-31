import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.multicard.MultiCardFragment;

public class asrw
  extends AnimatorListenerAdapter
{
  public asrw(MultiCardFragment paramMultiCardFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    MultiCardFragment.b(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    MultiCardFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asrw
 * JD-Core Version:    0.7.0.1
 */