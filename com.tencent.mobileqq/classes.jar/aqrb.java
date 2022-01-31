import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class aqrb
  extends AnimatorListenerAdapter
{
  aqrb(aqqy paramaqqy) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    aqqy.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrb
 * JD-Core Version:    0.7.0.1
 */