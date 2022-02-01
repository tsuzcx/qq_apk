import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.olympic.view.ScanIconAnimateView;

public class aymi
  implements Animator.AnimatorListener
{
  public aymi(ScanIconAnimateView paramScanIconAnimateView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ScanIconAnimateView.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.b();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymi
 * JD-Core Version:    0.7.0.1
 */