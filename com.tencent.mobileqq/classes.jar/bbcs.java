import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;

class bbcs
  implements Animator.AnimatorListener
{
  bbcs(bbco parambbco) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bbco.a(this.a).setPadding(bdaq.a(bbco.a(this.a).getContext(), 8.0F), -bbco.a(this.a), 0, 0);
    bbco.a(this.a).setVisibility(8);
    bbco.a(this.a, false);
    bbco.b(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bbco.a(this.a).setPadding(bdaq.a(bbco.a(this.a).getContext(), 8.0F), -bbco.a(this.a), 0, 0);
    bbco.a(this.a).setVisibility(8);
    bbco.a(this.a, false);
    bbco.b(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    bbco.a(this.a).setPadding(bdaq.a(bbco.a(this.a).getContext(), 8.0F), 0, 0, 0);
    bbco.a(this.a, true);
    bbco.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcs
 * JD-Core Version:    0.7.0.1
 */