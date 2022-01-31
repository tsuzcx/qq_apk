import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class apwx
  extends AnimatorListenerAdapter
{
  apwx(apwu paramapwu) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    apwu.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apwx
 * JD-Core Version:    0.7.0.1
 */