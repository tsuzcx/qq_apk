import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;

class arrf
  implements Animator.AnimatorListener
{
  arrf(arre paramarre) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = ObjectAnimator.ofFloat(SignalBombAnimationView.b(this.a.a), "alpha", new float[] { 1.0F, 0.0F });
    paramAnimator.setDuration(280L);
    paramAnimator.addListener(new arrg(this));
    paramAnimator.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrf
 * JD-Core Version:    0.7.0.1
 */