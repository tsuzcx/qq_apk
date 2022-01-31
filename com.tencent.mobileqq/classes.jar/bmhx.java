import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class bmhx
  extends AnimatorListenerAdapter
{
  bmhx(bmhv parambmhv) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bmhv.a(this.a).setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bmhv.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhx
 * JD-Core Version:    0.7.0.1
 */