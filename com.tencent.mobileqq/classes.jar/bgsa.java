import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import com.tencent.qqmini.sdk.core.widget.TabBar;

public class bgsa
  extends AnimatorListenerAdapter
{
  public bgsa(TabBar paramTabBar) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.setVisibility(8);
    this.a.animate().setListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsa
 * JD-Core Version:    0.7.0.1
 */