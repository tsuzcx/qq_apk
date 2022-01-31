import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class aufo
  extends AnimatorListenerAdapter
{
  aufo(aufh paramaufh) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (aufh.a(this.a) != null) {
      aufh.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufo
 * JD-Core Version:    0.7.0.1
 */