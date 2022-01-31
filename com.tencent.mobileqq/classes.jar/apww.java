import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class apww
  extends AnimatorListenerAdapter
{
  apww(apwu paramapwu) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    apwu.a(this.a).sendEmptyMessageDelayed(6, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apww
 * JD-Core Version:    0.7.0.1
 */