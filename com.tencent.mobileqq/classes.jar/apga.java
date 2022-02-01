import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class apga
  implements Animator.AnimatorListener
{
  apga(apfz paramapfz) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (apfz.a(this.a) != null) {
      apfz.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apga
 * JD-Core Version:    0.7.0.1
 */