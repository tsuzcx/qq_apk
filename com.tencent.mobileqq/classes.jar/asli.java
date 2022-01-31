import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class asli
  extends AnimatorListenerAdapter
{
  asli(aslg paramaslg) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aslg.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asli
 * JD-Core Version:    0.7.0.1
 */