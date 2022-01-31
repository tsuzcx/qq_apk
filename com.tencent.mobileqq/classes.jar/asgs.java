import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class asgs
  extends AnimatorListenerAdapter
{
  asgs(asgq paramasgq) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    asgq.a(this.a).sendEmptyMessageDelayed(6, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgs
 * JD-Core Version:    0.7.0.1
 */