import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class aqrh
  extends AnimatorListenerAdapter
{
  aqrh(aqrf paramaqrf) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aqrf.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrh
 * JD-Core Version:    0.7.0.1
 */