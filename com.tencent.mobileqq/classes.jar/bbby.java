import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow;

public class bbby
  implements Animator.AnimatorListener
{
  public bbby(AIOIceBreakShow paramAIOIceBreakShow) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AIOIceBreakShow.a(this.a, false);
    AIOIceBreakShow.a(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AIOIceBreakShow.a(this.a, false);
    AIOIceBreakShow.a(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AIOIceBreakShow.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbby
 * JD-Core Version:    0.7.0.1
 */