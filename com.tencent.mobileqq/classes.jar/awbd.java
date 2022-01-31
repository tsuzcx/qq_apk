import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class awbd
  extends AnimatorListenerAdapter
{
  awbd(awaw paramawaw) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (awaw.a(this.a) != null) {
      awaw.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awbd
 * JD-Core Version:    0.7.0.1
 */