import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;

class beds
  implements Animator.AnimatorListener
{
  beds(bedo parambedo) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bedo.a(this.a).setPadding(bggq.a(bedo.a(this.a).getContext(), 8.0F), -bedo.a(this.a), 0, 0);
    bedo.a(this.a).setVisibility(8);
    bedo.a(this.a, false);
    bedo.b(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bedo.a(this.a).setPadding(bggq.a(bedo.a(this.a).getContext(), 8.0F), -bedo.a(this.a), 0, 0);
    bedo.a(this.a).setVisibility(8);
    bedo.a(this.a, false);
    bedo.b(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bedo.a(this.a).setPadding(bggq.a(bedo.a(this.a).getContext(), 8.0F), 0, 0, 0);
    bedo.a(this.a, true);
    bedo.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beds
 * JD-Core Version:    0.7.0.1
 */