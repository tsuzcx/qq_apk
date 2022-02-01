import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class berm
  extends AnimatorListenerAdapter
{
  berm(berk paramberk) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    berk.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berm
 * JD-Core Version:    0.7.0.1
 */