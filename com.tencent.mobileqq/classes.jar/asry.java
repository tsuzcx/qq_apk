import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.multicard.MultiCardFragment;

public class asry
  extends AnimatorListenerAdapter
{
  public asry(MultiCardFragment paramMultiCardFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    MultiCardFragment.c(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    MultiCardFragment.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asry
 * JD-Core Version:    0.7.0.1
 */