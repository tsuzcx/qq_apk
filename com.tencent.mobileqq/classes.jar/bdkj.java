import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bdkj
  extends AnimatorListenerAdapter
{
  bdkj(bdkh parambdkh) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    bdkh.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkj
 * JD-Core Version:    0.7.0.1
 */