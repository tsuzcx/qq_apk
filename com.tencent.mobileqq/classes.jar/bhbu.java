import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.os.Handler;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView;
import com.tencent.mobileqq.trooppiceffects.view.ShakePicView.1.1;

public class bhbu
  implements Animator.AnimatorListener
{
  public bhbu(ShakePicView paramShakePicView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a.postDelayed(new ShakePicView.1.1(this), 160L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbu
 * JD-Core Version:    0.7.0.1
 */