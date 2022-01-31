import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class bjwm
  extends AnimatorListenerAdapter
{
  bjwm(bjwl parambjwl) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bjwl.a(this.a).sendEmptyMessageDelayed(1, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwm
 * JD-Core Version:    0.7.0.1
 */