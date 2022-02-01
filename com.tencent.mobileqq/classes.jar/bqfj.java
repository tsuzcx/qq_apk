import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class bqfj
  extends AnimatorListenerAdapter
{
  bqfj(bqfi parambqfi) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bqfi.a(this.a).sendEmptyMessageDelayed(1, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqfj
 * JD-Core Version:    0.7.0.1
 */