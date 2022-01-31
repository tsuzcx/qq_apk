import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;

class azak
  implements Animator.AnimatorListener
{
  azak(azag paramazag) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    azag.a(this.a).setPadding(baxn.a(azag.a(this.a).getContext(), 8.0F), -azag.a(this.a), 0, 0);
    azag.a(this.a).setVisibility(8);
    azag.a(this.a, false);
    azag.b(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    azag.a(this.a).setPadding(baxn.a(azag.a(this.a).getContext(), 8.0F), -azag.a(this.a), 0, 0);
    azag.a(this.a).setVisibility(8);
    azag.a(this.a, false);
    azag.b(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    azag.a(this.a).setPadding(baxn.a(azag.a(this.a).getContext(), 8.0F), 0, 0, 0);
    azag.a(this.a, true);
    azag.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azak
 * JD-Core Version:    0.7.0.1
 */