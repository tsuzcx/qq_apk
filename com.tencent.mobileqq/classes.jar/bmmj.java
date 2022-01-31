import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class bmmj
  extends AnimatorListenerAdapter
{
  bmmj(bmmh parambmmh) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bmmh.a(this.a).setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bmmh.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmj
 * JD-Core Version:    0.7.0.1
 */