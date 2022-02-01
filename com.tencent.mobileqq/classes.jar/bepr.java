import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.together.writetogether.view.SavingAnimView;

public class bepr
  implements Animator.AnimatorListener
{
  public bepr(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SavingAnimView.a(this.a, 2);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (SavingAnimView.a(this.a) != null) {
      SavingAnimView.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepr
 * JD-Core Version:    0.7.0.1
 */