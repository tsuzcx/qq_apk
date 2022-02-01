import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.extendfriend.wiget.SignalBombAnimationView;
import com.tencent.qphone.base.util.QLog;

public class asvk
  implements Animator.AnimatorListener
{
  public asvk(SignalBombAnimationView paramSignalBombAnimationView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.a.a != null) && (SignalBombAnimationView.a(this.a) != null))
    {
      SignalBombAnimationView.a(this.a).setVisibility(0);
      SignalBombAnimationView.a(this.a).setImageDrawable(this.a.a);
      this.a.a.start();
      QLog.d("SignalBombAnimationView", 2, "mFireDrawable start");
    }
    paramAnimator = ObjectAnimator.ofFloat(SignalBombAnimationView.b(this.a), "alpha", new float[] { 1.0F, 1.0F });
    paramAnimator.setDuration(480L);
    paramAnimator.addListener(new asvl(this));
    paramAnimator.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvk
 * JD-Core Version:    0.7.0.1
 */