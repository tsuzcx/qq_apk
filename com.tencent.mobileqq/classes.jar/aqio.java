import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;

public class aqio
  extends AnimatorListenerAdapter
{
  public aqio(SelectCoverActivity paramSelectCoverActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.a = null;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqio
 * JD-Core Version:    0.7.0.1
 */