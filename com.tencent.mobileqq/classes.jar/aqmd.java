import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class aqmd
  extends AnimatorListenerAdapter
{
  aqmd(aqmb paramaqmb) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    aqmb.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqmd
 * JD-Core Version:    0.7.0.1
 */