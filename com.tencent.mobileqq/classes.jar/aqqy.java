import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class aqqy
  extends AnimatorListenerAdapter
{
  aqqy(aqqw paramaqqw) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    aqqw.a(this.a).sendEmptyMessageDelayed(6, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqy
 * JD-Core Version:    0.7.0.1
 */