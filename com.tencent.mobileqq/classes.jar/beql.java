import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qqmini.sdk.launcher.AppUIProxy.LoadingUI;

public class beql
  implements Animation.AnimationListener
{
  public beql(AppUIProxy.LoadingUI paramLoadingUI) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AppUIProxy.LoadingUI.a(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beql
 * JD-Core Version:    0.7.0.1
 */