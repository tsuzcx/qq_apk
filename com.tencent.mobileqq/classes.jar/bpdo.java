import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class bpdo
  extends AnimatorListenerAdapter
{
  bpdo(bpdn parambpdn) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    bpdn.a(this.a).sendEmptyMessageDelayed(1, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdo
 * JD-Core Version:    0.7.0.1
 */