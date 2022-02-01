import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qqmini.proxyimpl.KingCardProxyImpl.1;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;

public class bjwl
  implements Animator.AnimatorListener
{
  public bjwl(KingCardProxyImpl.1 param1) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ActionBridge.UpdateUIActionBridge.updateRedDot(this.a.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ActionBridge.UpdateUIActionBridge.updateRedDot(this.a.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwl
 * JD-Core Version:    0.7.0.1
 */