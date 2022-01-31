import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class apxd
  extends AnimatorListenerAdapter
{
  apxd(apxb paramapxb) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    apxb.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apxd
 * JD-Core Version:    0.7.0.1
 */