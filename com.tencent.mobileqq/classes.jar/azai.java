import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;

class azai
  implements Animator.AnimatorListener
{
  azai(azae paramazae) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    azae.a(this.a).setPadding(bawz.a(azae.a(this.a).getContext(), 8.0F), -azae.a(this.a), 0, 0);
    azae.a(this.a).setVisibility(8);
    azae.a(this.a, false);
    azae.b(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    azae.a(this.a).setPadding(bawz.a(azae.a(this.a).getContext(), 8.0F), -azae.a(this.a), 0, 0);
    azae.a(this.a).setVisibility(8);
    azae.a(this.a, false);
    azae.b(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    azae.a(this.a).setPadding(bawz.a(azae.a(this.a).getContext(), 8.0F), 0, 0, 0);
    azae.a(this.a, true);
    azae.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azai
 * JD-Core Version:    0.7.0.1
 */