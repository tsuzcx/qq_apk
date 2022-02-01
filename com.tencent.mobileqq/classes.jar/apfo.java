import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class apfo
  extends AnimatorListenerAdapter
{
  apfo(apfm paramapfm) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    apfm.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfo
 * JD-Core Version:    0.7.0.1
 */