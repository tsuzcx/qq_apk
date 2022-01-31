import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;

class aqqz
  extends AnimatorListenerAdapter
{
  aqqz(aqqw paramaqqw) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    aqqw.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqz
 * JD-Core Version:    0.7.0.1
 */