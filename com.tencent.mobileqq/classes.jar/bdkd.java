import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.togetherui.writetogether.SavingAnimView;

public class bdkd
  implements Animator.AnimatorListener
{
  public bdkd(SavingAnimView paramSavingAnimView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SavingAnimView.a(this.a, 0);
    if (SavingAnimView.a(this.a) != null) {
      SavingAnimView.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SavingAnimView.c(this.a, SavingAnimView.a(this.a));
    SavingAnimView.d(this.a, SavingAnimView.d(this.a));
    if (SavingAnimView.a(this.a) != null) {
      SavingAnimView.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkd
 * JD-Core Version:    0.7.0.1
 */