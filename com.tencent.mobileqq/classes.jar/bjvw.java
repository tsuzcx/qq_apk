import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class bjvw
  extends AnimatorListenerAdapter
{
  bjvw(bjvu parambjvu) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bjvu.a(this.a).setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bjvu.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjvw
 * JD-Core Version:    0.7.0.1
 */