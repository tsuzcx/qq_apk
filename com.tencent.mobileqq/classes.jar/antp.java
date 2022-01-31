import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class antp
  extends AnimatorListenerAdapter
{
  antp(antn paramantn) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    antn.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     antp
 * JD-Core Version:    0.7.0.1
 */