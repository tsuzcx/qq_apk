import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class aqrf
  extends AnimatorListenerAdapter
{
  aqrf(aqrd paramaqrd) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aqrd.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrf
 * JD-Core Version:    0.7.0.1
 */