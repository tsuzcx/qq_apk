import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class amcp
  extends AnimatorListenerAdapter
{
  amcp(amco paramamco) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    amco.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amcp
 * JD-Core Version:    0.7.0.1
 */