import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class asgt
  extends AnimatorListenerAdapter
{
  asgt(asgq paramasgq) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    asgq.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgt
 * JD-Core Version:    0.7.0.1
 */