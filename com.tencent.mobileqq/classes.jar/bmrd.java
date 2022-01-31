import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class bmrd
  extends AnimatorListenerAdapter
{
  bmrd(bmqz parambmqz) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    wxe.b(bmqw.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wxe.b(bmqw.a, "scaleAnimator end!");
    this.a.w = 1.0F;
    this.a.j = false;
    this.a.a.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    wxe.b(bmqw.a, "scaleAnimator start!");
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrd
 * JD-Core Version:    0.7.0.1
 */