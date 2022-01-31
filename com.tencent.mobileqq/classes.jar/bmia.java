import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class bmia
  extends AnimatorListenerAdapter
{
  bmia(bmhu parambmhu) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bmhu.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmia
 * JD-Core Version:    0.7.0.1
 */