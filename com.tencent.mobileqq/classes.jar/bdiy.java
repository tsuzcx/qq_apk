import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import com.tencent.qqmini.sdk.core.widget.TabBar;

public class bdiy
  extends AnimatorListenerAdapter
{
  public bdiy(TabBar paramTabBar) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.setVisibility(8);
    this.a.animate().setListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdiy
 * JD-Core Version:    0.7.0.1
 */