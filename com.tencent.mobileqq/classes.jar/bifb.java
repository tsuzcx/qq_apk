import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class bifb
  extends AnimatorListenerAdapter
{
  bifb(biez parambiez) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    biez.a(this.a).setVisibility(8);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    biez.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bifb
 * JD-Core Version:    0.7.0.1
 */