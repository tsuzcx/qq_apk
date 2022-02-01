import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bocp
  extends AnimatorListenerAdapter
{
  bocp(bocn parambocn) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.h();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocp
 * JD-Core Version:    0.7.0.1
 */