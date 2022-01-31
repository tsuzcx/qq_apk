import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import java.util.Iterator;
import java.util.List;

public class avvp
  implements Animator.AnimatorListener
{
  public avvp(ProviderContainerView paramProviderContainerView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c.setVisibility(8);
    paramAnimator = ProviderContainerView.a(this.a);
    if (paramAnimator != null) {
      paramAnimator.a();
    }
    if (ProviderContainerView.a(this.a) != null)
    {
      paramAnimator = ProviderContainerView.a(this.a).iterator();
      while (paramAnimator.hasNext()) {
        ((avvr)paramAnimator.next()).a();
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (ProviderContainerView.a(this.a) != null) {
      ProviderContainerView.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avvp
 * JD-Core Version:    0.7.0.1
 */