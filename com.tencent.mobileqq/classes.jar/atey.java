import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;

class atey
  implements Animator.AnimatorListener
{
  atey(atex paramatex) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SignalBombAnimationView.b(this.a.a.a).setTranslationY(0.0F);
    SignalBombAnimationView.a(this.a.a.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atey
 * JD-Core Version:    0.7.0.1
 */