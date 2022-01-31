import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class bmmi
  extends AnimatorListenerAdapter
{
  bmmi(bmmh parambmmh) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bmmh.a(this.a).sendEmptyMessageDelayed(1, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmi
 * JD-Core Version:    0.7.0.1
 */