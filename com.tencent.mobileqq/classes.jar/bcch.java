import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.startup.step.SetSplash;

public final class bcch
  extends AnimatorListenerAdapter
{
  public bcch(bccr parambccr) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    SetSplash.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcch
 * JD-Core Version:    0.7.0.1
 */