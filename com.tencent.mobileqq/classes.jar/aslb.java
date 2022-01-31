import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class aslb
  extends AnimatorListenerAdapter
{
  aslb(askz paramaskz) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    askz.a(this.a).sendEmptyMessageDelayed(6, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslb
 * JD-Core Version:    0.7.0.1
 */