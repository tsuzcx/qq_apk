import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class bjwn
  extends AnimatorListenerAdapter
{
  bjwn(bjwl parambjwl) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    bjwl.a(this.a).setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bjwl.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwn
 * JD-Core Version:    0.7.0.1
 */