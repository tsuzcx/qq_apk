import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class amcq
  extends AnimatorListenerAdapter
{
  amcq(amcp paramamcp) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    amcp.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amcq
 * JD-Core Version:    0.7.0.1
 */