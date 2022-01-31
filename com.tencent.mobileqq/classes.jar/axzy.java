import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ListView;

class axzy
  implements Animator.AnimatorListener
{
  axzy(axzw paramaxzw) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    axzw.a(this.a).setPadding(azvv.a(axzw.a(this.a).getContext(), 8.0F), -axzw.a(this.a), 0, 0);
    axzw.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    axzw.a(this.a).setPadding(azvv.a(axzw.a(this.a).getContext(), 8.0F), 0, 0, 0);
    axzw.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    axzw.a(this.a).setPadding(azvv.a(axzw.a(this.a).getContext(), 8.0F), -axzw.a(this.a), 0, 0);
    axzw.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axzy
 * JD-Core Version:    0.7.0.1
 */