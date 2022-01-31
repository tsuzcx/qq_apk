import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class bmdo
  extends AnimatorListenerAdapter
{
  bmdo(bmdi parambmdi) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bmdi.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdo
 * JD-Core Version:    0.7.0.1
 */