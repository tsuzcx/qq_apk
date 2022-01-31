import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bmqm
  extends AnimatorListenerAdapter
{
  bmqm(bmqk parambmqk) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    wxe.b(bmqg.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wxe.b(bmqg.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.b.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    wxe.b(bmqg.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqm
 * JD-Core Version:    0.7.0.1
 */