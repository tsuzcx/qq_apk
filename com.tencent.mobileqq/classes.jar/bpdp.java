import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class bpdp
  extends AnimatorListenerAdapter
{
  bpdp(bpdn parambpdn) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bpdn.a(this.a).setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bpdn.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdp
 * JD-Core Version:    0.7.0.1
 */