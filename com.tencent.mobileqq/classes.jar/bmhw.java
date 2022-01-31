import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class bmhw
  extends AnimatorListenerAdapter
{
  bmhw(bmhv parambmhv) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bmhv.a(this.a).sendEmptyMessageDelayed(1, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhw
 * JD-Core Version:    0.7.0.1
 */