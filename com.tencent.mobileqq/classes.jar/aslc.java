import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class aslc
  extends AnimatorListenerAdapter
{
  aslc(askz paramaskz) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    askz.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslc
 * JD-Core Version:    0.7.0.1
 */