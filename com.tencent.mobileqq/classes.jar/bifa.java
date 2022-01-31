import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class bifa
  extends AnimatorListenerAdapter
{
  bifa(biez parambiez) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    biez.a(this.a).sendEmptyMessageDelayed(1, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bifa
 * JD-Core Version:    0.7.0.1
 */