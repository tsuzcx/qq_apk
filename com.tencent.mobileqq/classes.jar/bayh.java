import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;

class bayh
  implements Animator.AnimatorListener
{
  bayh(bayf parambayf) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bayf.a(this.a).setPadding(bcwh.a(bayf.a(this.a).getContext(), 8.0F), -bayf.a(this.a), 0, 0);
    bayf.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bayf.a(this.a).setPadding(bcwh.a(bayf.a(this.a).getContext(), 8.0F), 0, 0, 0);
    bayf.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bayf.a(this.a).setPadding(bcwh.a(bayf.a(this.a).getContext(), 8.0F), -bayf.a(this.a), 0, 0);
    bayf.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayh
 * JD-Core Version:    0.7.0.1
 */