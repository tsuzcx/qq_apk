import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class bjvv
  extends AnimatorListenerAdapter
{
  bjvv(bjvu parambjvu) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bjvu.a(this.a).sendEmptyMessageDelayed(1, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjvv
 * JD-Core Version:    0.7.0.1
 */