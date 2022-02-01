import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.startup.step.SetSplash;

public final class bdjc
  extends AnimatorListenerAdapter
{
  public bdjc(bdjm parambdjm) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    SetSplash.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdjc
 * JD-Core Version:    0.7.0.1
 */