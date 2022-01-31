import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ProgressBar;
import com.tencent.qqmini.sdk.launcher.AppUIProxy.LoadingUI;

public class beqk
  implements Animation.AnimationListener
{
  public beqk(AppUIProxy.LoadingUI paramLoadingUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AppUIProxy.LoadingUI.a(this.a).setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqk
 * JD-Core Version:    0.7.0.1
 */